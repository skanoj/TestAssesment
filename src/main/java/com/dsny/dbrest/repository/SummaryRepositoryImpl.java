package com.dsny.dbrest.repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.group;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.match;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.project;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import com.dsny.dbrest.domain.DayAttendee;
import com.dsny.dbrest.domain.DaySummary;
import com.dsny.dbrest.domain.LocationAttendee;
import com.dsny.dbrest.domain.LocationSummary;
import com.dsny.dbrest.domain.Summary;

public class SummaryRepositoryImpl implements SummaryRepositoryCustom{
	    
	private final MongoTemplate mdbTemplate; 
	
	@Autowired
	public SummaryRepositoryImpl(MongoTemplate mdbTemplate){
		this.mdbTemplate = mdbTemplate;
	}
	

	@Override
	public LocationSummary getAggregateByLoc(String location) {
		   		   
  
		  MatchOperation matchOperation = getMatchOperation(location);
		  GroupOperation groupOperation = getGroupOperation();
		  ProjectionOperation projectionOperation = getProjectOperation();
	      
	      List<DayAttendee> lstDayAttendee= mdbTemplate.aggregate(Aggregation.newAggregation(matchOperation,groupOperation,projectionOperation), Summary.class, DayAttendee.class).getMappedResults();
		
		  LocationSummary locSummary = new LocationSummary(location, lstDayAttendee);  
		  return locSummary;
		}
	
	 private MatchOperation getMatchOperation(String location) {
	        Criteria locCriteria = where("location").is(location.toUpperCase());
	        return match(locCriteria);
	    }
	 
	    private GroupOperation getGroupOperation() {
	        return group("dayOfWeek").sum("attendees").as("attendees");
	    }
	    
	    private ProjectionOperation getProjectOperation() {
	        return project("dayOfWeek", "attendees").and("day").previousOperation();
	    }


		@Override
		public DaySummary getAggregateByDay(String day) {
			  MatchOperation matchOperation1 = getMatchOperation1(day);
			  GroupOperation groupOperation1 = getGroupOperation1();
			  ProjectionOperation projectionOperation1 = getProjectOperation1();
			  
			  List<LocationAttendee> locAttendee = mdbTemplate.aggregate(Aggregation.newAggregation(matchOperation1,groupOperation1,projectionOperation1), Summary.class, LocationAttendee.class).getMappedResults();
			  DaySummary daySummary = new DaySummary(day, locAttendee);
			return daySummary;
		}

		
		
		 private MatchOperation getMatchOperation1(String day) {
		        Criteria locCriteria = where("dayOfWeek").is(day.toUpperCase());
		        return match(locCriteria);
		    }

		    private GroupOperation getGroupOperation1() {
		        return group("location").sum("attendees").as("attendees");
		    }

		    private ProjectionOperation getProjectOperation1() {
		        return project("location", "attendees")
		                .and("location").previousOperation();
		    }
	
}
