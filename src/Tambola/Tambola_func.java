package Tambola;

import java.lang.Math;
import java.util.*;  

class MultithreadingDemo extends Thread {
	int sec;
	int times;
	ArrayList<Integer> list_selectors=new ArrayList<Integer>();
	
	MultithreadingDemo(int sec, int times, int list[][][], int first_selector, int total){
		this.sec=sec*1000;
		this.times=times;
		for(int i=0;i<=first_selector;i++){
	          for(int j=0;j<=2;j++){
	              for(int ok=0;ok<=8;ok++){
	                  if((this.list_selectors.indexOf(list[i][j][ok]))==-1){
	                	  this.list_selectors.add(list[i][j][ok]);
	                  };
	              }
	          }
	      }
	}
	public void run()
	{
		try {
			// Displaying the thread that is running
			for(int i=0;i<=this.times;i++){
				Tambola_func nt=new Tambola_func();
				System.out.println(nt.pick_num());
				Thread.sleep(this.sec);
			}
			
		}
		catch (Exception e) {
			// Throwing an exception
			System.out.println("Exception is caught");
		}
	}
}



class Generate_ticket1{
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


	private int[] Generate_random_pos(int min,int max,int total){
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

	
	public int[][] p(){

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
		int row2[] = Generate_random_pos(10,20,3);
		Arrays.sort(row2);
		int row3[] = Generate_random_pos(21,30,3);
		Arrays.sort(row3);
		int row4[] = Generate_random_pos(31,40,3);
		Arrays.sort(row4);
		int row5[] = Generate_random_pos(41,50,3);
		Arrays.sort(row5);
		int row6[] = Generate_random_pos(51,60,3);
		Arrays.sort(row6);
		int row7[] = Generate_random_pos(61,70,3);
		Arrays.sort(row7);
		int row8[] = Generate_random_pos(71,80,3);
		Arrays.sort(row8);
		int row9[] = Generate_random_pos(81,90,3);
		Arrays.sort(row9);
		int data[][]={row1,row2,row3,row4,row5,row6,row7,row8,row9};

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
		
		return ticket;
	}


}

class Tambola_func{
	public int[][][] Create_tickets(int total){
		Generate_ticket gt=new Generate_ticket();
		int list[][][]=new int[total][8][2];//creating a 3d array
		for(int i=1;i<=total;i++){
			list[i-1]=gt.p();//calling p function which gives a 2d array
		}
		/*
		for(int i=0;i<=total-1;i++){
	          for(int j=0;j<=2;j++){
	              for(int ok=0;ok<=8;ok++){
	                  System.out.print(list[i][j][ok]);
	                  System.out.print(" ");
	              }
	              System.out.println("");
	          }
	          System.out.println("");
	      }
	     */
		return list;
	}

	public int pick_num(){
		int rand_num=(int)(Math.random()*(1-90+1)+90);
		return rand_num;
	}
	
}