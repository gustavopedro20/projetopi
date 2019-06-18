<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Vizsualizar Atividade</title>
</head>

<body class="background-image">

    <header>
        <c:import url="common/menu.jsp" />
    </header>

    <div id="main" class="container visualizar-atividade">
        <h3 class="page-header">Lista de atividade pendentes</h3>
        <form action="controller.do" method="POST">
            <c:if test="${not empty listaAtividade}">
                <div id="list" class="pre-scrollable">
                    <div class="col align-self-start">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Descrição</th>
                                    <th>Formato de Entrega</th>
                                    <th>Data de Início</th>
                                    <th>Data de Fim</th>
                                    <th class="actions"></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="atividade" items="${listaAtividade}">
                                    <tr>
                                        <td>${atividade.id}</td>
                                        <td>${atividade.descricao}</td>
                                        <td>${atividade.formatoEntrega}</td>
                                        <td>${atividade.dtInicio}</td>
                                        <td>${atividade.dtFim}</td>
                                        <td class="actions">
                                            <c:if test="${not empty sessionScope['alunoLogado']}">
                                                <button id="btn${atividade.id}" type="button" entrega="entrega"
                                                    class="btn btn-outline-info btn-sm" data-toggle="modal"
                                                    data-target="#entrega-modal"
                                                    data-atividade="${atividade.id}">Realizar Entrega
                                                </button>
                                            </c:if>
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
                    <a href="home.jsp" class="btn btn-outline-primary">Voltar</a>
                </div>
            </div>
        </form>
    </div>

    <c:import url="common/entrega-modal.jsp" />

    <footer>
        <c:import url="common/footer.jsp" />
        <script type="text/javascript">
            $("#entrega-modal").on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget);
                var recipient = button.data('atividade');
                $("#id_entrega").val(recipient);
            });
        </script>
    </footer>

    <!-- MODAL MENSAGEM INVALIDO -->
    <div class="modal fade" id="enviado" tabindex="-1" role="dialog" aria-labelledby="enviado" aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered"role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="valido">Mensagem do sistema:</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Fechar">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Atividade entregue com sucesso!
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Fechar</button>
                </div>
            </div>
        </div>
    </div>
    </div>

    <c:if test="${not empty enviado}">
        <script>$('#enviado').modal('show')</script>
    </c:if>

</body>

</html>