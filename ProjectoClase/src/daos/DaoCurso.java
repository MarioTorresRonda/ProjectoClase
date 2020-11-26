package daos;

import java.sql.Connection;
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
}
