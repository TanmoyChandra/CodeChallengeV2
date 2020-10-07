package com.example.demo.controller;
import java.util.*;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DealerEntity;
import com.example.demo.model.ApiError;
import com.example.demo.service.MyService;

import ch.qos.logback.classic.Logger;

@RestController
public class MyController {
	
	private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MyService.class);
	
	@Autowired
	MyService myService;
	
	@RequestMapping("/dealers")
	
	public List<DealerEntity> dealers() {
		LOGGER.debug("User Hits \"/dealer\" End Point");
		return myService.getAllDealers();
	}
	
	@RequestMapping(value="/finddealer", method=RequestMethod.GET)
	public List<DealerEntity> finddealer(@RequestParam String address) {
		LOGGER.debug("User Hits \"/finddealer\" End Point");
		return myService.fetchDealer(address);
	}

	@RequestMapping(value="/adddealer", method=RequestMethod.POST)
	public ResponseEntity<?> adddealer(@Valid @RequestBody DealerEntity newDealer, Errors errors) {
		LOGGER.debug("User Hits \"/adddealer\" End Point");
		
		//If the given data is not valid then..
		if (errors.hasErrors()) {
			ApiError apierror = new ApiError(HttpStatus.BAD_REQUEST, errors.getFieldError().getDefaultMessage(),errors);
			return new ResponseEntity<>(apierror, HttpStatus.BAD_REQUEST);
		}
		myService.addDealer(newDealer);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
