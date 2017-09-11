package bg.testBase;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import bg.testutils.Utills;


public class TestBase extends Utills{
     
	public static Properties Repository = new Properties();
	//public Properties config = new Properties();
	//public Properties AppText = new Properties();
	public File f;
	public FileInputStream FI;
	
	public void init() throws IOException{
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		implicitWait(5);
		driver.get(Repository.getProperty("url"));
	}
	
	public void loadPropertiesFile() throws IOException{
		f = new File(System.getProperty("user.dir")+"\\src\\bg\\config\\config.properties");
		FileInputStream FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\bg\\pagelocators\\loginpage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\bg\\pagelocators\\virtualTerminal.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
	    f = new File(System.getProperty("user.dir")+"\\src\\bg\\pagelocators\\transactions.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\bg\\pageLocators\\allPageLocators.properties");
		FI = new FileInputStream(f);
		Repository.load(FI); 
		
	}
	
	public static WebElement getLocator(String locator) throws Exception{
		
		String locatorType = locator.split("_")[0];
		String locatorValue = locator.split("_")[1];
		
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if (locatorType.toLowerCase().equals("classname")
			   || (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if (locatorType.toLowerCase().equals("tagname")
				   || (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.tagName(locatorValue));
		else if (locatorType.toLowerCase().equals("linktext")
				   || (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if (locatorType.toLowerCase().equals("cssselector")
				   || (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else 
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	/*public WebElement getWebElement(String locator) throws Exception{
		return getLocator(Repository.getProperty(locator));
	}*/
	
	//public List<WebElement> getWebElements(String locator) throws Exception{
		//return getLocators(Repository.getProperty(locator));
	//}
	
	public static void captureScreenshot(String sheetName){
		Date date=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd MM yyyy hh mm ss");
		String currentDate=df.format(date);
		//String currentDate=date.toString();

		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(screenshotFile, new File(System.getProperty("user.dir")+"\\screenshots\\"+sheetName+" "+currentDate+".png"));
		}
		catch(Exception e){			
		}
	}
	
	public String randomInt(){
		
		Random random = new Random();
		int n = random.nextInt(50);
		int odd = n * 2 + 1;
		String amount = Integer.toString(odd);
		return amount;
	}
	
	
	public void closeBrowser(){
		driver.quit();
	}
	

}
