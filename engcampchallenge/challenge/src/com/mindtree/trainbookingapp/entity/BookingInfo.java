package com.mindtree.trainbookingapp.entity;

public class BookingInfo implements Comparable<BookingInfo>{
	private int userId;
	private int trainId;
	private int fare;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTrainId() {
		return trainId;
	}
	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}
	public int getFare() {
		return fare;
	}
	@Override
	public String toString() {
		return "BookingInfo [userId=" + userId + ", trainId=" + trainId + ", fare=" + fare + ", getUserId()="
				+ getUserId() + ", getTrainId()=" + getTrainId() + ", getFare()=" + getFare() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	@Override
	public int compareTo(BookingInfo arg0) {
		// TODO Auto-generated method stub
		return this.fare-arg0.fare;
	}

}
