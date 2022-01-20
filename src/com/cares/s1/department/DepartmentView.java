package com.cares.s1.department;

import java.util.List;

public class DepartmentView {

	public void view(List<DepartmentDTO> arr) {
		// 모두 출력
		
		for(int i=0;i<arr.size();i++) {			
			System.out.print(arr.get(i).getDepartment_id()+ "\t");
			System.out.print(arr.get(i).getDepartment_name() + "\t");
			System.out.print(arr.get(i).getManager_id() + "\t");
			System.out.println(arr.get(i).getLocation_id());
			System.out.println("===============================================================================");
		}
		
	}
	
}
