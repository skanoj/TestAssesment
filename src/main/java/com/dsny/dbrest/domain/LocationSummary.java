package com.dsny.dbrest.domain;


public class LocationSummary {

	public String dayOfWeek;
	public int sumAttendees;
	
	public LocationSummary(String dayOfWeek, int sumAttendees) {
		this.dayOfWeek = dayOfWeek;
		this.sumAttendees = sumAttendees;
	}
	
	public void setSumAttendees(int sumAttendees) {
		this.sumAttendees = sumAttendees;
	}
	public int getSumAttendees() {
		return sumAttendees;
	}

	
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	@Override
	public String toString() {
		return "LocationSummary [dayOfWeek=" + dayOfWeek + ", sumAttendees="
				+ sumAttendees + "]";
	}

}
