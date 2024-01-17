package com.hotelproject.tablebooking.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
@Entity
public class Tables {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int tableNo;
    private boolean booked;
    private String bookedBy; 
    
    public Tables(){
    	
    }
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getTableNo() {
		return tableNo;
	}
	public void setTableNo(int tableNo) {
		this.tableNo = tableNo;
	}
	public boolean isBooked() {
		return booked;
	}
	public void setBooked(boolean booked) {
		this.booked = booked;
	}
	public String getBookedBy() {
		return bookedBy;
	}
	public Tables( int tableNo, boolean booked, String bookedBy) {
		super();
		
		this.tableNo = tableNo;
		this.booked = booked;
		this.bookedBy = bookedBy;
	}

	public Tables(Long id, int tableNo, boolean booked, String bookedBy) {
		super();
		this.id = id;
		this.tableNo = tableNo;
		this.booked = booked;
		this.bookedBy = bookedBy;
	}
	public void setBookedBy(String bookedBy) {
		this.bookedBy = bookedBy;
	}
    
}

