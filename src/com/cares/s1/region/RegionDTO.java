package com.cares.s1.region;

public class RegionDTO {

	// DTO 기본
	// 멤버변수의 접근지정자는 모두 private
	// getter, setter 생성
	// 멤버변수의 데이터타입과 변수명은 DB의 로우값의 데이터타입과 컬럼명과 일치
	// 생성자는 여러 개 만들어도 상관없지만, default 생성자는 무조건 있어야 함
	
	private Long region_id; // SQL의 number 형은 자릿수를 표현하지 않았을 경우 최대 32자리까지 표현하기 때문
	private String region_name;

	
	public RegionDTO() {
	
	}
	
	public Long getRegion_id() {
		return region_id;
	}
	public void setRegion_id(Long region_id) {
		this.region_id = region_id;
	}
	public String getRegion_name() {
		return region_name;
	}
	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}
	
	
	
}
