package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/FilmesController")
public class FilmesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] filmes = request.getParameterValues("filme");
		String exercicio = request.getParameter("ex");
		request.setAttribute("filmes", filmes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/"+exercicio+"/respostaFilme.jsp");
		dispatcher.forward(request, response);
	}

}
