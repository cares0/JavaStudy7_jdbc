package com.cares.s1.start;

import com.cares.s1.department.DepartmentController;
import com.cares.s1.department.DepartmentDAO;
import com.cares.s1.department.DepartmentDTO;
import com.cares.s1.department.DepartmentView;
import com.cares.s1.location.LocationDAO;
import com.cares.s1.location.LocationView;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentController departmentController = new DepartmentController();

		
		try {
			departmentController.start();
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		System.out.println("DB 연동 테스트 끝");
	}
	
}
