package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Model.BatchModel;
import com.Model.CourseModel;
import com.Model.PaymentModel;

public class PaymentDAO {

	public static Connection connect() {
		Connection con = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}

	

	public String insertData(PaymentModel pm) {
	   int course_fee = 0;
		String status="FAIL";
		String report="";
		   int cp = pm.getPaid();

		 Connection con = connect();

			try {
			 PreparedStatement ps = con.prepareStatement("select batch_id from student where stud_id = ?");
			 ps.setInt(1, pm.getStudid());

			 ResultSet rs = ps.executeQuery();
              int batch_id =0;
			 if (rs.next()) {
				 batch_id = rs.getInt(1);


			 }

			 PreparedStatement ps1 = con.prepareStatement("select course_id from batch where batch_id = ?");
			 ps1.setInt(1, batch_id);

			 ResultSet rs1 = ps1.executeQuery();
              int course_id =0;
			 if (rs1.next()) {
				 course_id = rs1.getInt(1);


			 }

			 PreparedStatement ps2 = con.prepareStatement("select course_fee from course where course_id = ?");
			 ps2.setInt(1, course_id);

			 ResultSet rs2 = ps2.executeQuery();

			 if (rs2.next()) {
				course_fee = rs2.getInt(1);
			 }
			 PreparedStatement ps3 = con.prepareStatement("select stud_id from student where stud_id=?");
			  ps3.setInt(1, pm.getStudid());

			  ResultSet n = ps3.executeQuery();
			  while(n.next()) {
				  report="ID GOT";
			  }
			}
		 catch(Exception e) {
					System.out.println(e);
				}
 		try {

			 PreparedStatement ps4 = con.prepareStatement("select sum(amount_paid) from payment where stud_id = ?");
			 ps4.setInt(1, pm.getStudid());

			 ResultSet rs4 = ps4.executeQuery();

			 int totalPaid = 0;

			 if (rs4.next()) {
				 totalPaid=rs4.getInt(1);
				 System.out.println("total paid: "+totalPaid);
			 }

			 System.out.println("curr paid: "+cp);
			 System.out.println("c fee: "+course_fee);
			   if(report=="ID GOT") {

				   if(totalPaid>=course_fee) {
					    status ="CLEAR" ;

				      }
				      else if(totalPaid + cp <= course_fee) {
		
				            	  PreparedStatement ps5 = con.prepareStatement("insert into payment(stud_id,amount_paid,paid_date) values (?,?,?)");
				     			 ps5.setInt(1, pm.getStudid());
				     			 ps5.setInt(2, pm.getPaid());
				     			 ps5.setString(3, pm.getDate());
		
		
				     			 int n =ps5.executeUpdate();
						     			 if(n>0) {
						     				 status ="SUCCESS";
						     			 }
				                   }

				          else  {
				            	  status="EXCEEDED";
				              }
 	              }
			   else {
				   status="ID NOT FOUND";
				   }
			   }
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
  }
	public String update(PaymentModel pm) {
		int course_fee = 0;
			 String status="FAIL";
				 
				   int cp = pm.getPaid();
				   

				 Connection con = connect();

					try {
					 PreparedStatement ps = con.prepareStatement("select batch_id from student where stud_id = ?");
					 ps.setInt(1, pm.getStudid());

					 ResultSet rs = ps.executeQuery();
		              int batch_id =0;
					 if (rs.next()) {
						 batch_id = rs.getInt(1);


					 }

					 PreparedStatement ps1 = con.prepareStatement("select course_id from batch where batch_id = ?");
					 ps1.setInt(1, batch_id);

					 ResultSet rs1 = ps1.executeQuery();
		              int course_id =0;
					 if (rs1.next()) {
						 course_id = rs1.getInt(1);


					 }

					 PreparedStatement ps2 = con.prepareStatement("select course_fee from course where course_id = ?");
					 ps2.setInt(1, course_id);

					 ResultSet rs2 = ps2.executeQuery();

					 if (rs2.next()) {
						 course_fee = rs2.getInt(1);
					 }
					 
					}
				 catch(Exception e) {
							System.out.println(e);
						}
		 		try {

					 PreparedStatement ps4 = con.prepareStatement("select sum(amount_paid) from payment where stud_id = ?");
					 ps4.setInt(1, pm.getStudid());

					 ResultSet rs4 = ps4.executeQuery();

					 int totalPaid = 0;

					 if (rs4.next()) {
						 totalPaid=rs4.getInt(1);
						 System.out.println("total paid: "+totalPaid);
					 }
					 
					 

					 
					 PreparedStatement ps5 = con.prepareStatement("select amount_paid from payment where sno =?");
					 ps5.setInt(1, pm.getSno());

					 ResultSet rs5 = ps5.executeQuery();  
					 int prevPaid = 0;

					 if (rs5.next()) {
						 prevPaid=rs5.getInt(1);
						 System.out.println("prevpaid: "+prevPaid);
					 }
					   
                      int updatePaid = totalPaid-prevPaid;
         			 System.out.println("update paid: "+updatePaid);
                      if(updatePaid+cp<=course_fee) {
				    	  PreparedStatement ps = con.prepareStatement("update payment set amount_paid=?,paid_date=? where sno=?");
							 ps.setInt(1,pm.getPaid());
							 ps.setString(2,pm.getDate());
							 ps.setInt(3,pm.getSno());


				     			 int n =ps.executeUpdate();
						     			 if(n>0) {
						     				 status ="SUCCESS";
						     			 }
                      }

				          else  {
				            	  status="EXCEEDED";
				              }
					  
					   }
				catch(Exception e) {
					System.out.println(e);
				}
				return status;
 		}
 
	public String delete(PaymentModel pm) {
		String status="failure";
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

			 PreparedStatement ps = con.prepareStatement(" delete from payment where sno=?");
			 ps.setInt(1,pm.getSno());

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

	
	public List<PaymentModel> selectWithId(PaymentModel pm) {

		List<PaymentModel>  paymentWithId = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from payment where sno=?");
            ps2.setInt(1, pm.getSno());
			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int sno = rs.getInt("sno");
				int sid = rs.getInt("stud_id");
				int amount = rs.getInt("amount_paid");
				String date = rs.getString("paid_date");

				paymentWithId.add(new PaymentModel(sno,sid,amount,date)); 
						 
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return  paymentWithId;

	}
	
	 
	
	public List<PaymentModel> fetchAllPayments() {

		List<PaymentModel>  payment = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
			PreparedStatement ps2 = con.prepareStatement("select *from payment");

			ResultSet rs = ps2.executeQuery();
			while (rs.next()) {
				int sno = rs.getInt("sno");
				int sid = rs.getInt("stud_id");
				int paid = rs.getInt("amount_paid");
				String date = rs.getString("paid_date");
 
				payment.add(new PaymentModel(sno,sid,paid,date)); 
						 
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return  payment;

	}
}
