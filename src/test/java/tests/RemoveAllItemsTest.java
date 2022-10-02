package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.RemoveAllItemsPage;
import util.BrowserFactoryPage;

public class RemoveAllItemsTest {

	WebDriver driver;

	@Test
	public void validateToddleRemove() throws InterruptedException {

		driver = BrowserFactoryPage.init();

		// PageFactory initializes the web elements using initElements() method.
		// this method take the driver object and the current class as input parameters
		// and returns the
		// page object by implicitly initalizing the elements.
		RemoveAllItemsPage removeAllItems = PageFactory.initElements(driver, RemoveAllItemsPage.class);
		removeAllItems.addCheckBoxes(BrowserFactoryPage.generateRandomnumber());
		removeAllItems.clickToddleAllToUnselectAllCheckedBoxes();

		BrowserFactoryPage.tearDown();
	}

}
