package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sampletest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		ChromeDriver cdriver = new ChromeDriver();
		cdriver.get("http://www.rediff.com");
		cdriver.findElement(By.xpath("html/body/div[2]/div[8]/div[1]/div[1]/div/form/div/input[1]")).clear();
		cdriver.findElement(By.xpath("html/body/div[2]/div[8]/div[1]/div[1]/div/form/div/input[1]")).sendKeys("Flipkart");
		cdriver.findElement(By.cssSelector("input.newsrchbtn")).click();
		System.out.println("Completed");
	}
}