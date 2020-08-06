package windowsAmazonAssignment;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AmazonWindow {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver.exe");
		driver = new FirefoxDriver();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testWindowAmazon() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		
		WebElement clickOnImage = driver.findElement(By.xpath("//img[contains(@src,'https://images-na.ssl-images-amazon.com/images/I/51js739JVYL.__AC_SY200_.jpg')]"));
		clickOnImage.click();
		Thread.sleep(5000);
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
//		for(String windowHandle : windowHandles) {
//			driver.switchTo().window(windowHandle).getTitle();
//		}
		
		List <String> windowHandleList = new ArrayList<String>(windowHandles);
		String newWindow = windowHandleList.get(1);
		
		driver.switchTo().window(newWindow);
		String productTitle = driver.findElement(By.xpath("//div[@id='titleSection']//following-sibling::span[contains(text(),'Espoir Mens ESP12457 Analog Blue Dial Watch')]")).getText();
		assertEquals(productTitle,"Espoir Mens ESP12457 Analog Blue Dial Watch");
		
		//driver.findElement(By.xpath("//a[@title=\"Add to Shopping Cart\"]")).click();
	    driver.switchTo().window(parentWindow);	
	}

}
