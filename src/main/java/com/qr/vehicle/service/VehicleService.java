package com.qr.vehicle.service;

import java.util.List;

import com.qr.xxpt.entity.Price;
import com.qr.xxpt.entity.Ranking;
import com.qr.xxpt.entity.Vehicle;

public interface VehicleService {

	public List<Vehicle> getVehicle();
	public List<Ranking> getRabking();
	public List<Price> getPrice();
}
