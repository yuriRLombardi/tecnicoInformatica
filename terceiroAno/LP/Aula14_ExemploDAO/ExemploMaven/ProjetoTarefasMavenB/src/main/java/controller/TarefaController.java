package controller;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tarefa;
import model.TarefaDAO;

import java.io.IOException;
import java.util.ArrayList;

import javax.sql.DataSource;

@WebServlet("/TarefaController")
public class TarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TarefaDAO tDAO;
	@Resource(name = "bancoTarefas")
	private DataSource dataSource;
	
	@Override
	public void init() {
		tDAO = new TarefaDAO(dataSource);
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();
		
		switch (operacao) {
		case "listar": 
			listarTarefas(request,response);
			break;
		case "buscar":
			buscarTarefa(request,response);
		default:
			System.out.println("Erro! Operação não encontrada");
		}
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();
		
		switch (operacao) {
		case "cadastrar": 
			cadastrarTarefa(request,response);
			break;
		case "remover":
			removerTarefa(request,response);
		case "atualizar":
			atualizarTarefa(request,response);
		default:
			System.out.println("Erro! Operação não encontrada");
		}

    }
    private void cadastrarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
	
		boolean inseriu = tDAO.insercao(descricao, prioridade);
		
		request.setAttribute("status", inseriu);
		request.setAttribute("operacao", "cadastrada");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
    }
    
    private void listarTarefas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	ArrayList<Tarefa> listaTarefas = tDAO.consultarTarefa();
    	
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
    	if(simbolo.equals("lixeira"))
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
	
		boolean atualizou = tDAO.modificarTarefa(id,descricao, prioridade);
		
		request.setAttribute("status", atualizou);
		request.setAttribute("operacao", "atualizada");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
    }

}