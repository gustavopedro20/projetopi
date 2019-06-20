<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="pt-br">

<head>
<c:import url="common/meta-link.jsp" />
<title>USJT - Associar Alunos</title>
</head>

<body class="background-image">

	<c:import url="common/menu.jsp" />

	<div id="main" class="container">
		<h4 class="page-header">Associar Alunos</h4>
		<form action="controller.do" method="post">
			<input type="hidden" name="idGrupo" value="${grupo.id}" />
			<div id="top" class="row">

				<div class="col-md-6 form-group">
					<label for="aluno">Selecione um Aluno</label> <select
						class="form-control" id="idAluno" name="idAluno">
						<c:forEach var="aluno" items="${comboAlunoSemGrupo}">
							<option value="${aluno.id}">${aluno.nome}</option>
						</c:forEach>
					</select>

				</div>
				<c:if test="${not empty comboAlunoSemGrupo}">
					<div class="col-md-6 botao-selecione-aluno">
						<button class="btn btn-outline-success" name="command" value="AdicionarAlunoNoGrupo">Associar</button>
					</div>
				</c:if>
			</div>

			<c:if test="${not empty listaAlunosCriar}">     
                <div id="lista" class="pre-scrollable">
					<div class="table-responsive col-md-12">
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Aluno</th>
									<th>Email</th>
									<th>RA</th>
									<th></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="aluno" items="${listaAlunosCriar}">
									<tr>
										<td>${aluno.nome}</td>
										<td>${aluno.email}</td>
										<td>${aluno.ra}</td>
										<td class="actions"><a
											class="btn btn-outline-info btn-sm"
											href="controller.do?command=ExcluirAlunoGrupo&id_aluno=${aluno.id}&id_grupo=${grupo.id}&professor=${grupo.prof.nome}&numero=${grupo.num}&nome=${grupo.nome}">Remover</a>
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
					<button class="btn btn-outline-primary" name="command"
						value="VisualizarGrupo">Salvar</button>
					<a href="controller.do?command=ExcluirGrupo&id=${grupo.id}"
						class="btn btn-default">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<footer>
		<c:import url="common/footer.jsp" />
	</footer>
</body>

</html>