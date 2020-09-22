package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import com.example.demo.model.Dealer;



@Service
public class MyService {
	ArrayList<Dealer> allDealers= new ArrayList<>();
	
	
	public MyService() {
		allDealers.add(new Dealer("Tanmoy","Kolkata",700008));
		
		allDealers.add(new Dealer("Sanu","Digha",700009));
		
		allDealers.add(new Dealer("Rakesh","Bihar",700013));

	}


	public ArrayList<Dealer> getAllDealers() {
		return allDealers;
	}


	public ArrayList<Dealer> addDealer(Dealer newDealer) {
		allDealers.add(newDealer);
		return allDealers;
	}


	public Dealer fetchDealer(String address) {

		ArrayList<Integer> diff= new ArrayList<>();
		Integer i=0;
		Integer numberOfArea=0;
		StringBuilder singleString = new StringBuilder();
		for (Dealer dealer : allDealers) {
			numberOfArea=numberOfArea+1;
			if(i!=0) {
				singleString.append("|");
			}
			i++;
			System.out.println(dealer.getAddress());
			singleString.append(dealer.getAddress());
		}
		System.out.println(singleString);
			 
			try { 
			String url = "https://api.distancematrix.ai/maps/api/distancematrix/json?destinations="+singleString+"&origins="+address+"&key=UQfpAG4OCtIZ2HP8W3CnMTqcm4OUC";
		    //String url = "https://www.google.com"; 
			URL obj = new URL(url);
		     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		     // optional default is GET
		     con.setRequestMethod("GET");
		     //add request header
		     con.setRequestProperty("User-Agent", "Mozilla/5.0");
		     int responseCode = con.getResponseCode();
		     System.out.println("\nSending 'GET' request to URL : " + url);
		     System.out.println("Response Code : " + responseCode);
		     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     System.out.println("----"+response);
		     //String res="{\"destination_addresses\":[\"Kolkata, West Bengal, India\",\"Digha, West Bengal, India\",\"Bihar, India\"],\"origin_addresses\":[\"Kerala, India\"],\"rows\":[{\"elements\":[{\"distance\":{\"text\":\"2258.9 km\",\"value\":2258871},\"duration\":{\"text\":\"43 h\",\"value\":154378},\"status\":\"OK\"},{\"distance\":{\"text\":\"2106.9 km\",\"value\":2106921},\"duration\":{\"text\":\"40 h\",\"value\":144059},\"status\":\"OK\"},{\"distance\":{\"text\":\"2498.1 km\",\"value\":2498140},\"duration\":{\"text\":\"49 h\",\"value\":177859},\"status\":\"OK\"}]}],\"status\":\"OK\"}";

		     JSONObject jsonResponse = new JSONObject(response.toString());
		     Integer j;
		     System.out.println(numberOfArea);
		     for (j=0;j<=numberOfArea-1;j++) {
		    	 //System.out.println(jsonResponse.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(j).getJSONObject("distance").get("value"));
		    	 diff.add(java.lang.Math.abs((int) jsonResponse.getJSONArray("rows").getJSONObject(0).getJSONArray("elements").getJSONObject(j).getJSONObject("distance").get("value")));
		     }
		     System.out.println(allDealers.get(diff.indexOf(Collections.min(diff))).getAddress());

			}
			catch(Exception e) {
				System.out.println(e);
			}
		
		return allDealers.get(diff.indexOf(Collections.min(diff)));
	}
}
