package api.endpoints;

public class Routes {

	
	public static String base_url = "https://petstore.swagger.io/v2";
	
	
	//USER MODULE
	public static String user_get_url = base_url+"/user/{username}";
	public static String user_post_url = base_url+"/user";
	public static String user_put_url = base_url+"/user/{username}";
	public static String user_delete_url = base_url+"/user/{username}";
	
	public static String user_get_login_url = base_url+"/user/login";
	public static String user_get_logout_url = base_url+"/user/logout";

	
	//PET MODULE
	
}
