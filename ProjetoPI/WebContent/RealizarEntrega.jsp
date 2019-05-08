<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Realizar Entrega</title>
</head>

<body class="background-image">
    <header>
        <c:import url="common/menu.jsp" />
    </header>
    <!-- Container Principal -->
    <div id="main" class="container">

        <div class="row">
            <div class="col-md-12">
                <p><strong>Orientador</strong>
                </p>
                <p>
                    ${grupo.prof.nome}
                </p>
            </div>
            <div class="col-md-12">
                <p><strong>Tema</strong>
                </p>
                <p>
                    ${atividade.nometema}
                </p>
            </div>
        </div>

        <div class="row">
            <div class="col-md-12">
                <p><strong>Grupo</strong>
                </p>
                <p>
                    ${grupo.nome}
                </p>
            </div>
            <div class="col-md-12">
                <p><strong>Turma</strong>
                </p>
                <p>
                    ${turma.nome}
                </p>
            </div>
        </div>

        
        <!-- <div id="actions" class="row">
            <div class="col-md-12">
                <a href="controller.do?command=EditarGrupo&id=${grupo.id}" class="btn btn-primary">Editar</a>
                <a href="#" class="btn btn-danger" data-toggle="modal" data-target="#delete-modal">Excluir</a>
                <a href="ListarGrupos.jsp" class="btn btn-default">Voltar</a>
            </div>
        </div> -->
    </div>



    <footer>
        <c:import url="common/footer.jsp" />
    </footer>
</body>

</html>