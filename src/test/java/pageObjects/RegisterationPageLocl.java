package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPageLocl extends BasePage {

	// Constructor
	public RegisterationPageLocl(WebDriver driver) {
		super(driver);

	}

	// Locators

	@FindBy(xpath = "//*[@id=\"input-firstname\"]")
	WebElement txt_firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastname;
	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement txt_email;
	@FindBy(xpath = "//*[@id=\"input-telephone\"]")
	WebElement txt_telephon;
	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='input-newsletter']")
	WebElement btn_newslettersb;
	@FindBy(xpath = "//*[@id=\"form-register\"]/div/div/input")
	WebElement btn_agreement;
	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btn_continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement condirmationMsge;

	// Methods

	public void firstname(String fn) {
		txt_firstname.sendKeys(fn);
	}

	public void lastname(String ln) {
		txt_lastname.sendKeys(ln);
	}

	public void email(String emailId) {
		txt_email.sendKeys(emailId);
	}

	public void password(String pwd) {
		txt_password.sendKeys(pwd);
	}

	public void subscribe() {

		btn_newslettersb.click();
		;
	}

	public void agreement() {
		btn_agreement.click();
		;
	}

	public void registerbtn() {
		btn_continue.click();

	}

	public String confirm_msg() {
		String result = condirmationMsge.getText();

		return result;

	}

}
