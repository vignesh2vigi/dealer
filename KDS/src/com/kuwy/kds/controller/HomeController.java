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
import com.kuwy.kds.model.Error;

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
	
	@RequestMapping(value = "/loanlimit", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> loanlimit(@RequestBody KdsModel loan,HttpSession session) {
		String admin_username=(String)session.getAttribute("admin_username");
		 if(admin_username==null){
			
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		System.out.println("loan=================="+loan.getLoanlimit());
		String admin_id=(String)session.getAttribute("admin_id");	
		loan.setAdmin_id(admin_id);
		kdsServices.loan(loan);
		return new ResponseEntity<KdsModel>(loan,HttpStatus.OK);
	}

	
	@RequestMapping(value = "/reject", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> reject(@RequestBody KdsModel reject,HttpSession session) {
		String admin_username=(String)session.getAttribute("admin_username");
		 if(admin_username==null){
			
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		System.out.println("rejectby==================="+reject.getRemark());
		String admin_id=(String)session.getAttribute("admin_id");
		reject.setAdmin_id(admin_id);
		reject = kdsServices.reject(reject);
		return new ResponseEntity<KdsModel>(reject,
				HttpStatus.OK);
	}

	
	@RequestMapping(value = "/delete/{dealer_name}", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deletedel(@PathVariable String dealer_name,HttpSession session) {
		String admin_username=(String)session.getAttribute("admin_username");
		 if(admin_username==null){
			
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		System.out.println("delete========"+dealer_name);
		KdsModel dealerObj = kdsServices.delete(dealer_name);
		return new ResponseEntity<KdsModel>(dealerObj,HttpStatus.OK);
	}
	@RequestMapping(value = "/approve/{dealer_mobile}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ape(@PathVariable String dealer_mobile,HttpSession session) {
		String admin_username=(String)session.getAttribute("admin_username");
		 if(admin_username==null){
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		System.out.println("delete========"+dealer_mobile);
		KdsModel deal = kdsServices.ape(dealer_mobile);
		return new ResponseEntity<KdsModel>(deal,HttpStatus.OK);
	}
	@RequestMapping(value="/dealerlist3",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getlist(HttpSession session){
		String admin_username=(String)session.getAttribute("admin_username");
		 if(admin_username==null){	
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		 List<KdsModel> list=kdsServices.Dealerlist();
		 return new ResponseEntity<List<KdsModel>>(list,HttpStatus.OK);
}
	@RequestMapping(value="/dealerlistave",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> list(HttpSession session){
		String admin_username=(String)session.getAttribute("admin_username");
		 if(admin_username==null){
			
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		 List<KdsModel> list=kdsServices.ave();
		 return new ResponseEntity<List<KdsModel>>(list,HttpStatus.OK);
}
	@RequestMapping(value="/dealerlistrjt",method=RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> deallist(HttpSession session){
		String admin_username=(String)session.getAttribute("admin_username");
		 if(admin_username==null){
			
			return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
		}
		 List<KdsModel> list=kdsServices.rjt();
		 return new ResponseEntity<List<KdsModel>>(list,HttpStatus.OK);
}
	@RequestMapping(value="/login",method=RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> log(@RequestBody KdsModel log,HttpSession session){
		if(!kdsServices.valid(log.getAdmin_id())){	
			Error error=new Error(2,"Invalid Admin Id");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		else if(!kdsServices.validpass(log.getAdmin_password())){	
			Error error=new Error(3,"Invalid Admin Password");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		KdsModel validUser=kdsServices.log(log);
		if(validUser==null){
			Error error=new Error(1,"Admin Id & password empty");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		session.setAttribute("admin_username", validUser.getAdmin_username());
		session.setAttribute("admin_id", validUser.getAdmin_id());
		return new ResponseEntity<KdsModel>(validUser,HttpStatus.OK);	
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET,produces=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<?> logout(HttpSession session){
	String admin_username=(String)session.getAttribute("admin_username");
	System.out.println("Name of the user is"+ admin_username);
	if(admin_username==null){
		return new ResponseEntity<Error>(HttpStatus.UNAUTHORIZED);
	}
	session.removeAttribute("admin_username");
	session.invalidate();
	return new ResponseEntity<KdsModel>(HttpStatus.OK);
}
	
	@RequestMapping(value = "/edit", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> edit(@RequestBody KdsModel edit,HttpSession session) {
		System.out.println("loan=================="+edit.getSno());
		KdsModel ks=kdsServices.edit(edit);
		return new ResponseEntity<KdsModel>(ks,HttpStatus.OK);
	}
}