package com.cares.s1.start;

import com.cares.s1.department.DepartmentDAO;
import com.cares.s1.department.DepartmentView;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");
		
		DepartmentDAO departmentDAO = new DepartmentDAO();
		DepartmentView departmentView = new DepartmentView();
		
		try {
			departmentView.view(departmentDAO.getList());
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		System.out.println("DB 연동 테스트 끝");
	}
	
}
