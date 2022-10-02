package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import junit.framework.Assert;

public class RemoveSingleItemPage {

	WebDriver driver;

	public RemoveSingleItemPage(WebDriver driver) {
		this.driver = driver;
	}
	
	int newNum;

	@FindBy(how = How.XPATH, using = "//input[@type='text' and @name='data']")
	WebElement TextBox;
	@FindBy(how = How.XPATH, using = "//input[@type='submit' and @name='submit' and @value='Add']")
	WebElement AddButton;

	@FindBy(how = How.XPATH, using = "// input[@type='submit' and @value='Remove']")
	WebElement RemoveButton;

	@FindBy(how = How.XPATH, using = "// input[@type='checkbox']")
	WebElement CheckBoxes;

	public void addCheckBoxes(int randomNum) {

		System.out.println("random number is " + randomNum);
		newNum = randomNum;
		for (int i = 0; i < randomNum; i++) {
			TextBox.sendKeys("xyz" + i);
			AddButton.click();
		}
	}

	public void removeSelected() throws InterruptedException {

		List<WebElement> ListOfCheckBoxes = driver.findElements(By.xpath("// input[@type='checkbox']"));

		System.out.println("printing random number in removeSelected method" + newNum);
		System.out.println("Number of check boxes present are: " + ListOfCheckBoxes.size());

		ListOfCheckBoxes.get(1).click();
		for (int i = 0; i < ListOfCheckBoxes.size(); i++) {
			if (ListOfCheckBoxes.get(i).isSelected()) {
				Thread.sleep(2000);
				RemoveButton.click();
				break;
			}
			else {
				System.out.println("check boxes are not selected");
			}
		}
		//System.out.println("new Number of check boxes present are: " + ListOfCheckBoxes.size());
	}
}
