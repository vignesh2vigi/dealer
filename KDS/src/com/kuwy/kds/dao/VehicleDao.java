package com.kuwy.kds.dao;


import com.kuwy.kds.model.dealership;
import com.kuwy.kds.model.vehicle;

public interface VehicleDao {
	public vehicle insert(vehicle insert);
	public dealership accessSignupSheet(dealership bankModel);
}
