import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.logging.Level;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;
public class NetworkCallTest {
	    public static void main(String[] args) {
	        System.setProperty("webdriver.chrome.driver",
	        		"C:\\driver\\chromedriver.exe");
	        
	       
	        ChromeOptions cop = new ChromeOptions();
	        cop.setAcceptInsecureCerts(true);
	        cop.addArguments("--ignore-certificate-errors");
	        cop.addArguments("--disable-popup-blocking");
	        cop.addArguments("--no-sandbox");
	        cop.addArguments("--no-sandbox");

	        LoggingPreferences loggingprefs = new LoggingPreferences();
	        loggingprefs.enable(LogType.BROWSER, Level.ALL);
	        loggingprefs.enable(LogType.CLIENT, Level.ALL);
	        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);
	        loggingprefs.enable(LogType.PROFILER, Level.ALL);

	        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
	        cop.setCapability("goog:loggingPrefs", loggingprefs);

	        cop.merge(capabilities);
	        WebDriver driver = new ChromeDriver(cop);
	        driver.get("http://usbank.com/index.html");
	        try {
	        capture(driver);}catch(Exception e) {}
	        String scriptToExecute = "var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;";
	        String netData = ((JavascriptExecutor)driver).executeScript(scriptToExecute).toString();
	       
	        
	        int status = -1;
	        List<LogEntry> logEntries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
	     
	       
                    
	             
            
	        }
	    
	    public static void capture(WebDriver driver) throws IOException {
	        OutputStream logfile = new FileOutputStream("c:\\cts\\log.txt");
	        PrintStream printlog = new PrintStream(logfile);
	       
	        driver.get("http://www.usbank.com/index.html");
	      
	       List< LogEntry> logs = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
	        for (LogEntry entry : logs) {
	        	if(entry.toString().contains("Query")) {printlog.append(entry.toString());}
	            if (entry.toString().contains("\"type\":\"smetrics.usbank.com/b/ss\""))
	            	     System.out.println(entry.toString());

	            if (entry.toString().contains("c1")) {
	            	
	            	System.out.println("c1 is printed");
	            }
	            if (entry.toString().contains("pageName")) {
	            	if(entry.toString().contains("Personal%20Home%20Page")) {
	            		System.out.println("Found !!");break;
	            		
	            	}
	            }
	            
	            printlog.append(new Date(entry.getTimestamp()) + " " + entry.toString() + " "
	                    + System.getProperty("line.separator"));
	            printlog.append(System.getProperty("line.separator"));
	            printlog.append(System.getProperty("line.separator"));
	        }
	        printlog.close();
	    }
	        	
	    }
	    

	   


    



