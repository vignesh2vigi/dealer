package com.kuwy.kds.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@XmlRootElement
@JsonInclude(Include.NON_DEFAULT)
public class KdsModel{

	private boolean status;
	private List<KdsModel> kdsDetails = new ArrayList<KdsModel>();
	private String dealer_name;
	private String dealer_mobile;
	private String dealer_email;
	private String dealer_pwd;
	private String dealer_shopname;
	private String dealer_type;
	private String dealer_pan;
	private String dealer_aadhaar;
	private String dealer_area;
	private String dealer_city;
	private String dealer_state;
	private String dealer_pincode;
	private String dealer_sign;
	private String dealer_geo_address;
	private String dealer_otp;
	private String datetime;
	private String activation_status;
	private String dealer_shopimages;
	private String dealer_id;
	private String loanlimit;
	private String remark;
	private int admin_id_pk;
	private String admin_id;
	private String admin_username;
	private String admin_password;
	
private int sno;
	public int getSno() {
	return sno;
}

public void setSno(int sno) {
	this.sno = sno;
}

	public int getAdmin_id_pk() {
		return admin_id_pk;
	}

	public void setAdmin_id_pk(int admin_id_pk) {
		this.admin_id_pk = admin_id_pk;
	}

	public String getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getLoanlimit() {
		return loanlimit;
	}

	public void setLoanlimit(String loanlimit) {
		this.loanlimit = loanlimit;
	}

	private String source_type;
	private String message;
	
	
	public List<KdsModel> getKdsDetails() {
		return kdsDetails;
	}

	public void setKdsDetails(List<KdsModel> kdsDetails) {
		this.kdsDetails = kdsDetails;
	}

	public String getDealer_name() {
		return dealer_name;
	}

	public void setDealer_name(String dealer_name) {
		this.dealer_name = dealer_name;
	}

	public String getDealer_mobile() {
		return dealer_mobile;
	}

	public void setDealer_mobile(String dealer_mobile) {
		this.dealer_mobile = dealer_mobile;
	}

	public String getDealer_email() {
		return dealer_email;
	}

	public void setDealer_email(String dealer_email) {
		this.dealer_email = dealer_email;
	}

	public String getDealer_pwd() {
		return dealer_pwd;
	}

	public void setDealer_pwd(String dealer_pwd) {
		this.dealer_pwd = dealer_pwd;
	}

	public String getDealer_shopname() {
		return dealer_shopname;
	}

	public void setDealer_shopname(String dealer_shopname) {
		this.dealer_shopname = dealer_shopname;
	}

	public String getDealer_type() {
		return dealer_type;
	}

	public void setDealer_type(String dealer_type) {
		this.dealer_type = dealer_type;
	}

	public String getDealer_pan() {
		return dealer_pan;
	}

	public void setDealer_pan(String dealer_pan) {
		this.dealer_pan = dealer_pan;
	}

	public String getDealer_aadhaar() {
		return dealer_aadhaar;
	}

	public void setDealer_aadhaar(String dealer_aadhaar) {
		this.dealer_aadhaar = dealer_aadhaar;
	}

	public String getDealer_area() {
		return dealer_area;
	}

	public void setDealer_area(String dealer_area) {
		this.dealer_area = dealer_area;
	}

	public String getDealer_city() {
		return dealer_city;
	}

	public void setDealer_city(String dealer_city) {
		this.dealer_city = dealer_city;
	}

	public String getDealer_state() {
		return dealer_state;
	}

	public void setDealer_state(String dealer_state) {
		this.dealer_state = dealer_state;
	}

	public String getDealer_pincode() {
		return dealer_pincode;
	}

	public void setDealer_pincode(String dealer_pincode) {
		this.dealer_pincode = dealer_pincode;
	}

	public String getDealer_sign() {
		return dealer_sign;
	}

	public void setDealer_sign(String dealer_sign) {
		this.dealer_sign = dealer_sign;
	}

	public String getDealer_geo_address() {
		return dealer_geo_address;
	}

	public void setDealer_geo_address(String dealer_geo_address) {
		this.dealer_geo_address = dealer_geo_address;
	}

	public String getDealer_otp() {
		return dealer_otp;
	}

	public void setDealer_otp(String dealer_otp) {
		this.dealer_otp = dealer_otp;
	}

	public String getDatetime() {
		return datetime;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getActivation_status() {
		return activation_status;
	}

	public void setActivation_status(String activation_status) {
		this.activation_status = activation_status;
	}

	public String getDealer_shopimages() {
		return dealer_shopimages;
	}

	public void setDealer_shopimages(String dealer_shopimages) {
		this.dealer_shopimages = dealer_shopimages;
	}

	public String getDealer_id() {
		return dealer_id;
	}

	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}

	public String getSource_type() {
		return source_type;
	}

	public void setSource_type(String source_type) {
		this.source_type = source_type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<KdsModel> getBankDetails() {
		return kdsDetails;
	}

	public void setBankDetails(List<KdsModel> kdsDetails) {
		this.kdsDetails = kdsDetails;
	}

	
}