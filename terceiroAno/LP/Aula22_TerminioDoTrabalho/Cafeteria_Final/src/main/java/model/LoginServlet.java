package model;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Simulação de "banco de dados" em memória
    private static final java.util.Map<String, String> userSessions = new java.util.concurrent.ConcurrentHashMap<>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validação simples (em produção, use hash e banco de dados)
        if ("admin".equals(username) && "123".equals(password)) {
            // Gera um ID único para a sessão
            String sessionId = UUID.randomUUID().toString();

            // Associa o usuário ao sessionId
            userSessions.put(sessionId, username);

            // Cria o cookie
            Cookie cookie = new Cookie("SESSION_ID", sessionId);
            cookie.setHttpOnly(true); // Protege contra JavaScript
            cookie.setMaxAge(60 * 30); // 30 minutos
            cookie.setPath("/"); // Disponível para todo o site

            // Adiciona o cookie à resposta
            response.addCookie(cookie);

            response.getWriter().println("Login bem-sucedido! Cookie criado.");
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Usuário ou senha inválidos.");
        }
    }

    // Endpoint para verificar usuário logado
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sessionId = null;

        // Lê cookies enviados pelo cliente
        if (request.getCookies() != null) {
            for (Cookie c : request.getCookies()) {
                if ("SESSION_ID".equals(c.getName())) {
                    sessionId = c.getValue();
                    break;
                }
            }
        }

        if (sessionId != null && userSessions.containsKey(sessionId)) {
            String username = userSessions.get(sessionId);
            response.getWriter().println("Usuário logado: " + username);
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println("Nenhum usuário logado.");
        }
    }
}
