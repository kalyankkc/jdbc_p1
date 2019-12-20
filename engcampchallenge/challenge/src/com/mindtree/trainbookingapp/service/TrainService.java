package com.mindtree.trainbookingapp.service;

import java.util.ArrayList;

import com.mindtree.trainbookingapp.dao.impl.DaoTrainImpl;

public interface TrainService {

	
	
	
	public ArrayList<String> displayTrainInfo(String source, String destination);
	
	public void bookTicket(int userid,int trainid);
}
