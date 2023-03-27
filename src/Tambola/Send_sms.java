package Tambola;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
public class Send_sms extends Thread{
	
	private String promo;
	private int number;
	public Send_sms(String promo) {
		// TODO Auto-generated constructor stub
		this.promo=promo;
	}
	public void setCurrent(Integer integer) {
		// TODO Auto-generated method stub
		this.number=integer;
	}

	public void run() {
		try {
			//call_me("8369350353");
			jdbc_con jc=new jdbc_con();
			jc.sendSms(promo,number);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
//	public static void main(String[] args) {
//     try {
//         Send_sms.call_me("8369350353");
//        } catch (Exception e) {
//         e.printStackTrace();
//       }
//     }
	   
public void call_me(String number) throws Exception {
     //String url = "https://jsonplaceholder.typicode.com/todos/1";
	 String url="http://sms.pearlsms.com/public/sms/send?sender=KHCAMP&smstype=TRANS&numbers="+number+"&apikey=654d1f5e595b4913aabff1f7e2b21ce1&message=We%20regret%20to%20inform,%20the%20scheduled%20camp%20for%20"+Integer.toString(this.number)+"%20is%20cancelled.%20We%20will%20provide%20you%20with%20a%20free%20camp%20in%20lieu%20of%20the%20cancelled%20camp.%20KHCAMP";
     URL obj = new URL(url);
     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
     // optional default is GET
     con.setRequestMethod("POST");
     //add request header
     con.setRequestProperty("User-Agent", "Mozilla/5.0");
     int responseCode = con.getResponseCode();
     //System.out.println("\nSending 'GET' request to URL : " + url);
     //System.out.println("Response Code : " + responseCode);
     BufferedReader in = new BufferedReader(
             new InputStreamReader(con.getInputStream()));
     String inputLine;
     StringBuffer response = new StringBuffer();
     while ((inputLine = in.readLine()) != null) {
     	response.append(inputLine);
     }
     in.close();
     //print in String
     //System.out.println(response.toString());
   }



}