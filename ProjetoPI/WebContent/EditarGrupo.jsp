<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Alterar Grupo</title>
</head>

<body class="background-image">

    <c:if test="${not empty sessionScope['alunoLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if>

    <c:if test="${empty sessionScope['userLogado']}">     
        <c:redirect url="index.jsp" />
    </c:if>
    <!-- Barra superior com os menus de navegação -->
    <c:import url="common/menu.jsp" />
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Alterar Grupo #${grupo.id }</h3>
        <!-- Formulario para alteração de clientes -->
        <form action="controller.do" method="post" autocomplete="off">
            <!-- area de campos do form -->
            <input type="hidden" name="id_grupo" value="${grupo.id}" />
            <input type="hidden" name="id_prof" value="${grupo.prof.id}" />
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome_grupo" id="nome_grupo" required maxlength="100"
                        placeholder="nome" value="${grupo.nome}">
                </div>
            </div>
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Numero</label>
                    <input type="text" class="form-control" name="numero_grupo" id="numero_grupo" required
                        maxlength="100" placeholder="numero" value="${grupo.num}">
                </div>
            </div>
            <hr />

            <c:if test="${not empty lista_alunos}">
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
                                <c:forEach var="aluno" items="${lista_alunos}">
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
                                                href="controller.do?command=ExcluirAlunoGrupo&id_aluno=${aluno.id}&id_grupo=${grupo.id}">Remover</a>
                                        </td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>
            </c:if>
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="EditarGrupo">Salvar</button>
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