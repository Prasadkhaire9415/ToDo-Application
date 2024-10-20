package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import bean.ToDo;
import bean.User;

/**
 * Servlet implementation class EditServlet1
 */
@WebServlet("/EditServlet1")
public class EditServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet1() {
        super();
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
	     ToDo ob=new ToDo();
		String title=request.getParameter("title");
		String description=request.getParameter("description");
		String todostatus=request.getParameter("status");
		String tdate=request.getParameter("target-date");
		Date date=Date.valueOf(tdate);
		
		
		
		ob.setTitle(title);
		ob.setDescription(description);
		ob.setTodostatus(todostatus);
		ob.setDate(date);
		System.out.println(ob.getTitle());
		int status=UserDao.update(ob);      //call update method
		
		if(status!=0) {
			response.sendRedirect("DisplayTodoServlet");
		}else {
			pw.println("data updation failed..");
		}
	}

}
