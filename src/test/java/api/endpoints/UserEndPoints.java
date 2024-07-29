package api.endpoints;
import static io.restassured.RestAssured.given;

import api.payloads.UserPojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
	
//Created to Perform CURD Operations(Create ,Read,Update ,Delete)

public class UserEndPoints {
	public static  Response CreateUser(UserPojoClass payload){
		Response response=given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(payload)
		.when()
		.post(Routes.post_url);
		return response;
		
		
		
	}
	public static  Response ReadUser(String username){
		Response response=given()
		
		.pathParam("username",username)
		.when()
		.get(Routes.get_url);
		return response;
		
		
		
	}
	
	public static  Response UpdateUser(String username,UserPojoClass payload){
		Response response=given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",username)
				.body(payload)
				.when()
				.put(Routes.update_url);
				return response;
		
		
		
	}
	public static  Response DeleteUser(String username){
		Response response=given()
		
		.pathParam("username",username)
		.when()
		.delete(Routes.delete_url);
		return response;
		
		
		
	}
	
	

}
