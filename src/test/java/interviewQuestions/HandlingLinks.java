package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingLinks {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
//		driver.findElement(By.linkText("Books")).click();
//		driver.navigate().back();
//		driver.findElement(By.linkText("Computers")).click();
		
		
		//To find all the links present on the page using 'a' tag as a common
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Number of links: " + allLinks.size());
		
		int count = 1;
		for (WebElement webElement : allLinks) {
			if (webElement.getText().isEmpty()) {
				continue;
			}
			System.out.println(count + ":" + webElement.getText());
			count++;
		}
		
		driver.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
