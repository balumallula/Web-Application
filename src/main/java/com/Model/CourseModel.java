package com.Model;

public class CourseModel {

	private int cid;
	private String coursename;
	private int coursefees;
	private String duration;

	public CourseModel(int cid ,String coursename, int coursefees, String duration) {
		super();
		this.cid = cid;
		this.coursename = coursename;
		this.coursefees = coursefees;
		this.duration = duration;
	}

	public CourseModel() {

	}

	@Override
	public String toString() {
		return "CourseModel [cid=" + cid + ", coursename=" + coursename + ", coursefees=" + coursefees + ", duration="
				+ duration + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public int getCoursefees() {
		return coursefees;
	}
	public void setCoursefees(int coursefees) {
		this.coursefees = coursefees;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}

}
