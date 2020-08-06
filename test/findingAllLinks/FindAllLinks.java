package findingAllLinks;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindAllLinks {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		 
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
			
			//Open browser
		    driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void findingAllLinksOnGoogle() throws InterruptedException {
		
		driver.get("https://www.google.com");
		
		Thread.sleep(3000);
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links) {
			System.out.println(link.getText());
		}
	}
}
