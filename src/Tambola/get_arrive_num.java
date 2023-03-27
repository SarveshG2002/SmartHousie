package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class get_arrive_num extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String promo=req.getParameter("promo");
		try {
			jdbc_con jc=new jdbc_con();
			int num=jc.get_arrive_num(promo);
			jc.con.close();
			res.getOutputStream().print(num);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			res.getOutputStream().print("error");
			e.printStackTrace();
		}
	}
	
}
