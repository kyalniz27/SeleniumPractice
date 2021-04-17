package interviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckDropdownSorted {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get("https://www.twoplugs.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Live Posting')]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'All')]")).click();
		
		List<WebElement> listOptions = driver.findElements(By.xpath("//select[@name='category_id']/option"));
		int listSize = listOptions.size();
		
		for(int i = 0; i < listSize; i++){
			
			System.out.println(i + " : " + listOptions.get(i).getText());
		}
		
		ArrayList originalList = new ArrayList();
		ArrayList tempList = new ArrayList();
		
		for (WebElement x : listOptions) {
			originalList.add(x.getText());
			tempList.add(x.getText());
		}
		
		Collections.sort(tempList);
		
		if (originalList.equals(tempList)) {
			System.err.println("Sorted");
		} else{
			System.err.println("Unsorted");
		}

		
		driver.quit();
	}

}
