package com.hotelproject.tablebooking.service;

import org.springframework.stereotype.Service;

import com.hotelproject.tablebooking.model.AdminLogin;


public interface AdminLoginService {

	public AdminLogin findMobilenumber(String Mobilenumber);
}
