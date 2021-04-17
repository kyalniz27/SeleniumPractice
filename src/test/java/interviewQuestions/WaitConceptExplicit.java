package interviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitConceptExplicit {

	public static void main(String[] args) throws Exception{
		// Explicit wait interacts with specific element. You might have to implement more than once on a page.
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		By locator = By.xpath("//h3[contains(text(),'SeleniumHQ Browser Automation')]");
		waitForElementPresent(driver, 10, locator).click();
		
			
		Thread.sleep(2000);
		driver.close();

	}
	
	public static WebElement waitForElementPresent(WebDriver driver, int timeOut, By locator){
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		
		return driver.findElement(locator);
	}

}
