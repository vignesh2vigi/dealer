package com.kuwy.kds.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_DEFAULT)
public class dealership {

	private String mobile_no;
	private String email_id;
	private String ex_sno;
	private String login_type;
	private String userid;

	private String dealership_name;
	private String dealership_type;
	private String category;
	private String name;
	private String dealer_landline;
	private String dealer_website;
	private String pincode;
	private String state;
	private String district;
	
	private String taluk;
	private String post;
	private String address;
	private String dealer_license_no;
	private String pan_no;
	private String dealer_acc_no;
	private String dealer_branch;
	
	private String dealer_bank_name;
	private String dealer_ifscode;
	private String dealer_vehi_sold;
	private String dealer_vehi_stock;
	private String image;
	private String no_dealer;
	private String credit_amt;
	
	private int active_status;
	private String status;
	private org.json.simple.JSONObject  respObj = new org.json.simple.JSONObject();
	
	
	
	
	public org.json.simple.JSONObject getRespObj() {
		return respObj;
	}
	public void setRespObj(org.json.simple.JSONObject respObj) {
		this.respObj = respObj;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public int getActive_status() {
		return active_status;
	}
	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}

	private JSONArray array;
	private JSONObject object;
	public JSONObject getObject() {
		return object;
	}
	public void setObject(JSONObject object) {
		this.object = object;
	}
	public JSONArray getArray() {
		return array;
	}
	public void setArray(JSONArray array) {
		this.array = array;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getEx_sno() {
		return ex_sno;
	}
	public void setEx_sno(String ex_sno) {
		this.ex_sno = ex_sno;
	}
	public String getLogin_type() {
		return login_type;
	}
	public void setLogin_type(String login_type) {
		this.login_type = login_type;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDealership_name() {
		return dealership_name;
	}
	public void setDealership_name(String dealership_name) {
		this.dealership_name = dealership_name;
	}
	public String getDealership_type() {
		return dealership_type;
	}
	public void setDealership_type(String dealership_type) {
		this.dealership_type = dealership_type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDealer_landline() {
		return dealer_landline;
	}
	public void setDealer_landline(String dealer_landline) {
		this.dealer_landline = dealer_landline;
	}
	public String getDealer_website() {
		return dealer_website;
	}
	public void setDealer_website(String dealer_website) {
		this.dealer_website = dealer_website;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDealer_license_no() {
		return dealer_license_no;
	}
	public void setDealer_license_no(String dealer_license_no) {
		this.dealer_license_no = dealer_license_no;
	}
	public String getPan_no() {
		return pan_no;
	}
	public void setPan_no(String pan_no) {
		this.pan_no = pan_no;
	}
	public String getDealer_acc_no() {
		return dealer_acc_no;
	}
	public void setDealer_acc_no(String dealer_acc_no) {
		this.dealer_acc_no = dealer_acc_no;
	}
	public String getDealer_branch() {
		return dealer_branch;
	}
	public void setDealer_branch(String dealer_branch) {
		this.dealer_branch = dealer_branch;
	}
	public String getDealer_bank_name() {
		return dealer_bank_name;
	}
	public void setDealer_bank_name(String dealer_bank_name) {
		this.dealer_bank_name = dealer_bank_name;
	}
	public String getDealer_ifscode() {
		return dealer_ifscode;
	}
	public void setDealer_ifscode(String dealer_ifscode) {
		this.dealer_ifscode = dealer_ifscode;
	}
	public String getDealer_vehi_sold() {
		return dealer_vehi_sold;
	}
	public void setDealer_vehi_sold(String dealer_vehi_sold) {
		this.dealer_vehi_sold = dealer_vehi_sold;
	}
	public String getDealer_vehi_stock() {
		return dealer_vehi_stock;
	}
	public void setDealer_vehi_stock(String dealer_vehi_stock) {
		this.dealer_vehi_stock = dealer_vehi_stock;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getNo_dealer() {
		return no_dealer;
	}
	public void setNo_dealer(String no_dealer) {
		this.no_dealer = no_dealer;
	}
	public String getCredit_amt() {
		return credit_amt;
	}
	public void setCredit_amt(String credit_amt) {
		this.credit_amt = credit_amt;
	}
	private List<String> regDetailsList = new ArrayList<String>();
	public List<String> getRegDetailsList() {
		return regDetailsList;
	}
	public void setRegDetailsList(List<String> regDetailsList) {
		this.regDetailsList = regDetailsList;
	}
}
