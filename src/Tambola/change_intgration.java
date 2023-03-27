package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class change_intgration extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String state=req.getParameter("state");
		String promo=req.getParameter("promo");
		
		jdbc_con jc;
		try {
			jc = new jdbc_con();
			String ret= jc.change_intgration(state,promo);
			res.getOutputStream().print(ret);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}