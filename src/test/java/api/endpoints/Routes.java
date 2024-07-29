package api.endpoints;

//Create user(POST)=https://petstore.swagger.io/v2/user
//Get user(Get)=https://petstore.swagger.io/v2/user/{username}
//Update user(PUT)=https://petstore.swagger.io/v2/user/{username}
//Delete user(delete)=https://petstore.swagger.io/v2/user/{username}

public class Routes {
	public static String base_url="https://petstore.swagger.io/v2";
	//User Model:
	public static String post_url=base_url+"/user";
	public static String get_url=base_url+"/user/{username}";
	public static String update_url=base_url+"/user/{username}";
	public static String delete_url=base_url+"/user/{username}";
	//Store model:
	//here create Store model URl
	//Pet Model
	//here create Per Model URL
	

}