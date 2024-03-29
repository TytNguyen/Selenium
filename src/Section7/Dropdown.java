package Section7;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ttu\\Documents\\ChromeDriver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		//a[@value='MAA'] - Xpath for chennai
		//a[@value='BLR']
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();		
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA'])")).click();
		Thread.sleep(2000);
		//ui-state-default.ui-state-highlight.ui-state-active
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();
		
	}
}
