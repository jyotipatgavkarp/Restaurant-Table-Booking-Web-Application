package com.hotelproject.tablebooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hotelproject.tablebooking.model.UserInfo;

public interface UserInfoRepo extends JpaRepository<UserInfo, Integer> {

	public List<UserInfo> findByBookingdate(String Bookingdate);
	
	@Query(value=" select * from user_info where bookingstatus = 0; ",nativeQuery=true)
	public List<UserInfo> pendingUsers();
	
	@Query(value= "select * from user_info where bookingstatus = 1 ;", nativeQuery=true)
	public List<UserInfo> acceptedUsers();
	
}
