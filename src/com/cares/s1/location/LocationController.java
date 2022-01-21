package com.cares.s1.location;

import java.util.Scanner;

public class LocationController {

	private LocationDAO locationDAO;
	private LocationView locationView;
	private Scanner sc;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 도시 리스트 출력"); 
			System.out.println("2. 도시  번호  검색");
			System.out.println("3. 도시 관리 나가기");
				
			int select = sc.nextInt();
			switch (select) {
			case 1 :
				locationView.view(locationDAO.getList()); 
				break;
			case 2 :
				System.out.println("검색할 도시의 번호를 입력하세요.");
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(sc.nextInt());
				locationView.view(locationDAO.getOne(locationDTO));
				break;
			case 3 :
				flag = false;
				break;		
			}
		}
		
	}
	
}
