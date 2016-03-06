package _04_Member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/MemberServlet")

public class MemberServlet extends HttpServlet {	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	HttpSession session = request.getSession();
	String accountUID = (String) session.getAttribute("LoginOK");
	String roleID = (String) session.getAttribute("roleID");
	session.setAttribute("LoginOK", accountUID);
	System.out.println("accountUID: "+accountUID);
	System.out.println("roleID: "+roleID);
	
	
	
	request.getRequestDispatcher(
			"/_04_Members/Members.jsp").forward(request, response);
	
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
