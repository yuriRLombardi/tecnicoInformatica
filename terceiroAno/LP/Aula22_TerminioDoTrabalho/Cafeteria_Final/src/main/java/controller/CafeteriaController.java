package controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.sql.DataSource;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.CafeteriaDAO;
import model.Produto;
import model.Usuario;

@WebServlet("/CafeteriaController")
public class CafeteriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CafeteriaDAO cDAO;
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("cafeteria-jpa");
	
	@Override
	public void init() throws ServletException{
		cDAO = new CafeteriaDAO(emf);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao").toLowerCase();
		switch (operacao) {
		case "listar":
			listar(request, response);
			break;
		case "buscar":
			buscar(request, response);
			break;
		case "validade":
			verValidade(request,response);
			break;
		case "entrega":
			calcularEntrega(request,response);
			break;
		case "ingredientes":
			verIngredientes(request,response);
			break;
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao").toLowerCase();
		switch (operacao) {
		case "cadastrar":
			cadastrar(request,response);
			break;
		case "atualizar":
			atualizar(request,response);
			break;
		case "remover":
			remover(request,response);
			break;
		}
	}
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
	    String desc = request.getParameter("desc");
	    double preco = Double.parseDouble(request.getParameter("preco"));
	    String validade = request.getParameter("dataVal");
	    String[] ingre = request.getParameterValues("ingrediente");
	    double taxa = Double.parseDouble(request.getParameter("taxa"));
	    
	    HttpSession session = request.getSession();
	    Usuario usuario = (Usuario) session.getAttribute("usuario");
	    
	    Cookie cookieNome = new Cookie(usuario.getLogin()+"_nome", URLEncoder.encode(nome,"utf-8"));
	    cookieNome.setMaxAge(60*60*24*365);
	    response.addCookie(cookieNome);
	    
	    Cookie cookiePreco = new Cookie(usuario.getLogin()+"_preco", Double.toString(preco));
	    cookiePreco.setMaxAge(60*60*24*365);
	    response.addCookie(cookiePreco);
	    
	    Cookie cookieValidade = new Cookie(usuario.getLogin()+"_validade", validade);
	    cookieValidade.setMaxAge(60*60*24*365);
	    response.addCookie(cookieValidade);
	    
		boolean inseriu = cDAO.inserir(nome,desc,preco,validade,ingre,taxa,usuario);
		request.setAttribute("situacao", inseriu);
		request.setAttribute("operacao", "cadastrado");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}
	private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int id = Integer.parseInt(request.getParameter("id"));
		Produto produtoBanco = cDAO.procurarProduto(id);
		request.setAttribute("produto", produtoBanco);
		String simbolo = request.getParameter("simbolo");
		String caminho;
		if(simbolo.equals("lixeira")) {
			caminho = "/confirmaRemocao.jsp";
		}
		else {
			caminho = "/atualizarProduto.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(caminho);
		dispatcher.forward(request, response);
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
	    Usuario usuario = (Usuario) session.getAttribute("usuario");
	    
		ArrayList<Produto> produtos = cDAO.consulta(usuario);
		request.setAttribute("produtos", produtos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cardapio.jsp");
		dispatcher.forward(request, response);
	}
	private void remover(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
	    boolean removeu = cDAO.deletar(id);
	    request.setAttribute("situacao", removeu);
	    request.setAttribute("operacao", "removido");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
	    dispatcher.forward(request, response);
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nome = request.getParameter("nome");
	    String desc = request.getParameter("desc");
	    double preco = Double.parseDouble(request.getParameter("preco"));
	    String validade = request.getParameter("dataVal");
	    String[] ingre = request.getParameterValues("ingrediente");
	    double taxa = Double.parseDouble(request.getParameter("taxa"));
	    boolean atualizou = cDAO.modificar(id,nome,desc,preco,validade,ingre,taxa,usuario);
	    
		request.setAttribute("situacao", atualizou);
		request.setAttribute("operacao", "atualizado");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}
	private void verValidade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Produto produtoBanco = cDAO.procurarProduto(id);
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		    
		ArrayList<Produto> produtos = cDAO.consulta(usuario);
		request.setAttribute("produtos", produtos);
		
		request.setAttribute("operacao", "validade");
		request.setAttribute("validade", produtoBanco.verificarValidade());
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cardapio.jsp");
		dispatcher.forward(request, response);	
	}
	private void calcularEntrega(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Produto produtoBanco = cDAO.procurarProduto(id);
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		    
		ArrayList<Produto> produtos = cDAO.consulta(usuario);
		request.setAttribute("produtos", produtos);
		
		request.setAttribute("operacao", "entrega");
		request.setAttribute("entrega", produtoBanco.calcularPreco());
		request.setAttribute("id", id);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cardapio.jsp");
		dispatcher.forward(request, response);		
	}
	private void verIngredientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Produto produtoBanco = cDAO.procurarProduto(id);
		
		String ingredientes = "Nenhum";
		
		if(produtoBanco.rotularProduto() != null) {
			ingredientes = String.join(",",produtoBanco.rotularProduto()) ;
		}
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		    
		ArrayList<Produto> produtos = cDAO.consulta(usuario);
		request.setAttribute("produtos", produtos);
		request.setAttribute("id", id);
		
		request.setAttribute("operacao", "ingredientes");
		request.setAttribute("ingredientes", ingredientes);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cardapio.jsp");
		dispatcher.forward(request, response);

	}
}