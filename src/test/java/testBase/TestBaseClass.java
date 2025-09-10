package testBase;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.HomePage;

public class TestBaseClass {
	
	public WebDriver driver;

	@BeforeClass
	public void setup()
	{
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.manage().window().maximize();
		driver.get("http://localhost/opencart/");


	}

	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	
	
	 public static String getRandomAlphabetic(int length) {
		    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		    StringBuilder sb = new StringBuilder();
		    Random random = new Random();

		    for (int i = 0; i < length; i++) {
		        sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
		    }

		    return sb.toString();
		}
	
	 public static String getRandom10Digits() {
	        String digits = "0123456789";
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < 10; i++) {
	            sb.append(digits.charAt(random.nextInt(digits.length())));
	        }

	        return sb.toString();
	    }
	 public static String getRandomAlphaNumeric(int length) {
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
	                          + "abcdefghijklmnopqrstuvwxyz"
	                          + "0123456789";
	        StringBuilder sb = new StringBuilder();
	        Random random = new Random();

	        for (int i = 0; i < length; i++) {
	            sb.append(characters.charAt(random.nextInt(characters.length())));
	        }

	        return sb.toString();
	    }
}
