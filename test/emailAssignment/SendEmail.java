package emailAssignment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SendEmail {

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
	public void sendmail() throws InterruptedException {
		
		driver.get("https://accounts.google.com/signin/v2/identifier?hl=en-GB&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		//driver.get("https://accounts.google.com/signin/v2/sl/pwd?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		Thread.sleep(3000);
		
		driver.findElement(By.name("identifier")).sendKeys("rohankambuj1987@gmail.com");
		
		driver.findElement(By.id("identifierNext")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.name("password")).sendKeys("prajrohan181112");
		
		driver.findElement(By.id("passwordNext")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
        Thread.sleep(3000);
		
		//driver.findElement(By.className("vO")).sendKeys("shreekhedkar@gmail.com");
		driver.findElement(By.xpath("//textarea[@name='to']")).sendKeys("shreekhedkar@gmail.com");
		
		driver.findElement(By.name("subjectbox")).sendKeys("<Rohan Kambuj> This is automated email");
		
		driver.findElement(By.xpath("//div[text()='Send']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("span[class='gb_ab gbii']")).click();
		
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}
}
