package Section14;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class filter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		driver.findElement(By.id("search-field")).sendKeys("rice");
		
		List<WebElement> veggies = driver.findElements(By.xpath("//tr//td[1]"));
		//E.g: 1 results
		List<WebElement> filteredList = veggies.stream().filter(veggie -> veggie.getText()
				.contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), filteredList.size());
	}

}
