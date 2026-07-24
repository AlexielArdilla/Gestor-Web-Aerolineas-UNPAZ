package alex.dao;

import alex.entity.User;

public interface BreakDAO {

	int createComienzoBreak(User user);
	
	int createFinalBreak(User user);
	
}
