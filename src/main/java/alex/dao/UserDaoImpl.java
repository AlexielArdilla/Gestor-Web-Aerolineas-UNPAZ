package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	Connection con = MyConnection.getConnection();

	public HibernateTemplate getHibernatetemplate() {
		return hibernateTemplate;
	}

	public void setHibernatetemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public User findUser(Integer id) {
		
		return hibernateTemplate.get(User.class, id);
		 
	}

	@Override
	public User findUserByName(String nombre) {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User miUser = null;
		
		String sql="select name, password, id from user where user.name = '?'";
		try {
			
			miUser = new User();
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, nombre);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				miUser.setName(rs.getString(1));
				miUser.setPassword(rs.getString(2));
				miUser.setId(rs.getInt(3));
				
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
		
		return miUser;
	}

	@Override
	public List<User> getUsers() {
		
		List<User> misUsers = new LinkedList<>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = "select * from USER";
		
		try {
			con = MyConnection.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()){
				
				User miUser = new User();
				miUser.setName(rs.getString(1));
				miUser.setPassword(rs.getString(2));
				miUser.setId(rs.getInt(3));
				
				misUsers.add(miUser);
				
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
		
		return misUsers;
	}

	
	
}
