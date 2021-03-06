// <summary>
//    Webdriver Factory
// </summary>
// <revision>
//     Author:	Nidhish Jain
//     Date:	07/14/2015		Action: Created
// </revision>
package test.Core;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebdriverFactory {
	
	public static WebDriver driver;
	public static DesiredCapabilities dc;
	 
	 public WebDriver getDriver(String browser,String server,String port)
	 {	
		  switch (browser) {
        case "chrome":
        	System.setProperty("webdriver.chrome.driver", "Drivers/chromeDriver.exe");
        	dc= DesiredCapabilities.chrome();
        		dc.isJavascriptEnabled();
        	driver=new ChromeDriver(dc);
        	break;
        case "firefox":
        	dc=DesiredCapabilities.firefox();
        	dc.isJavascriptEnabled();
        	//dc.setBrowserName("Firefox");
        	driver=new FirefoxDriver(dc);
            break;
        
        case "iExplorer":
        	
        	dc=DesiredCapabilities.internetExplorer();
        	dc.isJavascriptEnabled();
        	//dc.setBrowserName("iExplorer");
        	driver=new InternetExplorerDriver(dc);
            break;
                  
    }
		  try {
			driver = new RemoteWebDriver(new URL("http://"+server+":"+port+"/wd/hub"), dc);
					
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  // driver=new WebDriver(dc); 
	return driver;
   
  
		}
	 
}

