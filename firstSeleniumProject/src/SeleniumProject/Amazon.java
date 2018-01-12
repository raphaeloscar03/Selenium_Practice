package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Amazon {

	public static void main(String[] args) throws InterruptedException {
		// This is a Test Line
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("http://www.amazon.com");
		Thread.sleep(3000);
		cdriver.findElement(By.xpath("//select[@id='searchDropdownBox']/option[text()='Alexa Skills']")).click();	
		
	}
	
}
