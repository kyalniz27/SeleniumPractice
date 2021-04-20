package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.redbus.in/");
		driver.manage().window().maximize();
		
		String year = "2021";
		String month = "July";
		String day = "10";
		
		driver.findElement(By.xpath("//input[@id='onward_cal']")).click();
		
		while (true) {
			String monthYear =driver.findElement(By.xpath("//td[@class='monthTitle']")).getText();
			
			String arr[] = monthYear.split(" ");
			String mon = arr[0];
			String yr = arr[1];
			
			if (mon.equalsIgnoreCase(month) && yr.equalsIgnoreCase(year)) {
				break;
			}else{
				driver.findElement(By.xpath("//td[@class='next']//button")).click();
			}
			
		}
		
		//Date selection
		List<WebElement> allDates = driver.findElements(By.xpath("//tbody/tr/td"));
		
		for(WebElement ele: allDates){
			String dt = ele.getText();
			if (dt.equals(day)) {
				ele.click();
				break;
			}
		}
		
		

	}

}
