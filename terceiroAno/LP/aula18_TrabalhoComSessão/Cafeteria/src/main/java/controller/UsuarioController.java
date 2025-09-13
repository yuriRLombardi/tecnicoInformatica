package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Usuario;
import model.UsuarioDAO;

import java.io.IOException;

import javax.sql.DataSource;

@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDAO uDAO;
	@Resource(name = "bancoCafeteria")
	private DataSource dataSource;
	
	@Override
	public void init() {
		uDAO = new UsuarioDAO(dataSource);
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao =  request.getParameter("operacao").toLowerCase();
		switch (operacao) {
		case "logout":
			fazerLogout(request,response);
			break;
		case "deletar":
			deletarUsuario(request,response);
			break;
		default:
		}
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao =  request.getParameter("operacao").toLowerCase();
		switch (operacao) {
		case "cadastro":
			cadastrar(request,response);
			break;
		case "entrar":
			entrar(request,response);
		default:
		}
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String cnpj = request.getParameter("cnpj");
		String email = request.getParameter("email");
		String telefone = request.getParameter("tele");
		boolean inseriu = uDAO.inserir(login, senha, nome, cnpj, email, telefone);
		request.setAttribute("inseriu", inseriu);
		if(inseriu) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/cadastrar.html");
			dispatcher.forward(request, response);
		}
	}
	
	private void entrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario usuario = uDAO.procurarUsuario(login);
		
		if(usuario !=  null && usuario.getSenha().equals(senha)) {
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("indexProduto.jsp");
			dispatcher.forward(request, response);
		}
		else {
			request.setAttribute("erro", true);
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	private void fazerLogout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		session.invalidate();
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}
	
	private void deletarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		boolean deletou = uDAO.deletarUsuario(usuario.getLogin());
		request.setAttribute("situacao", deletou);
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
