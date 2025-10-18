package testClasses;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.RegistertionPage;
import testBase.TestBaseClass;

public class TC_RegisterAccount extends TestBaseClass {

	public HomePage home;
	public RegistertionPage reg;

	@Test(groups = { "regression", "master" })
	public void register() throws InterruptedException {
		logger.info("*** Starting TC_RegisterAccount***");

		try {
			home = new HomePage(driver);
			home.account();
			logger.info("Clicked on My Account");
			home.register();
			logger.info("Clicked on Regiser");

			reg = new RegistertionPage(driver);
			logger.info("Providing Customer Details");

			reg.firstname(getRandomAlphabetic(5).toUpperCase());

			reg.lastname(getRandomAlphabetic(5).toUpperCase());

			reg.email(getRandomAlphabetic(6) + "@gmail.com");
			reg.telephone(getRandom10Digits());
			String pwd = getRandomAlphaNumeric(8);
			reg.password(pwd);
			reg.passwordConfirmation(pwd);
			reg.checkPolicy();
			reg.registerbtn();
			logger.info("Validating the result");
			String msgconf = reg.confirm_msg();
			System.out.print(msgconf);
			if (msgconf.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}

			else {
				logger.error("test failed..");
				logger.debug("Debug logs....");
				Assert.assertTrue(false);
			}

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("Finishing the registration");
	}

}
