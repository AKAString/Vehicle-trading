package com.qr.vehicle.service_imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qr.vehicle.dao.VehicleDao;
import com.qr.vehicle.service.VehicleService;
import com.qr.xxpt.entity.Price;
import com.qr.xxpt.entity.Ranking;
import com.qr.xxpt.entity.Vehicle;
@Service
public class VehicleServiceIMP implements VehicleService {
 @Resource
	private VehicleDao vehicleDao;
	
	public VehicleDao getVehicleDao() {
		return vehicleDao;
	}

	public void setVehicleDao(VehicleDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	public List<Vehicle> getVehicle() {
		
		return vehicleDao.getVehicle();
	}

	public List<Ranking> getRabking() {
		// TODO Auto-generated method stub
		return vehicleDao.getRabking();
	}

	public List<Price> getPrice() {
		// TODO Auto-generated method stub
		return vehicleDao.getPrice();
	}

}
