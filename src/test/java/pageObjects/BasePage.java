package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	protected void safeClick(WebElement element) {
	    try {
	        Actions actions = new Actions(driver);
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	        actions.moveToElement(element).click().perform();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	    }
	}
}
