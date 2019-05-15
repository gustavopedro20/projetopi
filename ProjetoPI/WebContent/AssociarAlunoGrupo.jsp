<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Associar Alunos</title>
</head>

<body class="background-image">

    <c:if test="${not empty sessionScope['alunoLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if>

    <c:if test="${empty sessionScope['userLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if>

    <c:import url="common/menu.jsp" />

    <div id="main" class="container">
        <h4 class="page-header">Associar Alunos</h4>
        <form action="controller.do" method="post">
            <input type="hidden" name="id_grupo" value="${grupo.id}" />

            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="aluno">Selecione um Aluno</label>
                    <select class="form-control" id="aluno_combo" name="aluno_combo">
                        <c:forEach var="aluno" items="${lista_aluno}">
                            <option value="${aluno.id}">${aluno.nome}</option>
                        </c:forEach>
                    </select>
                    <hr>
                    <button class="btn btn-info" name="command" value="AdicionarAlunoNoGrupo">Associar</button>
                </div>
                <!-- <div id="actions" class="row">
                    <button class="btn btn-info" name="command" value="AdicionarAlunoNoGrupo">Associar</button>
                </div> -->
            </div>
            <div id="lista" class="row">
                <div class="table-responsive col-md-12">
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th>Aluno</th>
                                <th>Email</th>
                                <th>RA</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="aluno" items="${lista_alunos_criar}">
                                <tr>
                                    <td>
                                        ${aluno.nome}
                                    </td>
                                    <td>
                                        ${aluno.email}
                                    </td>
                                    <td>
                                        ${aluno.ra}
                                    </td>
                                    <td class="actions">
                                        <a class="btn btn-info btn-sm"
                                            href="controller.do?command=ExcluirAlunoGrupo&id_aluno=${aluno.id}&id_grupo=${grupo.id}&professor=${grupo.prof.nome}&numero=${grupo.num}&nome=${grupo.nome}">Remover</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <!-- <button type="submit" class="btn btn-primary" name="command" value="CriarGrupoAssociarAluno">Salvar</button> -->
                    <a class="btn btn-primary"href="controller.do?command=VisualizarGrupo&id=${grupo.id}">Visualizar</a>
                    <a href="controller.do?command=ExcluirGrupo&id=${grupo.id}" class="btn btn-default">Cancelar</a>
                    <!-- <a href="ListarGrupos.jsp" class="btn btn-default">Cancelar</a> -->
                </div>
            </div>
        </form>
    </div>
    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>