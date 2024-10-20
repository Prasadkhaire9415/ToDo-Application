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
 * Servlet implementation class InsertToDoServlet
 */
@WebServlet("/InsertToDoServlet")
public class InsertToDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertToDoServlet() {
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
			String title=request.getParameter("title");
			String description=request.getParameter("description");
			String todostatus=request.getParameter("status");
			String tdate=request.getParameter("target-date");
			Date date=Date.valueOf(tdate);
			
			
			
			
			
			
			PrintWriter pw=response.getWriter();
			ToDo td=new ToDo();
			td.setTitle(title);
			td.setDescription(description);
			td.setTodostatus(todostatus);
			td.setDate(date);
			int status=0;
			try {
				status=UserDao.insertToDo(td);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(status!=0) {
				response.sendRedirect("DisplayTodoServlet");
			}else {
				pw.println("insertion failed..");
			}
		
	}

}
