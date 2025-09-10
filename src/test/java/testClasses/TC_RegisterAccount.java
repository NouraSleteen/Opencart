package testClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistertionPage;
import pageObjects.RegisterationPageLocl;
import testBase.TestBaseClass;

public class TC_RegisterAccount extends TestBaseClass {
	

	public HomePage home;
	public RegisterationPageLocl reg;

	
	@Test
	public void register() throws InterruptedException
	{
		
		
		home= new HomePage(driver);
		home.account();
		home.register();
		Thread.sleep(2000);
		//for the web edition 
		
	/*	RegistertionPage reg = new RegistertionPage(driver);
		
		reg.username(getRandomAlphabetic(6));
		reg.firstname(getRandomAlphabetic(6).toUpperCase());
		reg.lastname(getRandomAlphabetic(6).toUpperCase());
		reg.email(getRandomAlphabetic(6) + "@gmail.com");
		reg.country("United Arab Emirates");
		reg.password(getRandomAlphaNumeric(8));
		
		String msgconf = reg.registerbtn();
		Assert.assertEquals(msgconf, "Welcome to OpenCart, your account has been created");*/
		
		// For local host edition
          reg = new 	RegisterationPageLocl(driver);
          
          reg.firstname(getRandomAlphabetic(5).toUpperCase());
  	
          reg.lastname(getRandomAlphabetic(5).toUpperCase());
  
          reg.email(getRandomAlphabetic(6) + "@gmail.com");
     
          reg.password(getRandomAlphaNumeric(8));
       	
          reg.subscribe();
        	
          reg.agreement();
      	
          reg.registerbtn();
       	
          String msgconf = reg.confirm_msg();
         	
  		 Assert.assertEquals(msgconf, "Your Account Has Been Created!");
					
	}

}
