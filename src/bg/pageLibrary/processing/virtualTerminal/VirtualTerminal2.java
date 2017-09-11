package bg.pageLibrary.processing.virtualTerminal;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import bg.testBase.TestBase;

public class VirtualTerminal2 extends TestBase{
	  
	//static String sheetName;
	public static void level2exb() throws Exception{
        
		/*  getLocator(Repository.getProperty("bg.processing")).click();
		  getLocator(Repository.getProperty("bg.processing.virtualt")).click();
		  driverwait(); */
		  getLocator(Repository.getProperty("bg.level2eb")).click(); 
		  
		  WebElement trate =getLocator(Repository.getProperty("bg.taxrate"));
		  trate.sendKeys(Repository.getProperty("taxrate"));
		  WebElement gtrate =getLocator(Repository.getProperty("bg.gtaxrate"));
		  gtrate.sendKeys(Repository.getProperty("gtaxrate"));
		  WebElement gtamnt =getLocator(Repository.getProperty("bg.gtaxamnt"));
		  gtamnt.sendKeys(Repository.getProperty("gtaxamnt"));
		  WebElement samnt =getLocator(Repository.getProperty("bg.shipamnt"));
		  samnt.sendKeys(Repository.getProperty("shipamnt"));
		  WebElement damnt =getLocator(Repository.getProperty("bg.discamnt"));
		  damnt.sendKeys(Repository.getProperty("discamnt"));
		  
		  WebElement tid =getLocator(Repository.getProperty("bg.taxid"));
		  tid.sendKeys(Repository.getProperty("taxid"));
		  WebElement gtid =getLocator(Repository.getProperty("bg.gtaxid"));
		  gtid.sendKeys(Repository.getProperty("gtaxid"));
		  WebElement ctid =getLocator(Repository.getProperty("bg.ctaxid"));
		  ctid.sendKeys(Repository.getProperty("ctaxid"));
		  WebElement cpo =getLocator(Repository.getProperty("bg.custpo"));
		  cpo.sendKeys(Repository.getProperty("custpo"));
		  WebElement duamnt =getLocator(Repository.getProperty("bg.dutyamnt"));
		  duamnt.sendKeys(Repository.getProperty("dutyamnt"));
		  
		  WebElement sdata =getLocator(Repository.getProperty("bg.supdata"));
		  sdata.sendKeys(Repository.getProperty("supdata"));
		  WebElement cref =getLocator(Repository.getProperty("bg.custref"));
		  cref.sendKeys(Repository.getProperty("custref"));
		  WebElement ctrate =getLocator(Repository.getProperty("bg.cityrate"));
		  ctrate.sendKeys(Repository.getProperty("cityrate"));
		  WebElement ctamnt =getLocator(Repository.getProperty("bg.cityamnt"));
		  ctamnt.sendKeys(Repository.getProperty("cityamnt"));
		  WebElement cotrate =getLocator(Repository.getProperty("bg.counrate"));
		  cotrate.sendKeys(Repository.getProperty("counrate"));
		  
		  WebElement cotamnt =getLocator(Repository.getProperty("bg.counamnt"));
		  cotamnt.sendKeys(Repository.getProperty("counamnt"));
		  WebElement strate =getLocator(Repository.getProperty("bg.staterate"));
		  strate.sendKeys(Repository.getProperty("staterate"));
		  WebElement stamnt =getLocator(Repository.getProperty("bg.stateamnt"));
		  stamnt.sendKeys(Repository.getProperty("stateamnt"));
		  WebElement bname =getLocator(Repository.getProperty("bg.buyername"));
		  bname.sendKeys(Repository.getProperty("buyername"));
		  WebElement cnumber =getLocator(Repository.getProperty("bg.custnum"));
		  cnumber.sendKeys(Repository.getProperty("custnum"));
		  
		  WebElement sname =getLocator(Repository.getProperty("bg.shipname"));
		  sname.sendKeys(Repository.getProperty("shipname"));
		  WebElement saddr1 =getLocator(Repository.getProperty("bg.shipaddr1"));
		  saddr1.sendKeys(Repository.getProperty("shipaddr1"));
		  WebElement saddr2 =getLocator(Repository.getProperty("bg.shipaddr2"));
		  saddr2.sendKeys(Repository.getProperty("shipaddr2"));
		  WebElement scty =getLocator(Repository.getProperty("bg.shipcity"));
		  scty.sendKeys(Repository.getProperty("shipcity"));
		  WebElement sstate =getLocator(Repository.getProperty("bg.shipstate"));
		  sstate.sendKeys(Repository.getProperty("shipstate"));
		  WebElement szip =getLocator(Repository.getProperty("bg.shipzip"));
		  szip.sendKeys(Repository.getProperty("shipzip"));
		  WebElement scoun =getLocator(Repository.getProperty("bg.shipcoun"));
		  scoun.sendKeys(Repository.getProperty("shipcoun"));
	      
		  	  
	} 
	
	public static void level3b() throws Exception{
        
		  getLocator(Repository.getProperty("bg.level3")).click();
		  
		  WebElement sq =getLocator(Repository.getProperty("bg.seq"));
		  sq.sendKeys(Repository.getProperty("seq"));
		  WebElement qut =getLocator(Repository.getProperty("bg.quant"));
		  qut.sendKeys(Repository.getProperty("quant"));
		  WebElement ucst =getLocator(Repository.getProperty("bg.ucost"));
		  ucst.sendKeys(Repository.getProperty("ucost"));
		  WebElement ides =getLocator(Repository.getProperty("bg.itemdes"));
		  ides.sendKeys(Repository.getProperty("itemdes"));
		  WebElement umea =getLocator(Repository.getProperty("bg.umeasure"));
		  umea.sendKeys(Repository.getProperty("umeasure"));
		  
		  WebElement ccode =getLocator(Repository.getProperty("bg.commcode"));
		  ccode.sendKeys(Repository.getProperty("commcode"));
		  WebElement pcode =getLocator(Repository.getProperty("bg.prodcode"));
		  pcode.sendKeys(Repository.getProperty("prodcode"));
		  WebElement tamnt =getLocator(Repository.getProperty("bg.taxamnt"));
		  tamnt.sendKeys(Repository.getProperty("taxamnt"));
		  WebElement rate1 =getLocator(Repository.getProperty("bg.taxrate1"));
		  rate1.sendKeys(Repository.getProperty("taxrate1"));
		  WebElement ltotal =getLocator(Repository.getProperty("bg.lnetotal"));
		  ltotal.sendKeys(Repository.getProperty("lnetotal"));
		  WebElement dsc =getLocator(Repository.getProperty("bg.itemdsc"));
		  dsc.sendKeys(Repository.getProperty("itemdsc"));
		  
	}    
	
	public static void makeACHTransaction(String TransactionType, String Name, String Amount) throws Exception{
        
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
		  
		  WebElement trmode1 = getLocator(Repository.getProperty("bg.processing.virtualt.check"));
		  if (trmode1.isSelected()) {
		       System.out.println("Test mode is selected");
	      }
		  else
	      {
	    	 trmode1.click(); 
	      }
	      
		  Select ttype = new Select(getLocator(Repository.getProperty("bg.processing.virtualt.trantype")));
		  ttype.selectByValue(TransactionType);
		  
		  WebElement amount =getLocator(Repository.getProperty("bg.processing.virtualt.achamnt"));
		  amount.sendKeys(Amount);
		  WebElement rout =getLocator(Repository.getProperty("bg.processing.virtualt.achrout"));
		  rout.sendKeys("123123123");
		  WebElement acno =getLocator(Repository.getProperty("bg.processing.virtualt.achaccnt"));
		  acno.sendKeys("123123");
		  
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
	
	public static void processTransAch() throws Exception{
		
		  getLocator(Repository.getProperty("bg.processing.virtualt.process")).click();
		  driverwait();
		  System.out.println(getLocator(Repository.getProperty("bg.approved")).getText());
		  System.out.println(getLocator(Repository.getProperty("bg.amount")).getText());
		  System.out.println(getLocator(Repository.getProperty("bg.tid")).getText()+getLocator(Repository.getProperty("bg.nid")).getText());
		  getLocator(Repository.getProperty("bg.ach.vewrec")).click();
		  driverwait();
		  getLocator(Repository.getProperty("bg.trandetails")).click();
		  
		}
	
}	
	