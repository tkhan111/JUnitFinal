package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.CheckToddlePage;
import util.BrowserFactoryPage;

public class CheckToddleTest {
	
	WebDriver driver;
	
	@Test
	public void validateToddle()  {
	
	driver = BrowserFactoryPage.init();
	
	//PageFactory initializes the web elements using initElements() method.
	//this method take the driver object and the current class as input parameters and returns the
	//page object by implicitly initalizing the elements.
	CheckToddlePage checkToddlePage = PageFactory.initElements(driver, CheckToddlePage.class);
	
	checkToddlePage.addCheckBoxes(BrowserFactoryPage.generateRandomnumber());
	checkToddlePage.clickToddleAllToSelectAllCheckedBoxes();
	
	BrowserFactoryPage.tearDown();
	}

}
