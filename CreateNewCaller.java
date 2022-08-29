package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreateNewCaller extends Commonclass {
	
   @Test
	public  void createNewCaller() throws InterruptedException {
		/*
		 * Assignment 3:Create New Caller 
		 * "1. Launch ServiceNow application 
		 * 2. Login  with valid credential 
		 * 3. Click-All and Enter Callers in filter navigator and press enter
		 *  4. Create new Caller by filling all the fields and click  'Submit'. 
		 * 5. Search and verify the newly created Caller" 
		 
		 */		 
			
			Shadow shadow=new Shadow(driver);
			Thread.sleep(10000);
			shadow.setImplicitWait(10);
			 WebElement dom = shadow.findElementByXPath("//div[@id='all']");
			 dom.click();
			 
			Thread.sleep(2000);
			shadow.setImplicitWait(10);
			WebElement filter = shadow.findElementByXPath("//input[@placeholder='Filter']"); 
			filter.click();
			
			Thread.sleep(2000); 
			filter.sendKeys("Callers",Keys.ENTER);
			dom.click();
				
			Thread.sleep(2000); 
			shadow.setImplicitWait(10);
			WebElement callers = shadow.findElementByXPath("//span[@class='item-icon']");
			callers.click();
			
			Thread.sleep(1000);
			shadow.setImplicitWait(10);
			driver.switchTo().frame(shadow.findElementByXPath("iframe[@id='gsft_main']"));
		     
			Thread.sleep(10000);
		    shadow.setImplicitWait(10);
			WebElement newButton = driver.findElement(By.xpath("//button[text()='New']"));
			newButton.click();
			driver.findElement(By.xpath("//input[@id='sys_user.first_name']")).sendKeys("Baby");
			driver.findElement(By.xpath("//input[@id='sys_user.last_name']")).sendKeys("G");
			driver.findElement(By.xpath("//input[@id='sys_user.title']")).sendKeys("Junior Developer");
			driver.findElement(By.xpath("//input[@id='sys_user.email']")).sendKeys("babyganeshece@gmail.com");
			driver.findElement(By.xpath("//input[@id='sys_user.phone']")).sendKeys("9488732119");
			driver.findElement(By.xpath("//input[@id='sys_user.mobile_phone']")).sendKeys("8148757338");
			driver.findElement(By.xpath("(//button[text()='Submit'])[2]")).click();
			
			WebElement drop = driver.findElement(By.xpath("//select[@class='form-control default-focus-outline']"));
			Select select = new Select(drop);
			select.selectByVisibleText("First name");
			
			//Search the name 
			driver.findElement(By.xpath("(//input[@class='form-control'])[1]")).sendKeys("Baby",Keys.ENTER);
			String name = driver.findElement(By.xpath("//table//tr[1]//td[4]")).getText();	
			System.out.println("newly created Caller is-----"+name);	

	}

}
