<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Vizsualizar Atividade</title>
</head>

<body class="background-image">

    <!-- <c:if test="${empty sessionScope['userLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if> -->

    <header>
        <c:import url="common/menu.jsp" />
    </header>

    <div id="main" class="container visualizar-atividade">
        <form action="controller.do" method="POST">
            <!-- <div id="top" class="row">

                <div class="page-header">
                    <h4>Lista de todos as Atividades</h4>
                </div>

            </div> -->
            <c:if test="${not empty lista_atividade}">
                <div id="list" class="pre-scrollable">
                    <div class="col align-self-start">
                        <h4>Lista de Atividade pendentes</h4>                      
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <!-- <th>Tema</th> -->
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
                                        <!-- <td>
                                            ${atividade.nomeTema}
                                        </td> -->
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
                                            <c:if test="${not empty sessionScope['alunoLogado']}">
                                                <button id="btn${atividade.id}" type="button" entrega="entrega"
                                                    class="btn btn-outline-info btn-sm" data-toggle= "modal"
                                                    data-target="#entrega-modal" data-atividade="${atividade.id}" >Realizar Entrega
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

    <c:import url="common/entrega-modal.jsp"/>

    <footer>
        <c:import url="common/footer.jsp" />

        <script type="text/javascript">
            $("#entrega-modal").on('show.bs.modal', function (event) {
                var button = $(event.relatedTarget); //botao que disparou a modal
                var recipient = button.data('atividade');
                $("#id_entrega").val(recipient);
            });
        </script>
    </footer>
</body>


</html>