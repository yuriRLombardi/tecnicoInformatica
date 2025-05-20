package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CalcSoma;

import java.io.IOException;

@WebServlet("/ControleCalc")
public class ControleCalc extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float num1 = Float.parseFloat(request.getParameter("num1"));
		float num2 = Float.parseFloat(request.getParameter("num2"));
		float num3 = Float.parseFloat(request.getParameter("num3"));
		
		CalcSoma calcSoma = new CalcSoma(num1, num2, num3);
		String res = calcSoma.maiorSoma();
		
		request.setAttribute("maiores", res);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/exibirMaior.jsp");
		requestDispatcher.forward(request, response);
	}

}
