package com.kuwy.kds.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kuwy.kds.model.KdsModel;
import com.kuwy.kds.service.KdsServices;


@Controller
public class HomeController {

	@Autowired
	private KdsServices kdsServices;
	
	@RequestMapping(value = "/dealerRegistration", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KdsModel> dealerRegistration(@RequestBody KdsModel info) {
		System.out.println("dealerRegistration");
		KdsModel dealerRegLoginObj = kdsServices.accessSignupSheet(info);
		return new ResponseEntity<KdsModel>(dealerRegLoginObj,
				HttpStatus.OK);
	}
	@RequestMapping(value = "/loanlimit", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KdsModel> loanlimit(@RequestBody KdsModel loan) {
		System.out.println("hi==================="+loan.getDealer_name());
		KdsModel dealerRegLoginObj = kdsServices.loan(loan);
		return new ResponseEntity<KdsModel>(dealerRegLoginObj,
				HttpStatus.OK);
	}
	@RequestMapping(value = "/reject", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KdsModel> reject(@RequestBody KdsModel reject) {
		System.out.println("hi==================="+reject.getDealer_name());
		KdsModel dealerRegLoginObj = kdsServices.reject(reject);
		return new ResponseEntity<KdsModel>(dealerRegLoginObj,
				HttpStatus.OK);
	}
	
	@RequestMapping(value = "/dealerlist", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KdsModel> dealerlist() {
		KdsModel dealerObj = kdsServices.dealerlist();
		return new ResponseEntity<KdsModel>(dealerObj,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{dealer_name}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KdsModel> deletedel(@PathVariable String dealer_name) {
		System.out.println("delete========"+dealer_name);
		KdsModel dealerObj = kdsServices.delete(dealer_name);
		return new ResponseEntity<KdsModel>(dealerObj,HttpStatus.OK);
	}
	@RequestMapping(value = "/approve/{dealer_name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<KdsModel> ape(@PathVariable String dealer_name) {
		System.out.println("delete========"+dealer_name);
		KdsModel deal = kdsServices.ape(dealer_name);
		return new ResponseEntity<KdsModel>(deal,HttpStatus.OK);
	}
	@RequestMapping(value="/dealerlist3",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getlist(HttpSession session){
		String dealer_name=(String)session.getAttribute("dealer_name");
		 if(dealer_name==null){
			
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		 List<KdsModel> list=kdsServices.Dealerlist();
		 return new ResponseEntity<List<KdsModel>>(list,HttpStatus.OK);
}
	@RequestMapping(value="/login",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> log(@RequestBody KdsModel log,HttpSession session){
		KdsModel validUser=kdsServices.log(log);
		if(validUser==null){
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		session.setAttribute("dealer_name", validUser.getDealer_name());
		return new ResponseEntity<KdsModel>(validUser,HttpStatus.OK);	
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> logout(HttpSession session){
	String dealer_name=(String)session.getAttribute("dealer_name");
	System.out.println("Name of the user is"+ dealer_name);
	if(dealer_name==null){
		return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
	}
	session.removeAttribute("dealer_name");
	return new ResponseEntity<KdsModel>(HttpStatus.OK);
}
}