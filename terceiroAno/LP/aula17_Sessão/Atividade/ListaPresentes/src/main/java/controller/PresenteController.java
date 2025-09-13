package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Presente;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/PresenteController")
public class PresenteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String item = request.getParameter("item");
			double valor = Double.parseDouble(request.getParameter("valor"));
			Presente presente = new Presente(item, valor);
			HttpSession session = request.getSession();
			ArrayList<Presente> lista = (ArrayList<Presente>) session.getAttribute("listaPresentes");
			if(lista == null) {
				lista = new  ArrayList<>();
				session.setAttribute("listaPresentes", lista);
			}
			lista.add(presente);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/infoPresente.jsp");
			dispatcher.forward(request, response);
	}

}
