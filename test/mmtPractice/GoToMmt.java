package mmtPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoToMmt {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUP() {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void redirectToMMT() {
		
		driver.get("https://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("make my trip");
		
		driver.findElement(By.name("q")).sendKeys(Keys.ARROW_DOWN);
		
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//a[contains(@href,'makemytrip')]")).click();
		
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void bookFlight() {
		
		//driver.findElement(By.xpath("//a[contains(@href,'flights')]/span[2]")).click();
		
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		
//		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[@role='combobox']/input[@placeholder='From']")));
//		
//		//driver.findElement(By.xpath("//input[@placeholder='From']")).click();
//		
//		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("Mum");
//		
//		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(Keys.DOWN);
//		
//		System.out.println(driver.findElement(By.xpath("//input[@placeholder='From']")).getAttribute("value"));
		
		new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='react-autosuggest__container react-autosuggest__container--open' and @role='combobox']/input"))).click();
		List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[@class='ui-menu-item'][starts-with(@id,'ui-id-')]//span[@class='autoCompleteItem__label']")));
		for (WebElement element:myList) {
		    if(element.getText().contains("Mumbai"));
		        element.click();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
