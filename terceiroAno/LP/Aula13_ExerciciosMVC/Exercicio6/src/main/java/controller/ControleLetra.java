package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.VerificadorLetra;

import java.io.IOException;


@WebServlet("/ControleLetra")
public class ControleLetra extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String letra = request.getParameter("letra");
		
		VerificadorLetra verificadorLetra = new VerificadorLetra();
		String mensagem = verificadorLetra.verLetra(letra);
		
		request.setAttribute("mensagem", mensagem);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/exibirMensagem.jsp");
		requestDispatcher.forward(request, response);
	}
}
