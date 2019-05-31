<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Cadastro de Usuário</title>
</head>

<body class="background-image">

    <c:import url="common/menu.jsp" />

    <div id="main" class="container">
        <h3 class="page-header">Cadastro de Usuário</h3>
        <hr>
        <form class="needs-validation" novalidate action="controller.do" method="POST">
            <div class="form-group">
                <label for="nome">Nome completo</label>
                <input type="text" class="form-control" name="nome" placeholder="Nome completo do aluno ou professor"
                    maxlength="50" required>
                <div class="valid-feedback">Tudo certo!</div>
                <!-- pattern="[a-z\s]+$"  -->
                <!-- <div class="invalid-feedback">Por favor, esse campo é obrigatório e aceita apenas letras!</div> -->
                <div class="invalid-feedback">Por favor, esse campo é obrigatório!</div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="raOuMatricula">RA/Matrícula</label>
                    <input type="text" class="form-control" name="raOuMatricula" placeholder="RA ou Matrícula"
                        maxlength="15" required>
                    <div class="valid-feedback">Tudo certo!</div>
                    <div class="invalid-feedback">Por favor, esse campo é obrigatório!</div>
                </div>
                <div class="form-group col-md-6">
                    <label for="tipo">Professor ou aluno?</label>
                    <select class="form-control" name="tipo">
                        <option value="Professor">Professor</option>
                        <option value="Aluno">Aluno</option>
                    </select>
                    <div class="valid-feedback">Tudo certo!</div>
                    <div class="invalid-feedback">Por favor, esse campo é obrigatório!</div>
                </div>
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" name="email" placeholder="Email" maxlength="30" required>
                    <div class="valid-feedback">Tudo certo!</div>
                    <div class="invalid-feedback">Por favor, esse campo é obrigatório!</div>
                </div>
                <div class="form-group col-md-6">
                    <label for="senha">Senha</label>
                    <input type="password" class="form-control" name="senha" placeholder="Senha" maxlength="15"
                        required>
                    <div class="valid-feedback">Tudo certo!</div>
                    <div class="invalid-feedback">Por favor, esse campo é obrigatório!</div>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" name="command" value="CadastrarUsuario">Cadastrar</button>
        </form>
        <script>
            (function () {
                'use strict';
                window.addEventListener('load', function () {
                    var forms = document.getElementsByClassName('needs-validation');
                    var validation = Array.prototype.filter.call(forms, function (form) {
                        form.addEventListener('submit', function (event) {
                            if (form.checkValidity() === false) {
                                event.preventDefault();
                                event.stopPropagation();
                            }
                            form.classList.add('was-validated');
                        }, false);
                    });
                }, false);
            })();
        </script>

        <c:if test="${not empty erroCadastro}">
            <script>window.alert('Email, ra ou matricula já existem!')</script>
        </c:if>
    </div>

    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>