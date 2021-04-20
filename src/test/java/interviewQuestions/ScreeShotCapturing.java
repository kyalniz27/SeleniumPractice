package interviewQuestions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreeShotCapturing {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Full page screenshot
//		TakesScreenshot tScreenshot=(TakesScreenshot) driver;
//		File src = tScreenshot.getScreenshotAs(OutputType.FILE);
//		File target = new File(".\\screenshots\\homepage.png");
//		FileUtils.copyFile(src, target);
		
		//Screenshot of a particular section		
//		WebElement section = driver.findElement(By.xpath("//div[@class='category-grid home-page-category-grid']"));
//		File src = section.getScreenshotAs(OutputType.FILE);
//		File target = new File(".\\screenshots\\featurepdoducts.png");
//		FileUtils.copyFile(src, target);
		
		
		//Screenshot for a specific element
		WebElement section = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File src = section.getScreenshotAs(OutputType.FILE);
		File target = new File(".\\screenshots\\logo.jpg");
		FileUtils.copyFile(src, target);
		
		driver.quit();
		
	}

}
