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

                <h3>Recupere sua conta</h3>                
                <label for="email" class="sr-only">Recupere sua conta para acessar o sistema</label>
                <input type="email" name="email" class="form-control" placeholder="Digite seu email para recuperação de senha" required autofocus>

                <button type="submit" class="btn btn-lg btn-success btn-block entrar" name="command"
                    value="RecuperarSenha">Enviar</button>
            </form>

        <footer>
            <c:import url="common/footer.jsp" />
        </footer>
    </div>
</body>

</html>