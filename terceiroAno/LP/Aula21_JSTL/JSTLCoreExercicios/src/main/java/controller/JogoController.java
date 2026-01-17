package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/JogoController")
public class JogoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String jogadaHuman = request.getParameter("Jogo");
		int gerarador = ((int) ( 1 + Math.random() * (3 - 1 + 1)));
		String jogadaBot = "";
		switch (gerarador) {
		case 1:
			jogadaBot = "Pedra";
			break;
		case 2:
			jogadaBot = "Papel";
			break;
		case 3:
			jogadaBot = "Tesoura";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + gerarador);
		}
		request.setAttribute("jogadaHuman", jogadaHuman);
		request.setAttribute("jogadaBot", jogadaBot);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Ex1/resultado.jsp");
		dispatcher.forward(request, response);
	}

}
