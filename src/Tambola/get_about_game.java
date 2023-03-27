package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class get_about_game extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
//		String cname=req.getParameter("cname");
		String promo=req.getParameter("promo");
		jdbc_con jc;
		try {
			jc = new jdbc_con();
			String ret= jc.get_about_game();
			res.getOutputStream().print(ret);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
