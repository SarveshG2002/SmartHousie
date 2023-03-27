package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class check_win extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String promo=req.getParameter("promo");
		String apply=req.getParameter("apply");
		String email=req.getParameter("email");
		String name=req.getParameter("name");
		System.out.println("Checking winner");
		try {
			jdbc_con jc=new jdbc_con();
			String winner=jc.check_win(promo,apply,email,name);
			res.getOutputStream().print(winner);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
}
