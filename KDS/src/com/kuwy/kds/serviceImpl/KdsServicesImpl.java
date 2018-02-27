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
	public KdsModel dealerlist() {
		// TODO Auto-generated method stub
		return kdsDao.dealerlist();
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
	public KdsModel ape(String dealer_name) {
		// TODO Auto-generated method stub
		return kdsDao.ape(dealer_name);
	}

	@Override
	public KdsModel reject(KdsModel reject) {
		// TODO Auto-generated method stub
		return kdsDao.reject(reject);
	}
	
	
	
}