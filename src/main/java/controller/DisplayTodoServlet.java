package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import bean.ToDo;
import bean.User;

/**
 * Servlet implementation class DisplayTodoServlet
 */
@WebServlet("/DisplayTodoServlet")
public class DisplayTodoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayTodoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 response.setContentType("text/html");
		 
		
		
		List<ToDo> al=new ArrayList();
		try {
			al=UserDao.fetch();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 out.println("<!DOCTYPE html>");
	        out.println("<html lang='en'>");
	        out.println("<head>");
	        out.println("<meta charset='UTF-8'>");
	        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
	        out.println("<title>ToDo Application</title>");
	        out.println("<style>");
	        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }");
	        out.println("header { background-color: #4CAF50; color: white; display: flex; justify-content: space-between; align-items: center; padding: 1rem 2rem; }");
	        out.println("header img {  height: 75px; width: 10%; }");
	        out.println("header button { background-color: #f44336; color: white; border: none; padding: 0.5rem 1rem; cursor: pointer; font-size: 1rem; }");
	        out.println("header button:hover { background-color: #d32f2f; }");
	        out.println(".content { max-width: 800px; margin: 2rem auto; padding: 1rem; background-color: white; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
	        out.println(".content h2 { text-align: center; margin-bottom: 1.5rem; }");
	        out.println(".content .add-todo { display: flex; justify-content: space-between; align-items: center; margin-bottom: 1rem; }");
	        out.println(".content .add-todo button { background-color: #4CAF50; color: white; border: none; padding: 0.5rem 1rem; cursor: pointer; font-size: 1rem; }");
	        out.println(".content .add-todo button:hover { background-color: #45a049; }");
	        out.println("table { width: 100%; border-collapse: collapse; }");
	        out.println("table th, table td { border: 1px solid #ddd; padding: 0.5rem; text-align: left; }");
	        out.println("table th { background-color: #4CAF50; color: white; }");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<header>");
	        out.println("<img src='ToDo application.png' alt='ToDo App Logo'>");
	        out.println("<button><a href='index.html' style='text-decoration:none;color:white;'>Log Out</a></button>");
	        out.println("</header>");
	        out.println("<div class='content'>");
	        out.println("<div class='add-todo'>");
	        out.println("<button><a href='NewToDo.html' style='text-decoration:none;color:white;'>Add ToDo</a></button>");
	        out.println("<h2>List Of ToDo's</h2>");
	        out.println("</div>");
	        out.println("<table>");
	        out.println("<thead>");
	        out.println("<tr>");
	        out.println("<th>Title</th>");
	        out.println("<th>Target Date</th>");
	        out.println("<th>ToDo Status</th>");
	        out.println("<th>Delete</th>");
	        out.println("<th>Edit</th>");
	        out.println("</tr>");
	        out.println("</thead>");
	        out.println("<tbody>");
	        
	        
		
	        for (ToDo td :al) {
                String title = td.getTitle();
                Date targetDate = td.getDate();
                String status = td.getTodostatus();
                
                out.println("<tr>");
                out.println("<td>" + title + "</td>");
                out.println("<td>" + targetDate + "</td>");
                out.println("<td>" + status + "</td>");
                out.println("<td><a style='text-decoration:none' href='DeleteServlet?title="+title+"'>Delete</a></td>");
                out.println("<td><a style='text-decoration:none' href='EditServlet?title="+td.getTitle()+"'>Edit</a></td>");
                out.println("</tr>");
            }
	        out.println("</tbody>");
	        out.println("</table>");
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
