package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class get_ran_num extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String promo=req.getParameter("promo");
		try {
			jdbc_con jc=new jdbc_con();
			String num=jc.get_all_num(promo);
			//System.out.println("we got this: "+num);
			//jc.con.close();
			res.getOutputStream().print(num);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
