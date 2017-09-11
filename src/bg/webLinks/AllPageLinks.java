package bg.webLinks;

import java.util.ArrayList;

import bg.testBase.TestBase;

public class AllPageLinks extends TestBase{
    String sheetName = "AllLnks";
	public void clickAllLinks() throws Exception{
		
		getLocator(Repository.getProperty("bg.gatewattut")).click();
		captureScreenshot(sheetName);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	    captureScreenshot(sheetName);
	    driverwait();
	    //captureScreenshot();
	    //driver.close();
	    driver.switchTo().window(tabs2.get(0));
	    
	    getLocator(Repository.getProperty("bg.processing")).click();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.processing.virtualt")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    getLocator(Repository.getProperty("bg.transactions")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.settlelist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.transearch")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.tranlist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.tranholdlist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.tranlistcustom")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.achrejectlst")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.aggsearch")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.aggslist")).click(); 
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    
	    getLocator(Repository.getProperty("bg.achrecon")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.pendinglist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.pendingsearch")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.payoutlist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.payoutsearch")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    
	    getLocator(Repository.getProperty("bg.rebilling")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.rebillinglist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.rebillingsearch")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    getLocator(Repository.getProperty("bg.fileupload")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.fileuploadlist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.fileuploadsearch")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.fileuploadnew")).click(); 
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    getLocator(Repository.getProperty("bg.customertokens")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.customertokenslist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.customertokenssearch")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.customertokenscreate")).click(); 
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    getLocator(Repository.getProperty("bg.reports")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.acctotals")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.accupdtotals")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.accupdsumrep")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.setmntrecon")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    getLocator(Repository.getProperty("bg.fraud")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.froverview")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.frvelfilter")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.frthreshold")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.fravscvvfilter")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.frcardisscountry")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.frnegdb")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.frgeoiptrack")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    
	    getLocator(Repository.getProperty("bg.tools")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsinteg")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsinteggs")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    driverwait();
	    getLocator(Repository.getProperty("bg.tools")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsinteg")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsintegpaymodu")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    getLocator(Repository.getProperty("bg.tools")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsinteg")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsintegcodesamp")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    getLocator(Repository.getProperty("bg.tools")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsinteg")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsintegapidocs")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    getLocator(Repository.getProperty("bg.tools")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsinteg")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsintegapplepay")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    getLocator(Repository.getProperty("bg.tools")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsguides")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsguidesops")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    getLocator(Repository.getProperty("bg.tools")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsformmaker")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    getLocator(Repository.getProperty("bg.toolsformmakerselfh")).click();
	    
	    
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.toolsformmakerbph")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    //driverwait();
	    //getLocator(Repository.getProperty("bg.tools")).click();
	    //driverwait();
	    getLocator(Repository.getProperty("bg.toolspci")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    
	    //getLocator(Repository.getProperty("bg.tools")).click();
	    //driverwait();
	    getLocator(Repository.getProperty("bg.toolsmerseal")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    //captureScreenshot();
	    driver.navigate().back();
	    
	    driverwait();
	    getLocator(Repository.getProperty("bg.admin")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.adminusers")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.adminuserlist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.adminuserspwdchange")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.adminaccnts")).click();
	    driverwait();
	    //captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.adminaccntslist")).click();
	    driverwait();
	    captureScreenshot(sheetName);
	    getLocator(Repository.getProperty("bg.adminaccntssearch")).click();
	    captureScreenshot(sheetName);
	    
	}
	
}
