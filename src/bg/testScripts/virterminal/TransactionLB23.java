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
import bg.pageLibrary.processing.virtualTerminal.VirtualTerminal2;
import bg.testBase.TestBase;


public class TransactionLB23 extends TestBase{
	
	LoginPage login;
	VirtualTerminal vt1; 
	VirtualTerminal2 vt2; 
	String transtype = "SALE";
	String cardn = "6011111111111117";
	String amnt = randomInt();
	
	@BeforeMethod
	   public void loginfirst() throws Exception{
		init();
		login = new LoginPage();
		login.loginToApplication();
	}
	
	
	  @Test
	  public void lvl23Trans() throws Exception {
		VirtualTerminal.makeTransaction(transtype,cardn,amnt);
		driverwait();
		VirtualTerminal.transeprblb();
		driverwait();
		VirtualTerminal2.level2exb();
		driverwait();
		VirtualTerminal2.level3b();
		driverwait();
		VirtualTerminal.processTrans();
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
