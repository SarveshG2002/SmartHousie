package Tambola;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig
public class Create_game extends HttpServlet{
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String cname=req.getParameter("cname");
		String promo=req.getParameter("promo");
		String housienum=req.getParameter("housienum");

		String stime=req.getParameter("stime");
		String etime=req.getParameter("etime");
		String players=req.getParameter("players");
		String duration=req.getParameter("duration");
		String backnum=req.getParameter("back");
		Part part =req.getPart("logo");
		Part part1=req.getPart("blogo1");
		Part part2=req.getPart("blogo2");
		Part part3=req.getPart("blogo3");
		Part part4=req.getPart("blogo4");
		Part part5=req.getPart("blogo5");
		
		String filename= part.getSubmittedFileName();
		String filename1=part1.getSubmittedFileName();
		String filename2=part2.getSubmittedFileName();
		String filename3=part3.getSubmittedFileName();
		String filename4=part4.getSubmittedFileName();
		String filename5=part5.getSubmittedFileName();
		
		//System.out.println("This is your background"+background);
		String comid=cname+String.valueOf(Math.random());
		//String brands= brand1+"-"+brand2+"-"+brand3+"-"+brand4+"-"+brand5;
		Part[] part_arr= {part,part1,part2,part3,part4,part5};
		String[] files= {filename,filename1,filename2,filename3,filename4,filename5};
		jdbc_con jc;
		try {
			jc = new jdbc_con();
			jc.creatC();
			String ret=jc.Save_admin_company(cname,comid,part_arr,files);
			System.out.println(ret);
			if(ret=="1") {
				System.out.println("allready exists");
			}

			else if(ret=="10") {
				res.getOutputStream().print("Please select logo");
			}
			boolean rt=false;
			String background="";
			if (backnum.compareTo("custom")==0) {
				Part stsss=req.getPart("userBack");
				System.out.println(stsss);
				String mainpath = "D:\\Projects\\Tambola\\Tambola_eclips\\DemoApp\\WebContent\\backgrounds\\"+cname+promo;
				//String mainpath = "/logos/"+cname;
				//String mainpath="/usr/apache-tomcat-9.0.70/webapps/ROOT/logos/"+cname+promo;
				File f1 = new File(mainpath);
				boolean bool = f1.mkdir();
				System.out.println("path created:  "+bool);
				InputStream is;
				byte[] data;
				String path;
				FileOutputStream fos;
				is=stsss.getInputStream();
				data=new byte[is.available()];
				is.read(data);
				//path = mainpath+"/"+stsss.getSubmittedFileName();//for linux
				path = mainpath+"\\"+stsss.getSubmittedFileName(); //for windows
				System.out.println(path);
				fos=new FileOutputStream(path);
				//System.out.println(path);
				fos.write(data);
				fos.close();
				backnum=cname+promo+"\\\\"+stsss.getSubmittedFileName();
				System.out.println("custom path: "+backnum);
				background="custom";
			}
			else if(backnum.compareTo("61")==0){
				background="default";
				backnum="";
			}
			else {
				background="selected";
			}
				rt = jc.Save_game(cname,promo,housienum,stime,etime,players,duration,backnum,background);
				if(rt) {
					//jc.con.close();
					//res.getOutputStream().print(a);
					//System.out.println("after saving game");
					New_thread nt=new New_thread(stime,etime,promo,duration,Integer.parseInt(players),Integer.parseInt(housienum));
					nt.start();
					res.getOutputStream().print("game created");
				}
				else {
					res.getOutputStream().print("Promocode allready exists, please use different promocode!!");
				}
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}