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
    <!-- Container Principal -->
    <div id="main" class="container">
        <form action="controller.do" method="post" autocomplete="off">

            <div id="top" class="row">
                <div class="page-header">
                    <h4>Lista de todos os Grupos</h4>
                </div>

                <!-- <div class="col-md-6">
                    <div class="input-group h2">
                        <input name="data[search]" class="form-control" id="search" type="text"
                            placeholder="Pesquisar Grupos (deixe vazio para trazer todos)">
                        <button class="btn btn-primary" type="submit" name="command" value="ListarGruposBuscar">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
                
                
                <div class="col-md-3">
                    <a href="CriarGrupo.jsp" class="btn btn-primary pull-right h2">Novo Grupo</a>
                </div> -->


            </div>

            <!-- /#top -->

            <hr />
            <c:if test="${not empty lista}">
                <div id="list" class="row">
                    <div class="col align-self-start">
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Número</th>
                                    <th>Orientador</th>
                                    <th>Nome</th>
                                    <!-- <th>Numero</th> -->
                                    <!-- <th class="actions">Ações</th> -->
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="grupo" items="${lista}">
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
                                        <!-- <td>
                                            ${grupo.num}
                                        </td> -->
                                        <td class="actions">
                                            <a class="btn btn-info btn-sm"
                                                href="controller.do?command=VisualizarGrupo&id=${grupo.id}">Visualizar</a>
                                            <a class="btn btn-secondary btn-sm"
                                                href="controller.do?command=EditarGrupo&id=${grupo.id}">Editar</a>
                                            <button id="btn${grupo.id}%>" type="button" class="btn btn-danger btn-sm"
                                                data-toggle="modal" data-target="#delete-modal"
                                                data-grupo="${grupo.id}">Excluir</button>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
            </c:if>
            <!-- /#bottom -->
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