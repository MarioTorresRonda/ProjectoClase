package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import conection.Conection;
import model.AlumnoView;
import model.Emilio;
import model.Telefono;

public class DaoAlumnoView {
	public ArrayList<AlumnoView> getAlumnoViews(String curso, String nombre) {
		ResultSet rs;
		ArrayList<AlumnoView> lista = new ArrayList<AlumnoView>();

		Connection con = Conection.conecta();
		Statement st;
		try {
			st = con.createStatement();
			String ordenSql = "select dni,curso,nombre from alumno where nombre like '%" + nombre + "%' and curso like '"+curso+"%'";              
				
			rs = st.executeQuery(ordenSql);
			while (rs.next()) {
				AlumnoView alumno = new AlumnoView();
				alumno.setDni(rs.getString("dni"));
				alumno.setCurso(rs.getString("curso"));
				alumno.setNombre(rs.getString("nombre"));

				
				//Telefonos
				PreparedStatement ps;
				ArrayList<Telefono> telefonos = new ArrayList<Telefono>();
				String ordenSql2 = "select tlf from telefono where dni =?";
				ps = con.prepareStatement(ordenSql2);
				ps.setString(1, alumno.getDni());
				ResultSet rs2 = ps.executeQuery();
				while (rs2.next()) {
					Telefono telefono = new Telefono();
					telefono.setDni(alumno.getDni());
					telefono.setTlf(rs2.getString("tlf"));
					telefonos.add(telefono);
					
				}
				alumno.setTelefonos(telefonos);
				//Telefonos

				
				//Emilios
				PreparedStatement ps2;
				ArrayList<Emilio> emilios = new ArrayList<Emilio>();
				String ordenSql3 = "select email from emilio where dni =?";
				ps2 = con.prepareStatement(ordenSql3);
				ps2.setString(1, alumno.getDni());
				ResultSet rs3 = ps2.executeQuery();
				while (rs3.next()) {
					Emilio emilio = new Emilio();
					emilio.setDni(alumno.getDni());
					emilio.setEmail(rs3.getString("email"));
					emilios.add(emilio);
				}
				alumno.setEmilios(emilios);
				//Emilios

				

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
}
