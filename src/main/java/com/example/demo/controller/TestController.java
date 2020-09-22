package com.example.demo.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;
import org.json.JSONObject;
//import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dealer;
import com.example.demo.service.MyService;
@RestController
public class TestController {
	@Autowired
	MyService myService;
	@RequestMapping("/dealers")
	public ArrayList<Dealer> dealers() {
		return myService.getAllDealers();
	}
	
	@RequestMapping(value="/finddealer", method=RequestMethod.GET)
	public Dealer finddealer(@RequestParam String address) {
		return myService.fetchDealer(address);
	}

	@RequestMapping(value="/adddealer", method=RequestMethod.POST)
	public ArrayList<Dealer> adddealer(@RequestBody Dealer newDealer) {
		return myService.addDealer(newDealer);
	}
}
