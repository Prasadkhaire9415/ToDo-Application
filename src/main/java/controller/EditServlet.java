package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.UserDao;
import bean.ToDo;
import bean.User;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String title=request.getParameter("title");
        
        System.out.println(title);
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Add New ToDo</title>");
        out.println("<style>");
        out.println("body { font-family: Arial, sans-serif; margin: 0; padding: 0; background-color: #f4f4f4; }");
        out.println("header { background-color: #4CAF50; color: white; display: flex; justify-content: space-between; align-items: center; padding: 1rem 2rem; }");
        out.println("header img { height: 75px; width: 10%; }");
        out.println("header button { background-color: #f44336; color: white; border: none; padding: 0.5rem 1rem; cursor: pointer; font-size: 1rem; }");
        out.println("header button:hover { background-color: #d32f2f; }");
        out.println(".content { max-width: 600px; margin: 2rem auto; padding: 2rem; background-color: white; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }");
        out.println(".content h2 { text-align: center; margin-bottom: 1.5rem; }");
        out.println(".form-group { margin-bottom: 1rem; }");
        out.println(".form-group label { display: block; margin-bottom: 0.5rem; }");
        out.println(".form-group input[type='text'], .form-group input[type='date'], .form-group select { width: 100%; padding: 0.5rem; border: 1px solid #ccc; border-radius: 4px; }");
        out.println(".form-group textarea { width: 100%; padding: 0.5rem; border: 1px solid #ccc; border-radius: 4px; resize: vertical; }");
        out.println(".form-group button { width: 100%; padding: 0.7rem; background-color: #4CAF50; color: white; border: none; border-radius: 4px; cursor: pointer; font-size: 1rem; }");
        out.println(".form-group button:hover { background-color: #45a049; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<header>");
        out.println("<img src='ToDo application.png' alt='ToDo App Logo'>");
        out.println("<button><a href='index.html' style='text-decoration:none; color: white;'>Log Out</a></button>");
        out.println("</header>");
        out.println("<div class='content'>");
        out.println("<h2>Add New ToDo</h2>");
        
        out.println("<form action='EditServlet1' method='post'>");  //update servlet
        
  
		try {
			ToDo ob = UserDao.getbytitle(title);
			System.out.println(ob.getDescription());
			out.println("<div class='form-group'>");
	        out.println("<label for='title'>Title</label>");
	        out.println("<input type='text' value='"+ob.getTitle()+"' name='title' required>");
	        out.println("</div>");
	        out.println("<div class='form-group'>");
	        out.println("<label for='description'>ToDo Description</label>");
	        out.println("<input type='text' value='"+ob.getDescription()+"' name='description' required>");
	        out.println("</div>");
	        out.println("<div class='form-group'>");
	        out.println("<label for='status'>ToDo Status</label>");
	        out.println("<select value='"+ob.getTodostatus()+"' name='status' required>");
	        out.println("<option value='in-progress'>In Progress</option>");
	        out.println("<option value='completed'>Completed</option>");
	        out.println("</select>");
	        out.println("</div>");
	        out.println("<div class='form-group'>");
	        out.println("<label for='target-date'>ToDo Target Date</label>");
	        out.println("<input type='date' value='"+ob.getDate()+"' name='target-date' required>");
	        out.println("</div>");
	        out.println("<div class='form-group'>");
	        out.println("<button type='submit'>Save</button>");
	        out.println("</div>");
	        out.println("</form>");
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     // call the method getbytitle
        
       	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
