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
		logger.info("*** Starting TC_RegisterAccount***");
		
		try
		{
		home= new HomePage(driver);
		home.account();
		logger.info("Clicked on My Account");
		home.register();
		logger.info("Clicked on Regiser");
		Thread.sleep(2000);
		
		logger.info("*** Starting TC_RegisterAccount***");
		//for the web edition 
		
	/*	reg = new RegistertionPage(driver);
		
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
          logger.info("Providing Customer Details");
          
          reg.firstname(getRandomAlphabetic(5).toUpperCase());
  	
          reg.lastname(getRandomAlphabetic(5).toUpperCase());
  
          reg.email(getRandomAlphabetic(6) + "@gmail.com");
     
          reg.password(getRandomAlphaNumeric(8));
       	
          reg.subscribe();
        	
          reg.agreement();
      	
          reg.registerbtn();
          logger.info("Validating the result");
          String msgconf = reg.confirm_msg();  	
          if(msgconf.equals("Your Account Has Been Created!"))
          {
        	  Assert.assertTrue(true);
          }
          
          else
          {  	  
      		  logger.error("test failed..");
      		  logger.debug("Debug logs....");
      		  Assert.assertTrue(false);
          }
          
		}
		catch(Exception e)
		{
			Assert.fail();
		}
  		  
  		
          logger.info("Finishing the registration");
	}

}
