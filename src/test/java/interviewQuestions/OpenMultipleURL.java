package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenMultipleURL {

	public static void main(String[] args) {
		// Selenium 4 provides newWindow method that allows you to open multiple URL in the same window.
		// driver.switchTo().newWindow(WindowType.TAB); --> Opens two different URL in the same window
		// driver.switchTo().newWindow(WindowType.WINDOW); --> Opens two different URL not in the same window
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");
		System.out.println(driver.getTitle());
		driver.get("https://www.opencart.com/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.quit();

	}

}
