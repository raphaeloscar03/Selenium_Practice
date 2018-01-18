package SeleniumProject;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Date of Travel in DD/Month/YYYY Format");
		String TravelDate = s.next();
		s.close();
		
		String Date =   TravelDate.split("/")[0];
		String Month =   TravelDate.split("/")[1];
		String Year =   TravelDate.split("/")[2];
		
		WebDriver cdriver = new ChromeDriver();
		cdriver.get("https://www.makemytr																																																			qip.com/");
		cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[1]/section/div[2]/div[1]/input")).clear();
		cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[1]/section/div[2]/div[2]/input")).clear();
		cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[1]/section/div[2]/div[2]/input")).sendKeys("Hyderabad (HYD)");
		cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[1]/section/div[2]/div[3]/input")).click();
		
		String DispYear = cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[2]")).getText();
		String DispMonth = cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[1]")).getText();
		
		while(!Year.equals(DispYear))
		{
			
			cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/a/span")).click();
			DispYear = cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[2]")).getText();
			
		}
		
		while(!Month.equals(DispMonth))
		{
			
			cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[2]/div/a/span")).click();
			DispMonth = cdriver.findElement(By.xpath("html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/div/div/span[1]")).getText();
			
		}
		
		WebElement Cal = cdriver.findElement(By.xpath("//div[@class='dateFilter hasDatepicker']"));
		List<WebElement> CalRowList = Cal.findElements(By.tagName("tr"));
		
		for(int i=0;i<CalRowList.size();i++)
		{
			WebElement CalRow = CalRowList.get(i);
			List<WebElement> CalDataList = CalRow.findElements(By.tagName("td"));
			
			for(int j=0; j<CalDataList.size(); j++)
			{
				
				if(Date.equals(CalDataList.get(j).getText().trim()))
				{
					CalDataList.get(j).click();
				}
				
			}
			
			
		}
		
	}
	
}
