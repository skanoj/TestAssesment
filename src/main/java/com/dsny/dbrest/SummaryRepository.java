package com.dsny.dbrest;

import com.dsny.dbrest.domain.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

@RepositoryRestResource(collectionResourceRel = "summary", path = "summary")
@Component
public interface SummaryRepository extends MongoRepository<Summary, String>{

/*	@RestResource(path="location") //http://localhost:8080/summary/search/location?location=NY
	public List<Summary> findByLocation(@Param("location") String location);
	@RestResource(path="weekday") //http://localhost:8080/summary/search/weekday?day=MONDAY
	public List<Summary> findByDayOfWeek(@Param("day") String location);*/

}
