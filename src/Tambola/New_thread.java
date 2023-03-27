package Tambola;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;

import com.google.gson.Gson;

class array_string{
	int [][] arr;
}
class list_string{
	private List<Integer> l=new ArrayList<Integer>();

	public List<Integer> getL() {
		return l;
	}

	public void setL(List<Integer> l) {
		this.l = l;
	}
}


class create{
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
}
/*
class get_data_of_tick{
	int [][] array;
	public int getRandomElement(List<Integer> list)
    {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
	public int pos_66() {
		if (array[0][6]==66) {
			return 1;
		}
		else if (array[1][6]==66) {
			return 2;
		}
		else if (array[2][6]==66) {
			return 3;
		}
		return 0;
	}
	public int get_controller1(){
		List <Integer> rand=new ArrayList<Integer>();
		for(int i=0;i<=8;i++) {
			if(array[0][i]!=0) {
				rand.add(array[0][i]);
			}
		}
		return getRandomElement(rand);
	}
	public int get_controller2(){
		List <Integer> rand=new ArrayList<Integer>();
		for(int i=0;i<=8;i++) {
			if(array[1][i]!=0) {
				rand.add(array[1][i]);
			}
		}
		return getRandomElement(rand);
	}
	public int get_controller3(){
		List <Integer> rand=new ArrayList<Integer>();
		for(int i=0;i<=8;i++) {
			if(array[2][i]!=0) {
				rand.add(array[2][i]);
			}
		}
		return getRandomElement(rand);
	}
	
	public List<Integer> rand5(List <Integer> randc) {
		List <Integer> rand=new ArrayList<Integer>();
		randc.add(0);
		for(int i=0;i<=2;i++) {
			for(int j=0;j<=8;j++) {
				if(randc.contains(array[i][j])==false) {
					rand.add(array[i][j]);
				}
			}
		}
		return rand;
	}

	public get_data_of_tick(int[][] early51_array) {
		// TODO Auto-generated constructor stub
		this.array=early51_array;
	}
	
}
*/
class get_data_of_tick{

	public List<Integer> get_early5(int[][] arr, List<Integer> l) {
		l.add(66);
		List<Integer> num=new ArrayList<Integer>();
		for(int i=0;i<3;i++) {
			for(int j=0;j<9;j++) {
				if(arr[i][j]!=0 && l.contains(arr[i][j])==false) {
					num.add(arr[i][j]);
				}
			}
		}
		Collections.shuffle(num);
		List<Integer> num1=new ArrayList<Integer>();
		num1.add(num.get(0));
		num1.add(num.get(1));
		num1.add(num.get(2));
		num1.add(num.get(3));
		num1.add(num.get(4));
		return num1;
	}
	public List<Integer> getl5(int n,int[][] arr){
		List<Integer> r=new ArrayList<Integer>();
		for(int i=0;i<=8;i++) {
			if(arr[n][i]!=0) {
				r.add(arr[n][i]);
			}
		}
		Collections.shuffle(r);
		return r;
	}
	public int getController(List<Integer> first5, List<Integer> must) {
		Collections.shuffle(first5);
		return first5.get(0);
	}
	public List<Integer> getAllnum(int[][] arr) {
		// TODO Auto-generated method stub
		List<Integer> a=new ArrayList<Integer>();
		for(int i=0;i<=2;i++) {
			for(int j=0;j<8;j++) {
				if(arr[i][j]!=0) {
					a.add(arr[i][j]);
				}
			}
		}
		
		return a;
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
	
	
}


public class New_thread extends Thread{
	private String stime;
	private String etime;
	private String promo;
	private String dur;
	private int num;
	private int players;
	private int at;
	private List <Integer> all_arr=new ArrayList<Integer>();
	private int[] rand_sel;
	private int early51;
	private int firstLine;
	private int secLine;
	private int thirdLine;
	private int fullhousie1;
	private int fullhousie2;
	private int fullhousie3;
	int [][] early51_array;
	int [][] firstLine_array;
	int [][] secLine_array;
	int [][] thirdLine_array;
	int [][] fullhousie1_array;
	int [][] fullhousie2_array;
	int [][] fullhousie3_array;
	List<Integer> unwanted=new ArrayList<>();
	List<Integer> wanted=new ArrayList<>();
	
	
	public static int[][] convertStringToArray(String input) {
	    // Use regular expression to split the input string
	    String[] rows = input.split("(?<=\\]),(?=\\[)");
	    // Create a 2D array with the same number of rows as the input string
	    int[][] result = new int[rows.length][];
	    for (int i = 0; i < rows.length; i++) {
	        // Remove the brackets from each row
	        rows[i] = rows[i].replaceAll("[\\[\\]]", "");
	        // Split the row into an array of integers
	        String[] row = rows[i].split(",");
	        // Create a new array of integers for each row
	        result[i] = new int[row.length];
	        for (int j = 0; j < row.length; j++) {
	            // Convert each string element to an integer and add it to the array
	            result[i][j] = Integer.parseInt(row[j]);
	        }
	    }
	    return result;
	}
	
	public static List<Integer> removeDuplicates(List<Integer> inputList) {
        return new ArrayList<Integer>(new LinkedHashSet<Integer>(inputList));
    }

	
	public New_thread(String stime, String etime,String promo,String dur, int players, int at) {
		// TODO Auto-generated constructor stub
		this.etime=etime;
		this.stime=stime;
		this.promo=promo;
		this.dur=dur;
		this.players=players;
		this.at=at;
	}
	private int check_index(int rand_sel2, String[] rand_sel1) {
		for(int i=0;i<=4;i++) {
			if(Integer.parseInt(rand_sel1[i])==rand_sel2) {
				return i;
			}
		}
		return -1;
	}

	public void run() {
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.HOUR_OF_DAY)+ ":"+ now.get(Calendar.MINUTE)+":"+now.get(Calendar.SECOND));
		int chour=now.get(Calendar.HOUR_OF_DAY);
		int cmin=now.get(Calendar.MINUTE);
		int csec=now.get(Calendar.SECOND);
		int hour=(Integer.parseInt(stime.substring(0, 2)))-chour;
		int min=(Integer.parseInt(stime.substring(3)))-cmin;
		System.out.println(hour+":"+min);
		hour=hour*60*60;
		min=min*60;
		int total_sec=(hour+min)-csec;
		System.out.println(total_sec);
		try {
			Thread.sleep(total_sec*1000);
			System.out.println("I am Ready");
			jdbc_con js=new jdbc_con();
			js.change_status(promo, "started");
			ResultSet rs=js.getAllAboutGame(this.promo);
			Gson gson=new Gson();
			//All_rand ar=gson.fromJson(rs.getString("random_numbers_array") , All_rand.class);
			
		//Getting random numbers ticket index
			randsel ap=gson.fromJson(rs.getString("selected_ticket_index"), randsel.class);
			rand_sel=ap.rand_sel;
			System.out.println(Arrays.toString(rand_sel));
			//List <Integer> rand=new ArrayList<Integer>();
			early51= rand_sel[0];
			firstLine=rand_sel[1];
			secLine=rand_sel[2];
			thirdLine=rand_sel[3];
			fullhousie1=rand_sel[4];
			fullhousie2=rand_sel[5];
			fullhousie3=rand_sel[6];
			
			//System.out.println(early51_array);
			System.out.println("first");
			
	//Getting selected tickets
			
			ResultSet tempRs=js.getData("select selected_ticket from user_data where ticket_id='"+early51+"'");
			System.out.println("early51: "+(tempRs.getString("selected_ticket")));
			early51_array=convertStringToArray(tempRs.getString("selected_ticket"));
			
			tempRs=js.getData("select selected_ticket from user_data where ticket_id='"+firstLine+"'");
			System.out.println("firstLine: "+(tempRs.getString("selected_ticket")));
			firstLine_array=convertStringToArray(tempRs.getString("selected_ticket"));
			
			tempRs=js.getData("select selected_ticket from user_data where ticket_id='"+secLine+"'");
			System.out.println("secondLine: "+(tempRs.getString("selected_ticket")));
			secLine_array=convertStringToArray(tempRs.getString("selected_ticket"));
			
			tempRs=js.getData("select selected_ticket from user_data where ticket_id='"+thirdLine+"'");
			System.out.println("thirdLine: "+(tempRs.getString("selected_ticket")));
			thirdLine_array=convertStringToArray(tempRs.getString("selected_ticket"));
			
			tempRs=js.getData("select selected_ticket from user_data where ticket_id='"+fullhousie1+"'");
			System.out.println("full housie 1: "+(tempRs.getString("selected_ticket")));
			fullhousie1_array=convertStringToArray(tempRs.getString("selected_ticket"));
			
			tempRs=js.getData("select selected_ticket from user_data where ticket_id='"+fullhousie2+"'");
			System.out.println("full housie 2: "+(tempRs.getString("selected_ticket")));
			fullhousie2_array=convertStringToArray(tempRs.getString("selected_ticket"));
			
			tempRs=js.getData("select selected_ticket from user_data where ticket_id='"+fullhousie3+"'");
			System.out.println("full housie 3: "+(tempRs.getString("selected_ticket")));
			fullhousie3_array=convertStringToArray(tempRs.getString("selected_ticket"));
			
			
			
			
			List<Integer> must=new ArrayList<>();
			
			
			System.out.println("Second task getting unwanted and wanted uniqueness............");
			
			
	//Getting 5 numbers from each selected tickets as per its winner status
			get_data_of_tick gd=new get_data_of_tick();
			List<Integer> f15=gd.getAllnum(fullhousie1_array);
			List<Integer> s15=gd.getAllnum(fullhousie2_array);
			List<Integer> t15=gd.getAllnum(fullhousie3_array);
			
			List<Integer> first5=gd.getl5(0,firstLine_array);
			List<Integer> sec5=gd.getl5(1,secLine_array);
			List<Integer> third5=gd.getl5(2,thirdLine_array);
			List<Integer> early5=gd.get_early5(early51_array,must);
			
			unwanted.addAll(early5);
			unwanted.addAll(first5);
			unwanted.addAll(sec5);
			unwanted.addAll(third5);
			int fh1=0;
			int fh2=0;
			int fh3=0;
			while(true) {
				fh1=gd.get_housie_num(fullhousie1_array,unwanted);
				if(unwanted.contains(fh1)) {
					
				}
				else {
					break;
				}
			}
			while(true) {
				fh2=gd.get_housie_num(fullhousie2_array,unwanted);
				if(unwanted.contains(fh2)) {
					
				}else {break;}
			}
			while(true) {
				fh3=gd.get_housie_num(fullhousie3_array,unwanted);
				if(unwanted.contains(fh3)) {
					
				}else {break;}
			}
			
			
			
			System.out.println("fh1: "+fh1+"\nfh2: "+fh2+"\nfh3: "+fh3);
			List<Integer> housie_numbers=new ArrayList<>();
			for(int i=0;i<=2;i++) {
				for (int j=0;j<=8;j++) {
					if(fullhousie1_array[i][j]!=0 && fullhousie1_array[i][j]!=fh1) {
						housie_numbers.add(fullhousie1_array[i][j]);
					}
				}
			}
			
			Collections.shuffle(housie_numbers);
			//f15.remove(fh1);
			unwanted.addAll(housie_numbers);
			unwanted.add(fh1);
			unwanted.add(fh2);
			unwanted.add(fh3);
			unwanted.add(66);

			System.out.println("unwanted: "+unwanted);
			System.out.println("unwanted: "+removeDuplicates(unwanted));
			unwanted=removeDuplicates(unwanted);
			
			for(int i=1;i<=90;i++) {
				if(unwanted.contains(i)==false) {
					wanted.add(i);
				}
			}
			System.out.println("wanted: "+wanted);
			Collections.shuffle(wanted);
			
			
			
			//f15.addAll(wanted);
			//wanted=f15;
			
			
			System.out.println("Third task combining both lists");
			List<Integer> ind_list=new ArrayList<Integer>();
			int ind=get_con_ind(unwanted,early5);
			ind_list.add(ind);
			ind=get_con_ind(unwanted,first5);
			ind_list.add(ind);
			ind=get_con_ind(unwanted,sec5);
			ind_list.add(ind);
			ind=get_con_ind(unwanted,third5);
			ind_list.add(ind);
			
			
			//List<Integer> temp_storage=unwanted.subList(ind, unwanted.indexOf(fh1));
			List<Integer> temp_storage=new ArrayList<Integer>();
			for(int i=ind+1;i<unwanted.indexOf(fh1);i++) {
				temp_storage.add(unwanted.get(i));
			}
			unwanted.removeAll(temp_storage);
			temp_storage.addAll(wanted);
			wanted=temp_storage;
			
			
			
			System.out.println("index of last element of winners_number: "+ind_list);
			int calc=-1;
			int differ=(at-15)/4;
			
			//For early5
			int low=0;
			int high=ind_list.get(0);
			int dif=high-low;
			List<Integer> temp_early5=new ArrayList<Integer>();
			for(int i=0;i<(differ-dif);i++) {
				temp_early5.add(wanted.get(i));
				wanted.remove(wanted.get(i));
			}
			temp_early5.addAll(unwanted.subList(low, high));
			Collections.shuffle(temp_early5);
			temp_early5.add(unwanted.get(high));
			System.out.println("first combination: "+temp_early5);
			
			//For first5
			low=high+1;
			high=ind_list.get(1);
			dif=high-low;
			List<Integer> temp_first5=new ArrayList<Integer>();
			for(int i=0;i<(differ-dif);i++) {
				temp_first5.add(wanted.get(i));
				wanted.remove(wanted.get(i));
			}
			temp_first5.addAll(unwanted.subList(low, high));
			Collections.shuffle(temp_first5);
			temp_first5.add(unwanted.get(high));
			System.out.println("Second combination: "+temp_first5);
			
			//For sec5
			low=high+1;
			high=ind_list.get(2);
			dif=high-low;
			List<Integer> temp_sec5=new ArrayList<Integer>();
			for(int i=0;i<(differ-dif);i++) {
				temp_sec5.add(wanted.get(i));
				wanted.remove(wanted.get(i));
			}
			temp_sec5.addAll(unwanted.subList(low, high));
			Collections.shuffle(temp_sec5);
			temp_sec5.add(unwanted.get(high));
			System.out.println("third combination: "+temp_sec5);
			
			//For third5
			low=high+1;
			high=ind_list.get(3);
			dif=high-low;
			List<Integer> temp_third5=new ArrayList<Integer>();
			for(int i=0;i<(differ-dif);i++) {
				temp_third5.add(wanted.get(i));
				wanted.remove(wanted.get(i));
			}
			temp_third5.addAll(unwanted.subList(low, high));
			Collections.shuffle(temp_third5);
			temp_third5.add(unwanted.get(high));
			System.out.println("fourth combination: "+temp_third5);
			
			
			List<Integer> Final_array=new ArrayList<Integer>();
			Final_array.addAll(temp_early5);
			Final_array.addAll(temp_first5);
			Final_array.addAll(temp_sec5);
			Final_array.addAll(temp_third5);
			System.out.println("Final_array half part: "+Final_array);
			System.out.println("Remaining numbers: "+wanted);
			
			
			List<Integer> temp_fh=new ArrayList<Integer>();
			List<Integer> temp_wanted=new ArrayList<Integer>();
			temp_wanted.addAll(wanted);
			System.out.println("Now we want "+(80-(Final_array.size()))+" more numbers to win");
			for(int i=0;i<(80-(Final_array.size()))-1;i++) {
				//System.out.println(i);
				//System.out.print(wanted.get(i));
				temp_fh.add(temp_wanted.get(i));
				wanted.remove(temp_fh.get(temp_fh.size()-1));
			}
			Final_array.addAll(temp_fh);
			
			System.out.println("unwanted: "+unwanted);
			Final_array.add(fh1);
			System.out.println("Final_array full housie part: "+Final_array);
			System.out.println("Remaining numbers"+wanted);
			wanted.add(fh2);
			wanted.add(fh3);
			Collections.shuffle(wanted);
			Final_array.addAll(wanted);
			Final_array.add(66);
			
			
			
			//List<Integer> combine1=combine(unwanted,early5,differ);
			
			
			
			
			/*
			System.out.println("Before #######################################################");
			System.out.println("first5: "+first5);
			System.out.println("sec5: "+sec5);
			System.out.println("third5: "+third5);
			System.out.println("early5: "+early5);
			
			//System.out.println("first5 before: "+first5);
			must.add(first5.get(0));
			//System.out.println("first5 after: "+first5);
			first5.remove(0);

			
			//gd.getController(first5,must);
			
			
			//System.out.println("sec5 before: "+sec5);
			for(int i:sec5) {
				if(must.contains(i)==false) {
					must.add(i);
					sec5.remove(sec5.indexOf(i));
					break;
				}
			}
			//System.out.println("sec5 after: "+sec5);
			
			
			for(int i:third5) {
				if(must.contains(i)==false) {
					must.add(i);
					third5.remove(third5.indexOf(i));
					break;
				}
			}
			
			for(int i:early5) {
				if(must.contains(i)==false) {
					must.add(i);
					early5.remove(early5.indexOf(i));
					break;
				}
			}
			System.out.println("After #######################################################");
			System.out.println("first5: "+first5);
			System.out.println("sec5: "+sec5);
			System.out.println("third5: "+third5);
			System.out.println("early5: "+early5);
			
			
			System.out.println("\n\n\n\n\n\n"+must);
			
			System.out.println("\n\n\n third");
			
			int []hollow = new int[90];
			List<Integer> random_numbers=new ArrayList<Integer>();
			int calc=-1;
			int differ=at/4;
			calc=calc+differ;
			System.out.println(differ);
			
			int temp_controller;
			List<Integer> early_token=new ArrayList<Integer>();
			
			
			
			
			hollow[calc]=must.get(4);
			calc=calc+differ;
			hollow[calc]=must.get(0);
			calc=calc+differ;
			hollow[calc]=must.get(1);
			calc=calc+differ;
			hollow[calc]=must.get(2);
			*/
			//gd.getRandom(0,differ,must);
			/*
			int rand;
			for (int i=0;i<differ-5;i++) {
				rand=(int)(Math.random()*(90-1+1)+1);
				if(must.contains(rand)==false && rand!=66 && rand!=0 && random_numbers.contains(rand)) {
					random_numbers.add(rand);
				}
			}
			random_numbers.addAll(early5);
			Collections.shuffle(random_numbers);
			//random_numbers.add(early5.get(3));
			
			List<Integer> random_numbersf=new ArrayList<Integer>();
			for (int i=0;i<differ-5;i++) {
				rand=(int)(Math.random()*(90-1+1)+1);
				if(must.contains(rand)==false && rand!=66 && rand!=0 && random_numbersf.contains(rand) && random_numbers.contains(rand)) {
					random_numbersf.add(rand);
				}
			}
			random_numbersf.addAll(first5);
			Collections.shuffle(random_numbersf);
			
			List<Integer> random_numberss=new ArrayList<Integer>();
			for (int i=0;i<differ-5;i++) {
				rand=(int)(Math.random()*(90-1+1)+1);
				if(must.contains(rand)==false && rand!=66 && rand!=0 && random_numberss.contains(rand) && random_numbersf.contains(rand) && random_numbers.contains(rand)) {
					random_numberss.add(rand);
				}
			}
			random_numberss.addAll(sec5);
			Collections.shuffle(random_numberss);
			
			List<Integer> random_numberst=new ArrayList<Integer>();
			for (int i=0;i<differ-5;i++) {
				rand=(int)(Math.random()*(90-1+1)+1);
				if(must.contains(rand)==false && rand!=66 && rand!=0 && random_numbers.contains(rand) && random_numberss.contains(rand) && random_numbersf.contains(rand) && random_numbers.contains(rand)) {
					random_numberst.add(rand);
				}
			}
			random_numberst.addAll(third5);
			Collections.shuffle(random_numberst);
			System.out.println(random_numbers);
			System.out.println(random_numbersf);
			System.out.println(random_numberss);
			System.out.println(random_numberst);
			*/
			
			
			
			
			
			/*
			get_data_of_tick dtf=new get_data_of_tick(firstLine_array);
			get_data_of_tick dts=new get_data_of_tick(secLine_array);
			get_data_of_tick dtt=new get_data_of_tick(thirdLine_array);
			
			
			
			
			create c= new create();
			int fh1=c.get_housie_num(fullhousie1_array,rand);
			rand.add(fh1);
			int fh2=c.get_housie_num(fullhousie2_array,rand);
			rand.add(fh2);
			int fh3=c.get_housie_num(fullhousie3_array,rand);
			rand.add(fh3);
			*/
			
			/*
			String sel=rs.getString("user_selection");
			String []rand_sel1=new  String[5];
			int temp10=0;
			for(int i=1;i<6;i++) {
				System.out.println(rand_sel_tempp[i]);
				rand_sel1[temp10]=rand_sel_tempp[i];
				temp10++;
			}
			//String []rand_sel1= {"2","4","3","5","8"};
			System.out.println(Arrays.toString(rand_sel));
			System.out.println(Arrays.toString(rand_sel1));
			List<Integer> l=new ArrayList<Integer>();
			String final_array="";
			
			int ind1=this.check_index(rand_sel[0],rand_sel1);
			int ind2=this.check_index(rand_sel[1],rand_sel1);
			if(ind1<ind2) {
				ResultSet rsU=js.getData("select selected_by from user_data where promo_code='"+this.promo+"' && ticket_id="+ind1+"");
				int temp=rsU.getInt("selected_by");
				final_array=final_array+"e"+Integer.toString(temp);
			}
			else if(ind2<ind1) {
				ResultSet rsU=js.getData("select selected_by from user_data where promo_code='"+this.promo+"' && ticket_id="+ind2+"");
				int temp=rsU.getInt("selected_by");
				final_array=final_array+"e"+Integer.toString(temp+3);
			}
			int fh1=this.check_index(rand_sel[2],rand_sel1);
			int fh2=this.check_index(rand_sel[3],rand_sel1);
			int fh3=this.check_index(rand_sel[4],rand_sel1);
	         
	        //find the smallest
	        if(fh1<fh2) {
	            if(fh3<fh1) {
	                ResultSet rsU=js.getData("select selected_by from user_data where promo_code='"+this.promo+"' && ticket_id="+fh3+"");
					int temp1=rsU.getInt("selected_by");
					final_array=final_array+"f"+Integer.toString(temp1+6);
	            } else {
	                ResultSet rsU=js.getData("select selected_by from user_data where promo_code='"+this.promo+"' && ticket_id="+fh1+"");
					int temp1=rsU.getInt("selected_by");
					final_array=final_array+"f"+Integer.toString(temp1);
	            }
	        } else {
	            if(fh2<fh3) {
	                ResultSet rsU=js.getData("select selected_by from user_data where promo_code='"+this.promo+"' && ticket_id="+fh2+"");
					int temp1=rsU.getInt("selected_by");
					final_array=final_array+"f"+Integer.toString(temp1+3);
	            } else {
	                ResultSet rsU=js.getData("select selected_by from user_data where promo_code='"+this.promo+"' && ticket_id="+fh3+"");
					int temp1=rsU.getInt("selected_by");
					final_array=final_array+"f"+Integer.toString(temp1+6);
	            }
	        }
	        System.out.println(final_array);
	        js.setData("update game set final_array='"+final_array+"' where promo_code='"+promo+"'");
			List<Integer> random_numbers;
			/*
			System.out.println(final_array.equals("e1f1"));
			System.out.println(final_array.equals("e1f2"));
			System.out.println(final_array.equals("e1f3"));
			System.out.println(final_array.equals("e1f4"));
			System.out.println(final_array.equals("e1f5"));
			System.out.println(final_array.equals("e1f6"));
			System.out.println(final_array.equals("e1f7"));
			System.out.println(final_array.equals("e1f8"));
			System.out.println(final_array.equals("e1f9"));
			
			System.out.println(final_array.equals("e2f1"));
			System.out.println(final_array.equals("e2f2"));
			System.out.println(final_array.equals("e2f3"));
			System.out.println(final_array.equals("e2f4"));
			System.out.println(final_array.equals("e2f5"));
			System.out.println(final_array.equals("e2f6"));
			System.out.println(final_array.equals("e2f7"));
			System.out.println(final_array.equals("e2f8"));
			System.out.println(final_array.equals("e2f9"));
			
			System.out.println(final_array.equals("e3f1"));
			System.out.println(final_array.equals("e3f2"));
			System.out.println(final_array.equals("e3f3"));
			System.out.println(final_array.equals("e3f4"));
			System.out.println(final_array.equals("e3f5"));
			System.out.println(final_array.equals("e3f6"));
			System.out.println(final_array.equals("e3f7"));
			System.out.println(final_array.equals("e3f8"));
			System.out.println(final_array.equals("e3f9"));
			
			System.out.println(final_array.equals("e4f1"));
			System.out.println(final_array.equals("e4f2"));
			System.out.println(final_array.equals("e4f3"));
			System.out.println(final_array.equals("e4f4"));
			System.out.println(final_array.equals("e4f5"));
			System.out.println(final_array.equals("e4f6"));
			System.out.println(final_array.equals("e4f7"));
			System.out.println(final_array.equals("e4f8"));
			System.out.println(final_array.equals("e4f9"));
			
			System.out.println(final_array.equals("e5f1"));
			System.out.println(final_array.equals("e5f2"));
			System.out.println(final_array.equals("e5f3"));
			System.out.println(final_array.equals("e5f4"));
			System.out.println(final_array.equals("e5f5"));
			System.out.println(final_array.equals("e5f6"));
			System.out.println(final_array.equals("e5f7"));
			System.out.println(final_array.equals("e5f8"));
			System.out.println(final_array.equals("e5f9"));
			
			System.out.println(final_array.equals("e6f1"));
			System.out.println(final_array.equals("e6f2"));
			System.out.println(final_array.equals("e6f3"));
			System.out.println(final_array.equals("e6f4"));
			System.out.println(final_array.equals("e6f5"));
			System.out.println(final_array.equals("e6f6"));
			System.out.println(final_array.equals("e6f7"));
			System.out.println(final_array.equals("e6f8"));
			System.out.println(final_array.equals("e6f9"));
			
			if(final_array.equals("e1f1")) {
				random_numbers=ar.getE1f1();
			}
			else if(final_array.equals("e1f2")) {
				random_numbers=ar.getE1f2();
			}
			else if(final_array.equals("e1f3")) {
				random_numbers=ar.getE1f3();
			}
			else if(final_array.equals("e1f4")) {
				random_numbers=ar.getE1f4();
			}
			else if(final_array.equals("e1f5")) {
				random_numbers=ar.getE1f5();
			}
			else if(final_array.equals("e1f6")) {
				random_numbers=ar.getE1f6();
			}
			else if(final_array.equals("e1f7")) {
				random_numbers=ar.getE1f7();
			}
			else if(final_array.equals("e1f8")) {
				random_numbers=ar.getE1f8();
			}
			else if(final_array.equals("e1f9")) {
				random_numbers=ar.getE1f9();
			}
			
			
			
			else if(final_array.equals("e2f1")) {
				random_numbers=ar.getE2f1();
			}
			else if(final_array.equals("e2f2")) {
				random_numbers=ar.getE2f2();
			}
			else if(final_array.equals("e2f3")) {
				random_numbers=ar.getE2f3();
			}
			else if(final_array.equals("e2f4")) {
				random_numbers=ar.getE2f4();
			}
			else if(final_array.equals("e2f5")){
				random_numbers=ar.getE2f5();
			}
			else if(final_array.equals("e2f6")) {
				random_numbers=ar.getE2f6();
			}
			else if(final_array.equals("e2f7")) {
				random_numbers=ar.getE2f7();
			}
			else if(final_array.equals("e2f8")) {
				random_numbers=ar.getE2f8();
			}
			else if(final_array.equals("e2f9")) {
				random_numbers=ar.getE2f9();
			}
			
			
			else if(final_array.equals("e3f1")) {
				random_numbers=ar.getE3f1();
			}
			else if(final_array.equals("e3f2")) {
				random_numbers=ar.getE3f2();
			}
			else if(final_array.equals("e3f3")) {
				random_numbers=ar.getE3f3();
			}
			else if(final_array.equals("e3f4")) {
				random_numbers=ar.getE3f4();
			}
			else if(final_array.equals("e3f5")) {
				random_numbers=ar.getE3f5();
			}
			else if(final_array.equals("e3f6")) {
				random_numbers=ar.getE3f6();
			}
			else if(final_array.equals("e3f7")) {
				random_numbers=ar.getE3f7();
			}
			else if(final_array.equals("e3f8")) {
				random_numbers=ar.getE3f8();
			}
			else if(final_array.equals("e3f9")) {
				random_numbers=ar.getE3f9();
			}
			
			
			else if(final_array.equals("e4f1")) {
				random_numbers=ar.getE4f1();
			}
			else if(final_array.equals("e4f2")) {
				random_numbers=ar.getE4f2();
			}
			else if(final_array.equals("e4f3")) {
				random_numbers=ar.getE4f3();
			}
			else if(final_array.equals("e4f4")) {
				random_numbers=ar.getE4f4();
			}
			else if(final_array.equals("e4f5")) {
				random_numbers=ar.getE4f5();
			}
			else if(final_array.equals("e4f6")) {
				random_numbers=ar.getE4f6();
			}
			else if(final_array.equals("e4f7")) {
				random_numbers=ar.getE4f7();
			}
			else if(final_array.equals("e4f8")) {
				random_numbers=ar.getE4f8();
			}
			else if(final_array.equals("e4f9")) {
				random_numbers=ar.getE4f9();
			}
			
			
			else if(final_array.equals("e5f1")) {
				random_numbers=ar.getE5f1();
			}
			else if(final_array.equals("e5f2")) {
				random_numbers=ar.getE5f2();
			}
			else if(final_array.equals("e5f3")) {
				random_numbers=ar.getE5f3();
			}
			else if(final_array.equals("e5f4")) {
				random_numbers=ar.getE5f4();
			}
			else if(final_array.equals("e5f5")) {
				random_numbers=ar.getE5f5();
			}
			else if(final_array.equals("e5f6")) {
				random_numbers=ar.getE5f6();
			}
			else if(final_array.equals("e5f7")) {
				random_numbers=ar.getE5f7();
			}
			else if(final_array.equals("e5f8")) {
				random_numbers=ar.getE5f8();
			}
			else if(final_array.equals("e5f9")) {
				random_numbers=ar.getE5f9();
			}
			
			
			else if(final_array.equals("e6f1")) {
				random_numbers=ar.getE6f1();
			}
			else if(final_array.equals("e6f2")) {
				random_numbers=ar.getE6f2();
			}
			else if(final_array.equals("e6f3")) {
				random_numbers=ar.getE6f3();
			}
			else if(final_array.equals("e6f4")) {
				random_numbers=ar.getE6f4();
			}
			else if(final_array.equals("e6f5")) {
				random_numbers=ar.getE6f5();
			}
			else if(final_array.equals("e6f6")) {
				random_numbers=ar.getE6f6();
			}
			else if(final_array.equals("e6f7")) {
				random_numbers=ar.getE6f7();
			}
			else if(final_array.equals("e6f8")) {
				random_numbers=ar.getE6f8();
			}
			else {
				System.out.println("last got");
				random_numbers=ar.getE6f9();
			}
			
			*/
			List<Integer> random_numbers=Final_array;
			list_string ls=new list_string();
			ls.setL(random_numbers);
			String fa=gson.toJson(ls);
			js.setData("update game set final_array='"+fa+"' where promo_code='"+promo+"'");
			System.out.println(random_numbers);
			Send_sms ss=new Send_sms(promo);
			for(int i=0;i<90;i++) {
				System.out.println("random number: "+random_numbers.get(i));
				this.num=random_numbers.get(i);
				js.add_current_num(random_numbers.get(i),i, promo);
				ss.setCurrent(random_numbers.get(i));
				ss.run();
				Thread.sleep(Integer.parseInt(this.dur)*1000);
			}
			js.change_status(promo, "ended");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		//System.out.println(promo+": started");
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}

	private int get_con_ind(List<Integer> unwanted, List<Integer> early5) {
		int ind_num=-1;
		int rand;
		for(int x:early5) {
			rand=unwanted.indexOf(x);
			if(rand>ind_num) {
				ind_num=rand;
			}
		}
		return ind_num;
	}

	private List<Integer> combine(List<Integer> unwanted1, List<Integer> early5, int differ) {
		List<Integer> ind=new ArrayList<Integer>();
		int ind_num=-1;
		int rand;
		for(int x:early5) {
			rand=unwanted1.indexOf(x);
			if(rand>ind_num) {
				ind_num=rand;
			}
		}
		System.out.println("ind_num: "+ind_num);
		
		return null;
	}
}