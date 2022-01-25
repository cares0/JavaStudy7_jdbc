package com.cares.s1.start;

import com.cares.s1.region.RegionDAO;
import com.cares.s1.region.RegionDTO;

public class StartMain {

	public static void main(String[] args) {
		System.out.println("DB 연동 테스트 시작");

		FrontController frontController = new FrontController();

		
		try {
			//frontController.mainStart();
			RegionDAO regionDAO = new RegionDAO();
			RegionDTO regionDTO = new RegionDTO();
			regionDTO.setRegion_id(6L);
			regionDTO.setRegion_name("South Pole");
			int result = regionDAO.setDelete(regionDTO);
			
			if(result > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
		
		System.out.println("DB 연동 테스트 끝");
	}
	
}
