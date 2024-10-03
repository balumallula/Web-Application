package com.Model;

public class StudentModel {
	private int sid;
	private String firstname;
	private String username;
	private String password;
	private String email;
	private long mobile;
	private String gender;
	private String branch;
	private int batch;
	private String year;
	private String fathername;
	private long fmobile;

	@Override
	public String toString() {
		return "StudentModel [sid=" + sid + ", firstname=" + firstname + ", username=" + username + ", password="
				+ password + ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", branch=" + branch
				+ ", batch=" + batch + ", year=" + year + ", fathername=" + fathername + ", fmobile=" + fmobile + "]";
	}

	public StudentModel(int sid, String name, String username, String password, String email, long mobile,
			String gender, String branch, int batchId, String yearOfPassout, String fatherName, long fatherMobile) {
		this.sid = sid;
		this.firstname = name;
		this.username = username;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.branch = branch;
		this.batch = batchId;
		this.year = yearOfPassout;
		this.fathername = fatherName;
		this.fmobile = fatherMobile;
	}

	public StudentModel() {
	}



	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getBatch() {
		return batch;
	}

	public void setBatch(int batch) {
		this.batch = batch;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getFathername() {
		return fathername;
	}

	public void setFathername(String fathername) {
		this.fathername = fathername;
	}

	public long getFmobile() {
		return fmobile;
	}

	public void setFmobile(long fmobile) {
		this.fmobile = fmobile;
	}
}
