package com.kuwy.kds.daoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kuwy.kds.dao.VehicleDao;
import com.kuwy.kds.model.dealership;
import com.kuwy.kds.model.vehicle;

public class VehicleDaoImpl implements VehicleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public vehicle insert(vehicle insert) {
		// TODO Auto-generated method stub
		boolean upflg=false;
		vehicle dealerRegLoginOutObj = new vehicle();
		
		try {
			/*Timestamp ts = new Timestamp(System.currentTimeMillis());*/
System.out.println(""+insert.getRegno());
			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO kuwy_dealer_stock_upload (regno,category,make,model,variant,fuel,transmission) VALUES (?,?,?,?,?,?,?)";
System.out.println("query=========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { insert.getRegno(),insert.getCategory(),insert.getMake(),insert.getModel(),insert.getVariant(),insert.getFuel(),insert.getTransmission()});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setMessage("success");
			} else {
				dealerRegLoginOutObj.setMessage("fail");
			}
			
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}
		List<vehicle> bankModelObjArray = new ArrayList<vehicle>(); 
		String query = "SELECT MAX(sno) AS sno FROM kuwy_dealer_stock_upload"; 
		System.out.println("query"+query);
	
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(vehicle.class)); 
		
			dealerRegLoginOutObj.setSno(bankModelObjArray.get(0).getSno());
						
	
		System.out.println("sno==========="+dealerRegLoginOutObj.getSno());
		try {
			Timestamp ts = new Timestamp(System.currentTimeMillis());

			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO kuwy_vehicle_detail (chassis_no,vehicle_id,engine_no,rto_no,rc_details,ownership,kms,manufacture_year,colour,insurance,insurance_validity,dealer_id,upload_datetime,listing_strategy,market_price,dealer_price,market_price_discount,nesosintion,status_flag,active_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
System.out.println("query=========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { insert.getChassis_no(),dealerRegLoginOutObj.getSno(),insert.getEngine_no(),insert.getRto_no(),insert.getRc_details(),insert.getOwnership(),insert.getKms(),insert.getManufacture_year(),insert.getColour(),insert.getInsurance(),insert.getInsurance_validity(),insert.getDealer_id(),ts,insert.getListing_strategy(),insert.getMarket_price(),insert.getDealer_price(),insert.getMarket_price_discount(),insert.getNesosintion(),insert.getStatus_flag(),insert.getActive_status()});
			
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setMessage("success");
				upflg=true;
			} else {
				dealerRegLoginOutObj.setMessage("failure");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			
		}
		
		List<vehicle> bankModelObjArray1 = new ArrayList<vehicle>(); 
		String query1 = "SELECT MAX(sno) AS vehicle_id FROM kuwy_vehicle_detail"; 
		System.out.println("query2"+query1);
	
		bankModelObjArray1 = getJdbcTemplate().query(query1, new BeanPropertyRowMapper(vehicle.class)); 
		dealerRegLoginOutObj.setVehicle_id(bankModelObjArray1.get(0).getVehicle_id());
		System.out.println("sno2======="+dealerRegLoginOutObj.getVehicle_id());

		try {
				int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO kuwy_vehicle_image (veh_det_id,image) VALUES (?,?)";
	System.out.println("query=========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] {dealerRegLoginOutObj.getVehicle_id(),insert.getImage()});
			
			if (insertDealerReg_int > 0) {	
				dealerRegLoginOutObj.setMessage("success");
				upflg=true;
			} else {
				dealerRegLoginOutObj.setMessage("failure");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());	
		}
		
		if(upflg){
			System.out.println("flg====="+upflg);
		}
		
		return dealerRegLoginOutObj;
	}

	@Override
	public dealership accessSignupSheet(dealership bankModel) {
		// TODO Auto-generated method stub
		dealership dealerRegLoginOutObj = new dealership();
		try {
			Timestamp ts = new Timestamp(System.currentTimeMillis());
       System.out.println("dealer_ship_name===>"+bankModel.getDealership_name());
       System.out.println("active==============>"+bankModel.getActive_status());
			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO kuwy_dealer_login_reg (dealer_id,dealer_name,dealer_mobile,dealer_email,dealer_pwd,datetime,dealer_shopname,dealer_type,dealer_pan,dealer_area,dealer_state,dealer_pincode,dealer_geo_address,dealer_city,dealer_shopimages,source_type,activation_status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,'1')";

			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { 
							bankModel.getUserid(),bankModel.getName(),bankModel.getMobile_no(),bankModel.getEmail_id(),bankModel.getUserid(),ts,bankModel.getDealership_name(),bankModel.getDealership_type(),bankModel.getPan_no(),bankModel.getPost(),bankModel.getState(),bankModel.getPincode(),bankModel.getGeo_address(),bankModel.getDistrict(),bankModel.getImage(),bankModel.getLogin_type()
							 });
			System.out.println("query===>"+insertDealerReg_query);
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus("Dealer Register Successfully...!");
			} else {
				dealerRegLoginOutObj.setStatus("Dealer Register UnSuccessful...!");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			
		}

		return dealerRegLoginOutObj;
	}
	

}
