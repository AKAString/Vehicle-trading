package com.qr.vehicle.dao;

import java.util.List;

import com.qr.xxpt.entity.Price;
import com.qr.xxpt.entity.Ranking;
import com.qr.xxpt.entity.Vehicle;

public interface VehicleDao {

	public List<Vehicle> getVehicle();
	public List<Ranking> getRabking();
	public List<Price> getPrice();
}
