package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class get_user_sel_num extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String promo=req.getParameter("promo");
		String mail=req.getParameter("mail");
		String name=req.getParameter("name");
		
		jdbc_con jc;
		try {
			jc = new jdbc_con();
			String ret=jc.get_user_sel_num(promo,mail,name);
			res.getOutputStream().print(ret);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
