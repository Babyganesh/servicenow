 package servicenow;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class CreatenewProposal extends Commonclass {
	@Test
	public  void createnewProposal() throws InterruptedException {

		/*
		 * Asssignment 2:Create new Proposal 
		 * "1. Launch ServiceNow application 
		 * 2. Login with valid credential 
		 * 3. Click All and Enter Proposal in filter navigator and* press enter 
		 * 4. Click- new and fill mandatory fields and click 'Submit' Button.
		  5. Verify the successful creation of new Proposal"
		 */
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
		
		Shadow shadow=new Shadow(driver);
		Thread.sleep(10000);
		shadow.setImplicitWait(10);
		 WebElement dom = shadow.findElementByXPath("//div[@id='all']");
		 dom.click();
		 
		 shadow.findElementByXPath("//input[@id='filter']").sendKeys("proposal",Keys.ENTER);
		 dom.click();
		 
		 shadow.findElementByXPath("//span[@class='item-icon']").click();
		 driver.switchTo().frame(shadow.findElementByXPath("iframe[@id='gsft_main']"));
		 
		 Thread.sleep(2000);
		 WebElement newbutton = driver.findElement(By.xpath("//button[text()='New']"));
		 newbutton.click();
		 
		 driver.findElement(By.xpath("//input[@id='std_change_proposal.short_description']")).sendKeys("My Proposal",Keys.ENTER);;
		 driver.findElement(By.xpath("(//button[text()='Submit'])[1]")).click();
		 
		 WebElement creation= driver.findElement(By.xpath("//td[text()='My Proposal']"));
		 String text = creation.getText();
		 System.out.println("successful creation of new Proposal is------"+text);
		 
	}

}
