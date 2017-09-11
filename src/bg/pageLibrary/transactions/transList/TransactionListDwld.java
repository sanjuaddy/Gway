package bg.pageLibrary.transactions.transList;

import bg.testBase.TestBase;

public class TransactionListDwld extends TestBase{
	
	public void listDwnld() throws Exception{
		
		//getLocator(Repository.getProperty("bg.processing")).click();
		//driverwait();
		getLocator(Repository.getProperty("bg.transactions")).click();
		driverwait();
		getLocator(Repository.getProperty("bg.tranlist")).click();
		
		//getLocator(Repository.getProperty("bg.csvexp")).click();
		//getLocator(Repository.getProperty("bg.colheads")).click();
		//driverwait();
		//getLocator(Repository.getProperty("bg.dwld")).click();
		driverwait();
		
		
	}
	
	

}
