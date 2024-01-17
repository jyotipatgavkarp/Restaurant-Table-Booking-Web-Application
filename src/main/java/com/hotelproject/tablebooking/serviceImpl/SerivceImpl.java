package com.hotelproject.tablebooking.serviceImpl;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelproject.tablebooking.model.UserInfo;
import com.hotelproject.tablebooking.repo.UserInfoRepo;
import com.hotelproject.tablebooking.service.UserInfoService;

@Service
public class SerivceImpl implements UserInfoService {

	@Autowired
	UserInfoRepo userInfoRepo;

	@Override
	public boolean MakingBooking(UserInfo userInfo) {
		userInfoRepo.save(userInfo);
		return true;
	}

	@Override
	public List<UserInfo> ShowUsers() {
		List <UserInfo> list = userInfoRepo.findAll();
		return list;
	}
	@Override
	public void deleteUser(int id)
	{
		userInfoRepo.deleteById(id);
		return;
	}
	public void makeBooking(UserInfo user)
	{
		userInfoRepo.save(user);
		return ;
	}

	@Override
	public List<UserInfo> search(String date) {
	
	List<UserInfo> list= userInfoRepo.findByBookingdate(date);
		
      return list;				
	}

	@Override
	public List<UserInfo> getpendingUsers() {
		
		
	    List<UserInfo> list = userInfoRepo.pendingUsers();
		return list;	
	}

	@Override
	public List<UserInfo> getConfirmedUsers() {
	
		List<UserInfo> list1=userInfoRepo.acceptedUsers();
		return list1;
	}
	 
	
}
