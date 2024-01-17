package com.hotelproject.tablebooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.hotelproject.tablebooking.model.Tables;
import com.hotelproject.tablebooking.repo.TableRepo;


public interface TableService {


	boolean AddNewTable(Tables t);
	
	List<Tables> getAllTables();

	Tables getByTableNumber(int tablenum);
	
	public void deleteByTableNumber(int tablenum);
	
}
