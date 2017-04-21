package com.dsny.dbrest.domain;

public class DaySummary {

	public String location;
	public int sumAttendees;
	
	public DaySummary(String location, int sumAttendees) {
		this.location = location;
		this.sumAttendees = sumAttendees;
	}
	
	public void setSumAttendees(int sumAttendees) {
		this.sumAttendees = sumAttendees;
	}
	public int getSumAttendees() {
		return sumAttendees;
	}

	
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "LocationSummary [location=" + location + ", sumAttendees="
				+ sumAttendees + "]";
	}
}
