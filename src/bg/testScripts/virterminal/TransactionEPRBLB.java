package bg.testScripts.virterminal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.pageLibrary.processing.virtualTerminal.VirtualTerminal;
import bg.testBase.TestBase;


public class TransactionEPRBLB extends TestBase{	 
	String sheetName;
	
	@BeforeMethod
	   public void loginfirst() throws Exception{
		init();
		LoginPage login = new LoginPage();
		login.loginToApplication();
	}
	
	
	  @Test
	  public void valTrans() throws Exception {
		VirtualTerminal vt = new VirtualTerminal();
		vt.transeprblb();
		vt.processTrans();
		
	  }
	  
	  @AfterMethod
	  public void logout() throws Exception{
		 // captureScreenshot();
		  driverwait();
		  System.out.println("Done...");
		  driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		  driverwait();
		  closeBrowser();
	  }
	  
	  
}	  
