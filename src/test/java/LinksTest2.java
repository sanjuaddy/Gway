package test.java;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.testBase.TestBase;
import bg.webLinks.WebLinks;

public class LinksTest2 extends TestBase{
	
	@BeforeClass
	  public void setUp() throws IOException {
		  init();
		  }
	  @Test(priority=1)
	  public void testLogin() throws Exception {
		LoginPage login = new LoginPage();
		login.loginToApplication();
	  }
	  @Test(priority=2)
	  public void testLinks() throws Exception  {
		  WebLinks wl = new WebLinks();
		  List<WebElement> links = driver.findElements(By.tagName("a"));
		  
			System.out.println(links.size());
	 
			for (int i = 0; i<links.size(); i=i+1)
	 
			{
	            
				try {
					System.out.println(links.get(i).getText()+"-----"+links.get(i).getAttribute("href")+"-----"+WebLinks.isLinkBroken(new URL(links.get(i).getAttribute("href"))));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
	            
			}
	  }
	  
	  @AfterClass
	  public void tearDown() throws InterruptedException {
		  driverwait();
		  driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		  driverwait();
		  closeBrowser();
	  }
}
