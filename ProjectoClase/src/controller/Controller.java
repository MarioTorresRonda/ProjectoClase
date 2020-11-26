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

import model.Curso;
import model.Emilio;
import model.EstacionesLinea;
import model.Linea;

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
		if (op.equals("inicio")) {
			ArrayList<Curso> listaCursos = new DaoCursos().getCursos();

			session.setAttribute("listaCursos", listaCursos);
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);

		} else if (op.equals("addAlumno")) {
			DaoAlumno DaoAlumno = new DaoAlumno();
			String nombreAlumno = request.getParameter("nombreAlumno").toString();
			String dniAlumno = request.getParameter("dniAlumno").toString();
			String cursoAlumno = request.getParameter("cursoAlumno").toString();

			if (DaoAlumno.addAlumno(nombreAlumno, dniAlumno, cursoAlumno)) {
				request.setAttribute("listaAlumnos", DaoAlumno.getAlumnos());
			} else {
				request.setAttribute("error", "Error al añadir el alumno");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta

		} else if (op.equals("addEmail")) {
			DaoEmail DaoEmail = new DaoEmail();
			String dniEmail = request.getParameter("dniEmail").toString();
			String emailEmail = request.getParameter("emailEmail").toString();

			if (DaoEmail.addEmail(dniEmail, emailEmail)) {
				request.setAttribute("listaEmails", DaoEmail.getEmails());
			} else {
				request.setAttribute("error", "Error al añadir el email");
			}
			dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response); // devolvemos respuesta
		} else if (op.equals("deleteEmail")) {
			Emilio emilio = new Emilio(request.getParameter("dniEmail").toString(), request.getParameter("emailEmail").toString());
			DaoEmail DaoEmail = new DaoEmail();

			if (DaoEmail.deleteEmail(emilio)) {
				request.setAttribute("listaEmails", DaoEmail.getEmails());
			} else {
				request.setAttribute("error", "Error al borrar el email");
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
