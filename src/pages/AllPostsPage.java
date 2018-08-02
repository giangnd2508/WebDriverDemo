package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Links;

public class AllPostsPage extends BasePage{

	WebDriver driver;
	
	@FindBy(css = "#the-list > tr:nth-of-type(1) .submitdelete")
	private WebElement DeleteBtn;

	@FindBy(css = "#the-list > tr:nth-of-type(1) .title")
	private WebElement firstRow;
	
	@FindBy(id = "cat")
	private WebElement catSelect;
	
	@FindBy(id = "post-query-submit")
	private WebElement filterBtn;
	
	public AllPostsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isDisplayed() {
		if (Links.URL_ALL_POSTS.equals(driver.getCurrentUrl())) {
			return true;
		} else {
			return false;
		}
	}
	
	public void deleteFirstRowPost() {
		action.moveToElement(firstRow).perform();
		DeleteBtn.click();
	}
	
	public String getTitleFirstPost() {
		return firstRow.getText();
	}

	public void filterByCategory(String cat) {
		Select select = new Select(catSelect);
		catSelect.click();
		select.selectByVisibleText(cat);
		filterBtn.click();
	}
}
