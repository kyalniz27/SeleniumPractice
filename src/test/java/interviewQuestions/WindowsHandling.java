package interviewQuestions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.graph.SuccessorsFunction;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//getWindowHandle() --> It returns the ID of the single browser window. It returns string and could be dynamic.
		String windowID = driver.getWindowHandle();
		//System.out.println(windowID);
		
		//getWindowHandles() --> It returns the ID of the multiple browser windows.It returns string and could be dynamic.
		//It allows to travel between multiple windows.
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set<String> windowIDs = driver.getWindowHandles(); // --> It returns multiple browser of IDs
		
		//1. Method: Iterator
//		Iterator<String> it = windowIDs.iterator();
//		String parentWindowID = it.next();
//		String childWindowID = it.next();
//		
//		System.out.println("Parent window ID: " + parentWindowID);
//		System.out.println("Child window ID: " + childWindowID);
		
		//2. Method: Using List collection
		//List and Set are both different collections. But ArrayList is implemented from List interface.
		//In Set interface duplicate elements are not allowed. But in List it is OK. 
		List<String> windowsIDsList = new ArrayList(windowIDs); //Converting Set to List
		String parentWindowID = windowsIDsList.get(0); // Returns parent window ID
		String childWindowID = windowsIDsList.get(1); // Returns child window ID
		
		System.out.println("Parent window ID: " + parentWindowID);
		System.out.println("Child window ID: " + childWindowID);
		
		//How to switch windows by using IDs
//		driver.switchTo().window(parentWindowID);
//		System.out.println("Parent window title: " + driver.getTitle());
//		
//		driver.switchTo().window(childWindowID);
//		System.out.println("Child window title: " + driver.getTitle());
		
		//For each loop
//		for (String string : windowsIDsList) {
//			
//			String title = driver.switchTo().window(string).getTitle();
//			System.out.println("Title: "+title);
//		}
		
		driver.switchTo().window(childWindowID);
		driver.findElement(By.xpath("//a[normalize-space()='Contact Sales']")).click();
		String contactSaleTitle = driver.getTitle();
		System.out.println("Contact sale: " + contactSaleTitle);
		
		driver.close();
	}

}
