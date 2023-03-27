package Tambola;
import java.io.File;
import java.util.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import com.google.gson.*;
import javax.servlet.http.Part;
import java.lang.Math;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//*************************************************************************************************************************************
class randsel{
	public int[] rand_sel;
}
class Generate_ticket{

	public int cheack_avail(int arr[],int cnum){
		int cond=0;
		for(int j=0;j<=arr.length-1;j++){
			if(arr[j]==cnum){
				cond=1;
				break;
			}
		}
		return cond;
	}


	protected int[] Generate_random_pos(int min,int max,int total){
		int b;
		int arr[]=new int[total];
		for(int i=0;i<=arr.length-1;i++){arr[i]=99;}
		for(int i=0;i<=total-1;i++){
			while (true){
				b = (int)(Math.random()*(max-min+1)+min);
				int cond=cheack_avail(arr,b);
				if (cond==0){
					arr[i]=b;
					break;
				}
			}
		}
		return arr;
	}

	
	public int[][] p(int selector){

		int ticket[][]={{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}};
		int ticketr[][]={{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0}};
		int pos1[] = Generate_random_pos(0,8,5);
		Arrays.sort(pos1);
		int pos2[] = Generate_random_pos(0,8,5);
		Arrays.sort(pos2);
		int pos3[] = Generate_random_pos(0,8,5);
		Arrays.sort(pos3);
		int pos[][]={pos1,pos2,pos3};

		int row1[] = Generate_random_pos(1,9,3);
		Arrays.sort(row1);
		int row2[] = Generate_random_pos(10,19,3);
		Arrays.sort(row2);
		int row3[] = Generate_random_pos(20,29,3);
		Arrays.sort(row3);
		int row4[] = Generate_random_pos(30,39,3);
		Arrays.sort(row4);
		int row5[] = Generate_random_pos(40,49,3);
		Arrays.sort(row5);
		int row6[] = Generate_random_pos(50,59,3);
		Arrays.sort(row6);
		int row7[] = Generate_random_pos(60,69,3);
		Arrays.sort(row7);
		int row8[] = Generate_random_pos(70,79,3);
		Arrays.sort(row8);
		int row9[] = Generate_random_pos(80,90,3);
		Arrays.sort(row9);
		int data[][]={row1,row2,row3,row4,row5,row6,row7,row8,row9};
		//This is for data
		for(int i=0;i<=8;i++){
			for(int j=0;j<=2;j++){
				ticketr[j][i]=data[i][j];	
			}
		}
		for(int i=0;i<=2;i++){
			for(int j=0;j<=4;j++){
				ticket[i][pos[i][j]]=ticketr[i][pos[i][j]];
			}
		}
		int col=0,mid1=0,mid2=0,up=0,low=0;
		if (selector==56){
			col=5;
			mid1=55;
			mid2=57;
			up=60;
			low=51;
		}
		else if (selector==66){
			col=6;
			mid1=65;
			mid2=67;
			up=70;low=61;
		}
		else if (selector==46){
			col=4;
			mid1=45;
			mid2=47;
			up=50;
			low=41;
		}
		if(ticket[0][col]==selector || ticket[1][col]==selector || ticket[2][col]==selector){
		
		}
		else{
			//011
			if(ticket[0][col]==0 && ticket[1][col]!=0 && ticket[2][col]!=0){
				ticket[1][col]=selector;
				ticket[2][col]=(int)(Math.random()*(up-mid2+1)+mid2);
			}
			//101
			else if(ticket[0][col]!=0 && ticket[1][col]==0 && ticket[2][col]!=0){
				ticket[0][col]=(int)(Math.random()*(mid1-low+1)+low);
				ticket[2][col]=selector;
			}
			//110
			else if(ticket[0][col]!=0 && ticket[1][col]!=0 && ticket[2][col]==0){
				ticket[0][col]=(int)(Math.random()*(mid1-low+1)+low);
				ticket[1][col]=selector;
			}
			//001
			
			else if(ticket[0][col]==0 && ticket[1][col]==0 && ticket[2][col]!=0){
				ticket[2][col]=selector;
			}
			//100
			else if(ticket[0][col]!=0 && ticket[1][col]==0 && ticket[2][col]==0){
				ticket[0][col]=selector;
			}
			//010
			else if(ticket[0][col]==0 && ticket[1][col]!=0 && ticket[2][col]==0){
				ticket[1][col]=selector;
			}
			//000
			else if(ticket[0][col]==0 && ticket[1][col]==0 && ticket[2][col]==0){
			}
			//111
			else if (ticket[0][col]!=0 && ticket[1][col]!=0 && ticket[2][col]!=0){
				if(ticket[2][col]>selector && ticket[0][col]<selector){
					ticket[1][col]=selector;
				}
				else if(ticket[2][col]<selector && ticket[0][col]<selector){
					ticket[2][col]=selector;
				}
				else if(ticket[2][col]>selector && ticket[0][col]>selector){
					ticket[0][col]=selector;
				}
			}

		}
		
		return ticket;
	}

	public int[][][] create(int players,int selector){
		
		int list[][][]=new int[players][8][2];//creating a 3d array
		int raw[][]=new int[8][2];
		boolean v=true;
		int i=0;
		while(i<players){
			raw=p(selector);
			for(int col=0;col<=8;col++){
				if(raw[0][col]==0 && raw[1][col]==0 && raw[2][col]==0){
					v=false;
					break;
				}
			}
			if(v==false){
				v=true;
			}else{
			
				list[i]=raw;
				v=true;
				i++;
			}	
		}

		return list;
	}
}
class createc{
	public int[][] change_f(int[][] tick,int common) {
		int c1=0;int c2=0;int c3=0;int c4=0;int bb=0;
		if(common==56){
			c1=53;c2=55;c3=57;c4=59;bb=5;
		}
		else if(common==46){
			c1=43;c2=45;c3=47;c4=49;bb=4;
		}
		else if(common==66){
			c1=63;c2=65;c3=67;c4=69;bb=6;
		}
		for(int j=0;j<=2;j++){
      		
			if(tick[j][bb]==common){
				if(tick[0][bb]!=0 && tick[1][bb]!=0 && tick[2][bb]!=0){
					tick[0][bb]=c1;
					tick[1][bb]=c2;
					tick[2][bb]=c3;
				}
				else if(tick[0][bb]==0 && tick[1][bb]!=0 && tick[2][bb]!=0) {
					tick[1][bb]=c2;
					tick[2][bb]=c3;
				}
				else if(tick[0][bb]!=0 && tick[1][bb]==0 && tick[2][bb]!=0) {
					tick[0][bb]=c1;
					tick[2][bb]=c3;
				}
				else if(tick[0][bb]!=0 && tick[1][bb]!=0 && tick[2][bb]==0) {
					tick[0][bb]=c1;
					tick[1][bb]=c2;
				}
				else if(tick[0][bb]!=0 && tick[1][bb]==0 && tick[2][bb]==0) {
					tick[0][bb]=c1;
				}
				else if(tick[0][bb]==0 && tick[1][bb]!=0 && tick[2][bb]==0) {
					tick[1][bb]=c2;
				}
				else if(tick[0][bb]==0 && tick[1][bb]==0 && tick[2][bb]!=0) {
					tick[2][bb]=c3;
				}
			}
			
	     }
		return tick;
	}
	
	
	public int get_housie_num(int[][] tick,List<Integer> rand) {
		List <Integer> num=new ArrayList<Integer>();
		int count=0;
		for(int j=0;j<=2;j++){
	  		for(int ok=0;ok<=8;ok++){
	  			if(tick[j][ok]!=0 && rand.contains(tick[j][ok])==false) {
	  				num.add(tick[j][ok]);
	  			}
	  		}
		}
		Collections.shuffle(num);
		return num.get(1);
	}
	
	
	
	public List<Integer> get_20(int[][] tick,int f1,int f2, int f3, int f4, int f5,int f6,int f7,int f8,int f9,int common) {
		List <Integer> sel=new ArrayList<Integer>();
		sel.add(f1);sel.add(f2);sel.add(f3);sel.add(f4);sel.add(f5);sel.add(f6);sel.add(f7);sel.add(f8);sel.add(f9);sel.add(common);
		List <Integer> num=new ArrayList<Integer>();
		List <Integer> r19=new ArrayList<Integer>();
		int count=0;
		int rand=0;
		for(int j=0;j<=2;j++){
	  		for(int ok=0;ok<=8;ok++){
	  			if(tick[j][ok]!=0) {
	  				num.add(tick[j][ok]);
	  			}
	  		}
		}
		//System.out.println("num: "+num);
		Collections.shuffle(num);
		for(int i:num) {
			if(sel.contains(i)==false) {
				r19.add(i);
				count++;
			}
			if(count<=4) {}else {
				break;
			}
		}
		int last=r19.get(4);
		r19.remove(4);
		for(int i=1;i<=15;i++) {
			rand=(int)(Math.random()*(90-1+1)+1);
			if(sel.contains(rand)==false && r19.contains(rand)==false && rand!=last) {
				r19.add(rand);
			}
			else {i--;}
		}
		Collections.shuffle(r19);
		r19.add(last);
		return r19;
	}
	
	public List<Integer> combine(List<Integer> r19,int common,int fh_at,int fh1,int fh2,int fh3,int fh4,int fh5,int fh6,int fh7,int fh8,int fh9,int[][] tick) {
		List <Integer> all_num=new ArrayList<Integer>();
		List <Integer> sel=new ArrayList<Integer>();
		sel.add(fh1);sel.add(fh2);sel.add(fh3);sel.add(fh4);sel.add(fh5);sel.add(fh6);sel.add(fh7);sel.add(fh8);sel.add(fh9);sel.add(common);
		List <Integer> r20=new ArrayList<Integer>();
		List <Integer> num=new ArrayList<Integer>();
		for(int i=1;i<=90;i++) {all_num.add(i);}
		Collections.shuffle(all_num);
		r20.addAll(r19);

		int rand=0;
		//Removing numbers from all_num that present in r20
		for(int i:r20) {
			if(all_num.contains(i)) {
				all_num.remove(all_num.indexOf(i));
			}
		}
		for(int i:sel) {
			if(all_num.contains(i)) {
				all_num.remove(all_num.indexOf(i));
			}
		}
		
		//getting numbers from housie tickiet that are not present in r20
		for(int j=0;j<=2;j++){
      		for(int ok=0;ok<=8;ok++){
      			if(tick[j][ok]!=0 && r20.contains(tick[j][ok])==false && sel.contains(tick[j][ok])==false) {
      				num.add(tick[j][ok]);
      				all_num.remove(all_num.indexOf(tick[j][ok]));
      			}
      		}
		}

		int count=fh_at-r20.size()-num.size()-1;
		int counter=0;
		for(int i:all_num) {
			if(r20.contains(i)==false && sel.contains(i)==false && num.contains(i)==false) {
				num.add(i);
				counter++;
			}
			if(counter==count) {
				break;
			}
		}
		num.add(fh1);
		r20.addAll(num);
		sel.remove(sel.indexOf(fh1));
		for(int i:num) {
			if(all_num.contains(i)) {
				all_num.remove(all_num.indexOf(i));
			}
		}
		all_num.addAll(sel);
		Collections.shuffle(all_num);
		r20.addAll(all_num);
		return r20;
	}
	
	
}


class housie_new{
	public static boolean check_avail(int num,int arr[]){
		for(int i=0;i<5;i++){
			if(num==arr[i]){
				return false;
			}
		}
		return true;
	}
	
	public String[] Tickets(int players,int fh_at){
		Generate_ticket gt=new Generate_ticket();
		int sel=66;
		int list1[][][]=gt.create(players,sel);
		int list2[][][]=gt.create(players,sel);
		int list3[][][]=gt.create(players,sel);
		List <Integer> rand=new ArrayList<Integer>();
		
		
		//System.out.println(all_num);
		//Generating random numbers to select tickets
		int[] rand_sel;
		if(players<=10) {
			rand_sel=gt.Generate_random_pos(1, players-1, 7);
		}
		else {
			rand_sel=gt.Generate_random_pos(1, 9, 7);
		}
		int early51= rand_sel[0];
		int firstLine=rand_sel[1];
		int secLine=rand_sel[2];
		int thirdLine=rand_sel[3];
		int fullhousie1=rand_sel[4];
		int fullhousie2=rand_sel[5];
		int fullhousie3=rand_sel[6];
		System.out.println(Arrays.toString(rand_sel));
		
		
		for(int i=0;i<=players-1;i++){
	          for(int j=0;j<=2;j++){
	              for(int ok=0;ok<=8;ok++){
	                  System.out.print(list1[i][j][ok]);
	                  System.out.print("               ");
	              }
	              System.out.println("");
	          }
	          System.out.println("");
	      }
		System.out.println("\n\n\n\n\n");
		
		//FirstLine ticket validation
		int[][] temp=line_validator(list1[firstLine],1);
		list1[firstLine]=temp;
		temp=line_validator(list2[firstLine],1);
		list2[firstLine]=temp;
		temp=line_validator(list3[firstLine],1);
		list3[firstLine]=temp;
		
		temp=line_validator(list1[secLine],2);
		list1[secLine]=temp;
		temp=line_validator(list2[secLine],2);
		list2[secLine]=temp;
		temp=line_validator(list3[secLine],2);
		list3[secLine]=temp;
		
		temp=line_validator(list1[thirdLine],3);
		list1[thirdLine]=temp;
		temp=line_validator(list2[thirdLine],3);
		list2[thirdLine]=temp;
		temp=line_validator(list3[thirdLine],3);
		list3[thirdLine]=temp;
		
		
		createc c=new createc();
		
		
		//For first person
				int[][] f1=list1[rand_sel[4]];
				int[][] f2=list2[rand_sel[4]];
				int[][] f3=list3[rand_sel[4]];
				
				//for second person
				int[][] f4=list1[rand_sel[5]];
				int[][] f5=list2[rand_sel[5]];
				int[][] f6=list3[rand_sel[5]];
				
				//for third person
				int[][] f7=list1[rand_sel[6]];
				int[][] f8=list2[rand_sel[6]];
				int[][] f9=list3[rand_sel[6]];
				//Replacing common number with another number
				f1=c.change_f(f1, sel);
				f2=c.change_f(f2, sel);
				f3=c.change_f(f3, sel);
				f4=c.change_f(f4, sel);
				f5=c.change_f(f5, sel);
				f6=c.change_f(f6, sel);
				f7=c.change_f(f7, sel);
				f8=c.change_f(f8, sel);
				f9=c.change_f(f9, sel);
				
				//Replacing original tickets
				list1[rand_sel[4]]=f1;
				list2[rand_sel[4]]=f2;
				list3[rand_sel[4]]=f3;
				
				list1[rand_sel[5]]=f4;
				list2[rand_sel[5]]=f5;
				list3[rand_sel[5]]=f6;
				
				list1[rand_sel[6]]=f7;
				list2[rand_sel[6]]=f8;
				list3[rand_sel[6]]=f9;
		
				for(int i=0;i<=players-1;i++){
			          for(int j=0;j<=2;j++){
			              for(int ok=0;ok<=8;ok++){
			                  System.out.print(list1[i][j][ok]);
			                  System.out.print("               ");
			              }
			              System.out.println("");
			          }
			          System.out.println("");
			      }
				System.out.println("\n\n\n\n\n");
				
				Gson gson=new Gson();
				Game_array ga=new Game_array();
				ga.setList1(list1);
				ga.setList2(list2);
				ga.setList3(list3);
				String tickets_array=gson.toJson(ga);
				randsel r=new randsel();
				r.rand_sel=rand_sel;
				String rand_sel1=gson.toJson(r);
				//System.out.println(rand_sel1);
				String[] a= {tickets_array,rand_sel1};
				System.out.println(tickets_array);
				
				
		return a;
	}
	

	private int[][] line_validator(int[][] list, int i) {
		Generate_ticket gt=new Generate_ticket();
		boolean b=true;
		//int [][][] list1 = null;
		while(b) {
			if(list[i-1][6]==66) {
				list=gt.create(1,66)[0];
			}
			else {
				b=false;
			}
		}
		if(b==false) {
			return list;
		}
		return null;
	}
}

//************************************************************************************************************************************

class winners{
	private String first5="";
	private String firstLine="";
	private String secondLine="";
	private String thirdLine="";
	private String fullhousie1="";
	private String fullhousie2="";
	private String fullhousie3="";
	public String getFirst5() {
		return first5;
	}
	public void setFirst5(String first5) {
		this.first5 = first5;
	}
	public String getFirstLine() {
		return firstLine;
	}
	public void setFirstLine(String firstLine) {
		this.firstLine = firstLine;
	}
	public String getSecondLine() {
		return secondLine;
	}
	public void setSecondLine(String secondLine) {
		this.secondLine = secondLine;
	}
	public String getThirdLine() {
		return thirdLine;
	}
	public void setThirdLine(String thirdine) {
		this.thirdLine = thirdine;
	}
	public String getFullhousie1() {
		return fullhousie1;
	}
	public void setFullhousie1(String fullhousie1) {
		this.fullhousie1 = fullhousie1;
	}
	public String getFullhousie2() {
		return fullhousie2;
	}
	public void setFullhousie2(String fullhousie2) {
		this.fullhousie2 = fullhousie2;
	}
	public String getFullhousie3() {
		return fullhousie3;
	}
	public void setFullhousie3(String fullhousie3) {
		this.fullhousie3 = fullhousie3;
	}
}

public class jdbc_con {
	public Connection con;
	jdbc_con() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		String user = "root";
		//String user="smarthousie_smart";
		String pass="1234";
		//String pass="@dmin@123";		
		String url="jdbc:mysql://localhost:3306/tambola";
		//String url="jdbc:mysql://localhost:3306/smarthousie_smart";
		//System.out.println("Connecting to db: (user:"+user+"; password:"+pass+"; DB:"+url+")");
		this.con = DriverManager.getConnection(url , user , pass);
	}
	public int pick_num(){
		int rand_num=(int)(Math.random()*(1-90+1)+90);
		return rand_num;
	}
	public Connection creatC() {
		try {
			System.out.println("Connecting to db....");
			Class.forName("com.mysql.jdbc.Driver");
			String user = "root";
			//String user="smarthousie_smart";
			String pass="1234";
			//String pass="@dmin@123";		
			String url="jdbc:mysql://localhost:3306/tambola";
			//String url="jdbc:mysql://localhost:3306/smarthousie_smart";
			//System.out.println("Connecting to db: (user:"+user+"; password:"+pass+"; DB:"+url+")");Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url , user , pass);
			System.out.println("Connected");
		}catch(Exception e) {
			System.out.println(e);
		}
		return con;
	}
	
	public void Save_brand_logo(String path,String cname,String brand1,String brand2,String brand3,String brand4,String brand5) throws IOException {
		System.out.print("logos saved");
	}
	
	public String Save_admin_company(String cname, String comid, Part[] part_arr, String[] files) throws IOException{
		String query="select * from company where Company_name='"+cname+"'";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			System.out.println(rs);
			rs.next();
			try {
				System.out.println(rs.getString("Company_name"));
				return "1";
			}catch(SQLException e) {
				System.out.println("exception caugth saving logos.....");
				query="insert into company values ('"+cname+"','"+comid+"','"+files[0]+"',1)";
				st=con.createStatement();
				int bb=st.executeUpdate(query);
				InputStream is;
				byte[] data;
				String path;
				System.out.println(Arrays.toString(files));
				FileOutputStream fos;
				String mainpath = "D:\\Projects\\Tambola\\Tambola_eclips\\DemoApp\\WebContent\\logos\\"+cname;
				//String mainpath = "/logos/"+cname;
				//String mainpath="/usr/apache-tomcat-9.0.70/webapps/ROOT/logos/"+cname;
				File f1 = new File(mainpath);
				boolean bool = f1.mkdir();
				System.out.println("path created:  "+bool);
				for(int i=0;i<files.length;i++) {
					if(files[i]!="") {
						is=part_arr[i].getInputStream();
						data=new byte[is.available()];
						is.read(data);
						//path = mainpath+"/"+files[i];//for linux
						path = mainpath+"\\"+files[i]; //for windows
						System.out.println(path);
						fos=new FileOutputStream(path);
						//System.out.println(path);
						fos.write(data);
						fos.close();
					}
				}
				
				//System.out.println(bb);
				return mainpath;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "10";
		}
	}
	public String check_game(String promo) {
		String query="select * from game where promo_code='"+promo+"'";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			System.out.println(rs.getString("Company_name"));
			return "1";
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "10";
		}
	}

	public boolean Save_game(String cname, String promo, String housienum, String stime, String etime,String players, String duration, String background,String background_status) throws SQLException, IOException {
		
		
		if(check_game(promo)=="1"){
			System.out.println("game is present");
			return false;
		}
		else {
			String game_id=cname+promo+String.valueOf(Math.random());
			housie_new Housie=new housie_new();
			String[] ret=Housie.Tickets(Integer.parseInt(players), Integer.parseInt(housienum));
			String tickets=ret[0];
			String rand_sel=ret[1];
			Statement st=con.createStatement();
			winners w=new winners();
			Gson gson=new Gson();
			String winners=gson.toJson(w);
			System.out.println("from game custom: "+background);
			String query = "insert into game values ('"+game_id+"','"+promo+"','"+cname+"','"+players+"','"+game_id+"','"+stime+"','"+etime+"','"+duration+"','"+tickets+"','0','Not started','','"+rand_sel+"','',0,'',0,'"+background+"','"+winners+"','true','"+background_status+"')";
			st=con.createStatement();
			st.executeUpdate(query);
			System.out.println("Game has been saved");
			return true;
		}
	}
	public void add_current_num(int num,int i, String promo) {
		try {
			//System.out.println("db connection closed: "+con.isClosed());
			if(con.isClosed()==true) {
				con=this.creatC();
			}
			//System.out.println("db connection closed: "+con.isClosed());
			Statement st=con.createStatement();
			String query= "update game set current_num='"+num +"' where promo_code='"+promo+"'";
			st.executeUpdate(query);
			query="update game set current_number_index="+i+" where promo_code='"+promo+"'";
			//System.out.println(query);
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	public String save_user(String name, String promocode, String phone, String email) throws SQLException {
		// TODO Auto-generated method stub
		Gson gson= new Gson();
		String ret = check_id_avail(name,phone,email,promocode);
		//System.out.println(ret);
		if (ret!="") {
			String query="select * from game where promo_code='"+promocode+"'";
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String start_time=rs.getString("start_time");
			return ret+start_time;
		}
		else if(ret==""){
			String query="select * from game where promo_code='"+promocode+"'";
			String str=""; 
			try {
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery(query);
				rs.next();
				int ticket_id=Integer.parseInt(rs.getString("tick_index"));
				String gameid=rs.getString("game_id");
				String rand=rs.getString("tickets");
				String start_time=rs.getString("start_time");
				int nul=0;
				//ticket_id=ticket_id+1;
				query ="insert into user_data (name,promo_code,mobile,email,ticket_id,ticket_grp_id,game_win,selected_by,updated_ticket) values('"+name+"','"+promocode+"','"+phone+"','"+email+"','"+ticket_id+"','"+gameid+"','started','"+nul+"','0')";
				st.executeUpdate(query);
				//System.out.println(ticket_id+" user data inserted");
				query="update game set tick_index="+(ticket_id+1)+" where game_id='"+gameid+"'";
				st.executeUpdate(query);
				
				Game_array gr=gson.fromJson(rand, Game_array.class);
				int list1[][][]=gr.getList1();
				int list2[][][]=gr.getList2();
				int list3[][][]=gr.getList3();
				Array_to_json arj=new Array_to_json();
				arj.setArray1(list1[ticket_id]);
				arj.setArray2(list2[ticket_id]);
				arj.setArray3(list3[ticket_id]);
				arj.setStart_time(start_time);
				str=gson.toJson(arj);
				return str;
			}catch (SQLException e) {
				System.out.println(e);
			}
			//System.out.println("sarvesh_1: "+str);
			return str;
			
		}
		//System.out.println("sarvesh: "+ret);
		return ret;
		
		//String query = "insert into game values ('"+name+"','"+promocode+"','"+phone+"','"+email+"','"+etime+"','"+duration+"','"+ret+"','0')";
		
	}
	
	public String selected_ticket(int data, String name, String mail, String phone, String promo) throws SQLException {
		class single_ticket{
			private int [][] arr;

			public int[][] getArr() {
				return arr;
			}

			public void setArr(int[][] arr) {
				this.arr = arr;
			}
			
		}
		Gson gson= new Gson();
		String query="select tickets,tick_index,game_id,selected_ticket_index from game where promo_code='"+promo+"'";
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery(query);
		rs.next();
		String rand=rs.getString("tickets");
		int ticket_id=rs.getInt("tick_index");
		String gameid=rs.getString("game_id");
		String rand_sel1=rs.getString("selected_ticket_index");
		randsel rand_sel=gson.fromJson(rand_sel1, randsel.class);
		
		int[] rand_seln=rand_sel.rand_sel;
		//System.out.println(Arrays.toString(rand_seln)+"-"+ticket_id);
		for(int i:rand_seln) {
			if(i==ticket_id) {
				
				query="select user_selection from game where promo_code='"+promo+"'";
				rs=st.executeQuery(query);
				rs.next();
				String user_selection=rs.getString("user_selection");
				user_selection=user_selection+"-"+Integer.toString(i);
				query="update game set user_selection='"+user_selection+"' where game_id='"+gameid+"'";
				st.executeUpdate(query);
				break;
			}
		}
		//String selected_tickets=rs.getString("selected_tickets");
		
		Game_array gr=gson.fromJson(rand, Game_array.class);
		int list[][][] = null;
		if(data==1) {
			list=gr.getList1();
		}
		else if (data==2) {
			list=gr.getList2();
		}
		else if(data==3) {
			list=gr.getList3();
		}
		query="select ticket_id from user_data where name='"+name+"' AND email='"+mail+"' And mobile='"+phone+"' AND promo_code='"+promo+"'";
		rs=st.executeQuery(query);
		rs.next();
		String ticket_id1=rs.getString("ticket_id");
		String sr=gson.toJson(list[Integer.parseInt(ticket_id1)]);
		//System.out.println("From you got: "+sr);
		/*
		single_ticket sta=new single_ticket();
		sta.setArr(list[Integer.parseInt(ticket_id1)]);
		System.out.println("Before converting: "+Arrays.toString(sta.getArr()));
		
		String sru=gson.toJson(sta);
		System.out.println("After converting you got: "+sru);
		*/
		query="update user_data set selected_ticket='"+sr+"',selected_by='"+data+"' where name='"+name+"' AND email='"+mail+"' And mobile='"+phone+"' AND promo_code='"+promo+"'";		
		st.executeUpdate(query);
		return sr;
	}
	
	public String check_id_avail(String name, String phone, String email, String promocode) {
		String query="select * from user_data where name='"+name+"' AND promo_code='"+promocode+"' AND mobile='"+phone+"' AND email='"+email+"'";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String tick=rs.getString("selected_ticket");
			String ticket_id=rs.getString("ticket_id");
			//System.out.println(tick);
			query="select * from game where promo_code='"+promocode+"'";
			rs=st.executeQuery(query);
			rs.next();
			String start_time=rs.getString("start_time");
			if(tick==null) {
				return "z"+ticket_id+start_time;
			}
			return "y"+tick+start_time;
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "";
		}
	}
	public ResultSet getAllAboutGame(String promo) {
		String query="select * from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return null;
		
	}
	public int get_user_index(String promo, int i) {
		String query="select selected_by from user_data where promo_code='"+promo+"' && ticket_id="+i+"";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			return rs.getInt("selected_by");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return 0;
	}
	public String get_current_num(String promo) {
		// TODO Auto-generated method stub
		//System.out.println("cheacking promo "+promo);
		String query="select current_num from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			
			String ss=rs.getString("current_num");
			return ss;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return "no";
	}
	public String get_duration(String promo) {
		// TODO Auto-generated method stub
		String query="select duration from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			
			String ss=rs.getString("duration");
			return ss;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return "no";
	}
	public String get_all_num(String promo) {
		String query="select final_array,current_num from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			Gson gson=new Gson();
			//All_rand ar=gson.fromJson(rs.getString("random_numbers_array") , All_rand.class);
			String final_array=rs.getString("final_array");
			
			list_string ar=gson.fromJson(final_array , list_string.class);
			//System.out.println(ar.getL());
			List<Integer> random_numbers = ar.getL();
			int cnum=rs.getInt("current_num");
			List<Integer> until = new ArrayList<Integer>();
			for(int a:random_numbers) {
				if(a!=cnum) {
					until.add(a);
				}
				else {
					until.add(a);
					break;
				}
			}
			list_string ls=new list_string();
			ls.setL(until);
			String fa=gson.toJson(ls);
			return fa;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return "no";
	}
	public void change_status(String promo,String status) {
		try {
			//System.out.println(con.isClosed());
			Statement st=con.createStatement();
			String query= "update game set status='"+status+"' where promo_code='"+promo+"'";
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	public void update_users_ticket(String num, String promo, String mail, String name) {
		// TODO Auto-generated method stub
		try {
			//System.out.println(con.isClosed());
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select updated_ticket from user_data where promo_code='"+promo+"' && email='"+mail+"' && name='"+name+"'");
			//System.out.println(promo+" "+mail+" "+name );
			rs.next();
			String ss=rs.getString("updated_ticket");
			//System.out.println("updated_ticket: "+ss+" "+num+" "+(ss.equals("0")));
			if ((ss.equals("0"))==false) {
				
				String[] arr=ss.split("-");
				//System.out.println(arr.toString());
				String temp="false";
				//System.out.println(Arrays.toString(arr));
				for(String x:arr) {
					if(x.equals(num)) {
						temp="true";
						//System.out.println("number is here");
						break;
					}
				}
				if(temp=="false") {
					ss=ss+"-"+num;
					String query= "update user_data set updated_ticket='"+ss+"' where promo_code='"+promo+"' && name='"+name+"' && email='"+mail+"'";
					st.executeUpdate(query);
				}
				
			}
			else {
				String query= "update user_data set updated_ticket='"+num+"' where promo_code='"+promo+"'";
				st.executeUpdate(query);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	public String get_logos(String promo) {
		class images{
			List <String> l=new ArrayList<String>();
			
		}
		String query="select Company_name from game where promo_code='"+promo+"'";
		
	      //List of all files and directories
	      
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String cname=rs.getString("Company_name");
			query="select Company_logo from company where Company_name='"+cname+"'";
			rs=st.executeQuery(query);
			rs.next();
			String logo_name=rs.getString("Company_logo");
			//File directoryPath = new File("/usr/apache-tomcat-9.0.70/webapps/ROOT/logos/"+cname);//for linux
			File directoryPath = new File("D:\\Projects\\Tambola\\Tambola_eclips\\DemoApp\\WebContent\\logos\\"+cname);//for windows
			String contents[] = directoryPath.list();
			//System.out.println(Arrays.toString(contents));
			Gson gson=new Gson();
			List <String> l=new ArrayList<String>();
			for(String i :contents) {
				l.add(i);
			}
			l.add(cname);
			l.add(Integer.toString(l.lastIndexOf(logo_name)));
			return l.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return "no";
	}
	public String check_num_arrived(String num, String promo) {
		String query="select final_array,current_num from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			//String allarr=rs.getString("random_numbers_array");
			String final_array=rs.getString("final_array");
			Gson gson=new Gson();
			list_string ar=gson.fromJson(final_array , list_string.class);
			//System.out.println(ar.getL());
			List<Integer> random_numbers = ar.getL();
			int cnum=rs.getInt("current_num");
			List<Integer> until = new ArrayList<Integer>();
			for(int a:random_numbers) {
				if(a!=cnum) {
					until.add(a);
				}
				else {
					until.add(a);
					break;
				}
			}
			//System.out.println("until: "+until);
			//System.out.println("updated number index: "+allarr.indexOf(cnum));
			//System.out.println(until.contains(Integer.parseInt(num)));
			if(until.contains(Integer.parseInt(num))) {
				//String query= "update user_data set updated_ticket='"+ss+"' where promo_code='"+promo+"' && name='"+name+"' && email='"+mail+"'";
				//st.executeUpdate(query);
				return "got";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "error";
		}
		return "not";
	}
	public String get_user_sel_num(String promo, String mail, String name) {
		String query="select updated_ticket from user_data where promo_code='"+promo+"' && name='"+name+"' && email='"+mail+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String nums=rs.getString("updated_ticket");
			return nums;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "error";
		}
	}
	public int get_arrive_num(String promo) {
		String query="select current_num from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			int num=rs.getInt("current_num");
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return 0;
		}
	}
	public ResultSet getData(String query) {
		//String query="select current_num from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Data not found"+e);
			return null;
		}
	}
	public void setData(String query) {
		// TODO Auto-generated method stub
		Statement st;
		try {
			st = con.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int get_current_number_index(String promo) {
		String query="select current_number_index from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			int num=rs.getInt("current_number_index");
			return num;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return 0;
		}
	}
	public String get_back_page(String promo) {
		// TODO Auto-generated method stub
		String query="select background,bckground_status from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String background=rs.getString("background");
			String status=rs.getString("bckground_status");
			String[] bs= {background,status};
			Gson gson=new Gson();
			String bss=gson.toJson(bs);
			return bss;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return query;
		}
	}
	public String check_win(String promo, String apply, String email, String name) {
		// TODO Auto-generated method stub
		String query="select winners from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String winners=rs.getString("winners");
			Gson gson=new Gson();
			winners w=gson.fromJson(winners, winners.class);
			
			Method m = w.getClass().getMethod("get"+apply);
		    String result = (String) m.invoke(w);
		    System.out.println(result);
		    if(result.equals("")) {
		    	System.out.println(apply);
			    m = w.getClass().getMethod("set"+apply, String.class);
			    m.invoke(w,email+"--"+name);
			    winners=gson.toJson(w);
				query= "update game set winners='"+winners+"' where promo_code='"+promo+"'";
				st.executeUpdate(query);
				return "You are winner for "+apply;
		    }
			return "You are not first one to claim award for "+apply;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return query;
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	public void sendSms(String promo,int number) {
		// TODO Auto-generated method stub
		String query="select intgration from game where promo_code='"+promo+"'";
		Statement st;
		try {
			
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String intgration=rs.getString("intgration");
			System.out.println("SMS intgration: "+intgration);
			System.out.println(intgration=="true"+" - "+ "true".compareTo(intgration));
			if("true".compareTo(intgration)==0) {
				System.out.println("Getting mobile numbers");
				query="select mobile from user_data where promo_code='"+promo+"'";
				st = con.createStatement();
				rs=st.executeQuery(query);
				String mobile;
				while (rs.next()) {
					 mobile=rs.getString("mobile");
					 Send_sms sms=new Send_sms(promo);
					 sms.setCurrent(number);
					 sms.call_me(mobile);
	            }
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getWinners(String promo) {
		// TODO Auto-generated method stub
		String query="select winners from game where promo_code='"+promo+"'";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String result=rs.getString("winners");
			Gson gson=new Gson();
			winners w=gson.fromJson(result, winners.class);
			String g=gson.toJson(w);
			return g;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public String get_current_game() {
		class temp{
			private List<String> a=new ArrayList<>();

			public List<String> getA() {
				return a;
			}

			public void setA(List<String> a) {
				this.a = a;
			}
		}
		String query="select promo_code,Company_name,intgration from game";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			String promo,name,intgration;
			String[] arr=new String[3];
			ArrayList<String> a=new ArrayList<>();
			String temp;
			System.out.println(a);
			while (rs.next()) {
				 promo=rs.getString("promo_code");
				 name=rs.getString("Company_name");
				 intgration=rs.getString("intgration");
				 temp=promo+"--"+name+"--"+intgration;
//				 arr[0]=promo;
//				 arr[1]=name;
//				 arr[2]=intgration;
				 a.add(temp);
				 System.out.println("loop: "+Arrays.toString(arr));
           }
			System.out.println("list: "+a);
			Gson gson=new Gson();
//			temp t=new temp();
//			t.setA(a);
//			System.out.println("okk: "+t.getA());
			String result=gson.toJson(a);
			System.out.println(result);
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public String get_about_game() {
		String query="select final_array from game";
		Statement st;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(query);
			rs.next();
			String result=rs.getString("final_array");
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public String change_intgration(String state, String promo) {
		// TODO Auto-generated method stub
		try {
			Statement st = con.createStatement();
			String query= "update game set intgration='"+state+"' where promo_code='"+promo+"'";
			st.executeUpdate(query);
			return "done";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
}
