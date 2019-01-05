package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Pasajero;

@Repository
public class PasajeroDaoImpl implements PasajeroDao{
	
	Connection con = MyConnection.getConnection();
	int max_id;

	@Override
	public int create(Pasajero pasajero) {
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into pasajero values(?,?,?,?);";

		int r;

		r = 0;

		
		try {
			String sql2 = "select MAX(id) from pasajero";
			ps = con.prepareStatement(sql2);
			rs = ps.executeQuery();
			
			while(rs.next()){
			max_id = rs.getInt(1);}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, max_id+1);
			s.setInt(2, pasajero.getDni());
			s.setInt(3, pasajero.getEdad());
			s.setString(4, pasajero.getNombre());
			
			
			r= s.executeUpdate();
			
			if (r > 0) {
				System.out.println("Create exitoso");
			}else{
				
				System.out.println("Algo ha fallado!!!");
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return max_id+1;
	}

	@Override
	public Pasajero findByDNI(int dni) {
		
		Pasajero miPasajero = new Pasajero();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from pasajero where dni = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, dni);
			rs = ps.executeQuery();
			
			while(rs.next()){
			miPasajero.setId(rs.getInt(1));
			miPasajero.setDni(rs.getInt(2));
			miPasajero.setEdad(rs.getInt(3));
			miPasajero.setNombre(rs.getString(4));}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return miPasajero;
	}
	
	@Override
	public int deleteById(int id) {
		
		int r= 0;
		
		try {
			String sql = "delete from pasajero where id = "+id;
			PreparedStatement ps = con.prepareStatement(sql);
			
			 r = ps.executeUpdate();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}

	@Override
	public List<Pasajero> getPasajeros() {
		
		List<Pasajero> misPasajeros = new LinkedList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from pasajero";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				Pasajero miPasajero = new Pasajero();
				miPasajero.setId(rs.getInt(1));
				miPasajero.setDni(rs.getInt(2));
				miPasajero.setEdad(rs.getInt(3));
				miPasajero.setNombre(rs.getString(4));
				
				misPasajeros.add(miPasajero);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return misPasajeros;
	}

}
