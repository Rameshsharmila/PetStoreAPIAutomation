package api.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.Userpojo;
import io.restassured.response.Response;

public class UserTests {
	
	Faker faker;
	Userpojo userpayload;
	
	
	public Logger logger;
	
	@BeforeClass
	public void setUpUserData() {
		faker = new Faker();
		userpayload = new Userpojo();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger = LogManager.getLogger(this.getClass());
	
	}
	
	
	
	@Test (priority=1)
	public void testCreateNewUser() {
		logger.info("-----Creating New User--------");
		Response response = UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		logger.info("-----Created New User--------");
	}
	
	
	@Test(priority=2)
	public void getUserDetails() {
		Response response = UserEndPoints.getUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test(priority=3)
	public void updateExistingUser() {
		//New payload to update existing data
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints.updateUser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		
		//Verify details are updated
		Response responseAfterUpdation = UserEndPoints.getUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	
	@Test(priority=4)
	public void deleteExistingUser() {
		Response response = UserEndPoints.deleteUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	

}
