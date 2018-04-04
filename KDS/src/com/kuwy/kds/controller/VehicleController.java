package com.kuwy.kds.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kuwy.kds.client.JerseyClient;
import com.kuwy.kds.model.Status;
import com.kuwy.kds.model.dealership;
import com.kuwy.kds.model.vehicle;
import com.kuwy.kds.service.VehicleService;
import com.kuwy.kds.utility.ccConstants;


@Controller


	
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/vehicle", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<vehicle> dealerRegistration(@RequestBody vehicle insert) {
		System.out.println("vehicle=====");
		vehicle dealerRegLoginObj = vehicleService.insert(insert);
		return new ResponseEntity<vehicle>(dealerRegLoginObj,HttpStatus.OK);
	}

	@RequestMapping(value = "/dealershiplist", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <dealership>dealership(HttpSession session){
						
		/*org.json.JSONObject jsonResp = null;*/
		String valuationResponse = null;
		dealership mk=new dealership();
		
		/*List regDetailsList = new ArrayList();*/
		
		
		try {
			valuationResponse = JerseyClient.getRequest(null);
		
			JSONParser parser = new JSONParser();
			org.json.simple.JSONObject json = (org.json.simple.JSONObject) parser.parse(valuationResponse);
			mk.setRespObj(json);
			
		}
		    catch (Exception e) {
			e.printStackTrace();
		}	
		return new ResponseEntity<dealership>(mk,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/active", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity <Status> accept(@RequestBody Status details){
		
		
		try {
			ObjectMapper mapper = new ObjectMapper();
			System.out.println("Input Json: "
					+ mapper.writeValueAsString(details));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	
		Gson gson = new Gson();
		
		//JSONParser parser = new JSONParser();
		String valuation = null;
		Status mk =new Status();
		//List<String> masterVariantList = new ArrayList<String>();
			
		try {
			valuation = JerseyClient.getInstance().postRequest(
					ccConstants.update,gson.toJson(details));
				    System.out.println("res====>"+gson.toJson(details));
		System.out.println("valuation"+valuation);
				    
					mk.setStatus(valuation);
			
		}
		    catch (Exception e) {
	
			e.printStackTrace();
		}

		return new ResponseEntity<Status>(mk,HttpStatus.OK);
	}

	@RequestMapping(value = "/dealerRegistration", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<dealership> dealerRegistration(@RequestBody dealership bankModel) {
		System.out.println("mobile"+bankModel.getMobile_no());
		System.out.println("user id"+bankModel.getUserid());
		dealership dealerRegLoginObj = vehicleService.accessSignupSheet(bankModel);
		return new ResponseEntity<dealership>(dealerRegLoginObj,
				HttpStatus.OK);
	}
}
