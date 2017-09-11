package bg.testScripts.virterminal;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.pageLibrary.processing.virtualTerminal.VirtualTerminal;
import bg.testBase.TestBase;
import bg.testutils.DataProviderClass;


public class AuthSaleCredit extends TestBase{
	//Create DataProviderClass object
		public static DataProviderClass dp;
		//public static VirtualTerminal vt;
		public static LoginPage login;
		//TestData Excel file stored location
		static String fileLocation=System.getProperty("user.dir")+"\\TestData\\TransCases.xlsx";
		//TestData Excel file SheetName
		static String sheetName="Transactions";

		@BeforeTest
		public void setUpMethod() throws Exception
		{
			init();
			login = new LoginPage();
			login.loginToApplication();
			dp=new DataProviderClass();
			//DataProvider Setup Method which returns fileLocation,sheetName,testcaseName
			dp.setUp(fileLocation, sheetName);
			captureScreenshot(sheetName);
		}

		//@Test(dataProvider="xlsData", dataProviderClass=DataProviderClass.class,enabled=false)
		@Test(dataProvider="xlsData", dataProviderClass=DataProviderClass.class,alwaysRun = true)
		public static void AuthVapp(String TestCaseName,String TransactionType,String Name,String Amount,String CardNumber,String ExpectedResult) throws Exception {
            
			
			
		    if (ExpectedResult.equals("APPROVED")){
			System.out.println(TestCaseName);
			VirtualTerminal.makeAuthTransaction(TransactionType,Name,Amount,CardNumber);
			captureScreenshot(sheetName);
			VirtualTerminal.processTrans();
			captureScreenshot(sheetName);
			System.out.println(ExpectedResult);
			
			}
			if(ExpectedResult.equals("DECLINED")){
			
				System.out.println(TestCaseName);
				VirtualTerminal.makeAuthTransaction(TransactionType,Name,Amount,CardNumber);
				captureScreenshot(sheetName);
				getLocator(Repository.getProperty("bg.processing.virtualt.process")).click();
				driverwait();
				captureScreenshot(sheetName);
				System.out.println(ExpectedResult);
				
			} 
			if(ExpectedResult.equals("ERROR")){
				System.out.println(TestCaseName);
				VirtualTerminal.makeAuthTransaction(TransactionType,Name,Amount,CardNumber);
				captureScreenshot(sheetName);
				VirtualTerminal.errorExp();
				captureScreenshot(sheetName);
				getLocator(Repository.getProperty("bg.processing.virtualt.process")).click();
				driverwait();
				captureScreenshot(sheetName);
				System.out.println(ExpectedResult);
				
			}
			
		}
		//@AfterMethod  //this is optional
		//public void screenshot(){
			//Screenshot capture
			//captureScreenshot(sheetName);
		//}
		@AfterTest
		public void tearDown() throws InterruptedException{
			//driver close method
			driverwait();
			System.out.println("Done...");
			driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
			driverwait();
			closeBrowser();
		}
}
