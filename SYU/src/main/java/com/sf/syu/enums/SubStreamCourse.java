package com.sf.syu.enums;

public enum SubStreamCourse {

	MBA_PGDM("MBA/PGDM"), BSc("B.Sc"), BE_Btech("BE/BTech"), MSc("M.sc"), BBA_BBM("BBA/BBM"), BA("BA");
	private final String subStreamCourse;

	 SubStreamCourse(String subStreamCourse) {
		this.subStreamCourse = subStreamCourse;
	}

	public String getSubStreamCourse() {
		return subStreamCourse;
	}

	
}
