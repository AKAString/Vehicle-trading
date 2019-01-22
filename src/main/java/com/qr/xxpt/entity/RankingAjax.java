package com.qr.xxpt.entity;

import java.util.ArrayList;
import java.util.List;

public class RankingAjax {

	List<String>yAxis=new ArrayList<String>();
	List<Integer>series=new ArrayList<Integer>();
	List<Ranking>rankings=new ArrayList<Ranking>();
	public List<String> getyAxis() {
		return yAxis;
	}
	public void setyAxis(List<String> yAxis) {
		this.yAxis = yAxis;
	}
	public List<Integer> getSeries() {
		return series;
	}
	public void setSeries(List<Integer> series) {
		this.series = series;
	}
	public List<Ranking> getRankings() {
		return rankings;
	}
	public void setRankings(List<Ranking> rankings) {
		this.rankings = rankings;
	}
	
}
