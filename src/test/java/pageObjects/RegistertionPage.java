package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistertionPage extends BasePage {

	/// this is the locators foe the web edition

	// Constructor
	public RegistertionPage(WebDriver driver) {
		super(driver);

	}

//Locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_telephone;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_passwordConfirm;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkbox_policy;
	@FindBy(xpath = "//*[@id=\"content\"]/form/div/div/input[2]")
	WebElement btn_register;
	@FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created')]")
	WebElement registriation_msg;

//Methods

	public void firstname(String fn) {
		txt_firstname.sendKeys(fn);
	}

	public void lastname(String ln) {
		txt_lastname.sendKeys(ln);
	}

	public void email(String emailId) {
		txt_email.sendKeys(emailId);
	}

	public void telephone(String phone) {
		txt_telephone.sendKeys(phone);
	}

	public void password(String pwd) {
		txt_password.sendKeys(pwd);
	}

	public void passwordConfirmation(String pwd) {
		txt_passwordConfirm.sendKeys(pwd);
	}

	public void checkPolicy() {
		checkbox_policy.click();

	}

	public void registerbtn() {
		btn_register.click();

	}

	public String confirm_msg() {
		return registriation_msg.getText();

	}

}
