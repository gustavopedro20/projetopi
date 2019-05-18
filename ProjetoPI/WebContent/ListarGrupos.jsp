<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Listar Grupos</title>
</head>

<body class="background-image">

    <!-- <c:if test="${not empty sessionScope['alunoLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if>

    <c:if test="${empty sessionScope['userLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if> -->

    <header>
        <c:import url="common/menu.jsp" />
    </header>

    <div id="main" class="container" role="main">
        <form action="controller.do" method="post" autocomplete="off">

            <div id="top" class="row">
                <div class="col align-self-start">
                    <h4>Lista de todos os Grupos</h4>
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
                                                href="controller.do?command=VisualizarGrupo&id=${grupo.id}">Visualizar</a>
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