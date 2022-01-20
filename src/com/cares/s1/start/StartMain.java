package com.cares.s1.start;

import com.cares.s1.department.DepartmentDAO;
import com.cares.s1.department.DepartmentView;
import com.cares.s1.location.LocationDAO;
import com.cares.s1.location.LocationView;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		LocationDAO locationDAO = new LocationDAO();
		LocationView locationView = new LocationView();
		
		try {
			departmentView.view(departmentDAO.getList());
			locationView.view(locationDAO.getList());
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		System.out.println("DB 연동 테스트 끝");
	}
	
}
