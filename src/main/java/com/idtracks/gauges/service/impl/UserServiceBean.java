package com.idtracks.gauges.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idtracks.gauges.domain.User;
import com.idtracks.gauges.service.UserService;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Service("userService")
@Transactional
public class UserServiceBean implements UserService  {
	
	protected static Logger logger = Logger.getLogger("service");
	
	@Resource(name="mongoTemplate")
	private MongoTemplate mongoTemplate;
	
	@Resource(name="gridFsTemplate")
	private GridFsTemplate gridFsTemplate;
	
	@Resource(name="mongoDbFactory")
	private MongoDbFactory mongoDbFactory;
	
	/**
	 * Adds a new User
	 */
	public String  addUser(User user) {
		String result = "";
		logger.debug("Adding a new user");
		try {
			// Set a new value to the pid property first since it's blank
			//user.setUid(UUID.randomUUID().toString());
			// Insert to db
			User addUser = new User(UUID.randomUUID().toString(),user.getUserName(),user.getPassword(), user.getEmail(),user.getOpenId(),user.getFullName(),user.getFirstName(),user.getLastName(),user.getGender(), user.getDob());
			if(addUser.getOpenId()!=null){
				addUser.setPassword("");
				addUser.setGender("");
				addUser.setDob("");
			}
		     mongoTemplate.insert(addUser);
			  result = "sucess";
		  }catch (Exception e) {
			logger.error("An error has occurred while trying to add new user", e);
			String loString = e.getLocalizedMessage();
			if(loString.contains("$emailunique")){
				result = "duplicateEmail";
			}
		}
		return result;
	}
	
	
	/**
	 * Adds a new User
	 */
	public Boolean updateUser(User user) {
		logger.debug("Updateing a existing user");
		try {
			Query query = new Query(Criteria.where("uid").is(user.getUid()));
			query.addCriteria(Criteria.where("openId").is(user.getOpenId()));
			Update update = new Update();
			User user2 = mongoTemplate.findAndModify(query, update, User.class); // return's old person object
			return true;
		} catch (Exception e) {
			logger.error("An error has occurred while trying to add new user", e);
			return false;
		}
	}
	
	/**
	 * Retrieves a single person
	 */
	public User getUser(String userName, String password ) {
		logger.debug("Retrieving an existing person");
		// Find an entry where pid matches the id
        Query query = new Query(Criteria.where("userName").is(userName));
        query.addCriteria(Criteria.where("password").is(password));
        // Execute the query and find one matching entry
        User user = mongoTemplate.findOne(query, User.class);
    	if(user!= null){
    		return user;
    	}else{
    		query = new Query(Criteria.where("email").is(userName));
            query.addCriteria(Criteria.where("password").is(password));
            user = mongoTemplate.findOne(query, User.class);
    	}
    	if(user == null){
    		query = new Query(Criteria.where("email").is(userName));
            user = mongoTemplate.findOne(query, User.class);
            if(user!=null){
             user.setPassword("");
            } 
    	}  
        return user;
	}
	
	public User findUserByOpenId(String openId){
		   Query query = new Query(Criteria.where("openId").is(openId));
		   User user = mongoTemplate.findOne(query, User.class);
	       return user;	
	}


	public String checkDuplicateEmail(String email) {
		Query query = new Query(Criteria.where("email").is(email));
        User user = mongoTemplate.findOne(query, User.class);
		if(user!=null){
			return "true";
		}else{
			return "false";
		}
	}
	 
	 public byte[] getUserProfilePicture(String fileName){
		  
			// get image file by it's filename
			  GridFS gfsPhoto = new GridFS(mongoDbFactory.getDb(), "userprofileImg");
				GridFSDBFile imageForOutput = gfsPhoto.findOne(fileName);
				 InputStream inputStream = imageForOutput.getInputStream();
				 byte[] bytes =null;
				 try {
					 bytes = IOUtils.toByteArray(inputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return bytes; 
	 }
	 
	 private String saveUserProfileImg(byte[] byteContent, String filename,String bucket) throws IOException {

			// File imageFile = new File(fileLocation);
			 GridFS gfsPhoto = new GridFS(mongoDbFactory.getDb(), bucket);
			// GridFSInputFile gfsFile = gfsPhoto.createFile(imageFile);
			  GridFSInputFile gfsFile = gfsPhoto.createFile(byteContent);
			 gfsFile.setFilename(filename);
			 gfsFile.save();
			 return "sucess";
		 }
}
