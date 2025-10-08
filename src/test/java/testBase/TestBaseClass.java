package testBase;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class TestBaseClass {
	
	public WebDriver driver;
	public Logger logger;
	public Properties p;

	@BeforeClass(groups={"regression","sanity", "master","ddt"})
	@Parameters({"browser"})
	public void setup(String br) throws IOException
	{
		FileInputStream configfile = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
        p = new Properties();

		p.load(configfile);

		
		logger = LogManager.getLogger(this.getClass());
		switch(br.toLowerCase())
		{
		case "chrome" :
			 ChromeOptions options = new ChromeOptions();
		    options.addArguments("--guest");  
		    HashMap<String, Object> prefs = new HashMap<>();
		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    options.setExperimentalOption("prefs", prefs);

		    driver = new ChromeDriver(options);
		    break;
		case "edge" :driver = new EdgeDriver(); break;
		case "firefox" :driver = new FirefoxDriver(); break;
		default:  throw new SkipException("Invalid browser: " + br);
		}

		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.manage().window().maximize();
		driver.get(p.getProperty("appurl"));
      

	}

	@AfterClass(groups={"regression","sanity", "master", "ddt"})
	public void tearDown()
	{
		driver.quit();
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
