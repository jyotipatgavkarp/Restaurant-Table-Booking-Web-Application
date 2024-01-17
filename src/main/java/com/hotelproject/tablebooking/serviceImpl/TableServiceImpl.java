package com.hotelproject.tablebooking.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelproject.tablebooking.model.Tables;
import com.hotelproject.tablebooking.repo.TableRepo;
import com.hotelproject.tablebooking.service.TableService;

@Service
public class TableServiceImpl implements TableService {

	@Autowired
	TableRepo tableRepo;
	
	//@Override
	
//	public boolean AddTable(Tables t) {		
//          if( t.getTableNo()!=tableRepo.findByTableNo(t.getTableNo()))
//          {
//			tableRepo.save(t);	
//			  return true;
//          }
//          else 
//          {
//        	  return false;
//          }
//		  
//	}


	@Override
	public List<Tables> getAllTables() {
		
		List<Tables> list=tableRepo.findAll();
				
		return  list;
	}

	@Override
	public boolean AddNewTable(Tables t) {

		
		if(tableRepo.getAllTableNo().contains(t.getTableNo()))
		{
			return false;
		}
		else
		{
			 tableRepo.save(t);	
			  return true;
			
		}
        
		
	}

	@Override
	public Tables getByTableNumber(int tablenum) {
		Tables obj = tableRepo.findByTableNo(tablenum);	
		
		return obj;
	}

	@Override
	public void deleteByTableNumber(int tablenum) {
		
		tableRepo.deleteByTableNo(tablenum);
		
	}

	

	
     
	
}
