package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionMethods_4 {

	public static void main(String[] args) {
		// Mouse drag and drop
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/demo-site/draganddrop");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement picture = driver.findElement(By.xpath("//li[1]"));
		WebElement target = driver.findElement(By.id("trash"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(picture, target).perform();
		
		
		
		
		

	}

}
