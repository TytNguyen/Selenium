package Section11;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CalenderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String monthNumber = "6";
		String date = "15";
		String year = "2027";
		String[] expectedList = {monthNumber,date,year};

		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.cssSelector(".react-date-picker__inputGroup")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(monthNumber)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+date+"']")).click();

		List<WebElement> actualList = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

		for(int i =0; i<actualList.size();i++) {
		System.out.println(actualList.get(i).getAttribute("value"));
		Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
		}
		driver.close();

	}

}
