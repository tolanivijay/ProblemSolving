package com.vijay.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="City")
public class CityDO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Countrycode")
	private String CountryCode;
	
	@Column(name = "District")
	private String District;
	
	@Column(name = "Population")
	private int Population;

	public String getName() {
		return Name;
	}

	public CityDO setName(String name) {
		Name = name;return this;
	}

	public String getCountryCode() {
		return CountryCode;
	}

	public CityDO setCountryCode(String countryCode) {
		CountryCode = countryCode;return this;
	}

	public String getDistrict() {
		return District;
	}

	public CityDO setDistrict(String district) {
		District = district;return this;
	}

	public int getPopulation() {
		return Population;
	}

	public CityDO setPopulation(int population) {
		Population = population;return this;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CityDO [id=" + id + ", Name=" + Name + "]";
	}

	
}
