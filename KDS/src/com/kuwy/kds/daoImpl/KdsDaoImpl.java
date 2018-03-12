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
				dealerRegLoginOutObj.setMessage("Dealer Register Successfully...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj.setMessage("Dealer Register UnSuccessful...!");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setStatus(false);
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}

		return dealerRegLoginOutObj;
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
		String pendingQuery = "SELECT sno,dealer_name,dealer_mobile,dealer_email,dealer_shopimages,dealer_shopname,dealer_type,dealer_pan,dealer_area,dealer_city,dealer_state,dealer_pincode,dealer_geo_address,dealer_sign,loanlimit,remark,activation_status,DATE(datetime) as regdate FROM kuwy_dealer_login_reg ORDER BY datetime DESC";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,
					new BeanPropertyRowMapper(KdsModel.class));
			
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			custVehiDetailsOutObj.setMessage(e.getMessage());
		}
		return custDetailsList;
	}

	@Override
	public KdsModel loan(KdsModel loan) {
		
		KdsModel dealerRegLoginOutObj = new KdsModel();
		
		
		String appendProductval = "";
		if(loan.getProduct_interest1()!=null)
		{
			appendProductval +=loan.getProduct_interest1() +",";
		}
		if(loan.getProduct_interest2()!=null)
		{
			appendProductval +=loan.getProduct_interest2() +",";
		}
		if(loan.getProduct_interest3()!=null)
		{
			appendProductval +=loan.getProduct_interest3() +",";
		}
		if(loan.getProduct_interest4()!=null)
		{
			appendProductval +=loan.getProduct_interest4() +",";
		}
		if(loan.getProduct_interest5()!=null)
		{
			appendProductval +=loan.getProduct_interest5() +",";
		}
		
		if(loan.getProduct_interest6()!=null)
		{
			appendProductval +=loan.getProduct_interest6() +",";
		}
		if(loan.getProduct_interest7()!=null)
		{
			appendProductval +=loan.getProduct_interest7() +",";
		}
		if(loan.getProduct_interest8()!=null)
		{
			appendProductval +=loan.getProduct_interest8() +",";
		}
		if(loan.getProduct_interest9()!=null)
		{
			appendProductval +=loan.getProduct_interest9() +",";
		}
		if(loan.getProduct_interest10()!=null)
		{
			appendProductval +=loan.getProduct_interest10() +",";
		}
		
		appendProductval =appendProductval.substring(0, appendProductval.length() - 1);
		
		
		try {
	
			int insertDealerReg_int = 0;
			
			String insertDealerReg_query ="UPDATE kuwy_dealer_login_reg SET loanlimit = ?, activation_status='1',remark='approved', product_interest='"+appendProductval+"' WHERE dealer_email=?";
System.out.println("Query==========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { loan.getLoanlimit(),loan.getDealer_email()});
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
		
System.out.println("adminId===="+loan.getAdmin_id());
System.out.println("loan limit===="+loan.getLoanlimit());

		try {
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			int insertDealerReg_int = 0;
			String insertDealerReg_query = "INSERT INTO kuwy_user_active_history (admin_id,dealer_id,action_datetime,loan_limit,approve_status,remark) VALUES (?,?,?,?,?,'approved')";
System.out.println("Query==="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { loan.getAdmin_id(),loan.getSno(),ts,loan.getLoanlimit(),1});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				dealerRegLoginOutObj
						.setMessage("Dealer Approve Successfully...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj
						.setMessage("Dealer Reject UnSuccessful...!");
			}
		} catch (DataAccessException e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setStatus(false);
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}
	
		return dealerRegLoginOutObj;
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public KdsModel log(KdsModel log) {
		// TODO Auto-generated method stub
		
       
			KdsModel bank = new KdsModel();
			List<KdsModel> bankModelObjArray = new ArrayList<KdsModel>(); 
			
			String query = "SELECT admin_id_pk,admin_id,admin_username,admin_password FROM kuwy_dealer_admin_log WHERE admin_id='"+log.getAdmin_id()+"' AND admin_password='"+log.getAdmin_password()+"' "; 
			System.out.println("query"+query);
			
			bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(KdsModel.class)); 
			if (bankModelObjArray.size() > 0) {
				bank.setStatus(true);
				bank.setAdmin_id_pk(bankModelObjArray.get(0).getAdmin_id_pk());
				bank.setAdmin_id(bankModelObjArray.get(0).getAdmin_id());
				bank.setAdmin_username(bankModelObjArray.get(0).getAdmin_username());
				bank.setAdmin_password(bankModelObjArray.get(0).getAdmin_password());
				
				} else { 
					/*System.out.println("pass");*/
					bank.setStatus(false);
					}
			return bank; 			
			
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public KdsModel ape(String dealer_mobile) {
		// TODO Auto-generated method stub
	
		System.out.println("dealername====="+dealer_mobile);
		KdsModel bank = new KdsModel();
		List<KdsModel> bankModelObjArray = new ArrayList<KdsModel>(); 
		String query = "SELECT sno,dealer_name,dealer_email,dealer_mobile,dealer_pwd,dealer_shopname,dealer_type,dealer_area,dealer_city,dealer_state,dealer_pincode FROM kuwy_dealer_login_reg WHERE dealer_mobile='"+dealer_mobile+"'"; 
		System.out.println("query"+query);
	
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(KdsModel.class)); 
		if (bankModelObjArray.size() > 0) {
			bank.setStatus(true);
			bank.setSno(bankModelObjArray.get(0).getSno());
			bank.setDealer_name(bankModelObjArray.get(0).getDealer_name());
		bank.setDealer_email(bankModelObjArray.get(0).getDealer_email());
		bank.setDealer_mobile(bankModelObjArray.get(0).getDealer_mobile());
		bank.setDealer_pwd(bankModelObjArray.get(0).getDealer_pincode());
		bank.setDealer_shopname(bankModelObjArray.get(0).getDealer_shopname());
		bank.setDealer_type(bankModelObjArray.get(0).getDealer_type());
		bank.setDealer_area(bankModelObjArray.get(0).getDealer_area());
		bank.setDealer_state(bankModelObjArray.get(0).getDealer_state());
		bank.setDealer_city(bankModelObjArray.get(0).getDealer_city());
		bank.setDealer_pincode(bankModelObjArray.get(0).getDealer_pincode());
		bank.setSno(bankModelObjArray.get(0).getSno());
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
			
			String insertDealerReg_query ="UPDATE kuwy_dealer_login_reg SET remark = ?,activation_status='0',loanlimit='0' WHERE dealer_email=?";
System.out.println("reject Update query=========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { reject.getRemark(),reject.getDealer_email()});
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
		System.out.println("Admin Id==================================="+reject.getAdmin_id());
		
			try {
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				int insertDealerReg_int = 0;
				String insertDealerReg_query = "INSERT INTO kuwy_user_active_history (admin_id,dealer_id,remark,action_datetime,loan_limit,approve_status) VALUES (?,?,?,?,?,?)";
				System.out.println("second===="+insertDealerReg_query);
	System.out.println("Query==="+insertDealerReg_query);
				insertDealerReg_int = this.jdbcTemplate.update(
						insertDealerReg_query,
						new Object[] { reject.getAdmin_id(),reject.getSno(),reject.getRemark(),ts,0,0});
				if (insertDealerReg_int > 0) {
					dealerRegLoginOutObj.setStatus(true);
					dealerRegLoginOutObj
							.setMessage("Dealer Reject Successfully...!");
				} else {
					dealerRegLoginOutObj.setStatus(false);
					dealerRegLoginOutObj
							.setMessage("Dealer Reject UnSuccessful...!");
				}
			} catch (DataAccessException e) {
				System.out.println(e.getLocalizedMessage());
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj.setMessage(e.getMessage());
			}
			
		
	
	

		return dealerRegLoginOutObj;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<KdsModel> ave() {

        KdsModel custVehiDetailsOutObj = new KdsModel();
        List<KdsModel> custDetailsList = new ArrayList<KdsModel>();
		String pendingQuery = "SELECT dealer_name,dealer_mobile,dealer_email,dealer_pwd,dealer_shopimages,dealer_shopname,dealer_type,dealer_pan,dealer_aadhaar,dealer_area,dealer_city,dealer_state,dealer_pincode,dealer_geo_address,dealer_sign,loanlimit,remark FROM kuwy_dealer_login_reg WHERE activation_status='1'";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,new BeanPropertyRowMapper(KdsModel.class));
			
			
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			custVehiDetailsOutObj.setMessage(e.getMessage());
		}
		return custDetailsList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<KdsModel> rjt() {

        KdsModel custVehiDetailsOutObj = new KdsModel();
        List<KdsModel> custDetailsList = new ArrayList<KdsModel>();
		String pendingQuery = "SELECT dealer_name,dealer_mobile,dealer_email,dealer_pwd,dealer_shopimages,dealer_shopname,dealer_type,dealer_pan,dealer_aadhaar,dealer_area,dealer_city,dealer_state,dealer_pincode,dealer_geo_address,dealer_sign,remark FROM kuwy_dealer_login_reg WHERE activation_status='0' AND remark IS NOT NULL";
		System.out.println("pendingQuery------------------------------------->"+pendingQuery);
		try {
			
			custDetailsList = this.jdbcTemplate.query(pendingQuery,new BeanPropertyRowMapper(KdsModel.class));
			
		} catch (Exception e) {
			custVehiDetailsOutObj.setStatus(false);
			custVehiDetailsOutObj.setMessage(e.getMessage());
		}
		return custDetailsList;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean valid(String admin_id) {
		// TODO Auto-generated method stub
		System.out.println("adminId====="+admin_id);
		KdsModel bank = new KdsModel();
		List<KdsModel> bankModelObjArray = new ArrayList<KdsModel>(); 
		String query = "SELECT admin_id FROM kuwy_dealer_admin_log WHERE admin_id='"+admin_id+"'"; 
		System.out.println("admin id check====="+query);
	
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(KdsModel.class)); 
		if (bankModelObjArray.size() > 0) {
			bank.setStatus(true);
		bank.setAdmin_id(bankModelObjArray.get(0).getAdmin_id());
		return true;
		
			} else { 
				/*System.out.println("pass");*/
				bank.setStatus(false);
				return false;
				}		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean validpass(String admin_password) {
		// TODO Auto-generated method stub
		System.out.println("password====="+admin_password);
		KdsModel bank = new KdsModel();
		List<KdsModel> bankModelObjArray = new ArrayList<KdsModel>(); 
		String query = "SELECT admin_password FROM kuwy_dealer_admin_log WHERE admin_password='"+admin_password+"'"; 
		System.out.println("admin_password check====="+query);
	
		bankModelObjArray = getJdbcTemplate().query(query, new BeanPropertyRowMapper(KdsModel.class)); 
		if (bankModelObjArray.size() > 0) {
			bank.setStatus(true);
		bank.setAdmin_password(bankModelObjArray.get(0).getAdmin_password());
		return true;
		
			} else { 
				/*System.out.println("pass");*/
				bank.setStatus(false);
				return false;
				}	
	}

	@Override
	public KdsModel edit(KdsModel edit) {
		// TODO Auto-generated method stub
		KdsModel dealerRegLoginOutObj = new KdsModel();
		try {
	
			int insertDealerReg_int = 0;
			
			String insertDealerReg_query ="UPDATE kuwy_dealer_login_reg SET dealer_name=?,dealer_pwd=?,dealer_email=?,dealer_mobile=?,dealer_shopname=?,dealer_type=?,dealer_area=?,dealer_city=?,dealer_state=?,dealer_pincode=? WHERE sno=?";
System.out.println("reject Update query=========="+insertDealerReg_query);
			insertDealerReg_int = this.jdbcTemplate.update(
					insertDealerReg_query,
					new Object[] { edit.getDealer_name(),edit.getDealer_pwd(),edit.getDealer_email(),edit.getDealer_mobile(),edit.getDealer_shopname(),edit.getDealer_type(),edit.getDealer_area(),edit.getDealer_city(),edit.getDealer_state(),edit.getDealer_pincode(),edit.getSno()});
			if (insertDealerReg_int > 0) {
				dealerRegLoginOutObj.setStatus(true);
				dealerRegLoginOutObj
						.setMessage("update...!");
			} else {
				dealerRegLoginOutObj.setStatus(false);
				dealerRegLoginOutObj
						.setMessage("not...!");
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			dealerRegLoginOutObj.setStatus(false);
			dealerRegLoginOutObj.setMessage(e.getMessage());
		}
		return dealerRegLoginOutObj;
	}

	
		
		 
	
}