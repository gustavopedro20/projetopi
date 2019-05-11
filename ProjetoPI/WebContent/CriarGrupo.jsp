<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Criar Grupo</title>
</head>

<body class="background-image">

    <c:if test="${empty sessionScope['userLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if>

    <!-- Barra superior com os menus de navegação -->
    <c:import url="common/menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Cadastro de Novo Grupo</h3>
        <!-- Formulario para inclusao de grupos -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->


            <div class="row">
                <div class="col-md-6 form-group">
                    <label for="professor">Selecione um Professor</label>
                    <select class="form-control" id="professor" name="professor">
                        <!-- <option selected="selected">Professores: </option> -->
                        <c:forEach var="professor" items="${lista_professor}">
                            <option value="${professor.id}">${professor.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-md-6 form-group">
                    <label for="turma">Selecione uma Turma</label>
                    <select class="form-control" id="turma" name="turma">
                        <c:forEach var="turma" items="${lista_turma}">
                            <option value="${turma.id}">${turma.sigla}</option>
                        </c:forEach>
                    </select>
                </div>
            </div>

            <div class="row">
                <div class="col-md-11 form-group">
                    <label for="aluno">Selecione um Aluno</label>
                    <select class="form-control" id="aluno" name="aluno">
                        <c:forEach var="aluno" items="${lista_aluno}">
                            <option value="${aluno.id}">${aluno.nome}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="actions form-group">
                    <a class="btn btn-info btn-sm"
                        href="controller.do?command=AdicionarAlunoNoGrupo&id_aluno=${aluno.getId()}">Associar</a>

                </div>

            </div>

            <div id="lista" class="row">
                <div class="col align-self-start">
                    <table class="table table-striped">
                        <thead class="thead-default">
                            <tr>
                                <th>Aluno</th>
                                <th>Email</th>
                                <th>RA</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${not empty lista}">
                                <c:forEach var="aluno" items="${lista}">
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
                            </c:if>

                        </tbody>
                    </table>
                </div>
            </div>


            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome do Grupo</label>
                    <input type="text" class="form-control" name="nome" id="nome" maxlength="15"
                        placeholder="Nome do grupo (não obrigatório)">
                </div>

                <div class="form-group col-md-6">
                    <label for="nome">Número do Grupo</label>
                    <input type="text" class="form-control" name="numero" id="numero" required maxlength="10"
                        placeholder="Número do grupo">
                </div>
            </div>
            <br />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarGrupo">Salvar</button>
                    <a href="ListarGrupos.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>

    </div>

    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>