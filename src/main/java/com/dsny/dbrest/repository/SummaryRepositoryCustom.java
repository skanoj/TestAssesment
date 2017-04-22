package com.dsny.dbrest.repository;

import org.springframework.stereotype.Component;

import com.dsny.dbrest.domain.DaySummary;
import com.dsny.dbrest.domain.LocationSummary;

@Component 
public interface SummaryRepositoryCustom {

	public LocationSummary getAggregateByLoc(String location); 
	
	public DaySummary getAggregateByDay(String day); 
	
	
	
}
