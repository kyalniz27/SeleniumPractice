package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://jqueryui.com/tooltip/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.switchTo().frame(0);
		WebElement inputBox = driver.findElement(By.xpath("//input[@id='age']"));
		String toolTipText = inputBox.getAttribute("title");
		
		System.out.println(toolTipText);
		
		driver.quit();
		
		
		
		
		
		
		
		
		

	}

}
