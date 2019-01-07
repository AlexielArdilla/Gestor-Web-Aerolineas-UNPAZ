package alex.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import alex.dao.BreakDAO;
import alex.entity.User;

@Service
public class BreakServiceImpl implements BreakService{
	
	@Autowired
	BreakDAO dao;
	
	@Override
	public int createComienzoBreak(User user) {
		
		return dao.createComienzoBreak(user);
	}

	@Override
	public int createFinalBreak(User user) {
		
		return dao.createFinalBreak(user);
	}

}
