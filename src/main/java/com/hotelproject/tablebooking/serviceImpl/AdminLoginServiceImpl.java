package com.hotelproject.tablebooking.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelproject.tablebooking.model.AdminLogin;
import com.hotelproject.tablebooking.repo.AdminLoginRepo;
import com.hotelproject.tablebooking.service.AdminLoginService;

@Service
public class AdminLoginServiceImpl implements AdminLoginService {

	@Autowired
	AdminLoginRepo adminLoginRepo;
	@Override
	public AdminLogin findMobilenumber(String Mobilenumber) {
		
	AdminLogin data= adminLoginRepo.findByMobilenumber(Mobilenumber);
		return data;
	}

	

}
