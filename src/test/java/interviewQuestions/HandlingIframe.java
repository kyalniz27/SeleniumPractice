package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingIframe {

	public static void main(String[] args) throws InterruptedException {
		// IFrame located in a page but you can't interact with them directly because they come from another source and they
		// are inside the frame.
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//1st frame
		driver.switchTo().frame("packageListFrame"); // Name of the frame 
		driver.findElement(By.xpath("//a[normalize-space()='org.openqa.selenium']")).click();
		driver.switchTo().defaultContent(); // go back to the main page
		
		Thread.sleep(3000);
		
		//2nd frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//span[normalize-space()='WebDriver']")).click();
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		//3rd frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//div[@class='topNav']//ul[@title='Navigation']//li//a[@href='help-doc.html'][normalize-space()='Help']")).click();
		
		
		
		
		

	}

}
