package com.hotelproject.tablebooking.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelproject.tablebooking.email.GEmailSender;
import com.hotelproject.tablebooking.model.AdminLogin;
import com.hotelproject.tablebooking.model.Tables;
//import com.hotelproject.tablebooking.EmailSender;
//import com.hotelproject.tablebooking.model.EmailRequest;
import com.hotelproject.tablebooking.model.UserInfo;
import com.hotelproject.tablebooking.repo.AdminLoginRepo;
import com.hotelproject.tablebooking.repo.TableRepo;
import com.hotelproject.tablebooking.service.AdminLoginService;
import com.hotelproject.tablebooking.service.TableService;
import com.hotelproject.tablebooking.service.UserInfoService;

import jakarta.mail.MessagingException;

@RestController
@CrossOrigin
public class Mycontroller {

	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	AdminLoginService adminLoginService;
	
	@Autowired
	TableService tableService;
	
	@Autowired
	TableRepo tr;
	
    @RequestMapping("login")
    public int loginmethod(@RequestBody AdminLogin adminLogin)
    {
    	// check mobile and password is same
    	
     	 System.out.println("in login");
         String mobile = adminLogin.getMobilenumber();
         String password = adminLogin.getPassword();
         System.out.println(mobile+" "+password);
         
         AdminLogin data = adminLoginService.findMobilenumber(mobile);
         if(data==null || !(password.equals(data.getPassword())))
         {
         	System.out.println("not matching");
         	return 0;
         	
         }
         else
         {        	
        	 System.out.println("matching");
         	return 1; // admin       	       	 
         }                   
     
    }
	
    
	@RequestMapping("MakingBooking")
	public boolean MakingBooking(@RequestBody UserInfo userinfo )
	{
	    userInfoService.MakingBooking(userinfo);
	    System.out.println("data saved");
	    return true;
	}
	
	@GetMapping("getUsersList")
	public List<UserInfo> listofUsers()
	{
		System.out.println("In User List");
		List<UserInfo> list = userInfoService.ShowUsers();
		return list;
	}
	@RequestMapping("delete{id}tableno{tablenum}")
	public Boolean deleteUser(@PathVariable("id") int id, @PathVariable("tablenum") int tablenum)
	{
		System.out.println("in delete");
		
	    try
	    {	
	    	
	    System.out.println(tablenum);
	    
	    if(tablenum<=0 ) {
	    	userInfoService.deleteUser(id);		
	    	return true;
	    }
		Tables existingTable = tableService.getByTableNumber(tablenum);
		existingTable.setBooked(false);
		existingTable.setBookedBy("none");
		System.out.println("table set in original ");
		userInfoService.deleteUser(id);		
		return true;
		
		}
		catch (Exception e ) 
		{
		  return false;
	    }
	}
	@RequestMapping("book{tablenum}")
	public Boolean BookedUser(@RequestBody UserInfo user,@PathVariable int tablenum)
	{
		
	try {
		
		System.out.println("in confirm booking");
		System.out.println("saving new table");
				
		Tables existingTable = tableService.getByTableNumber(tablenum);
        System.out.println(existingTable.getBookedBy()+" "+existingTable.getTableNo());
		if (existingTable!=null && !existingTable.isBooked())
		{
		    // Table with the specified tablenum already exists, update it
    	    existingTable.setBooked(true);
		    existingTable.setBookedBy(user.getName());
			
			String name=user.getName();	
		  //  tr.updateTableStatus(tablenum, name); 
		    
		} 
		else
		{
		   // Table with the specified tablenum doesn't exist, create a new one
		    Tables newTable = new Tables(tablenum, true, user.getName());
		    tr.save(newTable);
		}
		
		
		userInfoService.makeBooking(user);
				
		GEmailSender gEmailSender = new GEmailSender();
		String toemail=user.getEmail();
		String to =toemail;
		String from="jyotipatgavkar05@gmail.com";
		String subject = "Table Booking Confirmation !!! ";
	
		String message = "Dear " + user.getName() + ",\n\n"
		        + "We are delighted to inform you that your booking on "
		        + user.getBookingdate() + " at " + user.getBookingtime() + " has been successfully confirmed!\n\n"
		        + "Details of your reservation:\n"
		        + "Table Number: " + user.getTablenumber() + "\n\n"
		        + "We look forward to serving you and hope you have a wonderful dining experience.\n\n"
		        + "Thank you for choosing our establishment.\n\n"
		        + "Best regards,\n"
		        + "The Taj Hotel Team ";
		
		boolean b = gEmailSender.sendEmail(to, from, subject, message);
		if (b)
		{
	        System.out.println("Email sent successfully");
	        return true;
	    } 
		else 
		{
	        System.out.println("Failed to send email");
	        return false;   // Return false to indicate an issue with sending the email
	    }
		
	}
		catch (Exception e ) 
		{
          e.printStackTrace();
          System.out.println(e);
		  return false;
		
	    }
	
	}
	
	
	
	@RequestMapping("FindBydate/{Bookingdate}")
	public List<UserInfo> findUsersbyDate(@PathVariable("Bookingdate") String Bookingdate)
	{
		 List<UserInfo> list = userInfoService.search(Bookingdate);
		 return list;
	}
	
	@RequestMapping("addingtables{tableNo}")
	public int addingTables(@PathVariable("tableNo") int tableNo)
	{
		System.out.println("table number "+tableNo);
		System.out.println("saving tab");
		Tables t=new Tables((long) 1000,tableNo,false,"none");
		 boolean res=tableService.AddNewTable(t);
		if(res)
		{			
			return 1;	
		}

	    else
		{
		  return -1;
		}
		
	}
	//getUsersPendingList
	@GetMapping("getUsersPendingList")
	public List<UserInfo> listofUsersPending()
	{
		System.out.println("In User Pending List");
		
		List<UserInfo> list = userInfoService.getpendingUsers();
		return list;
		
	}
	@RequestMapping("getUserAcceptedList")
	public List<UserInfo> listOfConfirmedUsers()
	{
		
		System.out.println("in accpeted list ");
		List<UserInfo> list = userInfoService.getConfirmedUsers();
		System.out.println(list);
		return list;
		
	}	
	
	@RequestMapping("getBookedTables")
	public List<Tables> bookedTables()
	{
		System.out.println("getBookedTables");
		List<Tables> list =tableService.getAllTables();
		for(Tables data:list)
		System.out.println(data.getBookedBy()+" "+data.getTableNo());
		return list;
	}
	
	
	
	
}