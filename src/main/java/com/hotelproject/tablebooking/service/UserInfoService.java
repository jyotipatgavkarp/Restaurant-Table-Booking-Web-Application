package com.hotelproject.tablebooking.service;

import java.util.List;
import java.util.Map;

import com.hotelproject.tablebooking.model.UserInfo;

public interface UserInfoService {

	
   public boolean MakingBooking(UserInfo userInfo);
   
   public List<UserInfo> ShowUsers();
   
   public void deleteUser(int id);
   
   public void makeBooking(UserInfo userInfo);
   
   public List<UserInfo> search(String date);
   
   public List<UserInfo> getpendingUsers();
   
   public List<UserInfo> getConfirmedUsers();
   
}
