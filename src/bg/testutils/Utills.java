package bg.testutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Utills {
	
	public static WebDriver driver;
    
	public static WebDriver selectBrowser(String browser){
		if (browser.equals("firefox") || browser.equals("FIREFOX")){
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		}else if (browser.equals("chrome") || browser.equals("CHROME")){
			System.out.println("chrome browser");
			ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\bg\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver(ops);
			driver.manage().window().maximize();
			return driver;
		}else if (browser.equals("ie") || browser.equals("IE")){
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		return null;
	}
	
	public void implicitWait(int timeInSec){
		Reporter.log("waiting for page to load...");
		try{
			driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
			Reporter.log("Page is loaded");
		}
		catch(Throwable error){
			System.out.println("Timeout for Page Load Request to complete after "+ timeInSec + " second");
			Assert.assertTrue(false, "Timeout for page load request after "+timeInSec+" second");
		}
	}
	
	public static void driverwait() throws InterruptedException{
		Reporter.log("waiting for 4 seconds...");
		Thread.sleep(4000);
	}
	
}
