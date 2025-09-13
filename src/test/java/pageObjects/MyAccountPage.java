package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators 
	
	@FindBy(xpath="//*[@id=\"content\"]/h1") WebElement myaccount;
	
	//Methods
	
	public boolean myaccountpage()
	{
		boolean macc = myaccount.isDisplayed();
		return macc;
	}
	
	
	

}
