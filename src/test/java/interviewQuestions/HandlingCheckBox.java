package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCheckBox {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		
		List<WebElement> days = driver.findElements(By.xpath("//*[@type='checkbox' and contains(@id,'day')]"));
		System.out.println("Total of the check boxes:" + days.size());
		
//		//using for loop
//		for (int i = 0; i < days.size(); i++) {
//			days.get(i).click();
//		}
//		
//		
//		//using for each loop
//		for (WebElement webElement : days) {
//			webElement.click();
//		}
		
//		for (WebElement webElement : days) {
//			
//			String daysOfTheWeek = webElement.getAttribute("id");
//			
//			
//			if (daysOfTheWeek.equals("tuesday")||daysOfTheWeek.equals("thursday")||daysOfTheWeek.equals("saturday")) {
//				webElement.click();
//				continue;
//			}
//			System.out.println(daysOfTheWeek);
//		}
		int num = days.size();
		
		//last 2
//		for (int i = num-2; i <num; i++) {
//			days.get(i).click();
//			
//		}
		
		//first 2
		for (int i = 0; i < num-5; i++) {
			days.get(i).click();
		}
		
		
		
		
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	

}
