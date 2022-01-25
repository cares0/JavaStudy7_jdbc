package com.cares.s1.region;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cares.s1.util.DBConnector;

public class RegionDAO {

	private DBConnector dbConnector;
	
	public RegionDAO() {
		dbConnector = new DBConnector();
	}
	
	// 대륙정보 추가
	public int setInsert(RegionDTO regionDTO) throws Exception {
		Connection con = dbConnector.getConnect();
		
		// JAVA는 기본으로 auto commit임
		// auto commit 해제
		con.setAutoCommit(false);
		
		String sql = "INSERT INTO REGIONS (REGION_ID, REGION_NAME) VALUES (?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, regionDTO.getRegion_id());
		st.setString(2, regionDTO.getRegion_name());
		
		// INSERT 문의 결과문은 성공한 숫자를 줌 (여기서는 몇 행이 삽입되었는지)
		int result = st.executeUpdate();
		// 그래서 int형으로 결과를 받아주는 것!
		
		
		st.close();
		con.close();
		
		return result; // 0이면 INSERT 실패, 이 외 양의정수이면 1 이상 리턴해줌
		
	}
	
}
