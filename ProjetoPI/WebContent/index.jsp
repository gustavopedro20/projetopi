<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - PI</title>
</head>

<body class="text-center">
    <form class="form-signin" autocomplete="off">
        <img class="mb-4 img-login" src="assets/logo-usjt.png" alt="" width="72" height="72">
        <label for="inputEmail" class="sr-only">Email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="Email" required autofocus>
        <label for="inputPassword" class="sr-only">Senha</label>
        <input type="password" id="inputPassword" class="form-control" style="margin-bottom: 0" placeholder="Senha" required>

        <div class="esqueceu-senha"><a href="#">Esqueci minha senha</a></div>
        <button class="btn btn-lg btn-success btn-block entrar" type="submit">Entrar</button>
        <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
    </form>

    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>