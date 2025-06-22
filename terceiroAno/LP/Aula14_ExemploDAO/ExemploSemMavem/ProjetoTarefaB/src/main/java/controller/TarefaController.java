package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TarefaDAO;

import java.io.IOException;

@WebServlet("/TarefaController")
public class TarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private TarefaDAO tDAO;
	
	@Override
	public void init() {
		tDAO = new TarefaDAO();
	}

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao");
		operacao = operacao.toLowerCase();
		switch (operacao) {
		case "cadastrar": 
			cadastrarTarefa(request,response);
			break;
		default:
			System.out.println("Erro! Operação não encontrada");
		}

    }
    protected void cadastrarTarefa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String descricao = request.getParameter("descricao");
		int prioridade = Integer.parseInt(request.getParameter("prioridade"));
	
		boolean inseriu = tDAO.insercao(descricao, prioridade);
		
		request.setAttribute("status", inseriu);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
    }


}