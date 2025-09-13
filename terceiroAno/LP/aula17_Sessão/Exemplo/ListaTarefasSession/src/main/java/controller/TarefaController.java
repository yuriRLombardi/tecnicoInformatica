package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.DataSource;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Tarefa;
import model.TarefaDAO;
import model.Usuario;

@WebServlet("/TarefaController")
public class TarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private TarefaDAO tDAO;
	@Resource(name="bancoTarefas")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		tDAO = new TarefaDAO(dataSource);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();
		
		switch(operacao) {
			case "listar":
				listarTarefas(request, response);
				break;
			case "buscar":
				buscarTarefa(request, response);
				break;
			default:
				System.out.println("Erro! Operação não encontrada.");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();
		
		switch(operacao) {
			case "cadastrar":
				cadastrarTarefa(request, response);
				break;
			case "remover":
				removerTarefa(request, response);
				break;
			case "atualizar":
				atualizarTarefa(request, response);
				break;
			default:
				System.out.println("Erro! Operação não encontrada.");
		}
	}
	
	private void cadastrarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String descricao = request.getParameter("descricao");
		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		boolean inseriu = tDAO.inserirTarefa(descricao, prioridade, usuario.getLogin());
		
		request.setAttribute("status", inseriu);
		request.setAttribute("operacao", "cadastrada");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}
	
	private void listarTarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		ArrayList<Tarefa> listaTarefas = tDAO.consultarTarefas(usuario.getLogin());
		
		request.setAttribute("tarefasBanco", listaTarefas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/exibeTarefas.jsp");
		dispatcher.forward(request, response);
	}
	
	private void buscarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Tarefa tarefaBanco = tDAO.procurarTarefa(id);
		request.setAttribute("tarefa", tarefaBanco);
		
		String simbolo = request.getParameter("simbolo");
		String caminho;
		if (simbolo.equals("lixeira"))
			caminho = "/confirmaRemocao.jsp";
		else 
			caminho = "/atualizaTarefa.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(caminho);
		dispatcher.forward(request, response);
	}
	
	private void removerTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		boolean excluiu = tDAO.excluirTarefa(id);
		
		request.setAttribute("status", excluiu);
		request.setAttribute("operacao", "removida");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}
	
	private void atualizarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String descricao = request.getParameter("descricao");
		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
		
		boolean atualizou = tDAO.modificarTarefa(id, descricao, prioridade);
		
		request.setAttribute("status", atualizou);
		request.setAttribute("operacao", "atualizada");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}
}
