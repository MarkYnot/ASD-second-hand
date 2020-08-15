package cn.second_hand.user.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AServlet extends HttpServlet {

	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		request.getSession().setAttribute("msg", "Hello2 world");
		response.sendRedirect("/register.jsp");
	}
}
