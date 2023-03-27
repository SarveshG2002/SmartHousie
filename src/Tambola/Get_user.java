package Tambola;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class Get_user extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException{
		String name=req.getParameter("uname");
		String promocode=req.getParameter("promocode");
		String phone=req.getParameter("phone");
		String email=req.getParameter("email");
		//System.out.println("hello: "+name+" || your promoocode is: "+promocode);
		jdbc_con st;
		try {
			Gson gson= new Gson();
			st = new jdbc_con();
			if(st.check_game(promocode)=="1"){
				System.out.println("game is present");
				String ret=st.check_id_avail(name,phone,email,promocode);
				if(ret=="") {
					String tickets=st.save_user(name,promocode,phone,email);
					if(tickets!="") {
						Array_to_json arj=gson.fromJson(tickets, Array_to_json.class);
					}
					//System.out.println("tickets: "+tickets);
					res.getOutputStream().print(tickets);
				}
				else if(ret!="") {
					res.getOutputStream().print(ret);
				}
				
			}
			else {
				System.out.println("This game doesn't exists ");
				res.getOutputStream().print("This game doesn't exists");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}