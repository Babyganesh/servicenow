package servicenow;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class Fillmandatoryfields extends Commonclass{
	
	
	@Test
	public void fillmandatoryfields() throws InterruptedException {
		
		
		/*
		 * 1. Launch ServiceNow application 
		 * 2. Login with valid credentials 
		 * 3. Enter  Knowledge in filter navigator and press enter 
		 * 4. Create new Article
		 * 5.Select  knowledge base as IT and category as IT- java and Click Ok 
		 * 6.Update the other mandatory fields 
		 * 7.Select the submit option
		 */
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver=new
		 * ChromeDriver(); driver.get("https://dev41075.service-now.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		 * driver.findElement(By.id("user_password")).sendKeys("Service@123");
		 * driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		 */
		
		Shadow shadow=new Shadow(driver); 
		Thread.sleep(20000); 
		shadow.setImplicitWait(10);
		WebElement dom = shadow.findElementByXPath("//div[@id='all']");
		dom.click();
		
		Thread.sleep(2000); 
		shadow.setImplicitWait(10);
		WebElement filter = shadow.findElementByXPath("//input[@id='filter']");
		filter.click(); 
		Thread.sleep(2000); 
		shadow.setImplicitWait(10);
		filter.sendKeys("Knowledge",Keys.ENTER);
		dom.click();
		
		Thread.sleep(2000); 
		shadow.setImplicitWait(10);
		WebElement knowledge = shadow.findElementByXPath("//a[contains(@class,'nested-item')]");
		knowledge.click();
		
		Thread.sleep(1000);
		WebElement frameHandle = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameHandle);
		
		driver.findElement(By.xpath("//span[text()='Create an Article']")).click();
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_knowledge_base']")).sendKeys("IT");
		driver.findElement(By.xpath("//input[@id='sys_display.kb_knowledge.kb_category']")).sendKeys("IT - Java");
		driver.findElement(By.xpath("//input[@id='kb_knowledge.short_description']")).sendKeys("June non IT to IT");
	    driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
	    
	
	
	}

}
