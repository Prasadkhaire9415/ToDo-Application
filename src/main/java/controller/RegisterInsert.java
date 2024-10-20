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
 * Servlet implementation class RegisterInsert
 */
@WebServlet("/RegisterInsert")
public class RegisterInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterInsert() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   PrintWriter pw=response.getWriter();
	   String firstname=request.getParameter("firstname");
	   String lastname=request.getParameter("lastname");
	   String username=request.getParameter("username");
	   String password=request.getParameter("password");
	   User u=new User();
	   u.setFirstname(firstname);
	   u.setLastname(lastname);
	   u.setUsername(username);
	   u.setPassword(password);
	   int status=0;
	   try {
		   status=UserDao.insert(u);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   if(status!=0) {
		   pw.println("saves successfully..");
		 
		   response.sendRedirect("index.html");
		   
	   }else {
		   pw.println("Failed..");
	   }
	   
	}

}
