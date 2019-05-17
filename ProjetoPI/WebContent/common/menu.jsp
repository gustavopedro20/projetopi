<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav id="menu" class="panel" role="navigation">
	<a href="#menu" class="menu-link">&#9776;</a>
	<div class="box">
			<div class="name-user">${nameUserLogado}</div>
			<div class="email-user">${emailUserLogado}</div>
		</div>
	<ul>
		<li><a href="home.jsp">Home</a></li>
		
		<c:if
			test="${not empty sessionScope['profLogado'] or not empty sessionScope['admLogado']}">
			<li><a href="controller.do?command=ListarGruposBuscar">Lista
					de Grupos</a></li>
			<li><a href="controller.do?command=CarregarCriarGrupo">Cadastro
					de Grupos</a></li>
		</c:if>
		<c:if
			test="${not empty sessionScope['alunoLogado'] or not empty sessionScope['admLogado']}">
			<li><a href="controller.do?command=VisualizarAtividade">Visualizar
					Atividades</a></li>
		</c:if>
		<li><a href="index.jsp">Sair</a></li>
	</ul>

	
</nav>