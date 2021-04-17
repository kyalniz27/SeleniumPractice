package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {

	public static void main(String[] args) throws Exception {
		
		// Sometimes an element on a web site looks like button or drop down but when you inspect them they're actually
		//a link or not a drop down. So, these are examples of bootstraps.  
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hdfcbank.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Select Product Type')]")).click();
		
		List<WebElement> productTypes = driver.findElements(By.xpath("//ul[@class='dropdown1 dropdown-menu']/li"));
		
		System.out.println("Number of optios: " + productTypes.size());

	}

}
