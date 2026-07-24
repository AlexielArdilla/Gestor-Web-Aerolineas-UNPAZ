package alex.services;

import java.util.List;

import alex.entity.User;

public interface UserService {

	User getUser(Integer id);
	
	User findUserByName(String nombre);
	
	List<User> getUsers();
}
