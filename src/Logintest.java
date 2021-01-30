import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.*;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.*;
public class Logintest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		WebDriver d = new ChromeDriver();
		d.get("https://login.salesforce.com/");
		d.findElement(By.id("username")).sendKeys("Ashwini Iyer");
		d.findElement(By.id("password")).sendKeys("Password");
		
		d.findElement(By.id("Login")).click();
		try {
			Thread.sleep(9000);
			System.out.println(d.findElement(By.cssSelector("div#error.loginError")).getText());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
