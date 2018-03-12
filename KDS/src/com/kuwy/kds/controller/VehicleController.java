package com.kuwy.kds.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kuwy.kds.model.vehicle;
import com.kuwy.kds.service.VehicleService;


@Controller


	
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<vehicle> dealerRegistration(@RequestBody vehicle insert) {
		System.out.println("vehicle");
		vehicle dealerRegLoginObj = vehicleService.insert(insert);
		return new ResponseEntity<vehicle>(dealerRegLoginObj,
				HttpStatus.OK);
	}
	
	
}
