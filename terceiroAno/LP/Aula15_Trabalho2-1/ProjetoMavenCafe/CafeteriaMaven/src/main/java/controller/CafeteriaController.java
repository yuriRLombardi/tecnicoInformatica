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
import model.CafeteriaDAO;
import model.Produto;

@WebServlet("/CafeteriaController")
public class CafeteriaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CafeteriaDAO cDAO;
	@Resource(name = "bancoCafeteria")
	private DataSource dataSource;
	
	@Override
	public void init() {
		cDAO = new CafeteriaDAO(dataSource);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao").toLowerCase();
		switch (operacao) {
		case "listar":
			listar(request, response);
			break;
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operacao = request.getParameter("operacao").toLowerCase();
		switch (operacao) {
		case "cadastrar":
			cadastrar(request,response);
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
		boolean inseriu = cDAO.inserir(nome,desc,preco,validade,ingre,taxa); 
		request.setAttribute("situacao", inseriu);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/status.jsp");
		dispatcher.forward(request, response);
	}
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ArrayList<Produto> produtos = cDAO.consulta();
		request.setAttribute("produtos", produtos);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/cardapio.jsp");
		dispatcher.forward(request, response);
	}
}
