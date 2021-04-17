package interviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementVsElements {
	
	public static void main(String[] args) {
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		//find element
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='small-searchterms']"));
		searchBox.sendKeys("Test");
		
		driver.quit();
	}

}
