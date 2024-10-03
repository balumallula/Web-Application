package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Model.LoginModel;

public class LoginDAO {

	public String fetchData(LoginModel lm) {
		String status="failure";
		String login = lm.getLogin();
 		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/application", "root", "root");
	        if(login.equals("Admin")) {
			 PreparedStatement ps = con.prepareStatement("select adm_username,adm_pass from vcube_admin where adm_username=? and adm_pass=?");
			 ps.setString(1, lm.getUsername());
			 ps.setString(2, lm.getPassword());
				ResultSet n = ps.executeQuery();
				while(n.next()) {
					status="SUCCESS";
				}
	        }
	        else if(login.equals("Faculty")) {
				 PreparedStatement ps = con.prepareStatement("select faculty_Username,faculty_Password from faculty where faculty_Username=? and faculty_Password=?");
				 ps.setString(1, lm.getUsername());
				 ps.setString(2, lm.getPassword());
					ResultSet n = ps.executeQuery();
					while(n.next()) {
						status="SUCCESS";
					}
		        }else {
		        	 PreparedStatement ps = con.prepareStatement("select stud_username,stud_pass from student where stud_username=? and stud_pass=?");
					 ps.setString(1,lm.getUsername());
					 ps.setString(2,lm.getPassword());
						ResultSet n = ps.executeQuery();
						while(n.next()) {
							status="SUCCESS";
						}
		        }

		}
		catch(Exception e) {
			System.out.println(e);
		}


		return status;
	}
}
