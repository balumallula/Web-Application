package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Model.ForgotModel;



public class ForgotDAO {


	public String checkData(ForgotModel fm) {
	    String status = "failure";
	    String login = fm.getLogin();

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");


	        if (login.equals("Admin")) {
	        	PreparedStatement    ps11 = con.prepareStatement("select adm_username,mail_id from vcube_admin where adm_username = ? and mail_id = ?");

	            ps11.setString(1, fm.getUsername());
	            ps11.setString(2, fm.getEmail());
	            ResultSet rsa =  ps11.executeQuery();

	            if (rsa.next()) {

	                    status = "SUCCESS";
	                }
	            }
	         else if (login.equals("Faculty")) {
	        	 PreparedStatement   ps21 = con.prepareStatement( "select faculty_Username,faculty_Gmail from faculty where faculty_Username = ? and faculty_Gmail = ?");

	            ps21.setString(1, fm.getUsername());
	            ps21.setString(2, fm.getEmail());
	            ResultSet rsf = ps21.executeQuery();

	            if (rsf.next()) {


	                    status = "SUCCESS";
	                }
	            }
	         else {
	        	 PreparedStatement  ps3 = con.prepareStatement("select stud_username,stud_mail from student where stud_username = ? and stud_mail = ?");
	            ps3.setString(1, fm.getUsername());
	            ps3.setString(2, fm.getEmail());
	            ResultSet rss = ps3.executeQuery();

	            if (rss.next()) {

	                    status = "SUCCESS";
	                }
	            }
	        }
	     catch (Exception e) {
	        System.out.println(e);
	        e.printStackTrace();
	    }
        System.out.println(status);
	    return status;
	}

	public String updateData(ForgotModel fm) {
	    String status = "failure";
	    String login = fm.getLogin();
	    System.out.println("query : "+login);

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");

	        if (login.equals("Admin")) {
	        	PreparedStatement  ps1 = con.prepareStatement("update vcube_admin set adm_pass=?where adm_username = ?");

	            ps1.setString(1, fm.getPass());
	            ps1.setString(2, fm.getUsername());
	            int n = ps1.executeUpdate();

	            if (n>0) {

	                    status = "SUCCESS";
	                }
	            }
	         else if (login.equals("Faculty")) {
	        	 PreparedStatement  ps2 = con.prepareStatement( "update faculty set faculty_Password=? where faculty_Username = ?");

	             ps2.setString(1, fm.getPass());
		         ps2.setString(2, fm.getUsername());
	            int n = ps2.executeUpdate();

	            if (n>0) {

	                    status = "SUCCESS";
	                }
	            }
	         else {
	         PreparedStatement ps3 = con.prepareStatement("update student set stud_pass=?  where stud_username = ?");
	            ps3.setString(1, fm.getPass());
	            ps3.setString(2, fm.getUsername());

	            int n = ps3.executeUpdate();

	            if (n>0) {

	                    status = "SUCCESS";
	                }
	            }
	        }
	     catch (Exception e) {
	        System.out.println(e);
	        e.printStackTrace();
	    }
            System.out.println(status);
            System.out.println("user:"+fm.getUsername());
            System.out.println("pass:"+fm.getPass());
	    return status;
	}
}
