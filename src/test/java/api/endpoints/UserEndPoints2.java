package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.Userpojo;
import io.restassured.http.ContentType;

public class UserEndPoints2 {
	
	static ResourceBundle getUrl() {
		//User Resource Bundle to read the url from properties file
		ResourceBundle bundle = ResourceBundle.getBundle("routes");  //no need to give .properties ext
		return bundle;
	}
	
	
	// POST - Create a new user
	public static Response createUser(Userpojo userpayload) {
		String user_post_url = getUrl().getString("user_post_url");
		
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(userpayload)
							.when()								
								.post(user_post_url);
		
		return response;

	}

	// GET - Get details of an existing user
	public static Response getUser(String userName) {
		String user_get_url = getUrl().getString("user_get_url");
		Response response = given()
								.pathParam("username", userName)
							.when()
								.get(user_get_url);
		
		return response;
	}
	
	//UPDATE - Update details of an existing user
	public static Response updateUser(String userName, Userpojo userpayload) {
		String user_put_url = getUrl().getString("user_put_url");
		Response response = given()
								.pathParam("username", userName)
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(userpayload)
							.when()
								.put(user_put_url);
		
		return response;
	}
	
	
	// DELETE - Delete an existing user
		public static Response deleteUser(String userName) {
			String user_delete_url = getUrl().getString("user_delete_url");
			Response response = given()
									.pathParam("username", userName)
								.when()
									.delete(user_delete_url);
			
			return response;
		}
}
