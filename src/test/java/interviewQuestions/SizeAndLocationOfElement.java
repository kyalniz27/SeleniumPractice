package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SizeAndLocationOfElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']//img"));
		
		//Location - method1
		System.out.println("Location(x,y): " +logo.getLocation());
		System.out.println("Location(x): " +logo.getLocation().getX());
		System.out.println("Location(y): " +logo.getLocation().getY());
		
		//Location - method2
		System.out.println("Location(x): " +logo.getRect().getX());
		System.out.println("Location(y): " +logo.getRect().getY());
		
		//Size - Method1
		System.out.println("Size(Width,Hight): " + logo.getSize());
		System.out.println("Size(Hight): " + logo.getSize().getHeight());
		System.out.println("Size(Width): " + logo.getSize().getWidth());
		
		
		
		driver.quit();
		
	}

}
