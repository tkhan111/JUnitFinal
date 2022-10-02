package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class RemoveAllItemsPage {

	WebDriver driver;

	public RemoveAllItemsPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='data']")
	WebElement TextBox;
	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @name='submit' and @value='Add']")
	WebElement AddButton;
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox' and @name='allbox' and @value='on']")
	WebElement ToddleAll;

	@FindBy(how = How.XPATH, using = "// input[@type='checkbox']")
	WebElement CheckBoxes;

	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @name='submit' and @value='Remove']")
	WebElement RemoveButton;

	public void addCheckBoxes(int RandomNum) {

		for (int i = 0; i < RandomNum; i++) {
			TextBox.sendKeys("xyz" + i);
			AddButton.click();
		}
	}

	public void clickToddleAllToUnselectAllCheckedBoxes() throws InterruptedException {
		ToddleAll.click();

		List<WebElement> ListOfCheckBoxes = driver.findElements(By.xpath("// input[@type='checkbox']"));

		System.out.println("Number of check boxes present are: " + ListOfCheckBoxes.size());

		if (ToddleAll.isSelected()) {
			System.out.println("Toddle all is selected");
			
			for (int i = 0; i < ListOfCheckBoxes.size(); i++) {
				if (ListOfCheckBoxes.get(i).isSelected()) {
					System.out.println("checkbox is selected");

				}
			}
			
			Thread.sleep(3000);
			//removing all the checkboxes
			RemoveButton.click();
		}

		
		

	}
}
