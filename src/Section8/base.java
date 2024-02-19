package Section8;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ttu\\Documents\\ChromeDriver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		ChromeOptions op = new ChromeOptions();
		WebDriver driver = new ChromeDriver(op);
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//expected
		String[] itemsNeeded = {"Cucumber", "Brocolli", "Beetroot", "Potato"};
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		//Thread.sleep(3000);
		addItems(driver, itemsNeeded);

		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		//Thread.sleep(3000);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		
		//explicit wait
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}
	
	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		
		for (WebElement product: products) {
			String name = product.getText().split(" ")[0];
			//format it to get actual vegetable name
			//convert array into array list for easy search
			//check whether name you extracted is present in arrayList or not
					
			List itemsNeededList = Arrays.asList(itemsNeeded);
			
			if (itemsNeededList.contains(name)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(products.indexOf(product)).click();
				if (j == itemsNeeded.length) break;
			}
		}
	}

}
