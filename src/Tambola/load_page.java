package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class load_page extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String promo=req.getParameter("promo");
		try {
			jdbc_con jc=new jdbc_con();
			String ret=jc.get_back_page(promo);
			//System.out.println("background: "+ret);
			res.getOutputStream().print(ret);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

