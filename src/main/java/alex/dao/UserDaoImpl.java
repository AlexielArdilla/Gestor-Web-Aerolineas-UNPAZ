package alex.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import alex.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;

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

	
	
}
