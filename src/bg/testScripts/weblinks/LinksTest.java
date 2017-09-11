package bg.testScripts.weblinks;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.testBase.TestBase;
import bg.webLinks.WebLinks;

public class LinksTest extends TestBase{
	
	@BeforeClass
	  public void setUp() throws IOException {
		  init();
		  }
	  @Test(priority=0)
	  public void testLogin() throws Exception {
		LoginPage login = new LoginPage();
		login.loginToApplication();
	  }
	  @Test(priority=1)
	  public void testLinks()  {
		WebLinks wl = new WebLinks();
		List<WebElement> allimages = wl.findAllLinks(driver);
		System.out.println("Total number of elements found " + allimages.size());
		 
	    for( WebElement element : allimages){

	    	try

	    	{

		        System.out.println("URL: " + element.getAttribute("href")+ " returned " + WebLinks.isLinkBroken(new URL(element.getAttribute("href"))));

	    		//System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));

	    	}

	    	catch(Exception exp)

	    	{

	    		System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());	    		

	    	}
	    }
	  }
	  
	  @AfterClass
	  public void tearDown() {
		  closeBrowser();
	  }
}
