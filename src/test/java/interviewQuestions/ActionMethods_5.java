package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionMethods_5 {

	public static void main(String[] args) {
		// Mouse hover over action
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement desktopMenu = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement macMenu = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		
		Actions actions = new Actions(driver);
		actions.moveToElement(desktopMenu).moveToElement(macMenu).click().perform();
		
		
		

	}

}
