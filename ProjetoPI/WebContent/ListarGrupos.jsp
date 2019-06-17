<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Listar Grupos</title>
</head>

<body class="background-image">

    <header>
        <c:import url="common/menu.jsp" />
    </header>

    <div id="main" class="container">
        <form action="controller.do" method="POST" autocomplete="off">
            <input type="hidden" name="id_turma" value="${grupo.turma.id}" />
            <div id="top" class="col align-self-start">
                <h4>Lista de Grupos</h4>
            </div>
            <hr>
            <div class="col align-self-start">
                <dix class="row">
                    <div class="col-md-3 form-group">
                        <select class="form-control" id="sigla" name="sigla">
                            <c:forEach var="turma" items="${comboTurma}">
                                <option value="${turma.sigla}">${turma.sigla}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-3 form-group">
                        <select class="form-control" name="ano" id="ano">
                            <option value="2019">2019</option>
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                        </select>
                    </div>
                    <div class="col-md-3 form-group">
                        <select class="form-control" name="semestre" id="semestre">
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </div>
                    <div class="col-md-1-group">
                        <button class="btn btn-outline-warning" name="command" value="ListarGruposBuscar">Buscar</button>
                    </div>
                    <div class="col-md-1-group">
                        <button class="btn btn-outline-success" name="command" value="ListarGruposReiniciar" style="margin-left: 14px">Buscar Todos</button>
                    </div>
                </dix>
            </div>
            <c:if test="${not empty listaGrupos}">
                <div id="list" class="row">
                    <div class="col align-self-start">
                        <table class="table table-hover">
                            <thead class="text-center">
                                <tr>
                                    <th>#</th>
                                    <th>Número</th>
                                    <th>Orientador</th>
                                    <th>Nome</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="grupo" items="${listaGrupos}">
                                    <tr class="text-center">
                                        <td>${grupo.id}</td>
                                        <td>${grupo.num}</td>
                                        <td>${grupo.prof.nome}</td>
                                        <td>${grupo.nome}</td>
                                        <td class="actions">
                                            <a class="btn btn-outline-info btn-sm"
                                                href="controller.do?command=VisualizarGrupo&idGrupo=${grupo.id}">Visualizar
                                            </a>
                                            <button id="btn${grupo.id}%>" type="button"
                                                class="btn btn-outline-danger btn-sm" data-toggle="modal"
                                                data-target="#delete-modal" data-grupo="${grupo.id}">Excluir
                                            </button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <a href="home.jsp" class="btn btn-outline-primary">Voltar</a>
                </div>
            </div>
        </form>
    </div>

    <c:import url="common/delete-modal.jsp" />

    <footer>
        <c:import url="common/footer.jsp" />

        <script type="text/javascript">
            $("#delete-modal").on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget);
                var recipient = button.data('grupo');
                $("#id_excluir").val(recipient);
            });
        </script>
    </footer>
</body>

</html>