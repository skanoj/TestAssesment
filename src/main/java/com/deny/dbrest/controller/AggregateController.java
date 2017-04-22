package com.deny.dbrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dsny.dbrest.domain.DaySummary;
import com.dsny.dbrest.domain.LocationSummary;
import com.dsny.dbrest.repository.SummaryRepositoryCustom;

@RestController
@RequestMapping("/Assesment")
public class AggregateController {
	
	@Autowired
	SummaryRepositoryCustom srCustom;
	
    @GetMapping("/location")
    public LocationSummary getLocationSummary(@RequestParam("locationid") String locationId) {

    	 return srCustom.getAggregateByLoc(locationId);
    }
    
    @GetMapping("/day")
    public DaySummary getWeekDaySummary(@RequestParam("day") String day) {

    	 return srCustom.getAggregateByDay(day);
    }
	
}