package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Break;
import alex.entity.User;

@Repository
public class BreakDAOImpl implements BreakDAO{

	@Override
	public int createComienzoBreak(User user) {
		
		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		String sql="INSERT INTO `break`(`user`, `comienzo_o_final`, `horario`) VALUES (?,'comienzo',now())";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			
			r = ps.executeUpdate();
			
			if(r>0){
				
				System.out.println("Insert break exitoso");
				
			}else{
				
				System.out.println("Falló insert break");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
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
	public int createFinalBreak(User user) {

		Connection con = null;
		PreparedStatement ps = null;
		int r = 0;
		String sql="INSERT INTO `break`(`user`, `comienzo_o_final`, `horario`) VALUES (?,'final',now())";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			
			r = ps.executeUpdate();
			
			if(r>0){
				
				System.out.println("Insert break exitoso");
				
			}else{
				
				System.out.println("Falló insert break");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
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
