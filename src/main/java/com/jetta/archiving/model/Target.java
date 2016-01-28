package com.jetta.archiving.model;


/**
 * 백업대상 정보를 담는 오브젝트
 * */
public class Target {

	String type; // Dir 또는 File, Enumeration 사용할 수 있는지 검토
	
	String path; // 경로명 또는 파일명
	
	int cycle; // 백업주기

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getCycle() {
		return cycle;
	}

	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	
	@Override
	public String toString(){
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("구분 :").append(type).append("\n");
		sb.append("경로 :").append(path).append("\n");
		sb.append("주기 :").append(cycle);
		
		return sb.toString();
	}
}
