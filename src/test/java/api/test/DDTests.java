package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payloads.UserPojoClass;
import api.utitlites.DataProviders;
import io.restassured.response.Response;	

public class DDTests {
	@Test(priority=1,dataProvider="data",dataProviderClass = DataProviders.class)

	public void testPostUser(String UserId,String UserName,String fname,String lname,String useremail,String pw,String phone) {
		
		UserPojoClass payload= new UserPojoClass();	
		payload.setId(Integer.parseInt(UserId));
		payload.setUsername(UserName);
		payload.setFirstName(fname);
		payload.setLastName(lname);
		payload.setEmail(useremail);
		payload.setPassword(pw);
		payload.setPhone(phone);
		Response response=UserEndPoints.CreateUser(payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test(priority=2,dataProvider="UserNames",dataProviderClass = DataProviders.class)
	public void testDeleteUser(String Username) {
		Response response=UserEndPoints.DeleteUser(Username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
}
