package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class getWinners extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String promo=req.getParameter("promo");
		System.out.println("getting winners");
		try {
			jdbc_con jc=new jdbc_con();
			String winners=jc.getWinners(promo);
			System.out.println("winners: "+winners);
			res.getOutputStream().print(winners);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
