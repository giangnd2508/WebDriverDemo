package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrashPage {

	WebDriver driver;

	@FindBy(css = "#the-list > tr:nth-of-type(1) .title")
	private WebElement firstRow;

	public TrashPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getTitleFirstPost() {
		return firstRow.getText();
	}

}
