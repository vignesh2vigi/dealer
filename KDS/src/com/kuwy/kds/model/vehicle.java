package com.kuwy.kds.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@XmlRootElement
@JsonInclude(Include.NON_DEFAULT)
public class vehicle {

	private int sno;
	private String regno;
	private String category;
	private String variant;
	public String getVariant() {
		return variant;
	}
	public void setVariant(String variant) {
		this.variant = variant;
	}
	private List<vehicle> vehicleDetails = new ArrayList<vehicle>();
	public List<vehicle> getVehicleDetails() {
		return vehicleDetails;
	}
	public void setVehicleDetails(List<vehicle> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
	private String make;
	private String model;
	private String fuel;
	private String transmission;
	private String chassis_no;
	private String engine_no;
	private String rto_no;
	private String rc_details;
	private String ownership;
	private String kms;
	private String manufacture_year;
	private String colour;
	private String insurance;
	private String insurance_validity;
	private String dealer_id;
	private String upload_datetime;
	private String listing_strategy;
	private String market_price;
	private String dealer_price;
	private String market_price_discount;
	private String nesosintion;
	private String status_flag;
	private String active_status;
	private String status;
	private String image;
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	private int vehicle_id;
	public int getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getRegno() {
		return regno;
	}
	public void setRegno(String regno) {
		this.regno = regno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getFuel() {
		return fuel;
	}
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public String getChassis_no() {
		return chassis_no;
	}
	public void setChassis_no(String chassis_no) {
		this.chassis_no = chassis_no;
	}
	public String getEngine_no() {
		return engine_no;
	}
	public void setEngine_no(String engine_no) {
		this.engine_no = engine_no;
	}
	public String getRto_no() {
		return rto_no;
	}
	public void setRto_no(String rto_no) {
		this.rto_no = rto_no;
	}
	public String getRc_details() {
		return rc_details;
	}
	public void setRc_details(String rc_details) {
		this.rc_details = rc_details;
	}
	public String getOwnership() {
		return ownership;
	}
	public void setOwnership(String ownership) {
		this.ownership = ownership;
	}
	public String getKms() {
		return kms;
	}
	public void setKms(String kms) {
		this.kms = kms;
	}
	public String getManufacture_year() {
		return manufacture_year;
	}
	public void setManufacture_year(String manufacture_year) {
		this.manufacture_year = manufacture_year;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getInsurance_validity() {
		return insurance_validity;
	}
	public void setInsurance_validity(String insurance_validity) {
		this.insurance_validity = insurance_validity;
	}
	public String getDealer_id() {
		return dealer_id;
	}
	public void setDealer_id(String dealer_id) {
		this.dealer_id = dealer_id;
	}
	public String getUpload_datetime() {
		return upload_datetime;
	}
	public void setUpload_datetime(String upload_datetime) {
		this.upload_datetime = upload_datetime;
	}
	public String getListing_strategy() {
		return listing_strategy;
	}
	public void setListing_strategy(String listing_strategy) {
		this.listing_strategy = listing_strategy;
	}
	public String getMarket_price() {
		return market_price;
	}
	public void setMarket_price(String market_price) {
		this.market_price = market_price;
	}
	public String getDealer_price() {
		return dealer_price;
	}
	public void setDealer_price(String dealer_price) {
		this.dealer_price = dealer_price;
	}
	public String getMarket_price_discount() {
		return market_price_discount;
	}
	public void setMarket_price_discount(String market_price_discount) {
		this.market_price_discount = market_price_discount;
	}
	public String getNesosintion() {
		return nesosintion;
	}
	public void setNesosintion(String nesosintion) {
		this.nesosintion = nesosintion;
	}
	public String getStatus_flag() {
		return status_flag;
	}
	public void setStatus_flag(String status_flag) {
		this.status_flag = status_flag;
	}
	public String getActive_status() {
		return active_status;
	}
	public void setActive_status(String active_status) {
		this.active_status = active_status;
	}
	
}
