/**
 * 
 */
package com.vijay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vijay.model.CityDO;
import com.vijay.repo.CityRepo;

/**
 * @author VIJAY
 *
 */
@Service
public class CityServiceByJPA implements CityService{

	@Autowired
	private CityRepo repo;
	
	public List<CityDO> getAllCities() {
		return repo.findAll();
	}
	
	public void update(CityDO city) {
		System.out.println("Update complete for "+repo.save(city));
	}
	
	public void insert(CityDO city) {
		System.out.println("Insert complete for "+repo.save(city));
	}
	
	
}
