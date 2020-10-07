package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.JSONObject;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.AddressEntity;
import com.example.demo.entity.DealerEntity;
import com.example.demo.repo.DealerRepo;

import ch.qos.logback.classic.Logger;

import com.example.demo.repo.AddressRepo;

@Service
public class MyService {

	@Autowired
	DealerRepo dealerrepo;

	@Autowired
	AddressRepo addressrepo;

	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MyService.class);

	// This will return the details of all the Dealers
	public List<DealerEntity> getAllDealers() {
		LOGGER.info("getAllDealers() Executed");
		return dealerrepo.findAll();
	}

	// This will add a new entry of a new Dealer to the Database
	public DealerEntity addDealer(DealerEntity newDealer) {
		dealerrepo.save(newDealer);
		LOGGER.info("addDealer() Executed");
		return newDealer;
	}

	// This will fetch the nearest dealers address from the given origin address
	public List<DealerEntity> fetchDealer(String address) {

		ArrayList<Integer> diff = new ArrayList<>();
		ArrayList<String> allPinCode = new ArrayList<>();

		List<AddressEntity> allDealer = addressrepo.findAll();
		Integer i = 0;
		Integer numberOfArea = 0;
		StringBuilder singleString = new StringBuilder();

		for (AddressEntity d : allDealer) {
			allPinCode.add(d.getPincode());
			numberOfArea = numberOfArea + 1;
			if (i != 0) {
				singleString.append("|");
			}
			i++;
			singleString.append(d.getPincode());
		}
		try {
			String url = "https://api.distancematrix.ai/maps/api/distancematrix/json?destinations=" + singleString
					+ "&origins=" + address + "&key=UQfpAG4OCtIZ2HP8W3CnMTqcm4OUC";

			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("GET");
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
			//System.out.println("----" + response);
			// String res="{\"destination_addresses\":[\"Kolkata, West Bengal,
			// India\",\"Digha, West Bengal, India\",\"Bihar,
			// India\"],\"origin_addresses\":[\"Kerala,
			// India\"],\"rows\":[{\"elements\":[{\"distance\":{\"text\":\"2258.9
			// km\",\"value\":2258871},\"duration\":{\"text\":\"43
			// h\",\"value\":154378},\"status\":\"OK\"},{\"distance\":{\"text\":\"2106.9
			// km\",\"value\":2106921},\"duration\":{\"text\":\"40
			// h\",\"value\":144059},\"status\":\"OK\"},{\"distance\":{\"text\":\"2498.1
			// km\",\"value\":2498140},\"duration\":{\"text\":\"49
			// h\",\"value\":177859},\"status\":\"OK\"}]}],\"status\":\"OK\"}";

			JSONObject jsonResponse = new JSONObject(response.toString());
			Integer j;
			// System.out.println(numberOfArea);
			for (j = 0; j <= numberOfArea - 1; j++) {
				diff.add(java.lang.Math.abs((int) jsonResponse.getJSONArray("rows").getJSONObject(0)
						.getJSONArray("elements").getJSONObject(j).getJSONObject("distance").get("value")));
			}
			LOGGER.info("fetchDealer() Executed");

		} catch (Exception e) {
			LOGGER.error(e.toString());
		}
		System.out.println(allPinCode.get(diff.indexOf(Collections.min(diff))));
		return dealerrepo.findByaddressentity_pincode(allPinCode.get(diff.indexOf(Collections.min(diff))));
	}
}
