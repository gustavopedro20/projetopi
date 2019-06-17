<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Alterar Grupo</title>
</head>

<body class="background-image">

    <header>
        <c:import url="common/menu.jsp" />
    </header>

    <div id="main" class="container">
        <form action="controller.do" method="post" autocomplete="off">

            <input type="hidden" name="id_grupo" value="${grupo.id}" />
            <input type="hidden" name="id_prof" value="${grupo.prof.id}" />
            <!-- IMPLEMENTAR A TURMA AINDA -->
            <input type="hidden" name="id_turma" value="${turma.id}" />
            <!-- ATE AQUI -->

            <div id="top" class="row">
                <div class="col align-self-start">
                    <h4 class="page-header">Alterar ${grupo.nome}</h4>
                </div>
            </div>
            <br>
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome do Grupo</label>
                    <input type="text" class="form-control" name="nome_grupo" id="nome_grupo" required maxlength="100"
                        placeholder="nome" value="${grupo.nome}">
                </div>
                <div class="form-group col-md-6">
                    <label for="nome">Número do Grupo</label>
                    <input type="text" class="form-control" name="numero_grupo" id="numero_grupo" required
                        maxlength="100" placeholder="numero" value="${grupo.num}">
                </div>
                <div class="col-md-6 form-group">
                    <label for="aluno">Selecione um Aluno</label>
                    <select class="form-control" id="idAluno" name="idAluno">
                        <c:forEach var="aluno" items="${comboAlunoSemGrupo}">
                            <option value="${aluno.id}">${aluno.nome}</option>
                        </c:forEach>
                    </select> 
                </div>
                <div class="col-md-6 botao-selecione-aluno">
                    <button class="btn btn-outline-success" name="command" value="AdicionarAlunoNoGrupoEditar">Associar</button>
                </div>
            </div>

            <c:if test="${not empty listaAlunos}">
                <div id="list" class="pre-scrollable">
                    <div class="col align-self-start">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Aluno</th>
                                    <th>Email</th>
                                    <th>RA</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="aluno" items="${listaAlunos}">
                                    <tr>
                                        <td>${aluno.id}</td>
                                        <td>${aluno.nome}</td>
                                        <td>${aluno.email}</td>
                                        <td>${aluno.ra} </td>
                                        <td class="actions">
                                            <a class="btn btn-outline-info btn-sm"
                                                href="controller.do?command=ExcluirAlunoGrupo&idAluno=${aluno.id}&idGrupo=${grupo.id}">Remover
                                            </a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>
            <hr>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-outline-primary" name="command"
                        value="EditarGrupo">Salvar</button>
                    <button type="submit" class="btn btn-default" name="command"
                        value="ListarGruposReiniciar">Cancelar</button>
                    <!-- <a href="controller.do?command=ListarGruposBuscar" class="btn btn-default">Cancelar</a> -->
                </div>
            </div>

        </form>

    </div>

    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>