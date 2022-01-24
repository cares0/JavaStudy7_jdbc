package com.cares.s1.department;

import java.util.List;

import com.cares.s1.employee.EmployeeDTO;

public class DepartmentDTO {

	private Integer department_id;
	private String department_name;
	private Integer manager_id;
	private Integer location_id;
	
	// 부서 is a 사원 = 틀림 > 상속X
	// 부서 has a 사원 = 맞음 > 멤버변수로 선언해서 사용O
	
	// 부서 1개당 사원 N명 
	// 따라서 단순하게 DTO 객체 하나만을 멤버로 가져선 안됨 > List 활용
	private List<EmployeeDTO> employeeDTOs;
	
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public Integer getManager_id() {
		return manager_id;
	}
	public void setManager_id(Integer manager_id) {
		this.manager_id = manager_id;
	}
	public Integer getLocation_id() {
		return location_id;
	}
	public void setLocation_id(Integer location_id) {
		this.location_id = location_id;
	}
	
	
}
