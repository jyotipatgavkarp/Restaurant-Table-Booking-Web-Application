package com.hotelproject.tablebooking.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelproject.tablebooking.model.AdminLogin;

@Repository
public interface AdminLoginRepo extends JpaRepository <AdminLogin, Integer> {

	
	public AdminLogin findByMobilenumber(String Mobilenumber);
}
