package atividades;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Atv3")
public class Atv3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tabuada = 4;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Dados do Aluno</title></head>");
		out.println("<body>");
		out.println("<h1>Tabuada do "+tabuada+"</h1>");
		out.println("<table>");
		out.println("<tr><th>Fator</th><th>Resultado<th><tr>");
		for(int i = 1;i<=10;i++) {
		  out.println("<tr><td>"+i +"</td>"+"<td>"+(i*tabuada)+"</td></tr>");
		}
		out.println("</table>");
		out.println();
		out.println("</body></html>");
	}

}
