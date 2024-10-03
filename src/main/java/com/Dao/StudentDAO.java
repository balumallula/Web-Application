package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.StudentModel;

public class StudentDAO {

	public String insertData(StudentModel sm) {
		String status = "failure";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select stud_username from student where stud_username = ?");
			ps2.setString(1, sm.getUsername());
			ResultSet rs = ps2.executeQuery();

			if (!rs.next()) {
				PreparedStatement ps = con.prepareStatement(
						"insert into student(stud_name,stud_mobile,stud_mail,stud_gender,branch,year_of_passout,father_name,father_mobile,batch_id,stud_username,stud_pass)values(?,?,?,?,?,?,?,?,?,?,?)");
				ps.setString(1, sm.getFirstname());
				ps.setLong(2, sm.getMobile());
				ps.setString(3, sm.getEmail());
				ps.setString(4, sm.getGender());
				ps.setString(5, sm.getBranch());
				ps.setString(6, sm.getYear());
				ps.setString(7, sm.getFathername());
				ps.setLong(8, sm.getFmobile());
				ps.setInt(9, sm.getBatch());
				ps.setString(10, sm.getUsername());
				ps.setString(11, sm.getPassword());

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
	public String update(StudentModel sm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement("update student set stud_name=?,stud_mobile=?,stud_mail=?,stud_gender=?,branch=?,year_of_passout=?,father_name=?,father_mobile=?,batch_id=? where stud_id=?");
			 ps.setString(1, sm.getFirstname());
			 ps.setLong(2, sm.getMobile());
			 ps.setString(3,sm.getEmail());
			 ps.setString(4, sm.getGender());
			 ps.setString(5, sm.getBranch());
			 ps.setString(6, sm.getYear());
			 ps.setString(7, sm.getFathername());
			 ps.setLong(8, sm.getFmobile());
			 ps.setInt(9, sm.getBatch());
			 ps.setInt(10, sm.getSid());


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

	public String delete(StudentModel sm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement(" delete from student where stud_id=?");
			 ps.setInt(1,sm.getSid());

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


public List<StudentModel> selectWithId(StudentModel sm) {

		List<StudentModel> studentWithId = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from student where stud_id=?");
			ps2.setInt(1, sm.getSid());

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt("stud_id");
				String sname = rs.getString("stud_name");
				long smobile = rs.getLong("stud_mobile");
				String smail = rs.getString("stud_mail");
				String sgender = rs.getString("Stud_gender");
				String sbranch = rs.getString("branch");
				String syearofpass = rs.getString("year_of_passout");
				String sfname = rs.getString("father_name");
				long sfmobile = rs.getLong("father_mobile");
				int batchid = rs.getInt("batch_id");
				String username = rs.getString("stud_username");
				String password = rs.getString("stud_pass");

				studentWithId.add(new StudentModel(sid, sname, username, password, smail, smobile, sgender, sbranch, batchid,
						syearofpass, sfname, sfmobile));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return studentWithId;

	}

	public List<StudentModel>  selectWithBatch(StudentModel sm) {

		List<StudentModel> students = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from student where batch_id=?");
              ps2.setInt(1, sm.getBatch());
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int sid = rs.getInt("stud_id");
				String sname = rs.getString("stud_name");
				long smobile = rs.getLong("stud_mobile");
				String smail = rs.getString("stud_mail");
				String sgender = rs.getString("Stud_gender");
				String sbranch = rs.getString("branch");
				String syearofpass = rs.getString("year_of_passout");
				String sfname = rs.getString("father_name");
				long sfmobile = rs.getLong("father_mobile");
				int batchid = rs.getInt("batch_id");
				String username = rs.getString("stud_username");
				String password = rs.getString("stud_pass");

				students.add(new StudentModel(sid, sname, username, password, smail, smobile, sgender, sbranch, batchid,
						syearofpass, sfname, sfmobile));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return students;

	}
}
