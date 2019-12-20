package com.mindtree.trainbookingapp.service.impl;

import java.util.ArrayList;

import com.mindtree.trainbookingapp.dao.impl.DaoTrainImpl;
import com.mindtree.trainbookingapp.entity.BookingInfo;
import com.mindtree.trainbookingapp.exception.DaoTrainException;
import com.mindtree.trainbookingapp.exception.NoSuchDestinationException;
import com.mindtree.trainbookingapp.exception.NoSuchSourceException;
import com.mindtree.trainbookingapp.exception.NoSuchTrainException;
import com.mindtree.trainbookingapp.exception.NoSuchUserException;
import com.mindtree.trainbookingapp.exception.TrainServiceException;

public class TrainServiceImpl {

	static DaoTrainImpl dao=new DaoTrainImpl();
	
	
	public ArrayList<String> displayTrainInfo(String source, String destination) throws TrainServiceException {
		// TODO Auto-generated method stub
		ArrayList<String> trains=new ArrayList<String>();
		try {
		 trains=dao.displayTrainInfo(source,destination);
		}catch(DaoTrainException e)
		{
			throw new TrainServiceException("exception in daotrain layer");
		}
		return trains;
	}



	public ArrayList<BookingInfo> displayBookingDetails() throws TrainServiceException {
		ArrayList<BookingInfo> al=new ArrayList<>();
		try {
		al=dao.displayBookingDetails();
		}catch(DaoTrainException e)
		{
			throw new TrainServiceException("exception in daotrain layer");
		}
		
		return al;
		
		
	}

	public void bookTicket(int userId, int trainId) throws TrainServiceException {
		// TODO Auto-generated method stub
		try {
			
			System.out.println("inside serice layer"+userId+" "+trainId);
		dao.bookTicket(userId,trainId);
		}catch(DaoTrainException e)
		{
			e.printStackTrace();
			throw new TrainServiceException("exception in  train service layer");
		}
		
	}



	public void validatetrainId(int trainId)throws NoSuchTrainException {
		dao.validatetrainId(trainId);
		
	}



	public void validatesource(String source) throws NoSuchSourceException {
		dao.validatesource(source);
		
	}



	public void validatedestination(String destination) throws NoSuchDestinationException {
	   dao.validatedestination(destination);
		
	}



	public void validateuserid(int userId) throws NoSuchUserException {
		dao.validatetrainId(trainId);
		
	}

}
