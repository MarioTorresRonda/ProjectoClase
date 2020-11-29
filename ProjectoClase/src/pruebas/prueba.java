package pruebas;

import java.util.ArrayList;

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

public class prueba {
	public static void main(String[] args) {
		
		ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
		DaoAlumno daoAlumno = new DaoAlumno();
		alumnos = daoAlumno.getAlumnos();
		System.out.println(alumnos);
		
		ArrayList<Alumno> alumnosByCurso = new ArrayList<Alumno>();
		alumnosByCurso = daoAlumno.getAlumnosByCurso("2011-2012");
		System.out.println(alumnosByCurso);
		System.out.println(alumnosByCurso.size());
		alumnosByCurso = daoAlumno.getAlumnosByCurso("2010-2011");
		System.out.println(alumnosByCurso);
		System.out.println(alumnosByCurso.size());
		
		
		Alumno alumno = new Alumno();
		alumno = daoAlumno.getAlumno("03922982x");
		System.out.println(alumno);
		
		
		ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
		DaoTelefono daoTelefono = new DaoTelefono();
		telefonos = daoTelefono.getTelefonos("5293457N");
		System.out.println(telefonos);
		
		
		ArrayList<Emilio> emilios = new ArrayList<Emilio>();
		DaoEmilio daoEmilio = new DaoEmilio();
		emilios = daoEmilio.getEmilios("53465489B");
		System.out.println(emilios);
		
		
		ArrayList<Curso> cursos = new ArrayList<Curso>();
		DaoCurso daoCurso = new DaoCurso();
		cursos = daoCurso.getCursos();
		System.out.println(cursos);
		Curso curso = new Curso();
		curso.setGrupo("2005");
		//System.out.println(daoCurso.insertCurso(curso));
		System.out.println(daoCurso.borraCurso(curso.getGrupo()));
		
		
		ArrayList<AlumnoView> alumnoViews = new ArrayList<AlumnoView>();
		DaoAlumnoView daoAlumnoView = new DaoAlumnoView();
		alumnoViews = daoAlumnoView.getAlumnoViews("","");
		System.out.println(alumnoViews);
		System.out.println(alumnoViews.size());
		
		
		
		
	}
}
