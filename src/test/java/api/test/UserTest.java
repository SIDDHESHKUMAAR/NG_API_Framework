package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payloads.UserPojoClass;
import freemarker.log.Logger;
import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.response.Response;

public class UserTest {
	Faker faker= new Faker();	
	UserPojoClass pojo= new UserPojoClass();	
	public Logger logger;
	@BeforeClass
	public void setupData() {
		
		pojo.setId(faker.idNumber().hashCode());
		pojo.setUsername(faker.name().username());
		pojo.setFirstName(faker.name().firstName());
		pojo.setLastName(faker.name().lastName());
		pojo.setEmail(faker.internet().safeEmailAddress());
		pojo.setPassword(faker.internet().password());
		pojo.setPhone(faker.phoneNumber().cellPhone());
		
		
	}
	@Test(priority=1)
	
	public void testPostUser() {
		Response response=UserEndPoints.CreateUser(pojo);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
				
	}
	@Test(priority=2)
	public void testGetuserByName() {
		Response response=UserEndPoints.ReadUser(this.pojo.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
		
	}
	@Test(priority=3)
	public void testUserUpdate() {
		
		pojo.setFirstName(faker.name().firstName());
		pojo.setLastName(faker.name().lastName());
		pojo.setEmail(faker.internet().safeEmailAddress());
		
		Response response=UserEndPoints.UpdateUser(this.pojo.getUsername(),pojo);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		//to check after Updation
		Response responseafter=UserEndPoints.ReadUser(this.pojo.getUsername());
		responseafter.then().log().all();
		Assert.assertEquals(responseafter.getStatusCode(),200);
		
		
		
	}
	@Test(priority=4)
	public void testDeleteUser() {
		Response response=UserEndPoints.DeleteUser(this.pojo.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	

}
