package aula;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/ProcessaInfo")
public class ProcessaInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Override  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String sobrenome= request.getParameter("sobrenome");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Relátorio</title></head>");
		out.println("<body>");
		out.println("<h3>Relátorio de informações do usuário</h3>");
		out.println("<ul><li>Nome: "+nome+"</li>");
		out.println("<li>Sobrenome: "+sobrenome+"</li></ul>");
		out.println("</body>");
		out.println("</html>");
	}

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String nome = request.getParameter("nome");
		String sobrenome= request.getParameter("sobrenome");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>Boas-Vindas</title></head>");
		out.println("<body>");
		out.println("<h3>Boas-Vindas, "+nome+" "+sobrenome+"!</h3>");
		out.println("</body>");
		out.println("</html>");
	}

}
