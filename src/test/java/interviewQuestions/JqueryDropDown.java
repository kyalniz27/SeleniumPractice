package interviewQuestions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JqueryDropDown {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
		
		driver.findElement(By.cssSelector("#justAnInputBox")).click();
		
		selectChoiceValues(driver, "choice 2 1","choice 4","choice 6 2 3","choice 7");
		
	}
	
	public static void selectChoiceValues(WebDriver driver, String... value){
		
		List<WebElement> choiceList = driver.findElements(By.xpath("//li[@class='ComboTreeItemChlid']"));
		
		for (WebElement x : choiceList) {
			String text = x.getText();
			for (String val : value) {
				if (text.equals(val)) {
					x.click();
					break;
				}
			}
		}
	}

}
