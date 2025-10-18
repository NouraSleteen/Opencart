package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement accountlink;
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a")
	WebElement registerlink;
	@FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	WebElement loginlink;

	public void account() {
		accountlink.click();
		;
	}

	public void login() {
		loginlink.click();
		;
	}

	public void register() {
		registerlink.click();
		;
	}

}