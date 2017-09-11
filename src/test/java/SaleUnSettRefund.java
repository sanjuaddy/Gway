package test.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.pageLibrary.processing.virtualTerminal.VirtualTerminal;
import bg.pageLibrary.transactions.transList.TransactionListDwld;
//import bg.pageLibrary.processing.virtualTerminal.VirtualTerminal;
import bg.testBase.TestBase;

public class SaleUnSettRefund extends TestBase{
	LoginPage login;
	String transtype = "SALE";
	//999031662056
	//String givenid = "999031662267";
	String sheetName = "UnSetRef";
	String cardn = "378282246310005";
	String amnt = randomInt();
	public static VirtualTerminal vt;
	
	@BeforeMethod
	   public void loginfirst() throws Exception{
		init();
		login = new LoginPage();
		login.loginToApplication();
		captureScreenshot(sheetName);
	}
	
	
	  @Test
	  public void invTrans() throws Exception {
		  
		  VirtualTerminal.makeTransaction(transtype,cardn,amnt);
		  getLocator(Repository.getProperty("bg.processing.virtualt.process")).click();
		  String givenid = getLocator(Repository.getProperty("bg.nid")).getText();
		  driverwait();
		  captureScreenshot(sheetName);
		
		  TransactionListDwld tdwld = new TransactionListDwld();
		  tdwld.listDwnld();
		  
		  
		  WebElement tansWebtab = getLocator(Repository.getProperty("bg.webTable"));
		  List<WebElement> rows = tansWebtab.findElements(By.xpath("//section[1]/ol/li"));
	      int rows_count = rows.size();
	      System.out.println(rows_count);
	      for (int row=0; row<rows_count; row++){

		   List<WebElement> columns=tansWebtab.findElements(By.cssSelector("ol>li>ul>li"));
		   int columns_count = columns.size();
		   //System.out.println(columns_count);
		   for (int column=0; column<columns_count; column++){ 
			   String celtext = columns.get(column).findElement(By.xpath("//section[1]/ol/li["+row+"+1]/ul/li[4]/h3")).getText();
			   //System.out.println(celtext);
		      if (celtext.equals("Sale")) {
		    	  String str = driver.findElement(By.xpath("//article/form/div/section[1]/ol/li["+row+"+1]/ul/li[7]/div/span")).getText();
		    	  String transid = driver.findElement(By.xpath("//article/form/div/section[1]/ol/li["+row+"+1]/ul/li[2]")).getText().substring(0, 12);
		    	  String setstatus = driver.findElement(By.xpath("//article/form/div/section[1]/ol/li["+row+"+1]/ul/li[5]")).getText();
		    	  
		    	  if(transid.equals(givenid) && setstatus.contains("Pending")){
		    		  System.out.println(str);
		    		  System.out.println(transid);
		    		  
		    		  WebElement opt = driver.findElement(By.xpath("//article/form/div/section[1]/ol/li["+row+"+1]/ul/li[8]/section/button"));
		    		  opt.click();
		    		  captureScreenshot(sheetName);
		    		  List<WebElement> options= opt.findElements(By.xpath("//section[1]/ol/li["+row+"+1]/ul/li[8]/section/ul/li"));
		    		  int options_count = options.size();
		    		  System.out.println(options_count);
		    		  
		    		  for (int op=0;op<options_count;op++){
		    			  
		    			  if(options.get(op).getText().equalsIgnoreCase("refund")){
		    				  
		    				  System.out.println(options.get(op).getText());
		    				  options.get(op).click();
		    				  driverwait();
		    				  captureScreenshot(sheetName);
		    				  System.out.println(driver.findElement(By.xpath("//ul[2]/li/strong")).getText() +": "+driver.findElement(By.xpath("//ul[2]/li/span")).getText());
		    				  VirtualTerminal.processTrans();
		    				  driverwait();
		    				  getLocator(Repository.getProperty("bg.processing")).click();
		    				  driverwait();
		    				  getLocator(Repository.getProperty("bg.transactions")).click();
		    				  driverwait();
		    				  getLocator(Repository.getProperty("bg.tranlist")).click();
		    				  driverwait();
		    				  tansWebtab = getLocator(Repository.getProperty("bg.webTable"));
		    				  break;
		    			  }
		    			  
		    			  
		    		  }
		    		  break; 
		    	  }
		    	  
		    	  
		    	  
		          //columns.get(column).click();
		          break;
		      }
		      break;
		    }   
	      }
		}
	  
	  
	  @AfterMethod
	  public void clrform() throws Exception{
		  //System.out.println("Done...");
		  driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		  driverwait();
		  closeBrowser();
	  }
}
