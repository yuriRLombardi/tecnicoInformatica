<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <title>Login - Cafeteria</title>

  <style>
    /* === RESET E BASE === */
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: "Poppins", sans-serif;
    }

    body {
      height: 100vh;
      display: flex;
      justify-content: center;
      align-items: center;
      background: url("img/cafezin.jpg") no-repeat center center/cover;
    }

    main.pagina {
      width: 100%;
      display: flex;
      justify-content: center;
      align-items: center;
    }

    /* === CAIXA DE LOGIN === */
    .login-box {
      background: rgba(255, 255, 255, 0.15);
      backdrop-filter: blur(15px);
      border-radius: 15px;
      box-shadow: 0 0 25px rgba(0, 0, 0, 0.4);
      padding: 40px 50px;
      width: 380px;
      color: #fff;
      text-align: center;
    }

    .login-box h1 {
      font-size: 28px;
      margin-bottom: 20px;
      letter-spacing: 1px;
    }

    /* === CAMPOS === */
    label {
      display: block;
      text-align: left;
      margin-top: 10px;
      font-size: 14px;
      font-weight: 500;
    }

    input {
      width: 100%;
      padding: 10px;
      margin-top: 6px;
      border: none;
      border-bottom: 1px solid #ccc;
      background: transparent;
      color: #fff;
      outline: none;
      font-size: 14px;
    }

    input::placeholder {
      color: rgba(255, 255, 255, 0.7);
    }

    /* === BOTÕES === */
    button {
      width: 100%;
      margin-top: 20px;
      padding: 10px;
      border: none;
      border-radius: 8px;
      font-size: 15px;
      cursor: pointer;
      transition: all 0.3s ease;
    }

    button[type="submit"] {
      background: linear-gradient(135deg, #6b3e2e, #c49a6c);
      color: white;
    }

    button[type="submit"]:hover {
      background: linear-gradient(135deg, #8b4e37, #d1a87b);
      transform: scale(1.02);
    }

    button:not([type="submit"]) {
      background: rgba(255, 255, 255, 0.2);
      color: white;
    }

    button:not([type="submit"]):hover {
      background: rgba(255, 255, 255, 0.3);
    }

    /* === LINK DE CADASTRO === */
    a {
      text-decoration: none;
      color: #ffd9a0;
      font-weight: 500;
    }

    a:hover {
      text-decoration: underline;
    }

    /* === MENSAGEM DE ERRO === */
    .erro {
      color: #ffaaaa;
      font-size: 14px;
      margin-top: 15px;
    }

    /* === RESPONSIVIDADE === */
    @media (max-width: 420px) {
      .login-box {
        width: 90%;
        padding: 30px;
      }
    }
  </style>
</head>

<body>
  <main class="pagina">
    <section class="login-box">
      <h1>Entrar na sua conta</h1>

      <form action="UsuarioController" method="post">
        <label for="login">Login</label>
        <input type="text" id="login" name="login" required>

        <label for="senha">Senha</label>
        <input type="password" id="senha" name="senha" required>

        <button type="submit" name="operacao" value="Entrar">Entrar</button>
      </form>

      <a href="cadastrar.html"><button type="button">Cadastro</button></a>

      <c:if test="${erro != null && erro}">
        <p class='erro'>Usuário ou senha incorretos!</p>
      </c:if>
    </section>
  </main>
</body>
</html>
