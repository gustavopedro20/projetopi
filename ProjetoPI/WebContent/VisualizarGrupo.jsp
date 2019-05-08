<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Detalhes do Grupo</title>
</head>

<body class="background-image">
    <header>
        <c:import url="common/menu.jsp" />
    </header>
    <!-- Container Principal -->
    <div id="main" class="container">
        <form action="controller.do" method="post" autocomplete="off">
            <h4 class="page-header">Vizualizar Grupo ${grupo.nome}</h4>
            <br>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Número</strong>
                    </p>
                    <p>
                        ${grupo.num}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Orientador</strong>
                    </p>
                    <p>
                        ${grupo.prof.nome}
                    </p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <p><strong>Nome</strong>
                    </p>
                    <p>
                        ${grupo.nome}
                    </p>
                </div>
            </div>
            <br />
            <c:if test="${not empty lista}">
                <div id="list" class="row">
                    <div class="col align-self-start">
                        <table class="table table-striped">
                            <thead class="thead-dark">
                                <tr>
                                    <th>Aluno</th>
                                    <th>Email</th>
                                    <th>RA</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
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

                            </tbody>
                        </table>
                    </div>
            </c:if>
        </form>
    </div>




















    <div id="actions" class="row">
        <div class="col-md-12">
            <a href="controller.do?command=EditarGrupo&id=${grupo.id}" class="btn btn-secondary">Editar</a>
            <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
            <a href="ListarGrupos.jsp" class="btn btn-default">Voltar</a>
        </div>
    </div>
    </div>

    <!-- Modal -->
    <c:import url="common/delete-modal.jsp" />
    <!-- /.Modal -->

    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>