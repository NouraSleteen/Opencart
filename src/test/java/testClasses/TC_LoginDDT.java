package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBaseClass;
import utilities.DataProviders;

public class TC_LoginDDT extends TestBaseClass {
	
	public HomePage home;
	public LoginPage lp;
	public MyAccountPage maccp;
	
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= "ddt")
	public void loginDDT(String email, String pwd, String result, String exp)
	{
	logger.info("****starting loginDDT***");
		try {
	home = new HomePage(driver);
	home.account();
	
	home.login();
	
	lp = new LoginPage(driver);
	
	logger.info("Insert username");
	
	lp.setUsername(email);
	
	logger.info("insert password");
	
	lp.setPassword(pwd);
	
	logger.info("click login");
	
	lp.clickLogin();
	
	maccp = new MyAccountPage(driver);
	
	boolean expectedresult =  maccp.myaccountpage();

	/*
	 Data valid -----login success --test pass logout
	                 -login failed ----test fail
	 
	 Data invalid ----login sucess ---test fail- logout
	                 login faild ----test pass
	  
	  */
	if(result.equalsIgnoreCase("Valid"))
	{
		if(expectedresult==true)
		{
			
			maccp.logout();
			Assert.assertTrue(true);
		}
		
		else
		{
			Assert.assertTrue(false);
		}
		
	}
	
	if(result.equalsIgnoreCase("Invalid"))
	{
		if(expectedresult==true)
		{
		System.out.println(maccp.mylogout());
			maccp.logout();
			Assert.assertTrue(false);
		}
		
		else
		{
			Assert.assertTrue(true);
		}
	}
		}
		catch(Exception e)
		{
			 logger.error("Test failed due to exception: ", e);
			    Assert.fail(e.getMessage());
		}
		
	   finally {
	        logger.info("****finishing loginDDT****");
	    }
	}
}
	
		
		
	

