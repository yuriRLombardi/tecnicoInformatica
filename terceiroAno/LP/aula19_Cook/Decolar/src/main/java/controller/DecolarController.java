package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DecolarController")
public class DecolarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String origem = request.getParameter("origem");
		String destino = request.getParameter("destino");
		String dataIda = request.getParameter("dataIda");
		String dataVolta = request.getParameter("dataVolta");
		int numPessoas = Integer.parseInt(request.getParameter("numPessoas"));
		
		request.setAttribute("origem", origem);
		request.setAttribute("destino", destino);
		request.setAttribute("dataIda", dataIda);
		request.setAttribute("dataVolta", dataVolta);
		request.setAttribute("numPessoas", numPessoas);
		
		Cookie cookieOrigem = new Cookie("origem", origem);
		cookieOrigem.setMaxAge(60*60*24*365);
		response.addCookie(cookieOrigem);
		
		Cookie cookieDestino = new Cookie("destino", destino);
		cookieDestino.setMaxAge(60*60*24*365);
		response.addCookie(cookieDestino);
		
		Cookie cookieIda = new Cookie("dataIda",dataIda );
		cookieIda.setMaxAge(60*60*24*365);
		response.addCookie(cookieIda);
		
		Cookie cookieVolta = new Cookie("dataVolta",dataVolta );
		cookieVolta.setMaxAge(60*60*24*365);
		response.addCookie(cookieVolta);
		
		Cookie cookieNumPessoas = new Cookie("numPessoas",Integer.toString(numPessoas));
		cookieNumPessoas.setMaxAge(60*60*24*365);
		response.addCookie(cookieNumPessoas);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/passagens.jsp");
		dispatcher.forward(request, response);
		
	}

}
