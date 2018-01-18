package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Amazon {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("http://www.amazon.com");
		Thread.sleep(3000);
		cdriver.findElement(By.xpath("//select[@id='searchDropdownBox']/option[text()='Alexa Skills']")).click();	
		System.out.println("Completed Successfully");
		
	}
	
}
