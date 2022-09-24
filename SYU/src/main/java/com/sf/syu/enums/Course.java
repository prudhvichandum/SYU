package com.sf.syu.enums;

public enum Course {

	MBA_PGDM("MBA/PGDM"),BSc("B.Sc"),BE_Btech("BE/BTech"),MSc("M.sc"),BBA_BBM("BBA/BBM"),BA("BA");
	private final String course;

	

	 Course(String course) {
		this.course = course;
	}



	public String getCourse() {
		return course;
	}



	
}
