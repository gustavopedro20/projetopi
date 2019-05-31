<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - PI</title>
</head>

<body class="text-center">

    <div id="main" class="form-signin">

        <form action="controller.do" class="form-signin" autocomplete="off" name="user" method="post">
            <img class="mb-4 img-login" src="assets/logo-usjt.png" alt="" width="72" height="72">

            <label for="email" class="sr-only">Email</label>
            <input type="email" name="email" class="form-control" placeholder="Email" required autofocus>

            <label for="senha" class="sr-only">Senha</label>
            <input type="password" name="senha" class="form-control" style="margin-bottom: 0" placeholder="Senha"
                required>

            <select class="form-control" name="acesso">
                <option value="Aluno">Aluno</option>
                <option value="Professor">Professor</option>
                <option value="Administrador">Administrador</option>
            </select>

            <div class="esqueceu-senha">
                <a href="RecuperarSenha.jsp">Esqueci minha senha</a>
            </div>

            <button type="submit" class="btn btn-lg btn-success btn-block entrar" name="command"
                value="Login">Entrar</button>

            <p class="mt-5 mb-3 text-muted">&copy; GRUPO 7 - PI - 2019/01</p>
        </form>

        <footer>
            <c:import url="common/footer.jsp" />
        </footer>
    </div>
</body>

</html>