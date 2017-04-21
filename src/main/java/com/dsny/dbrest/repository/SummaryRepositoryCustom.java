package com.dsny.dbrest.repository;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dsny.dbrest.domain.LocationSummary; 

@Component 
public interface SummaryRepositoryCustom {
	
	@RestResource(path="locgroup")
	public List<LocationSummary> getAggregateByLoc(@Param("location") String location);

	@RestResource(path="daygroup")
	public List<LocationSummary> getAggregateByDay(@Param("day") String day);
}
