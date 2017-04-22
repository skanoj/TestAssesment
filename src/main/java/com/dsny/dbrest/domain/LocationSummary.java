package com.dsny.dbrest.domain;

import java.util.List;


public class LocationSummary {


	public String location;
    public List<DayAttendee> dayAttendee;
	
	public LocationSummary(String location, List<DayAttendee> dayAttendee) {
		super();
		this.location = location;
		this.dayAttendee = dayAttendee;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<DayAttendee> getDayAttendee() {
		return dayAttendee;
	}
	public void setDayAttendee(List<DayAttendee> dayAttendee) {
		this.dayAttendee = dayAttendee;
	}

	
	
	

}
