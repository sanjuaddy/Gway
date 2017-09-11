package bg.webLinks;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebLinks {
	
	public static List findAllLinks(WebDriver driver)
	 
	  {
	 
		  List<WebElement> elementList = new ArrayList();
	 
		  elementList = driver.findElements(By.tagName("a"));
	 
		  elementList.addAll(driver.findElements(By.tagName("img")));
	 
		  List<WebElement> finalList = new ArrayList(); 
	 
		  for (WebElement element : elementList)
	 
		  {
	 
			  if(element.getAttribute("href") != null)
	 
			  {
	 
				  finalList.add(element);
	 
			  }		  
	 
		  }	
	 
		  return finalList;
	 
	  }
	 
		public static String isLinkBroken(URL url) throws Exception
	 
		{
	 
			//url = new URL("http://yahoo.com");
	 
			String response = "";
	        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	 
			try
	 
			{
	            connection.connect();
			    response = connection.getResponseMessage();	        
			    connection.disconnect();
			    return response;
	 
			}
	        catch(Exception exp)
	 
			{
	            return "Not a link";
	        }  				
	 
		}	

}
