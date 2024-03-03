package Section14;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LiveDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//click on the column 
		driver.findElement(By.xpath("//tr//th[1]")).click();
		
		//capture all webelements into the list
		List<WebElement> elementsList = driver.findElements(By.xpath("//tr//td[1]"));
		
		//capture text of all webelements into new (original) list
		List<String> originalList = elementsList.stream().map(s->s.getText()).collect(Collectors.toList());
		
		//sort on the list original of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		//compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		//scan the name column with getText -> Beans -> print the price of the Rice
		List<String> price = elementsList.stream().filter(s->s.getText().contains("Beans"))
		.map(s->getPriceVeggie(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
	}

	private static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
		
	}
}