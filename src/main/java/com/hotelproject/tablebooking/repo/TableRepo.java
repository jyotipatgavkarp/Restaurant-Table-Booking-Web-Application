package com.hotelproject.tablebooking.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hotelproject.tablebooking.model.Tables;


@Repository
public interface TableRepo extends JpaRepository<Tables, Long> {

	
	@Query(value=" Select table_no from Tables ",nativeQuery=true)
	 public List<Integer> getAllTableNo();
	
	
	Tables findByTableNo(int tableNo);
	
//	@Modifying
//	@Query(value = "UPDATE Tables SET booked_by = :bookedBy WHERE table_no = :tablenumber", nativeQuery = true)
//	void updateTableStatus(@Param("tablenumber") int tableNo, @Param("bookedBy") String bookedBy);
	
	void deleteByTableNo(int tableNo);

	
}
