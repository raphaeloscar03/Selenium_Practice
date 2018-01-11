package SeleniumProject;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Rediff_IFrame {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver cdriver = new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		cdriver.get("http://www.rediff.com/");
		cdriver.manage().window().maximize();
		cdriver.findElement(By.className("newsrchbtn")).click();;
		Alert a = cdriver.switchTo().alert();
		String aMessage = a.getText();
		System.out.println("The Alert Message is :" + aMessage);
		a.accept();
		cdriver.switchTo().frame("moneyiframe");
		cdriver.findElement(By.xpath("//input[@class='mw001-widget-getquote']")).sendKeys("TCS");
		cdriver.findElement(By.xpath("//div[@class='mw001-widget-getquote-btn']")).click();
		cdriver.switchTo().defaultContent();
		String pWindow= cdriver.getWindowHandle();
		Set<String> windows = cdriver.getWindowHandles();
		for(String wName: windows)
		{
			if(!(wName.equals(pWindow)))
			{

				cdriver.switchTo().window(wName);
				String StockVal = cdriver.findElement(By.id("ltpid")).getText();
				System.out.println("The TCS Stock Value is:" +StockVal);
				double ConvStockVal = Double.parseDouble(StockVal.replace(",", "").trim());
				System.out.println("The TCS Converted Stock Value is:" +ConvStockVal);
				cdriver.close();
			}


		}

		cdriver.switchTo().window(pWindow);
		cdriver.close();

	}

}
