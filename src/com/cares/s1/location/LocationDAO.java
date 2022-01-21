package com.cares.s1.location;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cares.s1.util.DBConnector;

public class LocationDAO {

	private DBConnector dbConnector;
	
	public LocationDAO() {
		dbConnector = new DBConnector();
	}
	
	public LocationDTO getOne(LocationDTO loc) throws Exception {
		// 1. DB 로그인
		Connection con = dbConnector.getConnect();
		// 2. SQL Query 작성
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		// 3. Query 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 값 처리
		st.setInt(1, loc.getLocation_id());
		// 5. 최종 전송 및 결과 처리
		ResultSet rs = st.executeQuery();
		
		LocationDTO locationDTO = null;
		if (rs.next()) {
			locationDTO = new LocationDTO();
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("postal_code"));
			locationDTO.setCity(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
		}
		return locationDTO;
		
	}
	
	public List<LocationDTO> getList() throws Exception {
		// 1. DB 로그인
		Connection con = dbConnector.getConnect();
		
		// 2. Query 작성
		String sql = "SELECT * FROM LOCATIONS";
		
		// 3. Query 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ? 값 세팅
		
		// 5. 최종 전송 후 결과 처리
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<LocationDTO> arr = new ArrayList<>();
		
		while(rs.next()) {
			LocationDTO locationDTO = new LocationDTO();
			
			locationDTO.setLocation_id(rs.getInt("location_id"));
			locationDTO.setStreet_address(rs.getString("street_address"));
			locationDTO.setPostal_code(rs.getString("city"));
			locationDTO.setState_province(rs.getString("state_province"));
			locationDTO.setCountry_id(rs.getString("country_id"));
			
			arr.add(locationDTO);			
			
		}
		
		// 6. 연결 해제
		rs.close();
		st.close();
		con.close();
		
		return arr; 
	}
	
}
