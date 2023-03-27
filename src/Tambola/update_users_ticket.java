package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class update_users_ticket extends HttpServlet{
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String num=req.getParameter("num");
		String promo=req.getParameter("promo");
		String mail=req.getParameter("mail");
		String name=req.getParameter("name");
		//System.out.println("number is updating: "+num+" "+promo);
		
		try {
			jdbc_con jc=new jdbc_con();
			String ret=jc.check_num_arrived(num,promo);
			//System.out.println("check_num_arrived: "+ret);
			if(ret=="got") {
				res.getOutputStream().print("got");
				jc.update_users_ticket(num,promo,mail,name);
				//System.out.println("We called update_ticket");
			}
			else{
				res.getOutputStream().print("not");
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getOutputStream().print("error");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.getOutputStream().print("error");
		}
		
	}
	
}
