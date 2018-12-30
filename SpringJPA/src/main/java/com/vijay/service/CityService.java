package com.vijay.service;

import java.util.List;

import com.vijay.model.CityDO;

public interface CityService {

	public List<CityDO> getAllCities();
	
	public void update(CityDO city);
	
	public void insert(CityDO city);
}
