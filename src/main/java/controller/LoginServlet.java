package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import bean.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		int status=UserDao.search(username);
		int status1=UserDao.searchpass(username, password);
		if(status!=0 && status1!=0) {
			pw.println("<h1>Login Successfully..</h1>");
			response.sendRedirect("DisplayTodoServlet");						// hyperlink todo application	
			pw.println("<h1>Welcome To The Application..</h1>");
		}else if(status!=0 && status1==0) {
			pw.println("<p>Incorrect password!</p>");
			response.sendRedirect("index.html");
		}else if(status==0 && status1!=0) {
			pw.println("<p>Invalid username!</p>");
			response.sendRedirect("index.html");
		}else if(status==0 && status1==0){
			pw.println("<p>Invalid username and incorrect password..!</p>");
			response.sendRedirect("index.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
