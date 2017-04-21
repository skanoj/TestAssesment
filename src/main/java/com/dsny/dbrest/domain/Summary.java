package com.dsny.dbrest.domain;

import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

public class Summary {

	@Id
	public String id;
	public String location;
	public String dayOfWeek;
	public int attendees;
	
	public String getId() {
		return id;
	}
	public String getLocation() {
		return location;
	}
	public String getDayOfWeek() {
		return dayOfWeek;
	}
	public int getAttendees() {
		return attendees;
	}


	public Summary(String id, String location, String dayOfWeek, int attendees) {
		super();
		this.id = id;
		this.location = location;
		this.dayOfWeek = dayOfWeek;
		this.attendees = attendees;
	}

	@Override
	public String toString() {
		return "Summary [id=" + id + ", location=" + location + ", dayOfWeek="
				+ dayOfWeek + ", attendees=" + attendees + "]";
	}

}
