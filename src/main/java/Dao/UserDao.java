package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import bean.ToDo;
import bean.User;

public class UserDao {
public static Connection getConnection()throws Exception {
	
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/todo","root","9415");
		return con;
}
public static int insert(User u) throws Exception {
	Connection con=getConnection();
	String sql="insert into login (first,last,username,password)values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	ps.setString(1, u.getFirstname());
	ps.setString(2, u.getLastname());
	ps.setString(3, u.getUsername());
	ps.setString(4, u.getPassword());
	int status=0;
	status=ps.executeUpdate();
	return status;
}
public static int search(String username) {
	int status=0;
	try {
		Connection con=getConnection();
		String sql="select * from login where username=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			if(rs.getString("username").equals(username)) {
				status++;
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static int searchpass(String username,String password) {
	int status=0;
	try {
		Connection con=getConnection();
		String sql="select * from login where username=?";
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs =ps.executeQuery();
		while(rs.next()) {
			if(rs.getString("password").equals(password)) {
				status++;
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return status;
}
public static int insertToDo(ToDo td)throws Exception {
	Connection con=getConnection();
	String sql="insert into addtodo values(?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(sql);
	
	ps.setString(1, td.getTitle());
	ps.setString(2, td.getDescription());
	ps.setString(3, td.getTodostatus());
	ps.setDate(4, td.getDate());
	int status=ps.executeUpdate();
	System.out.println(status);
	return status;
}
public static List<ToDo> fetch()throws Exception{
	List<ToDo> al=new ArrayList();
	Connection con=getConnection();
	String sql="select * from addtodo";
	PreparedStatement ps=con.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		ToDo ob=new ToDo();
		ob.setTitle(rs.getString(1));
		ob.setDescription(rs.getString(2));
		ob.setTodostatus(rs.getString(3));
		ob.setDate(rs.getDate(4));
		al.add(ob);
	}
	return al;
}
public static int delete(String title) throws Exception{
	Connection con=getConnection();
	System.out.println(title);
	String sql="delete from addtodo where title=?";
	PreparedStatement ps=con.prepareStatement(sql);
	
	ps.setString(1, title);
	int status=ps.executeUpdate();
	System.out.println(status);
	return status;
}
public static ToDo getbytitle(String title)throws Exception {
	 Connection con=getConnection();
	 ToDo ob=new ToDo();
	 String sql="select * from addtodo where title=?";
	 PreparedStatement ps=con.prepareStatement(sql);

	 ps.setString(1, title);
	 ResultSet rs=ps.executeQuery();
	 System.out.println(rs);
	 while(rs.next()) {
		 ob.setTitle(rs.getString(1));
		 ob.setDescription(rs.getString(2));
		 ob.setTodostatus(rs.getString(3));
		 ob.setDate(rs.getDate(4));
		 
	 }
	 return ob;
}
public static int update(ToDo s) {
	 int status=0;
	 try {
		Connection con=getConnection();
		String title=s.getTitle();
		String sql="update addtodo set description=?,todo_status=?,targer_date=? where title=?";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setString(1,s.getDescription());
		ps.setString(2,s.getTodostatus());
		ps.setDate(3,s.getDate());
		ps.setString(4, s.getTitle());
		
		status=ps.executeUpdate();
		System.out.println(status);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 return status;
	 
}

}

