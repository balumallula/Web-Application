package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.CourseModel;

public class CourseDAO {

	public String insertData(CourseModel cm) {
		String status="failure";

 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement("insert into course(course_name,course_fee,course_duration)values(?,?,?)");
			 ps.setString(1,cm.getCoursename());
			 ps.setInt(2,cm.getCoursefees());
			 ps.setString(3,cm.getDuration());

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

	public String update(CourseModel cm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement("update course set course_Name=?,course_fee=?,course_duration=? where course_id=?");
			 ps.setString(1, cm.getCoursename());
			 ps.setInt(2, cm.getCoursefees());
			 ps.setString(3, cm.getDuration());
			 ps.setInt(4, cm.getCid());


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

	public String delete(CourseModel cm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement(" delete from course where course_id=?");
			 ps.setInt(1,cm.getCid());

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


	public List<CourseModel> selectWithId(CourseModel cm) {

		List<CourseModel>  courseWithId = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from course where course_id=?");
            ps2.setInt(1,cm.getCid());

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("course_id");
				String cname = rs.getString("course_name");
				int cfee = rs.getInt("course_fee");
				String cduration = rs.getString("course_duration");

				courseWithId.add(new CourseModel(cid,cname,cfee,cduration));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return  courseWithId;

	}
	public List<CourseModel> fetchAllCourse() {

		List<CourseModel>  course = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from course");

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int cid = rs.getInt("course_id");
				String cname = rs.getString("course_name");
				int cfee = rs.getInt("course_fee");
				String cduration = rs.getString("course_duration");

				course.add(new CourseModel(cid,cname,cfee,cduration));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return  course;

	}
}