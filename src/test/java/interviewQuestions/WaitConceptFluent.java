package interviewQuestions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitConceptFluent {

	public static void main(String[] args) {
		// It similar to WebDriverWait with more flexibility in polling time and ignoring exceptions
		// Example: TimeOuts 30 seconds and polling time is 5 seconds. In this case, web driver checks the presence of element in every-
		// 5 seconds up to 30 seconds. So, totally 6 times it will checks and ignore all exceptions if there are.
		// Fluent wait is also element specific like web driver wait.
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		By targetLocator = By.xpath("//h3[contains(text(),'SeleniumHQ Browser Automation')]");
		
		waitForElementWithFluentWait(driver, targetLocator).click();
		
		
		driver.quit();

	}
	
	public static WebElement waitForElementWithFluentWait(WebDriver driver, final By locator){
		
		//Declaration part
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);
		
		//Usage part
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			  public WebElement apply(WebDriver driver) {
			    return driver.findElement(locator);
			  }
			});
		
		return element;
	}

}
