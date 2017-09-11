package bg.pageLibrary.loginPage;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import bg.testBase.TestBase;

public class LoginPage extends TestBase{
	//String sheetName;
	public void loginToApplication() throws Exception{
		WebElement accountid = getLocator(Repository.getProperty("bg.login.accountid"));
		  Reporter.log("entering accountID to the accountID textbox");
		  accountid.sendKeys(Repository.getProperty("accountid"));
		  WebElement userName = getLocator(Repository.getProperty("bg.login.username"));
		  Reporter.log("entering userName to the userName textbox");
		  userName.sendKeys(Repository.getProperty("userid"));
		  WebElement password = getLocator(Repository.getProperty("bg.login.password"));
		  Reporter.log("entering password to the password textbox");
		  password.sendKeys(Repository.getProperty("password"));
		  Reporter.log("clicking on login button");
		  getLocator(Repository.getProperty("bg.login.loginButton")).click();
		  
		  //captureScreenshot(sheetName);
		  driverwait();
	}

	/*public void loginToApplication(String userName, String password) throws Exception {
		// TODO Auto-generated method stub
		  WebElement userName1 = getWebElement("actiTime.login.username");
		  Reporter.log("entering userName to the userName textbox");
		  userName1.sendKeys(userName);
		  WebElement password1 = getWebElement("actiTime.login.password");
		  Reporter.log("entering password to the password textbox");
		  password1.sendKeys(password);
		  Reporter.log("clicking on login button");
		  getWebElement("actiTime.login.loginButton").click();
		  driverwait();
	} */
}
