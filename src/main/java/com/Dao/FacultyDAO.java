package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.FacultyModel;


public class FacultyDAO {

	public String insertData(FacultyModel fm) {
		String status = "failure";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			PreparedStatement ps2 = con
					.prepareStatement("select faculty_Username from faculty where faculty_Username = ?");
			ps2.setString(1, fm.getUsername());
			ResultSet rs = ps2.executeQuery();

			if (!rs.next()) {
				PreparedStatement ps = con.prepareStatement(
						"insert into faculty(faculty_Name, faculty_Mobile, faculty_Gmail, faculty_gender, Experience, faculty_Username, faculty_Password, course_id) values(?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setString(1, fm.getFirstname());
				ps.setLong(2, fm.getMobile());
				ps.setString(3, fm.getEmail());
				ps.setString(4, fm.getGender());
				ps.setInt(5, fm.getExp());
				ps.setString(6, fm.getUsername());
				ps.setString(7, fm.getPassword());
				ps.setInt(8, fm.getCourse());

				int n = ps.executeUpdate();
				if (n > 0) {
					status = "SUCCESS";
				}
			} else {

				status = "failure";
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return status;
	}


	public String fupdate(FacultyModel fm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement("update faculty set faculty_Name=?,faculty_mobile=?,faculty_Gmail=?,faculty_gender=?,Experience=?,course_id=? where faculty_id=?");
			 ps.setString(1, fm.getFirstname());
			 ps.setLong(2, fm.getMobile());
			 ps.setString(3, fm.getEmail());
			 ps.setString(4, fm.getGender());
			 ps.setInt(5, fm.getExp());
			 ps.setInt(6, fm.getCourse());
			 ps.setInt(7, fm.getFid());

			 int n = ps.executeUpdate();
			 if(n>0){
				 status="SUCCESS";
			 }

		}
		catch(Exception e) {
			System.out.println(e);
		}


		return status;
	}

	public String fdelete(FacultyModel fm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement(" delete from faculty where faculty_id=?");
			 ps.setInt(1,fm.getFid());

			 int n = ps.executeUpdate();
			 if(n>0){
				 status="SUCCESS";
			 }

		}
		catch(Exception e) {
			System.out.println(e);
		}


		return status;
	}


	public List<FacultyModel> selectWithId(FacultyModel fm) {

		List<FacultyModel> facultyWithId = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from faculty where faculty_id=?");
			ps2.setInt(1, fm.getFid());

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("faculty_id");
				String fname = rs.getString("faculty_Name");
				long fmobile = rs.getLong("faculty_Mobile");
				String fmail = rs.getString("faculty_GMail");
				String fgender = rs.getString("faculty_gender");
				int fexp = rs.getInt("Experience");
				int course_id = rs.getInt("course_id");
				String username = rs.getString("faculty_Username");
				String password = rs.getString("faculty_Password");

				facultyWithId.add(new FacultyModel(fid,fname,username,password,fmail,fmobile,fgender, fexp,course_id));

			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return facultyWithId;


	}

	public List<FacultyModel> fetchAllFaculty() {

		List<FacultyModel> faculty = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from faculty");

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int fid = rs.getInt("faculty_id");
				String fname = rs.getString("faculty_Name");
				long fmobile = rs.getLong("faculty_Mobile");
				String fmail = rs.getString("faculty_GMail");
				String fgender = rs.getString("faculty_gender");
				int fexp = rs.getInt("Experience");
				int course_id = rs.getInt("course_id");
				String username = rs.getString("faculty_Username");
				String password = rs.getString("faculty_Password");

				faculty.add(new FacultyModel(fid,fname,username,password,fmail,fmobile,fgender, fexp,course_id));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return faculty;

	}

}
