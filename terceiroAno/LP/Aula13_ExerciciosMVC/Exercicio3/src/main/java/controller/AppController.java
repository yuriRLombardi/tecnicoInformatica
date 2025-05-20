package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Inverter;


@WebServlet("/AppController")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num1 = request.getParameter("num");

		Inverter invercao = new Inverter();
		
		String numInvertido = invercao.invert(num1);
		request.setAttribute("numeroNovo", numInvertido);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/exibirInvercao.jsp");
		dispatcher.forward(request, response);
	}


}
