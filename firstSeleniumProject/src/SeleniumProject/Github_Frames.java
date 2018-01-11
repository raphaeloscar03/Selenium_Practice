package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Github_Frames {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("https://seleniumhq.github.io/selenium/docs/api/java/");
		cdriver.switchTo().frame("packageListFrame");
		cdriver.findElement(By.xpath("//a[text()='com.thoughtworks.selenium']")).click();
		Thread.sleep(5000);
		cdriver.switchTo().defaultContent();
		
		cdriver.switchTo().frame("packageFrame");
		cdriver.findElement(By.xpath("//span[text()='CommandProcessor']")).click();
		Thread.sleep(5000);
		cdriver.switchTo().defaultContent();
		cdriver.switchTo().frame("classFrame");
		String str = cdriver.findElement(By.xpath("//dt[text()='All Known Implementing Classes:']/following::dd/a[1]")).getText();
		System.out.println("Value is :" +str);
		Thread.sleep(5000);
		
		if(str.equals("HttpCommandProcessor"))
				{
			
			System.out.println("Success");
			
				}
		cdriver.switchTo().defaultContent();
		cdriver.close();
		
	}

}
