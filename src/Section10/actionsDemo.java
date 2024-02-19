package Section10;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ttu\\Documents\\ChromeDriver\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		WebDriver driver = new ChromeDriver(options);
		
		
		driver.manage().window().maximize();

		driver.get("https://www.amazon.com/");
		
		Actions a = new Actions(driver);
		
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().build().perform();
		a.moveToElement(move).contextClick().build().perform();
	
	
	}

}
