package com.cares.s1.region;

import java.util.Scanner;

public class RegionController {

	private RegionInput regionInput;
	private RegionDAO regionDAO;
	private RegionView regionView;
	private Scanner sc;
	
	public RegionController() {
		regionInput = new RegionInput();
		regionDAO = new RegionDAO();
		regionView = new RegionView();
		sc = new Scanner(System.in);
	}
	
	public void start() throws Exception {
		boolean check = true;
		
		while(check) {
			System.out.println("1. Region 추가");
			System.out.println("2. Region 수정");
			System.out.println("3. Region 삭제");
			System.out.println("4. 나   가   기");
			int select = sc.nextInt();
			
			switch(select) {
			case 1:
				RegionDTO regionDTO = regionInput.setInsert();
				int result = regionDAO.setInsert(regionDTO);
				String message = "Insert Fail";
				if(result > 0) {
					message = "Insert Success";
				}
				regionView.view(message);
				break;
			case 2:
				regionDTO = regionInput.setInsert();
				result = regionDAO.setUpdate(regionDTO);
				message = "Update Fail";
				if (result > 0) {
					message = "Update Success";
				}
				regionView.view(message);
				break;
			case 3:
				regionDTO = regionInput.setDelete();
				result = regionDAO.setDelete(regionDTO);
				message = "Delete Fail";
				if(result > 0) {
					message = "Delete Success";
				}
				regionView.view(message);
				break;
			default:
				check = false;
			}
			
		}
		
		
	}
	
}
