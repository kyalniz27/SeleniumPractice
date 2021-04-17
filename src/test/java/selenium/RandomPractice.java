package selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomPractice {

	
	
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://turkceokulu.com/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("#menu1")).click();
		driver.findElement(By.name("Email")).sendKeys("mustafakokluusa@gmail.com");
		driver.findElement(By.name("Password")).sendKeys("1324");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#btn-login")).click();
		
		//driver.findElement(By.xpath("//body/div[@id='content']/div[@id='StaticHtml_65']/div[1]/div[1]/h3[1]/div[1]/a[1]")).click();
		

		//driver.quit();
	}

}
