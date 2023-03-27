package Tambola;

import java.io.IOException;


import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class first_servlet extends HttpServlet{
	public String toConvert(int list[][][],int total) {
		String list_string="";
		for(int i=0;i<=total-1;i++)
		{
	          for(int j=0;j<=2;j++)
	          {
	              for(int ok=0;ok<=8;ok++)
	              {
	                  list_string=list_string+Integer.toString(list[i][j][ok])+" ";
	              }
	              list_string=list_string+"*";
	          }
	         list_string=list_string+"- ";
	    }
		return list_string;
	}
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		Tambola_func tf= new Tambola_func();
		String a=req.getParameter("Tickit_number");
		String b=req.getParameter("Time_lapse");
		int ai=Integer.parseInt(a);
		int bi=Integer.parseInt(b);
		int list[][][]=tf.fun_call(ai,bi);
		System.out.println("Tickit_number: "+a);
		System.out.println("Time lapse: "+b);
		String list_string=toConvert(list,ai);
		
		jdbc_con jc=new jdbc_con();
		jc.creatC();
		res.getOutputStream().print(list_string);
		
	}
}
