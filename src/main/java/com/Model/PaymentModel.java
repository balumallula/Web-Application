package com.Model;

public class PaymentModel {

	private int sno;
	private int studid;
	private int paid;
	private String date;

	public PaymentModel(int sno,int studid, int paid, String date) {
		super();
		this.sno = sno;
		this.studid = studid;
		this.paid = paid;
		this.date = date;
	}


	@Override
	public String toString() {
		return "PaymentModel [sno=" + sno + ", studid=" + studid + ", paid=" + paid + ", date=" + date + "]";
	}




	public int getSno() {
		return sno;
	}




	public void setSno(int sno) {
		this.sno = sno;
	}




	public int getStudid() {
		return studid;
	}
	public void setStudid(int studid) {
		this.studid = studid;
	}
	public int getPaid() {
		return paid;
	}
	public void setPaid(int paid) {
		this.paid = paid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public PaymentModel(){

	}


}
