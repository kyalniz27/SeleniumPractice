package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoPractice {

		WebDriver driver;
		WebElement element;
		
		
		
		@BeforeTest
		public void setUp(){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("http://turkceokulu.com/");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		}
		
		
		
		@Test(enabled=false)
		public void testCase() throws InterruptedException{
			
			
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			driver.findElement(By.cssSelector("#menu1")).click();
			Thread.sleep(1000);
			driver.findElement(By.name("Email")).sendKeys("test123@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.name("Password")).sendKeys("test123");
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//input[@id='btn-login']")).click();
			//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='btn-login']"))).click();
			//driver.findElement(By.cssSelector("#btn-login")).click();
			driver.findElement(By.xpath("(//div[@class='form-group'])[2]/following-sibling::input")).click();
//			element = driver.findElement(By.xpath("//input[@id='btn-login']"));
//			
//			JavaScriptUtil.clickElementByJS(element, driver);
//			
			Thread.sleep(1000);
			String warning = driver.findElement(By.xpath("//div[@class='modal-content']/div[2]")).getText().trim();
			System.out.println(warning);
//			Thread.sleep(1000);
//			System.out.println(driver.findElement(By.cssSelector("#btnClose")).isEnabled());
			
			driver.findElement(By.xpath("//button[@id='btnClose']")).click();
		}
		
		@Test
		public void harmoni1(){
			driver.findElement(By.cssSelector("#menu1")).click();
			driver.findElement(By.name("Email")).sendKeys("mustafakokluusa@gmail.com");
			driver.findElement(By.name("Password")).sendKeys("1324");
			driver.findElement(By.xpath("//input[@id='btn-login']")).click();
			
			
			
		}
		
	
		@AfterTest
		public void tearDown(){
			driver.quit();
		}

}
