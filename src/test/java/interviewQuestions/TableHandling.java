package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TableHandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.selenium.dev/downloads/");
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		int rows = driver.findElements(By.xpath("//table[@class='data-list']/tbody/tr")).size();
		System.out.println("Total number of rows: " + rows);
		
		int cols = driver.findElements(By.xpath("//table[@class='data-list']/thead/tr/th")).size();
		System.out.println("Total number of column: " + cols);
		
		
		String singleValue = driver.findElement(By.xpath("//table[@class='data-list']//tr[2]//td[1]")).getText();
		System.out.println("The value is: " + singleValue);
		
		
//		System.out.println("********************************");
//		System.out.println("All data from the table");
//		for (int r = 1; r <= rows; r++) {
//			
//			for (int c = 1; c < cols; c++) {
//				String data = driver.findElement(By.xpath("//table[@class='data-list']//tr["+r+"]//td["+c+"]")).getText();
//				System.out.print(data + " ");
//			}
//			System.out.println();
//		}
		
		for (int i = 1; i < rows; i++){
			String language = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+i+"]/td[1]")).getText();
			if (language.equalsIgnoreCase("java")) {
				String version = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+i+"]/td[2]")).getText();
				String release = driver.findElement(By.xpath("//table[@class='data-list']/tbody/tr["+i+"]/td[3]")).getText();
				System.out.println(language + "  " + version+ "  " + release);
			}
		}
		
		
		driver.quit();

	}

}
