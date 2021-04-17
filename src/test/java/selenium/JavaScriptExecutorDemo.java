package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {
	
	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.twoplugs.com/");
		driver.manage().window().maximize();
		
		
		WebElement joinFree = driver.findElement(By.xpath("//header/div[1]/ul[1]/li[2]/a[1]"));
		
		//Flashing
		JavaScriptUtil.flash(joinFree, driver);
		
		//Drawing boarder around the element
		JavaScriptUtil.drawBorder(joinFree, driver);
				
		//TakeScreenShot
		JavaScriptUtil.getScreenShot(driver);
		
		//Title of the page
		System.out.println(JavaScriptUtil.getTitleByJS(driver));
		
		//ClickOn
//		WebElement loginBtn = driver.findElement(By.xpath("//header/div[1]/ul[1]/li[1]/a[1]/span[1]"));
//		JavaScriptUtil.clickElementByJS(loginBtn, driver);
//		
//		//After clicking on an element to generate an alert
//		JavaScriptUtil.generateAlert(driver, "You clicked on login button...");
		
		//Refreshing the page
		JavaScriptUtil.refreshBrowserByJS(driver);
		
		//Scroll down the page till we found the element
		WebElement img = driver.findElement(By.xpath("//body/div[1]/section[4]/div[2]/ul[1]/li[1]/div[1]/img[1]"));
		JavaScriptUtil.scrollIntoView(img, driver);
		JavaScriptUtil.flash(img, driver);
		JavaScriptUtil.drawBorder(img, driver);
		
		//Scroll down the page till the bottom of the page
		JavaScriptUtil.scrollPageDown(driver);
		
	//	driver.quit();
		
		
		
		
		
		
	}

}
