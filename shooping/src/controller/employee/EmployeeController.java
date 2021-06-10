package controller.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EmployeeController extends HttpServlet
	implements Servlet{
	public void doProcess(HttpServletRequest request, 
			HttpServletResponse response) 
					throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(
				contextPath.length());
		if(command.equals("/empList.em")) {
			RequestDispatcher dispatcher =
					request.getRequestDispatcher(
							"employee/employeeList.jsp");
			dispatcher.forward(request, response);
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
}
