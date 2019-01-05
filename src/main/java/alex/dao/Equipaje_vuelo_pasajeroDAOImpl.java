package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Equipaje_vuelo_pasajero;

@Repository
public class Equipaje_vuelo_pasajeroDAOImpl implements Equipaje_vuelo_pasajeroDAO{

	@Override
	public List<Equipaje_vuelo_pasajero> getEquipajes() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Equipaje_vuelo_pasajero> misEquipajes = new LinkedList<>();
		
		String sql ="select equipaje_vuelo_pasajero.id, equipaje_vuelo_pasajero.id_pasajero, "
				+ "equipaje_vuelo_pasajero.id_vuelo,equipaje_vuelo_pasajero.descripcion, "
				+ "equipaje_vuelo_pasajero.peso from equipaje_vuelo_pasajero order by id ASC";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Equipaje_vuelo_pasajero miEqui = new Equipaje_vuelo_pasajero();
				miEqui.setId(rs.getInt(1));
				miEqui.setId_pasajero(rs.getInt(2));
				miEqui.setId_vuelo(rs.getInt(3));
				miEqui.setDescripcion(rs.getString(4));
				miEqui.setPeso(rs.getDouble(5));
				
				misEquipajes.add(miEqui);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return misEquipajes;
	}

	@Override
	public int deleteEquipajeByID(int id) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		
		String sql = "delete from equipaje_vuelo_pasajero WHERE id = ?";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			
			r = ps.executeUpdate();
			
			if(r>0){
				
				System.out.println("Delete exitoso");
				
			}else{
				
				System.out.println("Algo falló");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
		
		return r;
	}

	@Override
	public int createEquiVueloPasajero(Equipaje_vuelo_pasajero equipaje_vuelo_pas) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		String sql ="insert into equipaje_vuelo_pasajero values(?, ?, ?, ?, ?)";
		
		try {
			
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, equipaje_vuelo_pas.getId());
			ps.setInt(2, equipaje_vuelo_pas.getId_vuelo());
			ps.setInt(3, equipaje_vuelo_pas.getId_pasajero());
			ps.setString(4, equipaje_vuelo_pas.getDescripcion());
			ps.setDouble(5, equipaje_vuelo_pas.getPeso());
			
			r= ps.executeUpdate();
			
			if(r>0){
				
				System.out.println("Create exitoso Equipaje");
			}else{
				
				System.out.println("Error al crear Equipaje");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return r;
	}
	
}
