package introduction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenium_introduction  {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ttu\\Documents\\ChromeDriver\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		driver.get("https://rahulshettyacademy.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		driver.close();
		}

}
