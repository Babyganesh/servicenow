package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

/*"1. Launch ServiceNow application
2. Login with valid credentials username as admin and password as India@123
3. Click-AllEnter Service catalog in filter navigator and press enter 
4. Click on  mobiles
5.Select Apple iphone6s
6.Update color field to rose gold and storage field to 128GB
7.Select  Order now option
8.Verify order is placed and copy the request number"
*/
public class OrderingMobile extends Commonclass {
	
	@Test
	public  void orderingMobile() throws InterruptedException {
		
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver=new
		 * ChromeDriver(); driver.get("https://dev41075.service-now.com/");
		 * driver.manage().window().maximize();
		 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 * 
		 * driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		 * driver.findElement(By.id("user_password")).sendKeys("Service@123");
		 * driver.findElement(By.xpath("//button[@id='sysverb_login']")).click();
		 */
		
		Shadow shadow = new Shadow(driver);
		Thread.sleep(10000);
		shadow.setImplicitWait(10);
		WebElement dom = shadow.findElementByXPath("//div[@id='all']");
		dom.click();
		
		Thread.sleep(2000); 
		WebElement serviceCatalog = shadow.findElementByXPath("//span[text()='Service Catalog']");
		serviceCatalog.click();
		
		Thread.sleep(10000); 
		WebElement frameHandle = shadow.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(frameHandle);
		driver.findElement(By.xpath("//h2[contains(text(), 'Mobiles')]")).click();
		
//		driver.findElement(By.xpath("//span[contains(text(), 'Cell phones to meet your business needs')]")).click();
		
		//driver.findElement(By.xpath("(//table[@class='no_underline_table'])[2]")).click();
		
		driver.findElement(By.xpath("//strong[text()='iPhone 6s']")).click();
		WebElement color = driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[1]"));
		Select option=new Select(color);
		option.selectByVisibleText("Gold");
		
	    driver.findElement(By.xpath("(//select[@class='form-control cat_item_option '])[2]")).click();
	    driver.findElement(By.xpath("//option[text()='128']")).click();
	    driver.findElement(By.xpath("//button[@id='oi_order_now_button']")).click();
		
        WebElement orderstatus = driver.findElement(By.xpath("//span[text()='Thank you, your request has been submitted']"));
        String text = orderstatus.getText();
        System.out.println(text+"-----order status");
		
	     WebElement requestNumber = driver.findElement(By.xpath("//a[@id='requesturl']"));
		 String text2 = requestNumber.getText();
		 System.out.println(text2+"----requestNumber");

	}

}
