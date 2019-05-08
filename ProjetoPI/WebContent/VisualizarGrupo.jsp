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
        <h3 class="page-header">Grupo de Id: ${grupo.id}</h3>
        <div class="row">
            <div class="col-md-12">
                <p><strong>Professor</strong>
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
        <div class="row">
            <div class="col-md-12">
                <p><strong>Número</strong>
                </p>
                <p>
                    ${grupo.num}
                </p>
            </div>
        </div>
        <hr />
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