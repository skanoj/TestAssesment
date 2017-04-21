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
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dsny.dbrest.domain.LocationSummary;
import com.dsny.dbrest.domain.Summary;

public class SummaryRepositoryImpl implements SummaryRepositoryCustom{
	    
	private final MongoTemplate mdbTemplate;
	
	@Autowired
	public SummaryRepositoryImpl(MongoTemplate mdbTemplate){
		this.mdbTemplate = mdbTemplate;
	}

	@Override
	public List<LocationSummary> getAggregateByLoc(String location) {
		   MatchOperation matchOperation = getMatchOperation(location);
	       GroupOperation groupOperation = getGroupOperation();
	       ProjectionOperation projectionOperation = getProjectOperation();
		 
	        return mdbTemplate.aggregate(Aggregation.newAggregation(
	                matchOperation,groupOperation, projectionOperation), Summary.class, LocationSummary.class).getMappedResults();
	        
	        
	}
	
	@Override
	public List<LocationSummary> getAggregateByDay(String day) {
		   MatchOperation matchOperation1 = getMatchOperation1(day);
	       GroupOperation groupOperation1 = getGroupOperation1();
	       ProjectionOperation projectionOperation1 = getProjectOperation1();
		 
	        return mdbTemplate.aggregate(Aggregation.newAggregation(
	                matchOperation1,groupOperation1, projectionOperation1), Summary.class, LocationSummary.class).getMappedResults();
	        
	        
	}
	
	
	 private MatchOperation getMatchOperation(String location) {
	        Criteria locCriteria = where("location").is(location);
	        return match(locCriteria);
	    }

	    private GroupOperation getGroupOperation() {
	        return group("dayOfWeek")
	                .last("dayOfWeek").as("dayOfWeek")
	                .sum("attendees").as("sumAttendees");
	    }

	    private ProjectionOperation getProjectOperation() {
	        return project("location", "dayOfWeek", "attendees")
	                .and("location").previousOperation();
	    }

		 private MatchOperation getMatchOperation1(String location) {
		        Criteria locCriteria = where("location").is(location);
		        return match(locCriteria);
		    }

		    private GroupOperation getGroupOperation1() {
		        return group("dayOfWeek")
		                .last("dayOfWeek").as("dayOfWeek")
		                .sum("attendees").as("sumAttendees");
		    }

		    private ProjectionOperation getProjectOperation1() {
		        return project("location", "dayOfWeek", "attendees")
		                .and("location").previousOperation();
		    }

}
