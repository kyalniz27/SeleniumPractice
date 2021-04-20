package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActionsMultipleKeys {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		WebElement box1 = driver.findElement(By.id("inputText1"));
		WebElement box2 = driver.findElement(By.id("inputText2"));
		
		box1.sendKeys("Hello World!");
		
		Actions actions = new Actions(driver);
		
		//CTRL + A
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("a");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
	
	
		//CTRL + C
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("c");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		
		//TAB
		actions.sendKeys(Keys.TAB);
		actions.perform();
		
		//CTRL + V
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.perform();
		
		driver.findElement(By.xpath("//div[@class='compareButtonText']")).click();
		
		if (box1.getAttribute("value").equalsIgnoreCase(box2.getAttribute("value"))) {
			System.out.println(driver.findElement(By.xpath("//span[@class='messageForUser']")).getText());
		} else{
			throw new Exception();
		}
		
		driver.quit();
	}

}
