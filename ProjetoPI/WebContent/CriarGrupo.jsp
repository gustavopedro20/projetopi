<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Criar Grupo</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Barra superior com os menus de navegação -->
	<c:import url="Menu.jsp"/>
    <!-- Container Principal -->
    <div id="main" class="container">
        <h3 class="page-header">Incluir Grupo</h3>
        <!-- Formulario para inclusao de clientes -->
        <form action="listar_professores.do" method="post">
            <!-- area de campos do form -->
            
            <div class="container">
					<!--  <h4 class="page-header">Teste Combo Box</h4>-->
				<div class="row">
					<div class="col-sm-3">
						<select class="form-control">
							<c:forEach var="professor" items="${lista}">
							
								<option value="${professor.id}">${professor.nome}</option>	
								
                            </c:forEach>
						</select>
					</div>
				</div>
				<br />
			</div>
            
       <!--
             <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Professor</label>
                    <input type="text" class="form-control" name="professor" id="professor" required maxlength="100" placeholder="professor">
                </div>
            </div>
            --> 
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" required maxlength="100" placeholder="nome">
                </div>
            </div>
            
            <div class="row">
                <div class="form-group col-md-12">
                    <label for="nome">Numero</label>
                    <input type="text" class="form-control" name="numero" id="numero" required maxlength="100" placeholder="numero">
                </div>
            </div>
            <hr />
            <div id="actions" class="row">
                <div class="col-md-12">
                    <button type="submit" class="btn btn-primary" name="acao" value="Criar">Salvar</button>
                    <a href="index.jsp" class="btn btn-default">Cancelar</a>
                </div>
            </div>
        </form>
    </div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</body>

</html>