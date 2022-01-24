package com.cares.s1.employee;

import java.util.Scanner;


public class EmployeeController {

	
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	private Scanner sc;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 직원 리스트 출력");
			System.out.println("2. 직원  번호  검색");
			System.out.println("3. 직원 관리 나가기");
			
			int select = sc.nextInt();
			
			switch(select) {
			case 1 :
				employeeView.view(employeeDAO.getList());
				break;
			case 2 :
				System.out.println("검색할 직원번호를 입력하세요.");
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(sc.nextInt());
				employeeDTO = employeeDAO.getOne(employeeDTO);
				employeeView.view(employeeDTO);				
				break;
			
			default:
				flag = false;
			}
			
		}
		
	}
}
