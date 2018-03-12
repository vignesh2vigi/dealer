package com.kuwy.kds.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.kuwy.kds.dao.KdsDao;
import com.kuwy.kds.model.KdsModel;
import com.kuwy.kds.service.KdsServices;

public class KdsServicesImpl implements KdsServices {
	
	@Autowired
	KdsDao kdsDao;

	@Override
	public KdsModel accessSignupSheet(KdsModel bankModel) {
		return kdsDao.accessSignupSheet(bankModel);
	}


	@Override
	public KdsModel delete(String dealer_name) {
		// TODO Auto-generated method stub
		return kdsDao.delete(dealer_name);
	}

	@Override
	public List<KdsModel> Dealerlist() {
		// TODO Auto-generated method stub
		return kdsDao.Dealerlist();
	}

	@Override
	public KdsModel loan(KdsModel loan) {
		// TODO Auto-generated method stub
		return kdsDao.loan(loan);
	}

	@Override
	public KdsModel log(KdsModel log) {
		// TODO Auto-generated method stub
		return kdsDao.log(log);
	}

	@Override
	public KdsModel ape(String dealer_mobile) {
		// TODO Auto-generated method stub
		return kdsDao.ape(dealer_mobile);
	}

	@Override
	public KdsModel reject(KdsModel reject) {
		// TODO Auto-generated method stub
		return kdsDao.reject(reject);
	}

	@Override
	public List<KdsModel> ave() {
		// TODO Auto-generated method stub
		return kdsDao.ave();
	}

	@Override
	public List<KdsModel> rjt() {
		// TODO Auto-generated method stub
		return kdsDao.rjt();
	}


	@Override
	public boolean valid(String admin_id) {
		// TODO Auto-generated method stub
		return kdsDao.valid(admin_id);
	}


	@Override
	public boolean validpass(String admin_password) {
		// TODO Auto-generated method stub
		return kdsDao.validpass(admin_password);
	}


	@Override
	public KdsModel edit(KdsModel edit) {
		// TODO Auto-generated method stub
		return kdsDao.edit(edit);
	}
	
	
}