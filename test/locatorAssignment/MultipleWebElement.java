package locatorAssignment;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MultipleWebElement {

	WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium 3.9.1\\resources\\geckodriver64bit.exe");
		driver = new FirefoxDriver();
		driver.get("http://toolsqa.com/automation-practice-form/");
		Thread.sleep(5000);
		driver.findElement(By.name("firstname")).sendKeys("Rohan");
		driver.findElement(By.name("lastname")).sendKeys("Kambuj");
		Thread.sleep(2000);
	}

	@After
	public void tearDown() throws Exception {
		
		driver.quit();
	}

	@Test
	public void testRadioButton() {
		
		WebElement genderRadioButton = driver.findElement(By.id("sex-0"));
		
		assertTrue(genderRadioButton.isDisplayed());
		
		if(!genderRadioButton.isSelected()) {
			
			genderRadioButton.click();
		}
		
		assertTrue(genderRadioButton.isSelected());
		
		List <WebElement> expRadioButtons = driver.findElements(By.xpath("//input[@name='exp']"));
		//int radioButtonSize = expRadioButtons.size();
		
//		for(int i=0;i<radioButtonSize;i++) {
//			String radioButtonValue = expRadioButtons.get(i).getAttribute("value");
//		
//			if(radioButtonValue.equals("5")) {
//				if(!radioButton.isSelected()) {
//				//assertEquals("5",radioButtonValue);	
//					expRadioButtons.get(i).click();
//				//}		
//			}
//		}
		
		for(WebElement radioButtonOption:expRadioButtons) {
			String radioButtonValue = radioButtonOption.getAttribute("value");

			if(radioButtonValue.equals("5")) {
			radioButtonOption.click();
			}
		}
	}
	
	//@Test
	public void testCheckBox() {
		
		List <WebElement> professionCheckBoxes = driver.findElements(By.name("profession"));
		
		for(WebElement profCheckBox: professionCheckBoxes) {
			profCheckBox.click();
			assertTrue(profCheckBox.isSelected());
		}
		
		List <WebElement> automationToolCheckBoxes = driver.findElements(By.name("tool"));
		
		for(WebElement autoToolCheckBox: automationToolCheckBoxes) {
			String checkBoxValue = autoToolCheckBox.getAttribute("value");
			if(checkBoxValue.equals("Selenium Webdriver")) {
				autoToolCheckBox.click();				
			}
		//	assertTrue(autoToolCheckBox.isSelected());
		}
	}
	
	//@Test
	public void testDropDown() {
		
		WebElement continentsDropDown = driver.findElement(By.id("continents"));
		
		Select dropDown = new Select(continentsDropDown);
		
		dropDown.selectByIndex(1);
		
//		List <WebElement> dropDownOptions = dropDown.getOptions();
//		int iSize = dropDownOptions.size();
//	 
//		for(int i =0; i<iSize ; i++){
//			String sValue = dropDownOptions.get(i).getText();
//			System.out.println(sValue);
//			}
//		System.out.println(dropDown.getOptions());
	}

    //@Test
    public void multiSelectDropBox() {
         
    	WebElement seleniumCommandsDropBox = driver.findElement(By.id("selenium_commands"));
    	
    	Select multiSelectDropDown = new Select(seleniumCommandsDropBox);
    	
    	assertTrue(multiSelectDropDown.isMultiple());
    	
    	multiSelectDropDown.selectByIndex(0);
    	multiSelectDropDown.selectByIndex(1);
    	multiSelectDropDown.selectByIndex(4);
    	
    	multiSelectDropDown.deselectByIndex(1);
    	
    	List<WebElement> multiSelectedOptions = multiSelectDropDown.getAllSelectedOptions();
    	int selectedOptionsCount = multiSelectedOptions.size();
    	
    	String[] actualSelectedOptions = new String[selectedOptionsCount];
    	
    	for(int i=0;i<selectedOptionsCount;i++) {
    		String actualSelectedOption = multiSelectedOptions.get(i).getText();
    		System.out.println("Options selected are: "+actualSelectedOption);
    		actualSelectedOptions[i]= actualSelectedOption;
    	}
    	
    	String[] expectedSelectedOptions = {"Browser Commands","WebElement Commands"};
    	
    	assertArrayEquals(expectedSelectedOptions, actualSelectedOptions);
    }    
}