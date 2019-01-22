package com.qr.vehicle.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qr.vehicle.service.VehicleService;
import com.qr.xxpt.base.BaseController;
import com.qr.xxpt.entity.Price;
import com.qr.xxpt.entity.Ranking;
import com.qr.xxpt.entity.RankingAjax;
import com.qr.xxpt.entity.Vehicle;
import com.qr.xxpt.entity.VehicleAjax;

@RequestMapping(value = "vehicle")
@Controller
public class VehicleController extends BaseController {
	@Resource
	private VehicleService vehicleService;

	public VehicleService getVehicleService() {
		return vehicleService;
	}

	public void setVehicleService(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	@RequestMapping(value = "getVehicle")
	public void getVehicle() {

		List<Vehicle> vehicles = vehicleService.getVehicle();
		VehicleAjax vehicleAjax = new VehicleAjax();
		List<String> xAxisIndex2017 = new ArrayList<String>();
		List<String> xAxisIndex2018 = new ArrayList<String>();
		List<Integer> axisPointer2017 = new ArrayList<Integer>();
		List<Integer> axisPointer2018 = new ArrayList<Integer>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		for (Vehicle vehicle : vehicles) {
			Long date = Long.parseLong(vehicle.getSale_date());
			String saledate = sdf.format(date);
			String str1[] = saledate.split("-");

			if (str1[0].equals("2018")) {
				xAxisIndex2018.add(str1[0] + "-" + str1[1]);
				axisPointer2018.add(vehicle.getDealcount());
			
			}
			if (str1[0].equals("2017")) {
				xAxisIndex2017.add(str1[0] + "-" + str1[1]);
				axisPointer2017.add(vehicle.getDealcount());
			
			}
		}
		vehicleAjax.setAxisPointer2017(axisPointer2017);
		vehicleAjax.setAxisPointer2018(axisPointer2018);
		vehicleAjax.setxAxisIndex2017(xAxisIndex2017);
		vehicleAjax.setxAxisIndex2018(xAxisIndex2018);
		Gson gson = new GsonBuilder().create();
		String vehiclesJson = gson.toJson(vehicleAjax);
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(vehiclesJson);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@RequestMapping(value = "getRabking")
	public void getRabking() {
		RankingAjax rankingAjax = new RankingAjax();
		List<Ranking> rankings = vehicleService.getRabking();
		rankingAjax.setRankings(rankings);
		List<String> s1 = new ArrayList<String>();
		List<Integer> i1 = new ArrayList<Integer>();
		for (Ranking ranking : rankings) {
			s1.add(ranking.getProvince());
			i1.add(ranking.getDealcount());
		}
		rankingAjax.setSeries(i1);
		rankingAjax.setyAxis(s1);
		Gson gson = new GsonBuilder().create();
		String rankingsJson = gson.toJson(rankingAjax);
		try {
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().write(rankingsJson);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@RequestMapping(value = "getPrice")
	public void getPrice() {
		List<Price> prices = vehicleService.getPrice();
		for (Price price : prices) {
			if (!price.getPriceNumber().equals("无数据")) {
				Float pricef = Float.parseFloat(price.getPriceNumber());
				if (pricef < 10000) {
 
				}
				if (pricef < 100000 && pricef > 10000) {

				}
				if (pricef < 500000 && pricef > 100000) {

				}
				if (pricef < 1000000 && pricef > 500000) {

				}
				if (pricef > 1000000) {

				}

			}

		}

	}
}
