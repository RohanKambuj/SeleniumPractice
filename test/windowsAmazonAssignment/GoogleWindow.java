package windowsAmazonAssignment;

//import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GoogleWindow {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver64bit.exe");
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("https://www.google.co.in");
		
		driver.findElement(By.linkText("Gmail")).click();
		
		//String parentWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List <String> windowHandleList = new ArrayList<String>(windowHandles);
		String newWindow = windowHandleList.get(1);
		
		driver.switchTo().window(newWindow);
		
	}

}
