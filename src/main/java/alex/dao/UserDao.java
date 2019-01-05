package alex.dao;

import java.util.List;

import alex.entity.User;

public interface UserDao {
	
	User findUser(Integer id);
	
	User findUserByName(String nombre);
	
	List<User> getUsers();

}
