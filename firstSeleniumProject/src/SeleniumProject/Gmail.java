package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Gmail {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("http://www.gmail.com");
		cdriver.findElement(By.xpath("//input[@aria-label='Email or phone']")).sendKeys("raph.oscar.w");
		Thread.sleep(5000);
		cdriver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		cdriver.findElement(By.xpath("//input[@aria-label='Enter your password']")).sendKeys("metalica03");
		Thread.sleep(5000);
		cdriver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(5000);
		if(cdriver.getTitle().contains("Inbox"))
		{
			cdriver.findElement(By.xpath("//span[@class='gb_ab gbii']")).click();
			Thread.sleep(5000);
			cdriver.findElement(By.xpath("//a[@id='gb_71']")).click();
		}
		
	}

}
