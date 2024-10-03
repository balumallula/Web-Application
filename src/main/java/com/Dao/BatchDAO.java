package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.BatchModel;

public class BatchDAO {

	public String insertData(BatchModel bm) {
		String status="failure";

 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement("insert into batch(batch_name,batch_starts_date,course_id)values(?,?,?)");
			 ps.setString(1,bm.getBatchname());
			 ps.setString(2,bm.getDate());
			 ps.setInt(3,bm.getCourse());

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
	public String update(BatchModel bm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement("update batch set batch_Name=?, batch_starts_date=?,course_id=? where batch_id=?");
			 ps.setString(1, bm.getBatchname());
			 ps.setString(2, bm.getDate());
			 ps.setInt(3, bm.getCourse());
			 ps.setInt(4, bm.getBid());

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

	public String delete(BatchModel bm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement(" delete from batch where batch_id=?");
			 ps.setInt(1,bm.getBid());

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


	public List<BatchModel> selectWithId(BatchModel bm) {

		List<BatchModel>  batchWithId = new ArrayList<>();
		 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from batch where batch_id=?");
            ps2.setInt(1, bm.getBid());
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("batch_id");
				String bname = rs.getString("batch_name");
				String batchDate = rs.getString("batch_starts_date");
				int cid = rs.getInt("course_id");

				batchWithId.add(new BatchModel(bid,bname,batchDate,cid));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return  batchWithId;

	}

	public List<BatchModel> fetchAllBatch() {

		List<BatchModel>  batch = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from batch");

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("batch_id");
				String bname = rs.getString("batch_name");
				String batchDate = rs.getString("batch_starts_date");
				int cid = rs.getInt("course_id");

				 batch.add(new BatchModel(bid,bname,batchDate,cid));

			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return  batch;

	}
}
