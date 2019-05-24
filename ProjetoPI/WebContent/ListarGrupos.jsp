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
        <form action="controller.do" method="post" autocomplete="off">
            <input type="hidden" name="id_turma" value="${grupo.turma.id}" />
            <div id="top" class="row">
                <div class="col align-self-start">
                    <h4>Lista de Grupos</h4>
                </div>
                <!-- Split dropright button -->
                <div class="col-md-6">
                    <div class="btn-group dropright">
                        <button type="button" class="btn btn-outline-primary">Escolha uma turma</button>
                        <button type="button" class="btn btn-outline-primary dropdown-toggle dropdown-toggle-split"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="sr-only">Toggle Dropright</span>
                        </button>
                        <div class="dropdown-menu">
                            <a class="dropdown-item" href="controller.do?command=ListarGruposBuscar&id_turma=1">CCP2AN-MCA</a>
                            <a class="dropdown-item" href="controller.do?command=ListarGruposBuscar&id_turma=2">SIN2AN-MCA</a>
                        </div>
                    </div>
                </div>
            </div>
            <br>
            <c:if test="${not empty lista_grupos}">
                <div id="list" class="row">
                    <div class="col align-self-start">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>Número</th>
                                    <th>Orientador</th>
                                    <th>Nome</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="grupo" items="${lista_grupos}">
                                    <tr>
                                        <td>
                                            ${grupo.num}
                                        </td>
                                        <td>
                                            ${grupo.prof.nome}
                                        </td>
                                        <td>
                                            ${grupo.nome}
                                        </td>
                                        <td class="actions">
                                            <a class="btn btn-outline-info btn-sm"
                                                href="controller.do?command=VisualizarGrupo&id=${grupo.id}&id_turma=${grupo.turma.id}">Visualizar</a>
                                            <!-- <a class="btn btn-secondary btn-sm"
                                                href="controller.do?command=CarregarEdicaoDoGrupo&id_grupo=${grupo.id}">Editar</a> -->
                                            <button id="btn${grupo.id}%>" type="button"
                                                class="btn btn-outline-danger btn-sm" data-toggle="modal"
                                                data-target="#delete-modal" data-grupo="${grupo.id}">Excluir</button>
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
                    <!-- <button type="submit" class="btn btn-primary" name="command" value="CriarGrupo">Próximo</button> -->
                    <a href="home.jsp" class="btn btn-outline-primary">Voltar</a>
                    <!-- "btn btn-outline-info btn-sm" -->
                </div>
            </div>
        </form>
    </div>

    <!-- Modal -->
    <c:import url="common/delete-modal.jsp" />
    <!-- /.Modal -->

    <footer>
        <c:import url="common/footer.jsp" />

        <script type="text/javascript">
            $("#delete-modal").on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); //botao que disparou a modal
                var recipient = button.data('grupo');
                $("#id_excluir").val(recipient);
            });
        </script>
    </footer>

</body>

</html>