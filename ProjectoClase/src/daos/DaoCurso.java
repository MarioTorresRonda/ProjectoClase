package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conection.Conection;
import model.Alumno;
import model.Curso;

public class DaoCurso {
	
	
	public ArrayList<Curso> getCursos() {
		ResultSet rs;
		ArrayList<Curso> lista = new ArrayList<Curso>();

		Connection con = Conection.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select curso from curso";
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				Curso curso = new Curso();
				curso.setGrupo(rs.getString("curso"));
				lista.add(curso);
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
	
	
	public boolean insertCurso(Curso curso) {
		Connection con = Conection.conecta();
		try {
			String ordenSQL;
			ordenSQL = "insert into curso values(?)";
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, curso.getGrupo());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean borraCurso(String curso) {
		int borrados = -1;
		Connection con = Conection.conecta();
		String ordenSQL = "delete from curso where curso=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, curso);
			borrados = st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}
}
