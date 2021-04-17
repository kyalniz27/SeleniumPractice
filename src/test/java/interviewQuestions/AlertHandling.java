package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertHandling {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Alert with OK button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
		
		//Alert with OK and Cancel button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().dismiss();
		
		//Alert with pop up message and capture the text
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Hello World!");
		System.out.println("Popup message: " + alert.getText());
		
		driver.close();
		
		
		
		
		
		
		
		
		
	}

}
