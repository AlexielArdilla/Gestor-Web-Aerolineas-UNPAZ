package alex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.UserDao;
import alex.entity.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	
	
	
	public UserDao getDao() {
		return dao;
	}



	public void setDao(UserDao dao) {
		this.dao = dao;
	}



	@Override
	public User getUser(Integer id) {

		return dao.findUser(id);
	}

}
