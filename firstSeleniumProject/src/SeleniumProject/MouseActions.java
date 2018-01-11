package SeleniumProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public static void main(String[] args){
		//DragandDrop
		
		WebDriver cdriver = new ChromeDriver();
		//cdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		cdriver.get("https://jqueryui.com/droppable/");
		cdriver.manage().window().maximize();
		cdriver.switchTo().frame(0);
		Actions a = new Actions(cdriver);
		a.dragAndDrop(cdriver.findElement(By.id("draggable")), cdriver.findElement(By.id("droppable")));
		a.perform();
		System.out.println("Drag and Drop Completed Successfully");
		//Mouse Hover
		cdriver.get("http://toolsqa.com/");
		a.moveToElement(cdriver.findElement(By.xpath("html/body/div[1]/div[1]/header/nav/ul/li[2]/a/span[1]/span/span")));
		a.moveToElement(cdriver.findElement(By.xpath("html/body/div[1]/div[1]/header/nav/ul/li[2]/ul/li[1]/a/span[1]/span/span")));
		a.click();
		a.perform();
		
		System.out.println("Mouse Hover Completed Successfully");
	}

}
