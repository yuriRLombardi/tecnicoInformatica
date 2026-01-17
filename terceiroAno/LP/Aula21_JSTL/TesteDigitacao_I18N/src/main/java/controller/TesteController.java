package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/TesteController")
public class TesteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String botao = request.getParameter("botao");
		String caminho;
		long tempoInicio = 0L;
		long tempoParada = 0L;
		double resultado = 0L;
		switch (botao) {
		case "iniciar": 
			tempoInicio = System.currentTimeMillis();
			Cookie cookie =  new Cookie("tempoInicio", Long.toString(tempoInicio));
			cookie.setMaxAge(60*60*24*365);
			response.addCookie(cookie);
			caminho = "/index.jsp";
			break;
		case "parar":
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie c : cookies) {
					if ("tempoInicio".equals(c.getName())) {
						tempoInicio = Long.parseLong(c.getValue());
						break;
					}
				}
				tempoParada = System.currentTimeMillis();
				resultado = 66.0/((tempoParada-tempoInicio)/60000.0);
			}
			request.setAttribute("resultado", resultado);
			caminho = "/resultado.jsp";
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + botao);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(caminho);
		dispatcher.forward(request, response);
	}
}
