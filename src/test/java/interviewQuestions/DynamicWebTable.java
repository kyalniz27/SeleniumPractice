package interviewQuestions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.tagName("button")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Sales']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Orders']")).click();
		
		//Get the number of the page
		String pageText = driver.findElement(By.cssSelector("div[class='col-sm-6 text-right']")).getText();
		System.out.println(pageText);
		
//		String[] pageNumber = pageText.split(" ");
//		for (int i = 0; i < pageNumber.length; i++) {
//			System.out.println(pageNumber[i]);
//		}
		
		String pageNo = pageText.substring(pageText.indexOf("(")+1, pageText.indexOf("Pages")-1);
		int totalPage = Integer.parseInt(pageNo);
		//int totalNo = Integer.valueOf(pageNo);
		System.out.println("Number of page: "+totalPage);
		
		
		for (int i = 1; i <= 10; i++) {
			WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']/li/span"));
			System.out.println("Active page number: "+activePage.getText());
			activePage.click();
			
			int rows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println("Number of rows: " +rows);
			
			//Reading all the rows from each page
			for (int r = 1; r < rows; r++) {
				String orderID = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[2]")).getText();
				String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[3]")).getText();
				String status = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td[4]")).getText();
				
				if (status.equals("Pending")) {
					System.out.println(orderID + "  " + customerName + "   " + status);
				}
				
			}
			
			String pageNo2 = Integer.toString(i+1);
			driver.findElement(By.xpath("//ul[@class='pagination']//li//a[text()='"+pageNo2+"']")).click();
		}
		
		
		
		
		
		
		driver.quit();

	}

}
