<%@page import="model.Telefono"%>
<%@page import="model.Emilio"%>
<%@page import="model.AlumnoView"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">

<head>
<title>ProyectoClase</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href="my-css.css">
</head>

<%
	ArrayList<AlumnoView> listaAlumno = (ArrayList<AlumnoView>) session.getAttribute("listaAlumno");
ArrayList<Curso> listaCurso = (ArrayList<Curso>) session.getAttribute("listaCurso");
%>

<body>

	<div class="container">

		<!-- Header -->

		<div class="row">
			<div class="col-sm-4 py-3">
				<img src="img/header.png" width="100%" />
			</div>
			<div class="col-sm-8 my-auto">
				<!-- Search form -->
				<div class="row">
					<div class="col-9  col-md-11 my-auto">
						<form action="Controller" method="GET">
							<div class="input-group md-form form-sm form-2 pl-0">
								<input class="form-control my-0 py-1" type="text"
									placeholder="Search" aria-label="Search" name="alumno"
									id="alumno">
								<div class="input-group-append ">
									<label for="curso"></label> <select
										class="form-control custom-select input-group-text text-right"
										style="width: 100px;" name="curso" id="curso"
										onchange="this.form.submit()">
										<option value="" readonly>Curso</option>
										<%
											for (Curso curso : listaCurso) {
										%>
										<option value="<%=curso.getGrupo()%>">
											<%=curso.getGrupo()%>
										</option>
										<%
											}
										%>
										<option value="">Todos</option>
									</select>
								</div>
								<input hidden="true" name="op" value="UsuarioBuscar">
							</div>
						</form>
					</div>
					<div class="col-3 col-md-1 my-auto text-right p-sm-0"
						data-toggle="modal" data-target="#AddGroupModal">
						<img src="img/add.svg" alt="addCurso" class="imgAdd-User"
							data-toggle="tooltip" data-placement="bottom"
							title="Añadir curso">
					</div>
				</div>
			</div>
		</div>

		<!--/ Header -->


		<!-- Container -->

		<div class="row">
			<div class="col py-1 bg-secondary"></div>
		</div>


		<%
			for (Curso curso : listaCurso) {
		%>


		<!-- Curso -->

		<div class="row py-sm-3 py-2 titulo">
			<div class="col-sm-auto">

				<h1>
					Curso
					<%=curso.getGrupo()%>
				</h1>

			</div>
			<div class="mb-0 pl-3 py-sm-auto ml-sm-auto open-DeleteObject"
				data-toggle="modal" data-target="#Warning"
				data-data="<%=curso.getGrupo()%>" data-type="Curso">
				<img src="img/delete.svg" alt="DeleteGroup-Curso"
					class="imgAdd-User" data-toggle="tooltip" data-placement="bottom"
					title="Eliminar Curso-<%=curso.getGrupo()%>">
			</div>
			<div class="mb-0 py-sm-auto open-AddUser" data-toggle="modal"
				data-target="#AddUserModal" data-metodo="add"
				data-curso="<%=curso.getGrupo()%>">
				<img src="img/add.svg" alt="addUser" class="imgAdd-User"
					data-toggle="tooltip" data-placement="bottom" title="Añadir alumno">
			</div>
		</div>

		<!-- Cards del curso -->


		<div
			class="row cartabox d-flex align-items-start align-items-stretch flex-row flex-wrap"
			id="myList">

			<!-- Individual card -->

			<%
				for (AlumnoView alumView : listaAlumno) {
				if (alumView.getCurso().equals(curso.getGrupo())) {
			%>

			<!-- card with col -->
			<div class="carta col-sm-12 col-md-6 col-lg-3 pt-3">

				<!-- Card -->
				<div class="card">

					<div class="card-body pb-0">
						<div class="row">
							<div class="col-8">
								<h5 class="card-title">
									<%=alumView.getNombre()%>
								</h5>
								<p class="card-text">
									<%=alumView.getDni()%>
								</p>
								<p hidden="true">
									<%=alumView.getCurso()%>
								</p>
							</div>
							<div class="col-4 text-right">
								<div class="mb-0 py-sm-auto open-AddUser" data-metodo="edit"
									data-curso="<%=alumView.getCurso()%>"
									data-dni="<%=alumView.getDni()%>"
									data-nombre="<%=alumView.getNombre()%>" data-toggle="modal"
									data-target="#AddUserModal">
									<img src="img/add.svg" alt="addUser" class="imgAdd"
										data-toggle="tooltip" data-placement="bottom"
										title="Editar alumno">
								</div>
								<div data-toggle="modal" data-target="#Warning"
									data-data="<%=alumView.getDni()%>" data-type="Alumno"
									class="mb-0 py-sm-auto open-DeleteObject">
									<img class="imgAdd" src="img/delete.svg"
										alt="DeletePhone-03954928P" data-toggle="tooltip"
										data-placement="bottom" title="Eliminar Alumno-Nombre">
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-12"></div>
						</div>
					</div>

					<!-- Acordeon con email y telefono-->


					<div id="Acordeon<%=alumView.getDni()%>" class="acordeon"
						role="tablist" aria-multiselectable="true">

						<!-- Email Acordeon Head -->

						<div class="card" style="height: auto">
							<div class="card-header" role="tab"
								id="HeadEmail-<%=alumView.getDni()%>">
								<div class="row mb-0">
									<div class="col-8 my-auto">
										<a data-toggle="collapse"
											data-parent="#Acordeon<%=alumView.getDni()%>"
											href="#ContentEmail-<%=alumView.getDni()%>"
											aria-expanded="false"
											aria-controls="ContentEmail-<%=alumView.getDni()%>">
											<h5 class="mb-0">Emails</h5>
										</a>
									</div>
									<div class="col-4 text-right">
										<a data-toggle="modal" data-target="#AddEmailModal"
											data-dniemail="<%=alumView.getDni()%>"
											data-nombre="<%=alumView.getNombre()%>"
											class="open-AddEmail"> <img class="imgAdd"
											src="img/add.svg" alt="AddEmail" data-toggle="tooltip"
											data-placement="bottom" title="Añadir Email">
										</a>
									</div>
								</div>
							</div>
							<div id="ContentEmail-<%=alumView.getDni()%>" class="collapse"
								role="tabpanel"
								aria-labelledby="<%=alumView.getDni()%>-HeadEmail">
								<div class="card-body pt-1">

									<!-- Email Acordeon content -->

									<%
										for (Emilio emilio : alumView.getEmilios()) {
									%>

									<!-- individual Email-->

									<div class="row content">
										<div class="col-8 my-auto">
											<%=emilio.getEmail()%>
											<br />
										</div>
										<div class="col-4 text-right">
											<a data-toggle="modal" data-target="#Warning"
												data-data="<%=emilio.getEmail()%>" data-type="Email"
												class="open-DeleteObject"> <img class="imgDel"
												src="img/delete.svg"
												alt="DeleteEmail-<%=emilio.getEmail()%>"
												data-toggle="tooltip" data-placement="bottom"
												title="Eliminar Email-<%=emilio.getEmail()%>">
											</a>
										</div>
									</div>

									<!--/ individual Email -->

									<%
										}
									%>

									<!--/Email Acordeon content -->

								</div>
							</div>
						</div>

						<!-- Phone Acordeon Head -->

						<div class="card" style="height: auto">
							<div id="<%=alumView.getDni()%>-HeadPhone" class="card-header"
								role="tab">
								<h5 class="mb-0">
									<div class="row">
										<div class="col-8 my-auto">
											<a data-toggle="collapse"
												data-parent="#Acordeon<%=alumView.getDni()%>"
												href="#ContentPhone-<%=alumView.getDni()%>"
												aria-expanded="false"
												aria-controls="ContentPhone-<%=alumView.getDni()%>">
												Telefonos </a>
										</div>
										<div class="col-4 text-right">
											<a data-toggle="modal" data-target="#AddPhoneModal"
												data-dniphone="<%=alumView.getDni()%>"
												data-nombre="<%=alumView.getNombre()%>"
												class="open-AddPhone"> <img class="imgAdd"
												src="img/add.svg" alt="AddPhone" data-toggle="tooltip"
												data-placement="bottom" title="Añadir Telefono">
											</a>
										</div>
									</div>
								</h5>
							</div>
							<div id="ContentPhone-<%=alumView.getDni()%>" class="collapse"
								role="tabpanel"
								aria-labelledby="<%=alumView.getDni()%>-HeadPhone">
								<div class="card-body pt-1">

									<!-- Phone Acordeon content -->

									<%
										for (Telefono telefono : alumView.getTelefonos()) {
									%>

									<div class="row content">
										<div class="col-8 my-auto">
											<%=telefono.getTlf()%>
											<br />
										</div>
										<div class="col-4 text-right">
											<a data-toggle="modal" data-target="#Warning"
												data-data="<%=telefono.getTlf()%>" data-type="Telefono"
												class="open-DeleteObject"> <img class="imgDel"
												src="img/delete.svg"
												alt="DeletePhone-<%=telefono.getTlf()%>"
												data-toggle="tooltip" data-placement="bottom"
												title="Eliminar Telefono <%=telefono.getTlf()%>">
											</a>
										</div>
									</div>

									<%
										}
									%>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
			<%
				}
			}
			%>
		</div>

		<!--/ Individual card -->
		<!--/ Cards del curso -->
		<!--/ Curso -->

		<%
			}
		%>
		<!--/ Container -->
		<!-- Footer -->

		<div class="row pt-4">
			<div class="col-12 py-1 bg-secondary"></div>
			<div class="col-12 footer py-2 text-center">
				<h4>Agenda azarquiel - Grupo1 - 2020</h4>
			</div>
		</div>

		<!--/ Footer -->

	</div>


	<!-- Modales -->

	<!-- Warning before deleting modal -->

	<div class="modal fade" id="Warning" tabindex="-1" role="dialog"
		aria-labelledby="WarningLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="WarningLabel">¡Cuidado!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="Controller" method="POST">
					<div class="modal-body">
						<p>
							¿Estas seguro de que quieres eliminar <a id="Object"> </a> ? <input
								type="hidden" name="Key" id="Key" value=""> <input
								type="hidden" name="op" id="op" value="">

						</p>

					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-danger" data-dismiss="modal">
							No</button>
						<button type="submit" class="btn btn-success">Si</button>

					</div>
				</form>
			</div>
		</div>
	</div>


	<!-- AddUser Modal  -->

	<div class="modal fade" id="AddUserModal" tabindex="-1" role="dialog"
		aria-labelledby="AddUserLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="AddUserLabel"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="Controller" method="POST">
					<div class="modal-body">
						<div class="row py-1">
							<div class="col-3">DNI:</div>
							<div class="col-9">
								<input class="form-control" type="text" name="dniAlumno"
									id="DNI" placeholder="DNI" required="required">
							</div>
						</div>
						<div class="row py-1">
							<div class="col-3">Nombre:</div>
							<div class="col-9">
								<input class="form-control" type="text" name="nombreAlumno"
									id="Nombre" placeholder="Tu nombre" required="required">
							</div>
						</div>
						<div class="row py-1">
							<div class="col-3">Curso:</div>
							<div class="col-9">
								<select class="form-control" id="cursoSelect">
									<%
										for (Curso curso : listaCurso) {
									%>
									<option class="option" id="<%=curso.getGrupo()%>"
										data-value="<%=curso.getGrupo()%>">"<%=curso.getGrupo()%>"
									</option>
									<%
										}
									%>
								</select>
							</div>
							<input type="hidden" name="cursoAlumno" id="CursoValue" value="">
						</div>
						<input type="hidden" name="op" id="opAddAlumno" value="addAlumno">
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<button type="submit" class="btn btn-primary">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- AddPhone Modal -->

	<div class="modal fade" id="AddPhoneModal" tabindex="-1" role="dialog"
		aria-labelledby="AddPhonelLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="AddPhoneTitle"></h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="Controller" method="POST">
					<div class="modal-body">
						<div class="row">
							<div class="col-3">Telefono:</div>
							<div class="col-9">
								<input class="form-control" type="text" name="tlf" id="tlf">
							</div>
						</div>

						<input hidden="true" name="dni" id="dniPhone"> <input
							hidden="true" name="op" id="op" value="addTelefono">


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<button type="sumbit" class="btn btn-primary">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- AddEmail Modal -->
<%--  --%>
	<div class="modal fade" id="AddEmailModal" tabindex="-1" role="dialog"
		aria-labelledby="AddEmailLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="AddEmailTitle">Añadir Email a</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="Controller" method="POST">
					<div class="modal-body">
						<div class="row">
							<div class="col-3">Email:</div>
							<div class="col-9">
								<input class="form-control" type="text" name="Email" id="Email">
							</div>
						</div>

						<input hidden="true" name="dni" id="dniEmail"> <input
							hidden="true" name="op" id="op" value="addEmail">


					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<button type="sumbit" class="btn btn-primary">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- AddGroup Modal -->


	<div class="modal fade" id="AddGroupModal" tabindex="-1" role="dialog"
		aria-labelledby="AddGroupLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Añadir curso</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="Controller" method="POST">
					<div class="modal-body">
						<div class="row">
							<div class="col-3">Curso:</div>
							<div class="col-9">
								<input type="text" class="form-control" name="grupo" id="grupo">
							</div>
						</div>

						<input hidden="true" id="op" name="op" value="addCurso" />

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Cerrar</button>
						<button type="submit" class="btn btn-primary">Enviar</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="my-js.js">
		
	</script>
</body>

</html>