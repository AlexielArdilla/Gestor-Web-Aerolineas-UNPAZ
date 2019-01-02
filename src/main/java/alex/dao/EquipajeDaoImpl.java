package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Equipaje;


@Repository
public class EquipajeDaoImpl implements EquipajeDao{

	Connection con = MyConnection.getConnection();;
	
	@Override
	public List<Equipaje> findEquipajes() {
		List <Equipaje> equipajes= new LinkedList<>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(
					"select equipaje_vuelo_pasajero.id, equipaje_vuelo_pasajero.id_vuelo, "
					+ "pasajero.nombre, equipaje_vuelo_pasajero.descripcion, "
					+ "equipaje_vuelo_pasajero.peso from equipaje_vuelo_pasajero "
					+ "join pasajero ON equipaje_vuelo_pasajero.id_pasajero = pasajero.id "
					+ "order by equipaje_vuelo_pasajero.id asc");
					
			rs = ps.executeQuery();

			while (rs.next()) {

				Equipaje miEquipaje = new Equipaje();
				miEquipaje.setId(rs.getInt(1));
				miEquipaje.setId_vuelo(rs.getInt(2));
				miEquipaje.setPasajero(rs.getString(3));
				miEquipaje.setDescripcion(rs.getString(4));
				miEquipaje.setPeso(rs.getDouble(5));
				
				equipajes.add(miEquipaje);
				
			}
			
				
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}
						
		return equipajes;
	}

	@Override
	public Equipaje findEquipaje(Integer id) {

		Equipaje miEquipaje = new Equipaje();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			
			con = MyConnection.getConnection();
			ps = con.prepareStatement("select equipaje_vuelo_pasajero.id, equipaje_vuelo_pasajero.id_vuelo, "
					+ "pasajero.nombre, equipaje_vuelo_pasajero.descripcion, equipaje_vuelo_pasajero.peso "
					+ "from equipaje_vuelo_pasajero join pasajero ON equipaje_vuelo_pasajero.id_pasajero = "
					+ "pasajero.id where equipaje_vuelo_pasajero.id = "+id);
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				miEquipaje.setId(rs.getInt(id));
				miEquipaje.setId_vuelo(rs.getInt(2));
				miEquipaje.setPasajero(rs.getString(3));
				miEquipaje.setDescripcion(rs.getString(4));
				miEquipaje.setPeso(rs.getDouble(5));
				
			
			}
			
		} catch (SQLException e) {		
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}										
		}
						
		return miEquipaje;
		
	}

	@Override
	public int deleteById(int id) {
		
		int r = 0;
		
		try {
			String sql= "DELETE from equipaje_vuelo_pasajero where id = "+id;
			PreparedStatement ps= con.prepareStatement(sql);
			r = ps.executeUpdate();
			
			ps.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return r;
	}

}
