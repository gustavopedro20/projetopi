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
        <h4 class="page-header">Cadastro de Usuário</h4>
        <form action="controller.do" method="post">
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="tipo">Selecione o Tipo de Usuário</label>
                    <select class="form-control" id="tipo" name="tipo">
                        <option value="aluno">Aluno</option>
                        <option value="professor">Professor</option>
                    </select>
                </div>
                <div class="form-group col-md-6">
                    <label for="num">RA / Matrícula</label>
                    <input type="text" class="form-control" name="num" id="num" maxlength="15"
                        placeholder="RA / Matrícula">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" maxlength="15"
                        placeholder="Digite o nome do usuário">
                </div>
                <div class="form-group col-md-6">
                    <label for="email">E-mail</label>
                    <input type="number" class="form-control" name="email" id="email" required maxlength="10"
                        placeholder="E-mail">
                </div>
            </div>
            <br />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarUsuario">Próximo</button>
                    <a href="home.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>