package com.mindtree.trainbookingapp.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import com.mindtree.trainbookingapp.entity.BookingInfo;
import com.mindtree.trainbookingapp.exception.NoSuchDestinationException;
import com.mindtree.trainbookingapp.exception.NoSuchSourceException;
import com.mindtree.trainbookingapp.exception.NoSuchTrainException;
import com.mindtree.trainbookingapp.exception.NoSuchUserException;
import com.mindtree.trainbookingapp.exception.TrainBookingAppRunnerException;
import com.mindtree.trainbookingapp.service.impl.TrainServiceImpl;
import com.mindtree.trainbookingapp.service.impl.UserServiceImpl;

public class TrainBookingAppRunner {
	
	
	
	
	
	
	
	
	static Scanner s=new Scanner(System.in);
	
	static TrainServiceImpl train =new TrainServiceImpl();
	
	static UserServiceImpl user =new UserServiceImpl();
 
	static ArrayList<String > trains =new ArrayList<String>();
	
	static ArrayList<BookingInfo > bookingDetails =new ArrayList<>();
	
	public static void main(String[] args) throws IOException  {
		int op;
		char ch;
		FileWriter writer = new FileWriter("C:\\Users\\M1056104\\Desktop\\output.txt"); 
		  //FileWriter fw = new FileWriter("C:\\Users\\M1056104\\Desktop\\output.txt ");
		BufferedWriter bw=new BufferedWriter(writer);
		try {
			do {
			System.out.println("enter the option\n1 To Book a ticket :"
					+ " \n2 TO show all the booking details in descending order:"
					+ " \n3 To write all the booking details in text file"
					);
			op=s.nextInt();
			s.nextLine();
			switch(op) 
			{
			case 1:System.out.println("please enter the info about the travel to book a ticket: ");
			       System.out.println("Enter the source");
			       String source=s.nextLine();
			       try{
			      train.validatesource(source);
			       }catch(NoSuchSourceException e)
			       {
			    	   System.out.println(" no such source");
			       }
			       System.out.println("enter the destination");
			       String destination=s.nextLine();
			       try
			       {
			       train.validatedestination(destination);
			       }catch(NoSuchDestinationException e)
			       {
			    	   System.out.println("no such destination");
			       }
			      trains=train.displayTrainInfo(source,destination);
			      for (String string : trains) {
					System.out.println(string);
				}
			      
			      System.out.println("plese provide the details of the train that u want to book for");
			      System.out.println("enter the userid");
			      int userId=s.nextInt();
			      try
			      {
			    	  train.validateuserid(userId);
			      }
			      catch(NoSuchUserException e)
			      {
			         System.out.println("no such user");
			      }
			       System.out.println("enter the trainid");
			       int trainId=s.nextInt();
			       
			       try {
			    	   train.validatetrainId(trainId);
			       }catch(NoSuchTrainException e)
			       {
			    	   System.out.println("no such train");
			       }
			       train.bookTicket(userId,trainId);
			break;
			 
			case 2:System.out.println("Booking details in descending order");
			       bookingDetails=train.displayBookingDetails();
			       Collections.sort(bookingDetails,Collections.reverseOrder());
			       for ( BookingInfo t : bookingDetails) {
					
			    	   System.out.println("train id:"+t.getTrainId()+"\tuser id:"+t.getUserId()+"\t fare "+t.getFare());
				}
		
			break;
			
			case 3:System.out.println("please check the text file");
			 bookingDetails=train.displayBookingDetails();
			 String tempstring="";
			   for ( BookingInfo t : bookingDetails) {
					//System.out.println(t.toString());
					System.out.println();
		    	   tempstring=tempstring+"train id:"+t.getTrainId()+"\tuser id:"+t.getUserId()+"\t fare "+t.getFare()+"\n";
			}
			       // System.out.println(tempstring);
			       bw.write(tempstring); 
			       bw.close();
			 
			
			break;
			
			default:System.out.println("enter the correct option");
			break;
			
			}
			
			System.out.println("do u want continue to continue y/n");
			ch=s.next().charAt(0);
			
		}while(ch!='n');
			}
		catch(TrainBookingAppRunnerException e)
			{
			    e.printStackTrace();
				System.out.println("exception in application layer");
			}
		
	}

}
