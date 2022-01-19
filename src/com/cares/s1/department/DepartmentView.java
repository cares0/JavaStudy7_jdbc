package com.cares.s1.department;

import java.util.List;

public class DepartmentView {

	public void view(List<DepartmentDTO> arr) {
		// 모두 출력
		
		for(int i=0;i<arr.size();i++) {			
			System.out.println("DEPARTMENT_ID : " + arr.get(i).getDepartment_id());
			System.out.println("DEPARTMENT_NAME : " + arr.get(i).getDepartment_name());
			System.out.println("MANAGER_ID : " + arr.get(i).getManager_id());
			System.out.println("LOCATION_ID : " + arr.get(i).getLocation_id());
			System.out.println("=========================");
		}
		
	}
	
}
