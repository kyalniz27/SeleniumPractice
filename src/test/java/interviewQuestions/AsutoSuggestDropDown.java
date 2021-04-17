package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AsutoSuggestDropDown {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.bing.com");
		System.out.println("Before: "+driver.getTitle());
		
		driver.findElement(By.xpath("//input[@id='sb_form_q']")).click();
		
		List<WebElement> autoSuggests = driver.findElements(By.xpath("//li[@class='sa_sg']//span"));
		
		for (WebElement webElement : autoSuggests) {
			if (webElement.getText().equals("johnson and johnson covid-19 vaccine")) {
				webElement.click();
				break;
			}
		}
		
		System.out.println("After: "+driver.getTitle());
		

		driver.quit();
	}

}
