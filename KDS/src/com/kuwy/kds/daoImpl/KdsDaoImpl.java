package com.kuwy.kds.daoImpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kuwy.kds.dao.KdsDao;
import com.kuwy.kds.model.KdsModel;

public class KdsDaoImpl implements KdsDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	@Override
	public KdsModel accessSignupSheet(KdsModel kdsModel) {


		KdsModel dealerRegLoginOutObj = new KdsModel();
		try {
			Timestamp ts = new Timestamp(System.currentTimeMillis());

			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO kuwy_dealer_login_reg (dealer_name,dealer_mobile,dealer_email,dealer_pwd,dealer_shopname,dealer_type,dealer_pan,dealer_aadhaar,dealer_area,dealer_city,dealer_state,dealer_pincode,dealer_sign,dealer_geo_address,dealer_shopimages,source_type,DATETIME) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { kdsModel.getDealer_name(),
							kdsModel.getDealer_mobile(),
							kdsModel.getDealer_email(),
							kdsModel.getDealer_pwd(),
							kdsModel.getDealer_shopname(),
							kdsModel.getDealer_type(),
							kdsModel.getDealer_pan(),
							kdsModel.getDealer_aadhaar(),
							kdsModel.getDealer_area(),
							kdsModel.getDealer_city(),
							kdsModel.getDealer_state(),
							kdsModel.getDealer_pincode(),
							kdsModel.getDealer_sign(),
							kdsModel.getDealer_geo_address(),
							kdsModel.getDealer_shopimages(),
							kdsModel.getSource_type(), ts });
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				dealerRegLoginOutObj
						.setMessage("Dealer Register Successfully...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj
						.setMessage("Dealer Register UnSuccessful...!");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setStatus(false);
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}

		return dealerRegLoginOutObj;
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public KdsModel dealerlist () {
		
		List<KdsModel> custDetailsList = new ArrayList<KdsModel>();
		KdsModel custVehiDetailsOutObj = new KdsModel();
		
		String pendingQuery = "SELECT dealer_name,dealer_mobile,dealer_email,dealer_pwd,dealer_shopimages,dealer_shopname,dealer_type,dealer_pan,dealer_aadhaar,dealer_area,dealer_city,dealer_state,dealer_pincode,dealer_geo_address,dealer_sign FROM kuwy_dealer_login_reg";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,
					new BeanPropertyRowMapper(KdsModel.class));
			
			if (custDetailsList.size() != 0) {
				custVehiDetailsOutObj.setKdsDetails(custDetailsList);
				custVehiDetailsOutObj.setStatus(true);
			}else{
				custVehiDetailsOutObj.setMessage("No Lead Found");
				custVehiDetailsOutObj.setStatus(false);
			}
			
			
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			custVehiDetailsOutObj.setMessage(e.getMessage());
		}


		return custVehiDetailsOutObj;
	}

	@Override
	public KdsModel delete(String dealer_name) {
		// TODO Auto-generated method stub
	
		KdsModel del = new KdsModel();
		try {
			
			int insertDealerReg_int = 0;
			System.out.println("deal====="+dealer_name.toString());
			String Query="DELETE FROM kuwy_dealer_login_reg WHERE dealer_name=?";
			insertDealerReg_int=this.jdbcTemplate.update(Query,new Object[] { dealer_name});
			System.out.println("deal====="+Query);
			if (insertDealerReg_int > 0) {
				del.setStatus(true);
				del
						.setMessage("Dealer request deleted...!");
			} else {
				del.setStatus(false);
				del
						.setMessage("Dealer request didn't delete...!");
			}
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return del;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<KdsModel> Dealerlist() {
		// TODO Auto-generated method stub
		
         KdsModel custVehiDetailsOutObj = new KdsModel();
         List<KdsModel> custDetailsList = new ArrayList<KdsModel>();
		String pendingQuery = "SELECT dealer_name,dealer_mobile,dealer_email,dealer_pwd,dealer_shopimages,dealer_shopname,dealer_type,dealer_pan,dealer_aadhaar,dealer_area,dealer_city,dealer_state,dealer_pincode,dealer_geo_address,dealer_sign FROM kuwy_dealer_login_reg";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,
					new BeanPropertyRowMapper(KdsModel.class));
			
			if (custDetailsList.size() != 0) {
				custDetailsList.add(custVehiDetailsOutObj);
			}else{
				custVehiDetailsOutObj.setMessage("No Lead Found");
				custVehiDetailsOutObj.setStatus(false);
			}
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			custVehiDetailsOutObj.setMessage(e.getMessage());
		}
		return custDetailsList;
	}

	@Override
	public KdsModel loan(KdsModel loan) {
		KdsModel dealerRegLoginOutObj = new KdsModel();
		try {
	
			int insertDealerReg_int = 0;
			
			String insertDealerReg_query ="UPDATE kuwy_dealer_login_reg SET loanlimit = ? WHERE dealer_name=?";
System.out.println("Query==========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { loan.getLoanlimit(),loan.getDealer_name()});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				dealerRegLoginOutObj
						.setMessage("loan Successfully...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj
						.setMessage("loan UnSuccessful...!");
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setStatus(false);
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}

		return dealerRegLoginOutObj;
	}

	
	@Override
	public KdsModel log(KdsModel log) {
		// TODO Auto-generated method stub
		
       
			KdsModel bank = new KdsModel();
			List<KdsModel> bankModelObjArray = new ArrayList<KdsModel>(); 
			String query = "SELECT dealer_name,dealer_email,dealer_pwd FROM kuwy_dealer_login_reg WHERE dealer_name='"+log.getDealer_name()+"' AND dealer_pwd='"+log.getDealer_pwd()+"' "; 
			System.out.println("query"+query);
			
			bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(KdsModel.class)); 
			if (bankModelObjArray.size() > 0) {
				bank.setStatus(true);
				bank.setDealer_name(bankModelObjArray.get(0).getDealer_name());
				bank.setDealer_pwd(bankModelObjArray.get(0).getDealer_pwd());
				
				} else { 
					/*System.out.println("pass");*/
					bank.setStatus(false);
					}
			return bank; 			
			
	}

	@Override
	public KdsModel ape(String dealer_name) {
		// TODO Auto-generated method stub
	
		System.out.println("dealername====="+dealer_name);
		KdsModel bank = new KdsModel();
		List<KdsModel> bankModelObjArray = new ArrayList<KdsModel>(); 
		String query = "SELECT dealer_name,dealer_email FROM kuwy_dealer_login_reg WHERE dealer_name='"+dealer_name+"'"; 
		System.out.println("query"+query);
	
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(KdsModel.class)); 
		if (bankModelObjArray.size() > 0) {
			bank.setStatus(true);
			bank.setDealer_name(bankModelObjArray.get(0).getDealer_name());
		bank.setDealer_email(bankModelObjArray.get(0).getDealer_email());		
			} else { 
				/*System.out.println("pass");*/
				bank.setStatus(false);
				}
		return bank;
	}

	@Override
	public KdsModel reject(KdsModel reject) {
		KdsModel dealerRegLoginOutObj = new KdsModel();
		try {
	
			int insertDealerReg_int = 0;
			
			String insertDealerReg_query ="UPDATE kuwy_dealer_login_reg SET remark = ? WHERE dealer_name=?";
System.out.println("Query==========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { reject.getRemark(),reject.getDealer_name()});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				dealerRegLoginOutObj
						.setMessage("reject Successfully...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj
						.setMessage("reject UnSuccessful...!");
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setStatus(false);
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}

		return dealerRegLoginOutObj;
	}
		
		 
	
}