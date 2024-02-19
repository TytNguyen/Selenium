package System.out;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment8 {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.findElement(By.id("autocomplete")).sendKeys("Vie");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.className("ui-menu-item"));
		
		String country = "Vietnam";
		
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase(country)) {
				option.click();
				break;
			}
		}
	}
}
