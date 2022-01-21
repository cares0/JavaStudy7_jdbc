package com.cares.s1.department;

import java.util.Scanner;

public class DepartmentController {

	private DepartmentDAO departmentDAO;
	private DepartmentView departmentView;
	private Scanner sc;
	
	public DepartmentController() {
		departmentDAO = new DepartmentDAO();
		departmentView = new DepartmentView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 부서 리스트 출력");
			System.out.println("2. 부서  번호  검색");
			System.out.println("3. 부서 관리 나가기");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :
				departmentView.view(departmentDAO.getList());
				break;
			case 2 :
				System.out.println("검색할 부서번호를 입력하세요.");
				DepartmentDTO departmentDTO = new DepartmentDTO();
				departmentDTO.setDepartment_id(sc.nextInt());
				departmentDTO = departmentDAO.getOne(departmentDTO);
				departmentView.view(departmentDTO);				
				break;
			
			default:
				flag = false;
			}
			
		}
		
	}
	
}
