package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daos.DaoAlumno;
import daos.DaoAlumnoView;
import daos.DaoCurso;
import daos.DaoEmilio;
import daos.DaoTelefono;
import model.Alumno;
import model.AlumnoView;
import model.Curso;
import model.Emilio;
import model.Telefono;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(); // solicitamos/creamos una session/obtenemos objeto session
		String op = request.getParameter("op"); // traemos el op
		RequestDispatcher dispatcher; // objeto dispatcher para despues devolver la respuesta
		
		
		
		if ( op.equals("inicio") ) {
			
			ArrayList<Curso> listaCurso = new DaoCurso().getCursos("");
			session.setAttribute("listaCurso", listaCurso);
			
			ArrayList<AlumnoView> listaAlumno = new DaoAlumnoView().getAlumnoViews("", "");
			session.setAttribute("listaAlumno", listaAlumno);
			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);

		} else if( op.equals("UsuarioBuscar")) {
			
			String nombreAlumno = "";
			String curso = "";
			
			if ( !request.getParameter("alumno").isEmpty() ) {
				nombreAlumno = request.getParameter("alumno").toString();
			}
			if ( !request.getParameter("curso").isEmpty() ) {
				curso = request.getParameter("curso").toString();
			}
			
			ArrayList<Curso> listaCurso = new DaoCurso().getCursos( curso );
			session.setAttribute("listaCurso", listaCurso);
			
			ArrayList<AlumnoView> listaAlumno = new DaoAlumnoView().getAlumnoViews(curso, nombreAlumno);
			session.setAttribute("listaAlumno", listaAlumno);

			
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
			
		}
		//
		//Alumnos 
		//
		else if (op.equals("addAlumno")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoAlumno DaoAlumno = new DaoAlumno();
			
			String nombreAlumno = request.getParameter("nombreAlumno").toString();
			String dniAlumno = request.getParameter("dniAlumno").toString();
			String cursoAlumno = request.getParameter("cursoAlumno").toString();
			
			if ( DaoAlumno.insertAlumno( new Alumno( dniAlumno, nombreAlumno , cursoAlumno ) ) ) {
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("", "") );
			} else {
				request.setAttribute("error", "Error al añadir el alumno");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta

		} else if (op.equals("editAlumno")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoAlumno DaoAlumno = new DaoAlumno();
			Alumno alumno = new Alumno(request.getParameter("dniAlumno"), request.getParameter("nombreAlumno"), request.getParameter("cursoAlumno"));
			
			if (DaoAlumno.actualizaAlumno(alumno)) {
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("", "") );
			} else {
				request.setAttribute("error", "Error al editar el alumno");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
		} else if (op.equals("deleteAlumno")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoAlumno daoAlumno = new DaoAlumno();

			if (daoAlumno.borraAlumno( request.getParameter("Key").toString() )) {
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("", "") );
			} else {
				request.setAttribute("error", "Error al borrar el email");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
		} 
		//
		// Emails
		//
		else if (op.equals("addEmail")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoEmilio DaoEmail = new DaoEmilio();
			String dniEmail = request.getParameter("dni").toString();
			String emailEmail = request.getParameter("Email").toString();

			if (DaoEmail.insertEmilio( new Emilio( dniEmail, emailEmail ) ) ) {
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("", "") );
			} else {
				request.setAttribute("error", "Error al añadir el email");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
			
		} else if (op.equals("deleteEmail")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoEmilio daoEmail = new DaoEmilio();

			if (daoEmail.borraEmilio( request.getParameter("Key").toString() )) {
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("", "") );
			} else {
				request.setAttribute("error", "Error al borrar el email");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
		}
		//
		//Cursos
		//		
		else if (op.equals("addCurso")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoCurso daocurso = new DaoCurso();
			
			String curso = request.getParameter("grupo").toString();

			if (daocurso.insertCurso( new Curso( curso ) ) ) {
				session.setAttribute("listaCurso", daocurso.getCursos("") );
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("", "") );
			} else {
				request.setAttribute("error", "Error al añadir el curso");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
			
		}else if (op.equals("deleteCurso")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoCurso daocurso = new DaoCurso();
			
			Curso curso = new Curso( request.getParameter("Key").toString() );

			if ( daocurso.borraCurso( curso.getGrupo() )) {
				session.setAttribute("listaCurso", daocurso.getCursos("") );
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("", "") );
			} else {
				request.setAttribute("error", "Error al borrar el curso");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
		} 
		//
		// Telefonos
		//
		else if (op.equals("addTelefono")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoTelefono daotelefono = new DaoTelefono();
			String dni = request.getParameter("dni").toString();
			String tlf = request.getParameter("tlf").toString();

			if (daotelefono.insertTelefono( new Telefono( dni, tlf ) ) ) {
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("" , "") );
			} else {
				request.setAttribute("error", "Error al añadir el telefono");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
			
		} else if (op.equals("deleteTelefono")) {
			DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
			DaoTelefono daotelefono = new DaoTelefono();

			if (daotelefono.borraTelefono( request.getParameter("Key").toString() )) {
				session.setAttribute("listaAlumno", daoAlumnoView.getAlumnoViews("" , "") );
			} else {
				request.setAttribute("error", "Error al borrar el telefono");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
