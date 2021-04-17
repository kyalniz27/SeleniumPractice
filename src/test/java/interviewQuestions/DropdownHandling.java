package interviewQuestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.nashorn.internal.runtime.options.Options;

public class DropdownHandling {

	public static void main(String[] args) throws Exception {
		
		

		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		WebElement element = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		Select select = new Select(element);
		
//		select.selectByValue("option3");
//		Thread.sleep(1000);
//		select.selectByVisibleText("Option1");
//		Thread.sleep(1000);
//		select.selectByIndex(2);
		
//		List<WebElement> options = select.getOptions();
//		
//		for (int i = 0; i < options.size(); i++) {
//			if (options.get(i).getText().equals("Option3")) {
//				options.get(i).click();
//				break;
//			}
//		}
//		
//		for (WebElement webElement : options) {
//			if (webElement.getText().equals("Option2")) {
//				webElement.click();
//				break;
//			}
//		}
		
		getSelectMethod(element, "Option1");
		
		Thread.sleep(1000);
		driver.quit();

	}
	
	
	
	public static void getSelectMethod(WebElement element, String text){
		Select select = new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	
	}
	
	


