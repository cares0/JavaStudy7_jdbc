package com.cares.s1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cares.s1.util.DBConnector;

public class DepartmentDAO {
	// DAO : Data Access Object - 데이터와 연결하는 클래스
	private DBConnector dbConnector; // 데이터와 연결은 여기서만 할 것이기 때문에
	
	public DepartmentDAO() {
		dbConnector = new DBConnector();
	}
	
	// 부서번호로 조회
	public DepartmentDTO getOne(DepartmentDTO dep) throws Exception {
		// 1. DB로그인
		Connection con = dbConnector.getConnect();
		
		// 2. SQL Query문 작성
		// 부서 테이블에서 부서번호로 조회 
		// SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = 어떤 번호 
		// -> 어떤 번호란 변하는 값 -> 변수
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ? ";
		// 3. Query문 미리 전송시켜서 DB가 준비
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ?값 세팅, 없으면 통과
		// st.set집어넣으려는데이터타입(int index, 값)
		// index는 ?의 순서번호
		// oracle은 인덱스가 1번부터 시작함!!
		// 만약 조건문이 2개 이상이라 ?가 2개 이상이라면 인덱스가 늘어나는 것임
		// 쿼리에 쓰여져있는 순서대로 맨왼쪽부터 1번 시작
		st.setInt(1, dep.getDepartment_id());
		
		// 5. Query문 최종 전송 후 결과 처리  최종전송하는 이유가 ? 때문이었음
		ResultSet rs = st.executeQuery();
		
		// 부서번호는 데이터의 특성상 맞으면 1개를 가져오게 되고 
		// 부서번호가 없는 번호를 입력하면 하나도 안가져옴
		DepartmentDTO departmentDTO = null; // 데이터가 있으면 객체를 만들꺼니까 여기서는 null
		if(rs.next()) {
			// 데이터가 있을 때			
			departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
		}
		
		// 6. 자원 해제
		rs.close();
		st.close();
		con.close();
		
		
		return departmentDTO;
	}
	
	
	
	public List<DepartmentDTO> getList() throws Exception {
		// SELECT * FROM DEPARTMENTS;
		// 1. DB 로그인
		Connection con = dbConnector.getConnect();
		
		// 2. SQL Query문 작성
		// Java에서는 Query문 ; 제외, 알아서 Java에서 넣어줌
		String sql = "SELECT * FROM DEPARTMENTS";
		
		// 3. 작성한 SQL Query 미리 전송
		// 데이터베이스가 미리 받아서 이 작업을 해놔야겠구나 하고 준비를 해놓음
		PreparedStatement st = con.prepareStatement(sql);
		
		// 4. ? 값을 세팅, 없으면 통과
		
		// 5. 최종 전송 후 결과 처리
		// SELECT의 결과물은 ResultSet에 보관, Oracle Sql Developer에서 run을 하면
		// View화면을 보는 것 뿐이지, 여기서는 View를 보고자 하는 것이 아니라
		// ResultSet 자체를 가져오고 싶은 것임
		ResultSet rs = st.executeQuery();
		// 한 row씩 꺼내오는 것임
		// cursor가 맨 위에 존재하는데 한줄씩 읽으면서 내려옴
		// 데이터가 없을 때 까지 cursor가 내려옴, 근데 몇 개의 데이터가 있는지 알 수가 없잖아
		// 몇번 반복할지 모를때 사용하는거, while문
		
		// cursor가 한줄 읽는 메서드 next() 리턴은 데이터가 있으면 true, 없으면 false
		ArrayList<DepartmentDTO> arr = new ArrayList<>();
		
		while(rs.next()) { // 데이터가 없을 때 까지 반복
			DepartmentDTO departmentDTO = new DepartmentDTO();
			
			departmentDTO.setDepartment_id(rs.getInt("department_id"));
			departmentDTO.setDepartment_name(rs.getString("department_name"));
			departmentDTO.setLocation_id(rs.getInt("location_id"));
			departmentDTO.setManager_id(rs.getInt("manager_id"));
			
			arr.add(departmentDTO);
		}
		
		// 6. 외부 연결 해제
		// 작업이 다 끝났으니까 연결을 무조건 끊어줘야 다른 사용자가 DB를 사용할 수가 있음
		// 연결된 순서의 역순
		rs.close();
		st.close();
		con.close();
		
		return arr;
	}
}
