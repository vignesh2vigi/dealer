package com.kuwy.kds.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.kuwy.kds.dao.VehicleDao;
import com.kuwy.kds.model.dealership;
import com.kuwy.kds.model.vehicle;
import com.kuwy.kds.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {
	@Autowired
	VehicleDao vehicleDao;
	@Override
	public vehicle insert(vehicle insert) {
		// TODO Auto-generated method stub
		return vehicleDao.insert(insert);
	}
	@Override
	public dealership accessSignupSheet(dealership bankModel) {
		// TODO Auto-generated method stub
		return vehicleDao.accessSignupSheet(bankModel);
	}

}
