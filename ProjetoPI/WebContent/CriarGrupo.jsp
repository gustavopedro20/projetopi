<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Criar Grupo</title>
</head>

<body class="background-image">

    <c:import url="common/menu.jsp" />

    <div id="main" class="container">
        <h4 class="page-header">Criar Grupo</h4>
        <form action="controller.do" method="post">
            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="professor">Selecione um Professor</label>
                    <select class="form-control" id="professor" name="professor">
                        <c:forEach var="professor" items="${comboProfessor}">
                            <option value="${professor.id}">${professor.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 form-group">
                    <label for="turma">Selecione uma Turma</label>
                    <select class="form-control" id="turma" name="turma">
                        <c:forEach var="turma" items="${comboTurma}">
                            <option value="${turma.id}">${turma.sigla}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome do Grupo</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="15"
                        placeholder="Nome do grupo">
                </div>
                <div class="form-group col-md-6">
                    <label for="nome">Número do Grupo</label>
                    <input type="number" class="form-control" name="numero" id="numero" required maxlength="10"
                        placeholder="Número do grupo">
                </div>
            </div>
            <br />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarGrupo">Próximo</button>
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