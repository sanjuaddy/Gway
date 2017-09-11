package test.java;

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


public class ValidTransaction extends TestBase{
	
	LoginPage login;
	VirtualTerminal vt; 
	static String transtype;
	String cardn = "424242424242424";
	String amnt = randomInt();
	
	@BeforeMethod
	   public void loginfirst() throws Exception{
		init();
		login = new LoginPage();
		login.loginToApplication();
	}
	
	
	  @Test
	  public void invTrans() throws Exception {
		//vt = new VirtualTerminal();
		VirtualTerminal.makeTransaction(transtype,cardn,amnt);
		driverwait();
	  }
	  
	  @AfterMethod
	  public void clrform() throws Exception{
		  System.out.println("Done...");
		  driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		  driverwait();
		  closeBrowser();
	  }
	  
	  
}	  
