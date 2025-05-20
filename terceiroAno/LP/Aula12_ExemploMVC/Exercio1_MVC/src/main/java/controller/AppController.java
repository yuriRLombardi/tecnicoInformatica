package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Retangulo;

@WebServlet("/AppController")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double base = Double.parseDouble(request.getParameter("base"));
		double altura = Double.parseDouble(request.getParameter("altura"));
	
		Retangulo r = new Retangulo(base,altura);
		double area = r.area();
		double perimetro = r.perimetro();
		
		request.setAttribute("areaR", area);
		request.setAttribute("perimetroR", perimetro);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/resultado.jsp");
		dispatcher.forward(request, response);
	}
}
