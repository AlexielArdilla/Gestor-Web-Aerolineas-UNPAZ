package alex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import alex.databaseConnection.MyConnection;
import alex.entity.Avion;

@Repository
public class AvionDaoImpl implements AvionDao {

	@Autowired
	HibernateTemplate hibernateTemplate;
	
	Connection con = MyConnection.getConnection();

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public int create(Avion avion) {

		String sql = "insert into avion values(?, ?, ?);";

		int r;

		r = 0;

		try {
			PreparedStatement s = con.prepareStatement(sql);
			s.setInt(1, avion.getId());
			s.setInt(2, avion.getCant_pasajero());
			s.setString(3, avion.getDescripcion());
			
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
		
		
		return avion.getId();
	}

	@Override
	public List<Avion> findAviones() {

		return hibernateTemplate.loadAll(Avion.class);
	}

	@Override
	public Avion findAvion(Integer id) {

		return hibernateTemplate.get(Avion.class, id);
	}

}
