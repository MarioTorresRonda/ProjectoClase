package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conection.Conection;
import model.Telefono;

public class DaoTelefono {
	
	public ArrayList<Telefono> getTelefonos(String dni) {
		ResultSet rs;
		ArrayList<Telefono> lista = new ArrayList<Telefono>();

		Connection con = Conection.conecta();
		PreparedStatement ps;
		try {
			String ordenSql = "select tlf from telefono where dni =?";
			ps = con.prepareStatement(ordenSql);
			ps.setString(1, dni);
			rs = ps.executeQuery();
			while (rs.next()) {
				Telefono telefono = new Telefono();
				telefono.setDni(dni);
				telefono.setTlf(rs.getString("tlf"));
				lista.add(telefono);
			}
			rs.close();
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public boolean insertTelefono(Telefono telefono) {
		new Conection();
		Connection con = Conection.conecta();
		try {
			String ordenSQL;
			ordenSQL = "insert into telefono values(?,?)";
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, telefono.getDni());
			st.setString(2, telefono.getTlf());
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al insertar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}
	
	public boolean borraTelefono(String tlf) {
		new Conection();
		Connection con = Conection.conecta();
		String ordenSQL = "delete from telefono where tlf=?";
		try {
			PreparedStatement st = con.prepareStatement(ordenSQL);
			st.setString(1, tlf);
			st.executeUpdate();
			st.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error al eliminar datos en la BDs: " + e.getMessage());
			return false;
		}
		return true;
	}

}
