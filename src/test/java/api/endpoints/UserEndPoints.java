package api.endpoints;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


import api.payload.Userpojo;
import io.restassured.http.ContentType;

public class UserEndPoints {

	// POST - Create a new user
	public static Response createUser(Userpojo userpayload) {
		Response response = given()
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(userpayload)
							.when()								
								.post(Routes.user_post_url);
		
		return response;

	}

	// GET - Get details of an existing user
	public static Response getUser(String userName) {
		Response response = given()
								.pathParam("username", userName)
							.when()
								.get(Routes.user_get_url);
		
		return response;
	}
	
	//UPDATE - Update details of an existing user
	public static Response updateUser(String userName, Userpojo userpayload) {
		Response response = given()
								.pathParam("username", userName)
								.contentType(ContentType.JSON)
								.accept(ContentType.JSON)
								.body(userpayload)
							.when()
								.put(Routes.user_put_url);
		
		return response;
	}
	
	
	// DELETE - Delete an existing user
		public static Response deleteUser(String userName) {
			Response response = given()
									.pathParam("username", userName)
								.when()
									.delete(Routes.user_delete_url);
			
			return response;
		}
}
