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
        <form action="controller.do" method="post">
            <form class="form-signin" autocomplete="off">
                <img class="mb-4 img-login" src="assets/logo-usjt.png" alt="" width="72" height="72">

                <label for="email" class="sr-only">Email</label>
                <input type="email" name="email" id="email" class="form-control" placeholder="Email" required autofocus>

                <label for="senha" class="sr-only">Senha</label>
                <input type="password" name="senha" id="senha" class="form-control" style="margin-bottom: 0"
                    placeholder="Senha" required>

                <select class="form-control">
                    <!--<option selected="selected">Sou:</option>-->
                    <option value="1">Aluno</option>
                    <option value="2">Professor</option>
                    <option value="3">Administrador</option>
                </select>

                <div class="esqueceu-senha">
                    <a href="#">Esqueci minha senha</a>
                </div>

                <button type="submit" class="btn btn-lg btn-success btn-block entrar" name="command"
                    value="Login">Entrar</button>


                <p class="mt-5 mb-3 text-muted">&copy; 2019</p>
            </form>
        </form>

        <footer>
            <c:import url="common/footer.jsp" />
        </footer>
    </div>
</body>

</html>