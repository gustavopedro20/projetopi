<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav id="menu" class="panel" role="navigation">
	<a href="#menu" class="menu-link">&#9776;</a>
	<div class="text-center box">
			<div class="name-user">${userLogado.nome}</div>
			<div class="email-user">${userLogado.email}</div>
		</div>
	<ul>
		<li><a href="home.jsp">Home</a></li>
		
		<c:if
			test="${not empty sessionScope['profLogado'] or not empty sessionScope['admLogado']}">
			<li><a href="controller.do?command=ListarGruposReiniciar">Lista
					de Grupos</a></li>
			<li><a href="controller.do?command=CarregarCriarGrupo">Cadastro
					de Grupos</a></li>
		</c:if>
		<c:if
			test="${not empty sessionScope['alunoLogado'] or not empty sessionScope['admLogado']}">
			<li><a href="controller.do?command=VisualizarAtividade">Visualizar
					Atividades</a></li>
		</c:if>
		<li><a href="logout.jsp">Sair</a></li>
	</ul>

	
</nav>