package bg.pageLibrary.processing.virtualTerminal;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;


import bg.testBase.TestBase;

public class VirtualTerminal extends TestBase{
	  
	static String sheetName;
	static String transtype;
	
	
	public static void setTrans(String transtype) throws Exception{
		if(transtype.equalsIgnoreCase("auth")){
			Select ttype = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.trantype")));
			ttype.selectByValue(transtype);
		}
		
		if(transtype.equalsIgnoreCase("sale")){
			Select ttype = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.trantype")));
			ttype.selectByValue(transtype);
		}
	}
	
	public static void makeTransaction(String transtype,String cardn,String amnt) throws Exception{
        
		getLocator(Repository.getProperty("bg.processing")).click();
		  getLocator(Repository.getProperty("bg.processing.virtualt")).click();
		  
		  WebElement trmode = getLocator(Repository.getProperty("bg.processing.virtualt.test"));
		  if (trmode.isSelected()) {
		       System.out.println("Test mode is selected");
	      }
		  else
	      {
	    	 trmode.click(); 
	      }
	      
		  //Select ttype = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.trantype")));
		  //ttype.selectByValue("SALE");
		  setTrans(transtype);
		  
		  WebElement amount =getLocator(Repository.getProperty("bg.processing.virtualt.amnt"));
		  amount.sendKeys(amnt);
		  
		  Select emonth = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.expmonth")));
		  emonth.selectByValue("06");
		  
		  Select eyear = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.expyear")));
		  eyear.selectByValue("2022");
		  
		  WebElement carno =getLocator(Repository.getProperty("bg.processing.virtualt.card"));
		  carno.sendKeys(cardn);
		  
		  WebElement fname =getLocator(Repository.getProperty("bg.processing.virtualt.firstname"));
		  fname.sendKeys(Repository.getProperty("fname"));
		  WebElement lname =getLocator(Repository.getProperty("bg.processing.virtualt.lastname"));
		  lname.sendKeys(Repository.getProperty("lname"));
		  WebElement cname =getLocator(Repository.getProperty("bg.processing.virtualt.compname"));
		  cname.sendKeys(Repository.getProperty("cname"));
		  WebElement addrs =getLocator(Repository.getProperty("bg.processing.virtualt.addr"));
		  addrs.sendKeys(Repository.getProperty("addrs"));
		  WebElement suit =getLocator(Repository.getProperty("bg.processing.virtualt.suite"));
		  suit.sendKeys(Repository.getProperty("suit"));
		  WebElement city =getLocator(Repository.getProperty("bg.processing.virtualt.city"));
		  city.sendKeys(Repository.getProperty("city"));
		  WebElement state =getLocator(Repository.getProperty("bg.processing.virtualt.state"));
		  state.sendKeys(Repository.getProperty("state"));
		  WebElement zip =getLocator(Repository.getProperty("bg.processing.virtualt.zip"));
		  zip.sendKeys(Repository.getProperty("zip"));
		  WebElement email =getLocator(Repository.getProperty("bg.processing.virtualt.email"));
		  email.sendKeys(Repository.getProperty("email"));
	      
		  	  
	} 
	  
	public static void processTrans() throws Exception{
		
	  getLocator(Repository.getProperty("bg.processing.virtualt.process")).click();
	  
	/*  WebElement err1 = getLocator(Repository.getProperty("bg.processing.virtualt.processorerror"));
	  if (err1.isDisplayed()){
		  System.out.println(err1.getText());
	  } */
	  
	  driverwait();
	  System.out.println(getLocator(Repository.getProperty("bg.approved")).getText());
	  System.out.println(getLocator(Repository.getProperty("bg.amount")).getText());
	  System.out.println(getLocator(Repository.getProperty("bg.tid")).getText()+getLocator(Repository.getProperty("bg.nid")).getText());
	  System.out.println(getLocator(Repository.getProperty("bg.appcode")).getText()+getLocator(Repository.getProperty("bg.acode")).getText());
	  //captureScreenshot(sheetName);
	  getLocator(Repository.getProperty("bg.viewrec")).click();
	  driverwait();
	  getLocator(Repository.getProperty("bg.trandetails")).click();
	  
	}	
	
	public static void transeprblb() throws Exception{
		
	  //makeTransaction(transtype);
	  getLocator(Repository.getProperty("bg.extproinfo")).click();
	  getLocator(Repository.getProperty("bg.tipamount")).sendKeys("1");
	  getLocator(Repository.getProperty("bg.customid1")).sendKeys("123");
	  getLocator(Repository.getProperty("bg.customid2")).sendKeys("123");
	  getLocator(Repository.getProperty("bg.invoiceid")).sendKeys("123");
	  getLocator(Repository.getProperty("bg.comments")).sendKeys("Test trans");
	  
	  getLocator(Repository.getProperty("bg.recbilling")).click();
	  Select recb = new Select(getLocator(Repository.getProperty("bg.enablerecb")));
	  recb.selectByValue("1");
	  getLocator(Repository.getProperty("bg.noofcycles")).sendKeys("4");
	  getLocator(Repository.getProperty("bg.rebillamnt")).sendKeys("3");
	  getLocator(Repository.getProperty("bg.rebillfreq")).sendKeys("4 months");
	  getLocator(Repository.getProperty("bg.startdate")).click();
	   
	  String today = getCurrentDay();
	  System.out.println("The date today is " + today);
	  WebElement dateWidget = getLocator(Repository.getProperty("bg.datebox"));
	  List<WebElement> rows = dateWidget.findElements(By.tagName("tr"));
      int rows_count = rows.size();
      for (int row=0; row<rows_count; row++){
	   List<WebElement> columns=dateWidget.findElements(By.tagName("td"));
	   int columns_count = columns.size();
	   for (int column=0; column<columns_count; column++){ 
		   String celtext = columns.get(column).getText();
	  //for (WebElement cell: columns) {
	      //String z=cell.getAttribute("class").toString();
	      //if(z.equalsIgnoreCase("day")){
	      if (celtext.equals(today)) {
	          columns.get(column).click();
	        break;
	      }
	    }   
      }
	
	  getLocator(Repository.getProperty("bg.level2")).click();
	 // getLocator(Repository.getProperty("bg.usel2billing")).click();
	  Select lvl2b = new Select(getLocator(Repository.getProperty("bg.usel2billing")));
	  lvl2b.selectByValue("1");
	  //getLocator(Repository.getProperty("bg.taxamnt")).sendKeys("11.33");
	  getLocator(Repository.getProperty("bg.orderid")).sendKeys("123");
	  getLocator(Repository.getProperty("bg.taxamnt1")).sendKeys("11.33");
	  
	  //processTrans();
		
		
	}
	
	private static String getCurrentDay() {
		 Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		 //Get Current Day as a number
		 int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		 System.out.println("Today Int: " + todayInt +"\n");

		 //Integer to String Conversion
		 String todayStr = Integer.toString(todayInt);
		 return todayStr;
		}
	
	
	public static void makeAuthTransaction(String TransactionType, String Name, String Amount, String CardNumber) throws Exception{
        
		  getLocator(Repository.getProperty("bg.processing")).click();
		  getLocator(Repository.getProperty("bg.processing.virtualt")).click();
		  
		  WebElement trmode = getLocator(Repository.getProperty("bg.processing.virtualt.test"));
		  if (trmode.isSelected()) {
		       System.out.println("Test mode is selected");
	      }
		  else
	      {
	    	 trmode.click(); 
	      }
	      
		  Select ttype = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.trantype")));
		  ttype.selectByValue(TransactionType);
		  
		  WebElement amount =getLocator(Repository.getProperty("bg.processing.virtualt.amnt"));
		  amount.sendKeys(Amount);
		  
		  
		  Select emonth = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.expmonth")));
		  emonth.selectByValue("06");
		  
		  Select eyear = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.expyear")));
		  eyear.selectByValue("2022");
		  
		  WebElement carno =getLocator(Repository.getProperty("bg.processing.virtualt.card"));
		  carno.sendKeys(CardNumber);
		  
		  
		  //driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='tab-1']/div/section[2]/div")));
		  
		  //WebElement amt =getLocator(Repository.getProperty("bg.processing.virtualt.amnt"));
		  //amt.sendKeys(Repository.getProperty("amount"));
		  //WebElement card =getLocator(Repository.getProperty("bg.processing.virtualt.card"));
		  //card.sendKeys(Repository.getProperty("carno"));
		  WebElement fname =getLocator(Repository.getProperty("bg.processing.virtualt.firstname"));
		  fname.sendKeys(Name);
		  WebElement lname =getLocator(Repository.getProperty("bg.processing.virtualt.lastname"));
		  lname.sendKeys(Repository.getProperty("lname"));
		  WebElement cname =getLocator(Repository.getProperty("bg.processing.virtualt.compname"));
		  cname.sendKeys(Repository.getProperty("cname"));
		  WebElement addrs =getLocator(Repository.getProperty("bg.processing.virtualt.addr"));
		  addrs.sendKeys(Repository.getProperty("addrs"));
		  WebElement suit =getLocator(Repository.getProperty("bg.processing.virtualt.suite"));
		  suit.sendKeys(Repository.getProperty("suit"));
		  WebElement city =getLocator(Repository.getProperty("bg.processing.virtualt.city"));
		  city.sendKeys(Repository.getProperty("city"));
		  WebElement state =getLocator(Repository.getProperty("bg.processing.virtualt.state"));
		  state.sendKeys(Repository.getProperty("state"));
		  WebElement zip =getLocator(Repository.getProperty("bg.processing.virtualt.zip"));
		  zip.sendKeys(Repository.getProperty("zip"));
		  WebElement email =getLocator(Repository.getProperty("bg.processing.virtualt.email"));
		  email.sendKeys(Repository.getProperty("email"));
		  
		  //captureScreenshot(sheetName);
		} 
	
	public static void errorExp() throws Exception{
		
		Select emonth = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.expmonth")));
		  emonth.selectByValue("06");
		  
		  Select eyear = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.expyear")));
		  eyear.selectByValue("2017");
		
	}
	
	
	

	public void clearForm() throws Exception{
		
		getLocator(Repository.getProperty("bg.processing.virtualt.clearf")).click();
		
		driver.switchTo().alert();
		String alertMessage=driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.findElement(By.xpath("html/body/div[3]/div[3]/div/button[2]"));
		driverwait();
	}
	
}	
	