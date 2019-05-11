<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Vizsualizar Atividade</title>
</head>

<body class="background-image">

    <c:if test="${empty sessionScope['userLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if>

    <header>
        <c:import url="common/menu.jsp" />
    </header>

    <div id="main" class="container">
        <form action="controller.do" method="POST">
            <!-- <div id="top" class="row">

                <div class="page-header">
                    <h4>Lista de todos as Atividades</h4>
                </div>

            </div> -->
            <c:if test="${not empty lista}">
                <div id="list" class="row">
                    <div class="col align-self-start">
                        <h4>Lista de todos as Atividades</h4>
                        <table class="table table-striped">
                            <thead>
                                <tr>
                                    <th>Tema</th>
                                    <th>Descrição</th>
                                    <th>Formato de Entrega</th>
                                    <th>Data de Início</th>
                                    <th>Data de Fim</th>
                                    <th class="actions"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="atividade" items="${lista_atividade}">
                                    <tr>
                                        <td>
                                            ${atividade.nomeTema}
                                        </td>
                                        <td>
                                            ${atividade.descricao}
                                        </td>
                                        <td>
                                            ${atividade.formatoEntrega}
                                        </td>
                                        <td>
                                            ${atividade.dtInicio}
                                        </td>
                                        <td>
                                            ${atividade.dtFim}
                                        </td>
                                        <td class="actions">
                                            <a class="btn btn-info btn-sm"
                                                href="controller.do?command=EnviarAtividade&id=${atividade.id}"
                                                data-toggle="modal" data-target="#entregando" data-atividade="${atividade.id}">Realizar Entrega</a>
                                                <!-- &atividade=${atividade.formatoEntrega} -->
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </c:if>

            <div id="actions" class="row">
                <div class="col-md-12">
                    <!-- <button type="submit" class="btn btn-primary" name="command" value="CriarGrupo">Voltar</button> -->
                    <a href="" class="btn btn-secondary">Voltar</a>
                </div>
            </div>
        </form>
    </div>

    <footer>

        <div class="modal fade" id="entregando" tabindex="-1" role="dialog" aria-labelledby="modalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Fechar"><span
                                aria-hidden="true">&times;</span>
                        </button>
                        <!-- <h4 class="modal-title" id="modalLabel">Anexar entrega</h4> -->
                    </div>
                    <div class="modal-body">
                        <h4>Entrega de Atividade</h4>
                        <input class="form-control" type="text" placeholder="Insira o link da atividade"
                            name="entrega" id="entrega">
                    </div>
                    <div class="modal-footer">
                        <form action="controller.do" method="post">
                            <input type="hidden" name="id" id="id_entrega" />
                            <button type="submit" class="btn btn-primary" name="command" value="EnviarAtividade">Enviar</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <c:import url="common/footer.jsp" />

        <script type="text/javascript">
            $("#entregando").on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); //botao que disparou a modal
                var recipient = button.data('atividade');
                $("#id_entrega").val(recipient);
            });
        </script>
    </footer>

</body>


</html>