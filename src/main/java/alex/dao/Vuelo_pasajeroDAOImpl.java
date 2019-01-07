package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;


import alex.databaseConnection.MyConnection;
import alex.entity.Vuelo_pasajero;

@Repository
public class Vuelo_pasajeroDAOImpl implements Vuelo_pasajeroDAO{

	@Override
	public int create(Vuelo_pasajero v_pasajero) {
		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into vuelo_pasajero values(?,?,?)";
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, v_pasajero.getId_vuelo());
			ps.setInt(2, v_pasajero.getId_pasajero());
			ps.setDouble(3, v_pasajero.getPeso_total_equipaje());
			
			r= ps.executeUpdate();
			
			if (r > 0) {
				System.out.println("Create exitoso Buenisimoooo!!!");
			}else{
				
				System.out.println("Algo ha fallado!!!");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return r;
	}

	@Override
	public List<Vuelo_pasajero> findVuelos_pasajero() {
		
		List<Vuelo_pasajero> misPasajeros = new LinkedList<>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "SELECT * from vuelo_pasajero";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs= ps.executeQuery();
			
			while(rs.next()){
				
				Vuelo_pasajero miVP= new Vuelo_pasajero();
				miVP.setId_vuelo(rs.getInt(1));
				miVP.setId_pasajero(rs.getInt(2));
				miVP.setPeso_total_equipaje(rs.getDouble(3));
			
				misPasajeros.add(miVP);
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
		
		return misPasajeros;
	}

	@Override
	public Vuelo_pasajero findAVuelo_pasajeroByIDPasajero(int id) {
	
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Vuelo_pasajero miVuelo = null;
		
		String sql = "SELECT * from vuelo_pasajero where id_vuelo = ?";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()){
			 miVuelo = new Vuelo_pasajero();
			miVuelo.setId_vuelo(rs.getInt(1));
			miVuelo.setId_pasajero(rs.getInt(2));
			miVuelo.setPeso_total_equipaje(rs.getDouble(3));
					
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			try {
				ps.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return miVuelo;
	}

	@Override
	public int deleteVueloPasajeroByIDPasajero(int id_vuelo, int id_pasajero) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		String sql = "delete from vuelo_pasajero where ID_PASAJERO = ? AND ID_VUELO = ?";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, id_pasajero);
			ps.setInt(2, id_vuelo);
			
			r = ps.executeUpdate();
			
			if (r > 0) {
				System.out.println("Create exitoso");
			}else{
				
				System.out.println("Algo ha fallado!!!");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public int updatePesoTotalVuelopasajero(Vuelo_pasajero vueloPasajero) {
	
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "UPDATE `vuelo_pasajero` SET `PESO_TOTAL_EQUIPAJE`= ? WHERE `ID_VUELO` = ? AND `ID_PASAJERO` = ?";
		int r = 0;
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setDouble(1, vueloPasajero.getPeso_total_equipaje());
			ps.setInt(2, vueloPasajero.getId_vuelo());
			ps.setInt(3, vueloPasajero.getId_pasajero());
			
			r= ps.executeUpdate();
			
			if (r > 0) {
				System.out.println("Create exitoso Buenisimoooo!!!");
			}else{
				
				System.out.println("Algo ha fallado!!!");
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return r;
	}

	

	

}
