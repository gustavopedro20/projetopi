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
                                            <a class="btn btn-info btn-sm" href="">Realizar Entrega</a>
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
        <c:import url="common/footer.jsp" />
    </footer>

</body>

</html>