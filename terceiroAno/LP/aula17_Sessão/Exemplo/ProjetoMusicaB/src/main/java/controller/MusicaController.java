package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Musica;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/MusicaController")
public class MusicaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String nome = request.getParameter("nome");
			String banda = request.getParameter("banda");
			int ano = Integer.parseInt(request.getParameter("ano")) ;
			Musica musica = new Musica(nome, banda, ano);
			
			HttpSession session = request.getSession();
			ArrayList<Musica> playlist = (ArrayList<Musica>) session.getAttribute("minhasMusicas");
			if(playlist == null) {
				playlist = new ArrayList<>();
				session.setAttribute("minhasMusicas", playlist);
			}
			playlist.add(musica);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/playlist.jsp");
			dispatcher.forward(request, response);
	}

}
