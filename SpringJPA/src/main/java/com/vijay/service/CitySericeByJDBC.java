package com.vijay.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.vijay.model.CityDO;

public class CitySericeByJDBC implements CityService {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<CityDO> getAllCities() {
		String query = "select * from city";
		return jdbcTemplate.query(query, new CityMapper());
	}

	@Override
	public void update(CityDO city) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insert(CityDO city) {
		SimpleJdbcInsert insert = new SimpleJdbcInsert(jdbcTemplate).withTableName("City")
				.usingGeneratedKeyColumns("ID");
		Map<String, Object> parameters = new HashMap<String, Object>();

		parameters.put("Name", city.getName());
		parameters.put("CountryCode", city.getCountryCode());
		parameters.put("District", city.getDistrict());
		parameters.put("Population", city.getPopulation());

		System.out.println("Added " + insert.executeAndReturnKey(parameters));

	}

	class CityMapper implements RowMapper<CityDO> {

		public CityDO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CityDO city = new CityDO();
			city.setCountryCode(rs.getString("CountryCode"));
			city.setDistrict(rs.getString("District"));
			city.setName(rs.getString("Name"));
			city.setPopulation(rs.getInt("Population"));
			return city;
		}
	}

}
