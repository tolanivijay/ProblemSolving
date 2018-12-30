package com.vijay.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.model.CityDO;
import com.vijay.service.CityService;

@RestController
public class MyController {

	@Autowired
	private CityService cityService;

	@GetMapping(path = "/citiesAll")
	public List<CityDO> getAllCities() {
		return cityService.getAllCities();
	}

	@GetMapping(path = "insert5")
	@Transactional
	public void insertCities() {
		for (int i=1;i<=5;i++) {
			CityDO cityDO = new CityDO();
			cityDO.setName("Test").setCountryCode("AFG").setDistrict("Test").setPopulation(i);
			cityService.insert(cityDO);
		}
	}

}
