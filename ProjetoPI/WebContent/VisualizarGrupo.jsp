<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
	<c:import url="common/meta-link.jsp" />
	<title>USJT - Detalhes do Grupo</title>
</head>

<body class="background-image">

	<!-- <c:if test="${not empty sessionScope['alunoLogado']}">     
        <c:redirect url="index.jsp" />
	</c:if>

	<c:if test="${empty sessionScope['userLogado']}">     
        <c:redirect url="index.jsp" />
	</c:if> -->

	<header>
		<c:import url="common/menu.jsp" />
	</header>

	<div id="main" class="container">
		<form action="controller.do" method="post" autocomplete="off">
			<input type="hidden" name="idGrupo" value="${grupo.id}" />
			<h4 class="page-header">Visualizar ${grupo.nome}</h4>
			<hr>
			<div class="row">
				<div class="col-md-12">
					<p>
						<strong>Número</strong>
					</p>
					<p>${grupo.num}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<p>
						<strong>Orientador</strong>
					</p>
					<p>${grupo.prof.nome}</p>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<p>
						<strong>Nome</strong>
					</p>
					<p>${grupo.nome}</p>
				</div>
			</div>
			<br />
			<c:if test="${not empty listaAlunos}">
				<div id="list" class="pre-scrollable">
					<div class="col align-self-start">
						<table class="table table-hover">
							<thead>
								<tr>
									<th>#</th>
									<th>Aluno</th>
									<th>Email</th>
									<th>RA</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="aluno" items="${listaAlunos}">
									<tr>
										<td>${aluno.id}</td>
										<td>${aluno.nome}</td>
										<td>${aluno.email}</td>
										<td>${aluno.ra}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</c:if>
			<div id="actions" class="row">
				<div class="col-md-12">
					<!-- <a href="controller.do?command=CarregarEdicaoDoGrupo&id_grupo=${grupo.id}&id_turma=${grupo.turma.id}"
						class="btn btn-outline-dark">Editar</a> -->
					<button name="command" value="CarregarEdicaoDoGrupo" class="btn btn-outline-dark">Editar</button>
					<button id="btn${grupo.id}%>" type="button" class="btn btn-outline-danger" data-toggle="modal"
						data-target="#delete-modal" data-grupo="${grupo.id}">Excluir</button>
					<a href="controller.do?command=ListarGruposReiniciar" class="btn btn-default">Voltar</a>
				</div>
			</div>
		</form>
	</div>

	<!-- Modal -->
	<c:import url="common/delete-modal.jsp" />
	<!-- /.Modal -->

	<footer>
		<c:import url="common/footer.jsp" />

		<script type="text/javascript">
			$("#delete-modal").on('show.bs.modal', function (event) {
				var button = $(event.relatedTarget); //botao que disparou a modal
				var recipient = button.data('grupo');
				$("#id_excluir").val(recipient);
			});
		</script>
	</footer>
</body>

</html>