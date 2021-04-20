package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionMethods_2 {

	public static void main(String[] args) {
		// Double click action
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElement(By.xpath("//input[@id='field1']")).clear();
		driver.findElement(By.xpath("//input[@id='field1']")).sendKeys("Welcome to Selenium");
		
		WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		Actions actions = new Actions(driver);
		actions.doubleClick(button).perform();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
