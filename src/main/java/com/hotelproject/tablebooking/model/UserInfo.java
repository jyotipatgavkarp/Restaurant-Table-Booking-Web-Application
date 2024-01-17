package com.hotelproject.tablebooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
public class UserInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String name;
	private String phone;
	@Email
	private String email;
	private String bookingtime;
	private String bookingdate;
	private int numofpersons;
	private int bookingstatus;
	private int tablenumber;
	
  
	public int getTablenumber() {
		return tablenumber;
	}
	public void setTablenumber(int tablenumber) {
		this.tablenumber = tablenumber;
	}
	public String getName() {
		return name;
	}
	public int getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(int bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBookingtime() {
		return bookingtime;
	}
	public void setBookingtime(String bookingtime) {
		this.bookingtime = bookingtime;
	}
	public String getBookingdate() {
		return bookingdate;
	}
	public void setBookingdate(String bookingdate) {
		this.bookingdate = bookingdate;
	}
	public int getNumofpersons() {
		return numofpersons;
	}
	public void setNumofpersons(int numofpersons) {
		this.numofpersons = numofpersons;
	}
}
