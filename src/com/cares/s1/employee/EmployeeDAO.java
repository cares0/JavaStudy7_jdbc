package com.cares.s1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cares.s1.util.DBConnector;

public class EmployeeDAO {
	private DBConnector dbConnector;
	
	public EmployeeDAO() {
		dbConnector = new DBConnector();
	}
	
	public EmployeeDTO getOne(EmployeeDTO emp) throws Exception {
		Connection con = dbConnector.getConnect();
		
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, emp.getEmployee_id());
		
		ResultSet rs = st.executeQuery();
		
		EmployeeDTO employeeDTO = null;
		
		if (rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setSalary(rs.getDouble("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
	
		}
		return employeeDTO;
	}
	
	public List<EmployeeDTO> getList() throws Exception {
		Connection con = dbConnector.getConnect();
		
		String sql = "SELECT * FROM EMPLOYEES";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<EmployeeDTO> ar = new ArrayList<>();
		EmployeeDTO employeeDTO = null;
		
		while (rs.next()) {
			employeeDTO = new EmployeeDTO();
			employeeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeeDTO.setFirst_name(rs.getString("first_name"));
			employeeDTO.setLast_name(rs.getString("last_name"));
			employeeDTO.setEmail(rs.getString("email"));
			employeeDTO.setPhone_number(rs.getString("phone_number"));
			employeeDTO.setHire_date(rs.getString("hire_date"));
			employeeDTO.setJob_id(rs.getString("job_id"));
			employeeDTO.setSalary(rs.getDouble("salary"));
			employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
			employeeDTO.setManager_id(rs.getInt("manager_id"));
			employeeDTO.setDepartment_id(rs.getInt("department_id"));
			
			ar.add(employeeDTO);
		}
		return ar;
	}
	
}
