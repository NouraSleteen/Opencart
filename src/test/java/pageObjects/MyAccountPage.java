package pageObjects;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	WebDriverWait wait;

	public MyAccountPage(WebDriver driver) {
		super(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}

	// Locators

	@FindBy(xpath = "//*[@id=\"content\"]/h2[1]")
	WebElement myaccountmsg;
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]")
	WebElement logoutlink;
	// Methods

	public boolean myaccountpage() {
		try {
			wait.until(ExpectedConditions.visibilityOf(myaccountmsg));
			return myaccountmsg.isDisplayed();

		} catch (Exception e) {
			return false;

		}

	}

	public String mylogout() {
		try {
			wait.until(ExpectedConditions.visibilityOf(logoutlink));
			return logoutlink.getText();

		} catch (Exception e) {
			return null;

		}

	}

	public void logout() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutlink)).click();
		safeClick(logoutlink);
	}

}
