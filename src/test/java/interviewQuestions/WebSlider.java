package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebSlider {

	public static void main(String[] args) {
		// Slider method
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		WebElement minSlider =  driver.findElement(By.xpath("//span[1]"));
		System.out.println("Location of the minimum slider: " + minSlider.getLocation()); //(59, 249)
		System.out.println("Hight and width of the elementr: " + minSlider.getSize()); // (21, 21)
		
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(minSlider, 100, 0).perform();
		
		System.out.println("Location of the minimum slider: " + minSlider.getLocation()); //(59, 249)
		System.out.println("Hight and width of the elementr: " + minSlider.getSize()); // (21, 21)
		
		driver.quit();
		
		
		

	}

}
