package cn.second_hand.user.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.second_hand.user.domain.User;
import cn.second_hand.user.domain.UserException;
import cn.second_hand.user.service.UserService;

public class UserServlet extends BaseServlet {
	private UserService userService = new UserService();

	public  String register(HttpServletRequest request, HttpServletResponse response)   {
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		String repeatPwd = request.getParameter("confirmPwd");
		Map<String,String> map = new HashMap<String,String>();
		if(user.getEmail()==null||user.getEmail().trim().isEmpty()) {
			map.put("email", "Please enter an email address");
		}
		else if(!user.getEmail().matches("\\w+@\\w+\\.\\w+")) {
			map.put("email", "Enter a valid email address");
		}
		if(user.getPassword()==null||user.getPassword().trim().isEmpty()) {
			map.put("password", "Please enter your password");
		}
		else if(user.getPassword().length()<6 ) {
			map.put("password", "Please make password strong");
		}else if(user.getPassword().length()>16) {
			map.put("password", "Please make password weak");
		}
		if(!repeatPwd.equals(user.getPassword())) {
			map.put("repeatPwd", "Two passwords are not same");
		}
		
		if(!map.isEmpty()) {
			request.setAttribute("errors", map);
			request.setAttribute("user", user);
			request.setAttribute("confirmPwd", repeatPwd);
			return "f:/register.jsp";
		}
		
		try {
		userService.register(user);
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			request.setAttribute("confirmPwd", repeatPwd);
			return "f:/register.jsp";
		}
		
		// add email verification at release 2
		
		request.setAttribute("msg", "Registration successfully!");
		return "f:/msg.jsp";
	}
	
	public  String login(HttpServletRequest request, HttpServletResponse response)    { 
		User user = new User();
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		try {
			User currentUser = userService.login(user);
			request.getSession().setAttribute("session_user", currentUser);
			return "r:/index.jsp";
		} catch (UserException e) {
			request.setAttribute("msg", e.getMessage());
			request.setAttribute("user", user);
			return "f:/login.jsp";
		}
	
	}
}
