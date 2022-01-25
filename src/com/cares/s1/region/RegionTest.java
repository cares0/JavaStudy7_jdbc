package com.cares.s1.region;

public class RegionTest {

	public static void main(String[] args) {
		// Region Package 내에 있는 것만 Test
		
		RegionDAO regionDAO = new RegionDAO();
		RegionDTO regionDTO = new RegionDTO();
		RegionController regionController = new RegionController();
		
		regionDTO.setRegion_id(5L);
		regionDTO.setRegion_name("South Pole");
		
		try {
			regionController.start();
			//int result = regionDAO.setUpdate(regionDTO);
			//int result = regionDAO.setInsert(regionDTO);
			//int result = regionDAO.setDelete(regionDTO);
			//System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
