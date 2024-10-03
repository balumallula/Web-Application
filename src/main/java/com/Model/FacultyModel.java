package com.Model;

public class FacultyModel {
	    private String firstname;
	    private String username;
	    private String password;
	    private String email;
	    private long mobile;
	    private String gender;
	    private int exp;
	    private int course;
	    private int fid;


		@Override
		public String toString() {
			return "FacultyModel [firstname=" + firstname + ", username=" + username + ", password=" + password
					+ ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", exp=" + exp + ", course="
					+ course + ", fid=" + fid + "]";
		}



		public FacultyModel(int fid,String firstname, String username, String password, String email, long mobile,
				String gender,int exp, int course) {
			super();
			this.fid = fid;
			this.firstname = firstname;
			this.username = username;
			this.password = password;
			this.email = email;
			this.mobile = mobile;
			this.gender = gender;
			this.exp = exp;
			this.course = course;
		}



		public FacultyModel() {

		}

		public int getFid() {
			return fid;
		}



		public void setFid(int fid) {
			this.fid = fid;
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
		public int getExp() {
			return exp;
		}
		public void setExp(int exp2) {
			this.exp = exp2;
		}
		public int getCourse() {
			return course;
		}
		public void setCourse(int course) {
			this.course = course;
		}

}
