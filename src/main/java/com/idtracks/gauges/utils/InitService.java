package com.idtracks.gauges.utils;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service for initializing MongoDB with sample data
 * <p>
 * For a complete reference to MongoDB
 * see http://www.mongodb.org/
 * <p>
 * For transactions, see http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/transaction.html
 * 
 * @author Krams at {@link http://krams915@blogspot.com}
 */
@Transactional
public class InitService {

	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="mongoTemplate")
	private MongoTemplate mongoTemplate;

	private void init() {
		// Populate our MongoDB database
		logger.debug("Init MongoDB users");
		
		// Drop existing collection
		//mongoTemplate.dropCollection("mycollection");
	
		// Create new object
	/*	Person p = new Person ();
		p.setPid(UUID.randomUUID().toString());
		p.setFirstName("John");
		p.setLastName("Smith");
		p.setMoney(1000.0);*/
	}
}
