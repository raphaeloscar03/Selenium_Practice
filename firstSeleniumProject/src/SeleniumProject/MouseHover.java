package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {
	public static void main(String[] args){
		//DragandDrop
		
		WebDriver cdriver = new ChromeDriver();
		//cdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		Actions a = new Actions(cdriver);
		//Mouse Hover
		cdriver.get("http://toolsqa.com/");
		a.moveToElement(cdriver.findElement(By.xpath("html/body/div[1]/div[1]/header/nav/ul/li[2]/a/span[1]/span/span")));
		a.moveToElement(cdriver.findElement(By.xpath("html/body/div[1]/div[1]/header/nav/ul/li[2]/ul/li[1]/a/span[1]/span/span")));
		a.click();
		a.perform();
		
		System.out.println("Mouse Hover Completed Successfully");

}
	
}

