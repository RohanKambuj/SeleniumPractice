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
import org.openqa.selenium.chrome.ChromeDriver;

public class ToolsQAWindow {

	WebDriver driver;
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium 3.9.1\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		
		String parentWindow = driver.getWindowHandle();
		
		driver.findElement(By.id("button1")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]//*[text()='New Message Window']")).click();
		
		driver.findElement(By.xpath("//*[@id=\"content\"]//*[text()='New Browser Tab']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
//		for (String windowHandle: windowHandles) {
//			driver.switchTo().window(windowHandle);
//			System.out.println(windowHandle);
//		}
		
		List<String> windowHandleList = new ArrayList<String>(windowHandles);
		
		String newBrowserWindow = driver.switchTo().window(windowHandleList.get(1)).getTitle();
		
		System.out.println(newBrowserWindow);
		
        String newMessageWindow = driver.switchTo().window(windowHandleList.get(2)).findElement(By.xpath("/html/body/text()")).getText();
		
		System.out.println(newMessageWindow);
		
        String newBrowserTab = driver.switchTo().window(windowHandleList.get(3)).getCurrentUrl();
		
		System.out.println(newBrowserTab);
		
		driver.switchTo().window(parentWindow);
	}

}
