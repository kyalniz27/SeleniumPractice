package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDate2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='dob']")).click();
		
		Select monthDrop = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-month']")));
		monthDrop.selectByVisibleText("Oct");
		
		Select yearDrop = new Select(driver.findElement(By.xpath("//select[@class='ui-datepicker-year']")));
		yearDrop.selectByVisibleText("1990");
		
		String date = "15";
		List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
		
		for(WebElement d: allDates){
			if (d.getText().equals(date)) {
				d.click();
				break;
			}
		}
		
		
		driver.quit();
		
		
		

	}

}
