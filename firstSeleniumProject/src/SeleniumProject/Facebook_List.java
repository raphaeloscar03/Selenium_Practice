package SeleniumProject;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook_List {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("https://www.facebook.com/r.php?locale=en_GB&display=page");
		cdriver.findElement(By.id("u_0_m")).sendKeys("Raphael");
		Thread.sleep(2000);
		cdriver.findElement(By.id("u_0_o")).sendKeys("Oscar");
		Thread.sleep(2000);
		cdriver.findElement(By.id("u_0_r")).sendKeys("raph.oscar.w@gmail.com");
		Thread.sleep(2000);
		cdriver.findElement(By.id("u_0_u")).sendKeys("raph.oscar.w@gmail.com");
		Thread.sleep(2000);
		cdriver.findElement(By.id("u_0_y")).sendKeys("Password");
		Thread.sleep(2000);

		//Day
		
		WebElement datelist = cdriver.findElement(By.id("day"));
		Select dayselect = new Select(datelist);
		
		List<WebElement> day = dayselect.getOptions();
		
		for(int i=0; i<day.size();i++)
		{
			day.get(i).click();
		}
		
		dayselect.selectByValue("28");
			
		//Month
		
		WebElement monthlist = cdriver.findElement(By.id("month"));
		Select monthselect = new Select(monthlist);
		
		List<WebElement> month = monthselect.getOptions();
		
		for(int i=0; i<month.size();i++)
		{
			month.get(i).click();
		}
		
		monthselect.selectByVisibleText("Mar");
		
		//Year
		
		WebElement yearlist = cdriver.findElement(By.id("year"));
		Select yearselect = new Select(yearlist);
		
		List<WebElement> year = yearselect.getOptions();
		
		for(int i=0; i<year.size();i++)
		{
			year.get(i).click();
		}
		
		yearselect.selectByVisibleText("1990");
	
		
	cdriver.findElement(By.id("u_0_d")).click();
	Thread.sleep(2000);
	cdriver.findElement(By.id("u_0_14")).click();
	Thread.sleep(5000);

	String errormsg = cdriver.findElement(By.id("reg_error_inner")).getText();
	System.out.println(errormsg);
	 if(errormsg.contains("Please")) {
		 
		 System.out.println("Please choose a stronger Password");
		 
	 }
	
	}

}
