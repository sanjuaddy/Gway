package bg.testScripts.login;

import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.testBase.TestBase;

import org.testng.annotations.BeforeClass;

import java.io.IOException;

//import org.openqa.selenium.WebElement;
//import org.testng.Reporter;
import org.testng.annotations.AfterClass;

public class TestLogin extends TestBase {
  @BeforeClass
  public void setUp() throws IOException {
	  init();
	  }
  @Test
  public void testLogin() throws Exception {
	LoginPage login = new LoginPage();
	login.loginToApplication();
  }
  
  @AfterClass
  public void tearDown() {
	  closeBrowser();
  }

}
