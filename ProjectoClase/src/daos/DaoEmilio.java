package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conection.Conection;
import model.Telefono;
import model.Emilio;

public class DaoEmilio {
	public ArrayList<Emilio> getEmilios(String dni) {
		ResultSet rs;
		ArrayList<Emilio> lista = new ArrayList<Emilio>();

		Connection con = Conection.conecta();
		PreparedStatement ps;
		try {
			String ordenSql = "select email from emilio where dni =?";
			ps = con.prepareStatement(ordenSql);
			ps.setString(1, dni);
			rs = ps.executeQuery();
			while (rs.next()) {
				Emilio emilio = new Emilio();
				emilio.setDni(dni);
				emilio.setEmail(rs.getString("email"));
				lista.add(emilio);
			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

	public boolean insertEmilio(Emilio emilio) {
		Connection con = new Conection().conecta();
		try {
			String ordenSQL;
			ordenSQL = "insert into emilio values(?,?)";
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, emilio.getDni());
			st.setString(2, emilio.getEmail());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}

	public boolean borraEmilio( String email ) {
		int borrados = -1;
		Connection con = new Conection().conecta();
		String ordenSQL = "delete from emilio where email=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, email);
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
