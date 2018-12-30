package com.vijay.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.model.CityDO;


public interface CityRepo extends JpaRepository<CityDO, Integer>{

	
	//public CityRepo findById1(Integer id);
	
}
