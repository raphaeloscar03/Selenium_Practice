package SeleniumProject;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rediff_IFrame {
	
	public static WebDriver cdriver;
	public static Robot r;
	public static long unique;
	public static WebDriver InitializeDriver()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		cdriver = new ChromeDriver();
		return cdriver;
	}
	
	public static void takescreenshot(WebDriver cdriver, String Filename) {
	
	TakesScreenshot ts = (TakesScreenshot) cdriver;
	File Screenshot = ts.getScreenshotAs(OutputType.FILE);
	unique = Calendar.getInstance().getTimeInMillis();
	try {
		FileUtils.copyFile(Screenshot, new File("C:\\Users\\Tools lab4\\Local Repo\\Screenshots\\"+Filename+"_"+unique+".png"));
		} 
	catch (IOException e) 
		{
		e.printStackTrace();
		}
		
	}
	
	public static File robotscreenshot(String Filename) throws IOException, AWTException {
		r = new Robot();
		BufferedImage Img = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		File Robotpic = new File("C:\\Users\\Tools lab4\\Local Repo\\Screenshots\\"+Filename+"_"+unique+".png");
		ImageIO.write(Img, "png", Robotpic);
		return Robotpic;
	}

	
	public static void main(String[] args) throws AWTException, IOException{

		WebDriver cdriver = InitializeDriver();
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
				takescreenshot(cdriver,"Error");
				robotscreenshot("Robot");
				//System.out.println("The Robot Screenshot path is :" + Image);
				cdriver.close();
			}


		}

		cdriver.switchTo().window(pWindow);
		cdriver.close();

	}

}
