package com.Model;

public class BatchModel {


	private String batchname;
	private String date;
	private int course;
	private int bid;

	public BatchModel( int bid ,String batchname, String date, int course) {
		super();
		this.bid = bid;
		this.batchname = batchname;
		this.date = date;
		this.course = course;
	}


	public BatchModel() {

	}

	@Override
	public String toString() {
		return "BatchModel [batchname=" + batchname + ", date=" + date + ", course=" + course + ", bid=" + bid + "]";
	}

	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBatchname() {
		return batchname;
	}
	public void setBatchname(String batchname) {
		this.batchname = batchname;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getCourse() {
		return course;
	}
	public void setCourse(int course) {
		this.course = course;
	}
}
