package com.mindtree.trainbookingapp.dao.impl;

import java.util.ArrayList;
import java.sql.*;
import com.mindtree.trainbookingapp.dao.DaoTrain;
import com.mindtree.trainbookingapp.entity.BookingInfo;
import com.mindtree.trainbookingapp.exception.DaoTrainException;
import com.mindtree.trainbookingapp.utiliy.DBConnection;

public class DaoTrainImpl implements DaoTrain {

	public ArrayList<String> displayTrainInfo(String source, String destination) throws DaoTrainException {
		
	  ArrayList<String> trains=new ArrayList<String>();
		try {
		Connection connection =DBConnection.getDbConnection();
		PreparedStatement pst;
		pst=connection.prepareStatement("select *from traininfo where source=? and destination=?");
		pst.setString(1, source);
		pst.setString(2, destination);
		ResultSet rs=pst.executeQuery();
		while(rs.next()) {
			trains.add(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getInt(5)+" "+rs.getInt(6));
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
			throw new DaoTrainException("exception inside daotrain layer");
		}
		
		return trains;
	
		
	}

	public void bookTicket(int userId, int trainId) throws DaoTrainException  {
		try {
			//System.out.println("inside serice dao layer"+userId+" "+trainId);
		Connection connection =DBConnection.getDbConnection();
		PreparedStatement pst;
		
		pst=connection.prepareStatement("select fare from traininfo where t_id=?");
		pst.setInt(1, trainId);
		ResultSet rs=pst.executeQuery();
		rs.next();
		int fare=rs.getInt(1);
		System.out.println("fare is"+fare);
		
		pst=connection.prepareStatement("insert into bookinginfo values(?,?,?)");
		pst.setInt(1, userId);
		pst.setInt(2, trainId);
		pst.setInt(3, fare);
		pst.executeUpdate();
		System.out.println("booking sucessfull and ticket fare is"+fare);
	}catch(SQLException e)
		{
		e.printStackTrace();
		throw new DaoTrainException("exception inside daotrain layer");
		}

}

	public ArrayList<BookingInfo> displayBookingDetails() throws DaoTrainException {
		
		ArrayList<BookingInfo> al=new ArrayList<>();
		try {
		Connection connection =DBConnection.getDbConnection();
		PreparedStatement pst;
		pst=connection.prepareStatement("select * from bookinginfo ");	
		ResultSet rs=pst.executeQuery();
		BookingInfo temp;
		
		while(rs.next())
		{
			temp=new BookingInfo();
			temp.setUserId(rs.getInt(1));
			temp.setTrainId(rs.getInt(2));
			temp.setFare(rs.getInt(3));
			al.add(temp);
		}
	}catch(SQLException e)
		{
		throw new DaoTrainException("exception inside daotrain layer");
		}
		return al;
}

	public int validatetrainId(int trainId) throws DaoTrainException {
		try {
		Connection connection =DBConnection.getDbConnection();
		PreparedStatement pst;
		pst=connection.prepareStatement("select t_id from traininfo where t_id=? ");	
		pst.setInt(1, trainId);
		ResultSet rs=pst.executeQuery();
		rs.next();
		if(rs.next())
		{
			return 0;
		}
		}catch(SQLException e)
		{
			throw new DaoTrainException("exception inside daotrain layer");
		}
		return 1;
	}

	public void validatesource(String source) {
		// TODO Auto-generated method stub
		
	}

	public void validatedestination(String destination) {
		// TODO Auto-generated method stub
		
	}
}
