package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.Userpojo;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class UserTestsDD {

	//yet to do - pass all values as HashMap
	@Test (priority=1, dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testCreateMultipleUsers(String userID, String userName, String firstName, String lastName, String useremail, String password, String phone ) {
		Userpojo userPayload = new Userpojo();
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(useremail);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	
	
	@Test (priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testDeleteMultipleUsers(String userName) {
		Response response = UserEndPoints.deleteUser(userName);
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	
	
}
