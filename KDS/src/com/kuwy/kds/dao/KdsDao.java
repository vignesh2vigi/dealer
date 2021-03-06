package com.kuwy.kds.dao;

import java.util.List;

import com.kuwy.kds.model.KdsModel;

public interface KdsDao {
	
	public KdsModel accessSignupSheet(KdsModel bankModel);
	public KdsModel loan(KdsModel loan);
	public KdsModel reject(KdsModel reject);
	public KdsModel delete(String dealer_name);
	public List<KdsModel> Dealerlist();
	public List<KdsModel> ave();
	public List<KdsModel> rjt();
	public KdsModel log(KdsModel log);
	public KdsModel ape(String dealer_mobile);
	public boolean valid(String admin_id);
	public boolean validpass(String admin_password);
	public KdsModel edit(KdsModel edit);
	
}
