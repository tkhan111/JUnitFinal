package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.RemoveAllItemsPage;
import pages.RemoveSingleItemPage;
import util.BrowserFactoryPage;

public class RemoveSingleItemTest {
	
	WebDriver driver;

	@Test
	public void validateToddleRemoveSingle() throws InterruptedException {

		driver = BrowserFactoryPage.init();

		// PageFactory initializes the web elements using initElements() method.
		// this method take the driver object and the current class as input parameters
		// and returns the
		// page object by implicitly initalizing the elements.
		RemoveSingleItemPage removeSingleItem = PageFactory.initElements(driver, RemoveSingleItemPage.class);
		removeSingleItem.addCheckBoxes(BrowserFactoryPage.generateRandomnumber());
		removeSingleItem.removeSelected();

		BrowserFactoryPage.tearDown();
	}

}
