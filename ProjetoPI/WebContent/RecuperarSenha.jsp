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

            <input type="email" name="email" class="form-control"
                placeholder="Digite seu email para recuperação de senha" required autofocus>

            <button type="submit" class="btn btn-lg btn-success btn-block entrar" name="command"
                value="RecuperarSenha">Enviar</button>
            <a class="btn btn-lg btn-danger btn-block" href="index.jsp">Cancelar</a>
        </form>

        <footer>
            <c:import url="common/footer.jsp" />
        </footer>
        
        <!-- MODAL MENSAGEM VALIDO -->
        <div class="modal fade" id="valido" tabindex="-1" role="dialog" aria-labelledby="valido" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="valido">Mensagem do sistema:</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Foi lhe enviado um emal com uma nova senha!
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>

        <!-- MODAL MENSAGEM INVALIDO -->
        <div class="modal fade" id="invalido" tabindex="-1" role="dialog" aria-labelledby="valido" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="valido">Mensagem do sistema:</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                            <span aria-hidden="true">&times;</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        Esse email não consta no sistema!
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <c:if test="${not empty invalido}">
        <script>$('#invalido').modal('show')</script>
    </c:if>
    <c:if test="${not empty valido}">
        <script>$('#valido').modal('show')</script>
    </c:if>

</body>

</html>