package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Atv1
 */
@WebServlet("/Atv1")
public class Atv1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Dados do Aluno</title></head>");
		out.println("<body>");
		out.println("<h1>Dados do Aluno</h1>");
		out.println("<ul>");
		out.println("<li>Yuri</li>");
		out.println("<li>ht3023664</li>");
		out.println("<li>yuri.lombardi@aluno.ifsp.edu.br</li>");
		out.println("</ul>");
		out.println("<h1>Dados do Aluno</h1>");
		out.println("<ul>");
		out.println("<li>Kevin</li>");
		out.println("<li>ht3023397</li>");
		out.println("<li>kevin.reis@aluno.ifsp.edu.br</li>");
		out.println("</ul>");
		out.println("</body></html>");
	}

}
