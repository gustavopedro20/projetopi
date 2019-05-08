<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="pt-br">

<head>
    <c:import url="common/meta-link.jsp" />
    <title>USJT - Criar Grupo</title>
</head>

<body class="background-image">
    <!-- Barra superior com os menus de navegação -->
	<c:import url="common/menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Cadastro de Novo Grupo</h3>
        <!-- Formulario para inclusao de grupos -->
        <form action="controller.do" method="post">
            <!-- area de campos do form -->
        
            <br>
            <div class="row">
                <div class="col-sm-3">
                    <select class="form-control">
                        <!-- <option selected="selected">Professores: </option> -->
                        <c:forEach var="professor" items="${lista}">                        
                            <option value="${professor.id}">${professor.nome}</option>                      
                        </c:forEach>
                    </select>
                </div>
            </div>
            <br />
        
            
            <div class="row">
                <div class="form-group col-md-6">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" maxlength="15" placeholder="Nome do grupo (não obrigatório)">
                </div>
            
                <div class="form-group col-md-6">
                    <label for="nome">Numero</label>
                    <input type="text" class="form-control" name="numero" id="numero" required maxlength="10" placeholder="Número do grupo">
                </div>
            </div>
            <br />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="command" value="CriarGrupo">Salvar</button>
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