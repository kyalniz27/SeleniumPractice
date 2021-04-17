package interviewQuestions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetTextVsGetAttributeValue {

	public static void main(String[] args) {
		
		
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement emailBox = driver.findElement(By.xpath("//input[@id='Email']"));
		//emailBox.clear();
		//emailBox.sendKeys("test123@hotmail.com");
		
		//getAttribute() is a method which will return the value of any attribute.
		//getText() is a method which returns anything. It return inner text but it's not related any attribute
		
		String text = emailBox.getAttribute("value");
		String text2 = emailBox.getText();
		System.out.println("getAttribute method: " + text);
		System.out.println("getText method: " + text2);
		
		

	}

}
