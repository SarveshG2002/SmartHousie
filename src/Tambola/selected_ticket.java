package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class selected_ticket extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		int data=Integer.parseInt(req.getParameter("data"));
		String name=req.getParameter("name");
		String mail=req.getParameter("mail");
		String phone=req.getParameter("phone");
		String promo=req.getParameter("promo");
		String ret="";
		try {
			jdbc_con jc=new jdbc_con();
			ret=jc.selected_ticket(data,name,mail,phone,promo);
			//System.out.println("After selecting ticket: "+ret);
			res.getOutputStream().print(ret);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
