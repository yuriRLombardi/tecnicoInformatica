package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * Servlet implementation class Atv2
 */
@WebServlet("/Atv2")
public class Atv2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/LL/yyyy");
		
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Dados do Aluno</title></head>");
		out.println("<body>");
		out.println("<p> Data atual: "+LocalDate.now().format(formato)+"</p>");
		out.println("</body></html>");

	}

}
