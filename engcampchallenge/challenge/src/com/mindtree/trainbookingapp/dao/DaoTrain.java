package com.mindtree.trainbookingapp.dao;

import java.util.ArrayList;

import com.mindtree.trainbookingapp.exception.DaoTrainException;

public interface DaoTrain {
	
	public ArrayList<String> displayTrainInfo(String source, String destination) throws DaoTrainException;

	public void bookTicket(int userId, int trainId) throws DaoTrainException;
}
