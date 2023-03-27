package Tambola;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class login_signup extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		jdbc_con jc;
		String usr=req.getParameter("usr");
		String method=req.getParameter("method");
		String pass=req.getParameter("pass");
		String query;
		try {
			jc = new jdbc_con();
			if(method.compareTo("signup")==0) {
				
				String mail=req.getParameter("mail");
				
					query="select * from admin_lgin where username='"+usr+"' && mail='"+mail+"' && password='"+pass+"'";
					ResultSet ret=jc.getData(query);
					if(ret.next()) {
			            System.out.println("ID exists in the database");
			         } else {
			            System.out.println("ID does not exist in the database");
			            query="insert into admin_lgin values('"+usr+"','"+mail+"','"+pass+"')";
						jc.setData(query);
						res.getOutputStream().print("user_saved");
			         }
				
				
			}
			else if(method.compareTo("login")==0) {
				try {
					ResultSet ret= jc.getData("select * from admin_lgin where username='"+usr+"' && password='"+pass+"'");
					System.out.println(ret.getString("mail"));
					res.getOutputStream().print("User Exists");
					
				}
				catch(SQLException e) {
					res.getOutputStream().print("User undefine");
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}