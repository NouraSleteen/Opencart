package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistertionPage  extends BasePage{
	
	
	///this is the locators foe the web edition
	
	
	//Constructor
public RegistertionPage(WebDriver driver)
{
	super(driver);

}


//Locators

@FindBy(xpath="//input[@id='input-username']")
WebElement txt_username ;
@FindBy(xpath="//input[@id='input-firstname']")
WebElement txt_firstname ;
@FindBy(xpath="//input[@id='input-lastname']")
WebElement txt_lastname ;
@FindBy(xpath="	//input[@id='input-email']")
WebElement txt_email;
@FindBy(xpath="//*[@id=\"input-country\"]/option")
List<WebElement> dr_countries ;
@FindBy(xpath="//input[@id='input-password']")
WebElement txt_password ;
@FindBy(xpath="//*[@id=\"button-register\"]/button[2]")
WebElement btn_register ;
@FindBy(xpath="//*[@id=\"register\"]/div/div[1]/h3")
WebElement registriation_msg ;


	
	
	
//Methods

public void username(String userName)
{
	txt_username.sendKeys(userName);
}
	
public void firstname(String fn)
{
	txt_username.sendKeys(fn);
}
	
public void lastname(String ln)
{
	txt_username.sendKeys(ln);
}
	
public void email(String emailId)
{
	txt_username.sendKeys(emailId);
}
	
public void country(String countryName)
{
	for (WebElement country : dr_countries)
	{
	
		String dr_country=country.getText();
		if(dr_country.equals(countryName))
		{
			country.click();
		}
	}
}
	
public void password(String pwd)
{
	txt_username.sendKeys(pwd);
}
	
public void registerbtn()
{
	btn_register.click();

}

public String   confirm_msg()
{
	String  result =registriation_msg.getText();
	
	return result;

}

}
