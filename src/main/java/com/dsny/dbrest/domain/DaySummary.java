package com.dsny.dbrest.domain;

import java.util.List;

public class DaySummary {

	public String location;
    public List<LocationAttendee> locationAttendee;
    
	public DaySummary(String location, List<LocationAttendee> locationAttendee) {
		super();
		this.location = location;
		this.locationAttendee = locationAttendee;
	}
	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<LocationAttendee> getLocationAttendee() {
		return locationAttendee;
	}
	public void setLocationAttendee(List<LocationAttendee> locationAttendee) {
		this.locationAttendee = locationAttendee;
	}

}
