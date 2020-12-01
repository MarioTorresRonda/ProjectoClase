package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conection.Conection;
import model.Alumno;

public class DaoAlumno {

	public ArrayList<Alumno> getAlumnos() {
		ResultSet rs;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();

		Connection con = Conection.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select dni, nombre, curso from alumno";
			rs = st.executeQuery(ordenSql);

			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setDni(rs.getString("dni"));
				alumno.setCurso(rs.getString("curso"));
				alumno.setNombre(rs.getString("nombre"));
				lista.add(alumno);
			}
			rs.close();
			st.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public ArrayList<Alumno> getAlumnosByCurso(String curso) {
		ResultSet rs;
		ArrayList<Alumno> lista = new ArrayList<Alumno>();
		PreparedStatement ps;
		Connection con = Conection.conecta();
		try {
			String sql = "select dni, nombre, curso from alumno where curso=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, curso);
			rs = ps.executeQuery();
			while (rs.next()) {
				Alumno alumno = new Alumno();
				alumno.setDni(rs.getString("dni"));
				alumno.setCurso(curso);
				alumno.setNombre(rs.getString("nombre"));
				lista.add(alumno);
			}
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public Alumno getAlumno(String dni) {
		ResultSet rs;
		Connection con = Conection.conecta();
		PreparedStatement ps;
		Alumno alumno = new Alumno();
		try {
			String sql = "select curso, nombre from alumno where dni=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, dni);
			rs = ps.executeQuery();
			rs.next();
			alumno.setDni(dni);
			alumno.setCurso(rs.getString("curso"));
			alumno.setNombre(rs.getString("nombre"));
			rs.close();
			ps.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al acceder a la BDs: " + e.getMessage());
		}
		return alumno;
	}

	public boolean insertAlumno(Alumno alumno) {
		Connection con = Conection.conecta();
		try {
			String ordenSQL;
			ordenSQL = "insert into alumno values(?,?, (select curso from curso where curso = ?))";
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, alumno.getDni());
			st.setString(2, alumno.getNombre());
			st.setString(3, alumno.getCurso());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean borraAlumno(String dni) {
		Connection con = Conection.conecta();
		String ordenSQL = "delete from alumno where dni=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, dni);
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean actualizaAlumno(Alumno alumno) {
		new Conection();
		Connection con = Conection.conecta();
		String ordenSQL = "update alumno set nombre=?,curso=? where dni=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, alumno.getNombre());
			st.setString(2, alumno.getCurso());
			st.setString(3, alumno.getDni());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al actualizar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}
}
