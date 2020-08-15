package cn.second_hand.user.service;

import cn.second_hand.user.dao.UserDao;
import cn.second_hand.user.domain.User;
import cn.second_hand.user.domain.UserException;

public class UserService {
	private UserDao dao = new UserDao();

	public void register(User user) throws UserException{
		if(dao.findByEmail(user.getEmail())!=null) {
			throw new UserException("Email address already exists");
		}
		
		dao.register(user);
	}

	public User login(User user) throws UserException {
		User u = dao.findByEmail(user.getEmail());
		if(u==null) {
			throw new UserException("Email address not exists");
		}
		if(!u.getPassword().equals(user.getPassword())) {
			throw new UserException("Password is wrong");
		}
		return u;
	}


}
