package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingAutoCompleteDropdown {

	public static void main(String[] args)throws Exception {
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.twoplugs.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='autocomplete']"));
		
		searchBox.clear();
		searchBox.sendKeys("Toronto");
		
		String text;
		do {
			
			Thread.sleep(2000);
			text = searchBox.getAttribute("value");
			System.err.println(text);
			searchBox.sendKeys(Keys.ARROW_DOWN);
			
			if (text.equals("Toronto, KS, USA")) {
				searchBox.sendKeys(Keys.ENTER);
				break;
			}
			
			
		} while (!text.isEmpty());
		
		
		Thread.sleep(2000);
		driver.quit();
		
	}

}
