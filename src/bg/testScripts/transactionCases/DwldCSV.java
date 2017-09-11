package bg.testScripts.transactionCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import bg.pageLibrary.loginPage.LoginPage;
import bg.pageLibrary.transactions.transList.TransactionListDwld;
//import bg.pageLibrary.processing.virtualTerminal.VirtualTerminal;
import bg.testBase.TestBase;

public class DwldCSV extends TestBase{
	LoginPage login;
	
	
	@BeforeMethod
	   public void loginfirst() throws Exception{
		init();
		login = new LoginPage();
		login.loginToApplication();
	}
	
	
	  @Test
	  public void invTrans() throws Exception {
		
		  TransactionListDwld tdwld = new TransactionListDwld();
		  tdwld.listDwnld();
		  
		  File file = getLatestFilefromDir("C:\\Users\\CDI\\Downloads");
		  String csvFileName = file.getName();
		  System.out.println("CSV File Downloaded is :- "+csvFileName);

		  System.out.println("Verifying number of entries with number of entries in csv");
		  System.out.println(getRecordsCountInCSV("C:\\Users\\CDI\\Downloads",csvFileName));
	  }
	  
	  public File getLatestFilefromDir(String dirPath){
		    File dir = new File(dirPath);
		    File[] files = dir.listFiles();
		    if (files == null || files.length == 0) {
		        return null;
		    }
		
		    File lastModifiedFile = files[0];
		    for (int i = 1; i < files.length; i++) {
		       if (lastModifiedFile.lastModified() < files[i].lastModified()) {
		           lastModifiedFile = files[i];
		       }
		    }
		    return lastModifiedFile;
		}
	  
	  public int getRecordsCountInCSV(String downloadPath, String csvFileName) {
			int lineNumberCount = 0;
			try {
				if (!csvFileName.isEmpty() || csvFileName != null) {
					String filePath =	downloadPath + System.getProperty("file.separator") + csvFileName;
					System.out.println(filePath);
					File file = new File(filePath);
					if (file.exists()) {
						System.out.println("File found :" +csvFileName);
						FileReader fr = new FileReader(file);
						LineNumberReader linenumberreader = new LineNumberReader(fr);
						while (linenumberreader.readLine() != null) {
							lineNumberCount++;
						}
						//To remove the header
						lineNumberCount=lineNumberCount-1;
						System.out.println("Total number of lines found in csv : " + (lineNumberCount));
						linenumberreader.close();
					    } else {
						System.out.println("File does not exists");
					    }
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			return lineNumberCount;
		}
	  
	  
	  @AfterMethod
	  public void clrform() throws Exception{
		  //System.out.println("Done...");
		  driver.findElement(By.xpath("//a[contains(@href,'logout')]")).click();
		  driverwait();
		  closeBrowser();
	  }
}
