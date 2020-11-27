<%@page import="model.Telefono"%>
<%@page import="model.Emilio"%>
<%@page import="model.AlumnoView"%>
<%@page import="model.Curso"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <title>ProyectoClase</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="my-css.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<%

ArrayList<AlumnoView> listaAlumno  = (ArrayList<AlumnoView>) session.getAttribute("listaAlumno"); 
ArrayList<Curso> listaCurso  = (ArrayList<Curso>) session.getAttribute("listaCurso");

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
                        <input class="form-control" id="listSearch" type="text" placeholder="Busca alumnos o cursos">
                    </div>
                    <div class="col-3 col-md-1 my-auto text-right p-sm-0" data-toggle="tooltip" data-placement="bottom" title="Añadir curso" >
                        <img src="img/add.svg" alt="addUser" class="imgAdd-User" >
                    </div>
                </div>
            </div>
        </div>

        <!--/ Header -->


        <!-- Container -->

        <div class="row">
            <div class="col py-1 bg-secondary">
            </div>
        </div>


<% for (Curso curso : listaCurso)
		{
		
		%>


        <!-- Curso -->

        <div class="row py-sm-3 py-2 titulo">
            <div class="col-sm-auto">

                <h1> Curso <%= curso.getGrupo() %> </h1>

            </div>
            <div class="mb-0 pl-3 py-sm-auto ml-sm-auto open-DeleteObject" data-toggle="modal" data-target="#Warning" data-data="Año" data-type="Curso">
                <img src="img/delete.svg" alt="DeleteGroup-Curso" class="imgAdd-User" data-toggle="tooltip" data-placement="bottom" title="Eliminar Curso-<%= curso.getGrupo() %>" >
            </div>
            <div class="mb-0 py-sm-auto open-AddUser" data-toggle="modal" data-target="#AddUserModal" data-curso="<%= curso.getGrupo() %>" >
                <img src="img/add.svg" alt="addUser" class="imgAdd-User" data-toggle="tooltip" data-placement="bottom" title="Añadir alumno" >
            </div>
        </div>

        <!-- Cards del curso -->


        <div class="row cartabox d-flex align-items-start align-items-stretch flex-row flex-wrap" id="myList">
	
        <!-- Individual card -->
        
		<% for (AlumnoView alumView : listaAlumno)
		{	
			if ( alumView.getCurso().equals( curso.getGrupo() ) ) {
		%>

            <!-- card with col -->
            <div class="carta col-sm-12 col-md-6 col-lg-3 pt-3">

                <!-- Card -->
                <div class="card">

                    <div class="card-body pb-0">
                        <div class="row">
                            <div class="col-8">
                                <h5 class="card-title"> <%=alumView.getNombre()%> </h5>
                                <p class="card-text"> <%=alumView.getDni()%> </p>
                                <p hidden> <%=alumView.getCurso()%> </p>
                            </div>
                            <div class="col-4 text-right">
                                <a data-toggle="modal" data-target="#Warning" data-data="<%=alumView.getNombre()%>"
                                    data-type="Alumno" class="open-DeleteObject">
                                    <img class="imgDel" src="img/delete.svg" alt="DeletePhone-<%=alumView.getDni()%>" data-toggle="tooltip" data-placement="bottom" title="Eliminar Alumno <%=alumView.getNombre()%>">
                                </a>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-12">
                                
                            </div>
                        </div>
                    </div>

                    <!-- Acordeon con email y telefono-->


                    <div id="Acordeon<%=alumView.getDni()%>" class="acordeon" role="tablist" aria-multiselectable="true">

                        <!-- Email Acordeon Head -->

                        <div class="card">
                            <div class="card-header" role="tab" id="HeadEmail-<%=alumView.getDni()%>">
                                <h5 class="mb-0">
                                    <div class="row">
                                        <div class="col-8 my-auto">
                                            <a data-toggle="collapse" data-parent="#Acordeon<%= alumView.getDni() %>"
                                                href="#ContentEmail-<%=alumView.getDni()%>" aria-expanded="false"
                                                aria-controls="ContentEmail-<%=alumView.getDni()%>">
                                                Emails
                                            </a>
                                        </div>
                                        <div class="col-4 text-right">
                                            <a data-toggle="modal" data-target="#AddEmail">
                                                <img class="imgAdd" src="img/add.svg" alt="AddEmail" data-toggle="tooltip" data-placement="bottom" title="Añadir Email">
                                            </a>
                                        </div>
                                    </div>
                                </h5>
                            </div>
                            <div id="ContentEmail-<%=alumView.getDni()%>" class="collapse" role="tabpanel"
                                aria-labelledby="<%=alumView.getDni()%>-HeadEmail">
                                <div class="card-body pt-1">

                                    <!-- Email Acordeon content -->

									<% for (Emilio emilio : alumView.getEmilios() )
									{ %>

                                    <!-- individual Email-->

                                    <div class="row content">
                                        <div class="col-8 my-auto">
                                            <%=emilio.getEmail()%> <br />
                                        </div>
                                        <div class="col-4 text-right">
                                            <a data-toggle="modal" data-target="#Warning" data-data="<%=emilio.getEmail()%>"
                                                data-type="Email" class="open-DeleteObject">
                                                <img class="imgDel" src="img/delete.svg" alt="DeleteEmail-<%=emilio.getEmail()%>" data-toggle="tooltip" data-placement="bottom" title="Eliminar Email-<%=emilio.getEmail()%>" >
                                            </a>
                                        </div>
                                    </div>

                                    <!--/ individual Email -->

									<% } %>
									
                                    <!--/Email Acordeon content -->

                                </div>
                            </div>
                        </div>

                        <!-- Phone Acordeon Head -->

                        <div class="card">
                            <div id="<%=alumView.getDni()%>-HeadPhone" class="card-header" role="tab">
                                <h5 class="mb-0">
                                    <div class="row">
                                        <div class="col-8 my-auto">
                                            <a data-toggle="collapse" data-parent="#Acordeon<%=alumView.getDni()%>"
                                                href="#ContentPhone-<%=alumView.getDni()%>" aria-expanded="false"
                                                aria-controls="ContentPhone-<%=alumView.getDni()%>">
                                                Telefonos
                                            </a>
                                        </div>
                                        <div class="col-4 text-right">
                                            <a data-toggle="modal" data-target="#AddPhone">
                                                <img class="imgAdd" src="img/add.svg" alt="AddPhone" data-toggle="tooltip" data-placement="bottom" title="Añadir Telefono">
                                            </a>
                                        </div>
                                    </div>
                                </h5>
                            </div>
                            <div id="ContentPhone-<%=alumView.getDni()%>" class="collapse" role="tabpanel" aria-labelledby="<%=alumView.getDni()%>-HeadPhone">
                                <div class="card-body pt-1">

                                    <!-- Phone Acordeon content -->

									<% for (Telefono telefono : alumView.getTelefonos() )
									{ %>

                                    <div class="row content">
                                        <div class="col-8 my-auto">
                                            <%=telefono.getTlf()%> <br />
                                        </div>
                                        <div class="col-4 text-right">
                                            <a data-toggle="modal" data-target="#Warning" data-data="<%=telefono.getTlf()%>"
                                                data-type="Telefono" class="open-DeleteObject">
                                                <img class="imgDel" src="img/delete.svg" alt="DeletePhone-<%=telefono.getTlf()%>" data-toggle="tooltip" data-placement="bottom" title="Eliminar Telefono <%=telefono.getTlf()%>">
                                            </a>
                                        </div>
                                    </div>
                                    
                                    <% } %>
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
        
        <% } %>      
        <!--/ Container -->
        <!-- Footer -->

        <div class="row pt-4"   >
            <div class="col-12 py-1 bg-secondary">
                
            </div>
            <div class="col-12 footer py-2 text-center" >
                <h4>
                    Agenda azarquiel - Grupo1 - 2020
                </h4>  
            </div>
        </div>

        <!--/ Footer -->

    </div>


    <!-- Modales -->

    <!-- Warning before deleting modal-->

    <div class="modal fade" id="Warning" tabindex="-1" role="dialog" aria-labelledby="WarningLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="WarningLabel">¡Cuidado!</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <p>
                        ¿Estas seguro de que quieres eliminar

                        <a id="Object">

                        </a>

                        ?
                    </p>
                </div>
                <div class="modal-footer">

                    <button type="button" class="btn btn-danger" data-dismiss="modal"> No </button>
                    <button type="button" class="btn btn-success"> Si </button>

                </div>
            </div>
        </div>
    </div>


    <!-- AddUser Modal  -->

    <div class="modal fade" id="AddUserModal" tabindex="-1" role="dialog" aria-labelledby="AddUserLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="AddUserLabel"> Nuevo usuario </h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                </div>
                <form action="Controller" method="POST">
                    <div class="modal-body">
                        <div class="row py-1">
                            <div class="col-3">
                                DNI:
                            </div>
                            <div class="col-9">
                                <input class="form-control" type="text" name="dniAlumno" id="dniAlumno" placeholder="DNI" required="required" >
                            </div>
                        </div>
                        <div class="row py-1">
                            <div class="col-3">
                                Nombre:
                            </div>
                            <div class="col-9">
                                <input class="form-control" type="text" name="nombreAlumno" id="nombreAlumno" placeholder="Tu nombre" required="required" >
                            </div>
                        </div>
                        <div class="row py-1">
                            <div class="col-3">
                                Curso:
                            </div>
                            <div class="col-9">
                                <select class="form-control" id="cursoSelect">
                                <% for(Curso curso : listaCurso ) {%>
                                	<option class="option" id="<%= curso.getGrupo() %>" data-value="<%= curso.getGrupo() %>"> "<%= curso.getGrupo() %>" </option>
                                <% } %>
                                </select>
                            </div>
                            <input type="hidden" name="cursoAlumno" id="CursoValue" value="">
                        </div>
                        <input type="hidden" name="op" value="addAlumno">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal" > Cerrar </button>
                        <button type="submit" class="btn btn-primary"  > Enviar </button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <!-- AddPhone Modal -->

    <!-- AddEmail Modal -->

    <!-- AddGroup Modal -->

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    <script src="my-js.js"> </script>
</body>

</html>