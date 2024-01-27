import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Calender {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ttu\\Documents\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.path2usa.com/travel-companion/");
		
		// Scroll the Page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='form-field-travel_comp_date']")).click();
		
		while (!driver.findElement(By.xpath("//div[@class='flatpickr-month']")).getText().contains("April"))
		{
			Thread.sleep(2000);
		    driver.findElement(By.xpath("//span[@class='flatpickr-next-month']")).click();
		}
		
		//Grab common attribute
		//Put into list and iterate
		Thread.sleep(2000);
		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
		
		for (int i = 0; i< dates.size(); i++) {
			String text = dates.get(i).getText();
			if (text.equalsIgnoreCase("23")) 
			{
				dates.get(i).click();
				break;
			}
		}
	}

}
