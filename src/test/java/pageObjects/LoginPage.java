package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginPage extends BasePage {

	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	// Locators

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath = "//*[@id=\"content\"]//div/form/input")
	WebElement btn_login;

	// Methods
	public void setUsername(String username) {
		wait.until(ExpectedConditions.visibilityOf(txt_email));
		txt_email.clear();
		txt_email.sendKeys(username);

	}

	public void setPassword(String pwd) {
		wait.until(ExpectedConditions.visibilityOf(txt_password));
		txt_password.clear();
		txt_password.sendKeys(pwd);
	}

	public void clickLogin() {
		wait.until(ExpectedConditions.elementToBeClickable(btn_login));
		btn_login.click();
		;

	}

}
