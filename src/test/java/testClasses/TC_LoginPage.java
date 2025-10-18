package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBaseClass;

public class TC_LoginPage extends TestBaseClass {

	public HomePage home;
	public LoginPage lp;
	public MyAccountPage map;

	@Test(groups = { "sanity", "master" })
	public void login() {
		logger.info("*** TC_LoginPage***");
		try {
			home = new HomePage(driver);
			home.account();
			home.login();

			logger.info("Providing Customer credential  login");
			lp = new LoginPage(driver);
			lp.setUsername(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			logger.info("Validating the result");
			map = new MyAccountPage(driver);

			boolean expectedresult = map.myaccountpage();

			Assert.assertTrue(expectedresult);
		}

		catch (Exception e) {
			Assert.fail();
		}

		logger.info("Finishing the login");

	}

}
