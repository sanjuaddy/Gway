package bg.testScripts.weblinks;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.testBase.TestBase;
import bg.webLinks.AllPageLinks;

public class TestAllLinks extends TestBase{
	//String sheetName = "AllLnks";
  
	@BeforeClass
	  public void setUp() throws IOException {
		  init();
		  }
	
	@BeforeMethod
	   public void loginfirst() throws Exception{
		
		LoginPage login = new LoginPage();
		login.loginToApplication();
	}
	
	
	  @Test
	  public void testActiveLinks() throws Exception {
		AllPageLinks al = new AllPageLinks();
		al.clickAllLinks();
		//al.captureScreenshot(sheetName);
		//driverwait();
	  }
	  
	  @AfterMethod
	  public void clrform() throws Exception{
		  //captureScreenshot();
		  System.out.println("Done...");
		  driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		  driverwait();
		  
	  }
	  
	  @AfterClass
	  public void close(){
		  closeBrowser();
	  }
}
