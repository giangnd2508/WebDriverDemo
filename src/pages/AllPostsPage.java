package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Links;

public class AllPostsPage extends BasePage {

	WebDriver driver;

	@FindBy(css = "#the-list > tr:nth-of-type(1) .submitdelete")
	private WebElement DeleteBtn;

	@FindBy(css = "#the-list > tr:nth-of-type(1) .title")
	private WebElement firstRow;

	@FindBy(id = "cat")
	private WebElement catSelect;

	@FindBy(id = "post-query-submit")
	private WebElement filterBtn;

	@FindBy(id = "post-search-input")
	private WebElement searchInput;

	@FindBy(id = "search-submit")
	private WebElement searchBtn;

	@FindBy(css = "#the-list strong a")
	private List<WebElement> postList;

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

	public void searchPost(String keyword) {
		searchInput.sendKeys(keyword);
		searchBtn.click();
	}

	public boolean hasKeyword(String keyword) {
		for (int i = 0; i < postList.size(); i++) {
			String postTitle = postList.get(i).getText().toLowerCase();
			if (!(postTitle.contains(keyword.toLowerCase()))) {
				postList.get(i).click();
				driver.switchTo().frame("content_ifr");
				bodyHasKeyword(keyword);
				driver.switchTo().defaultContent();
				driver.navigate().back();
			}
		}
		return true;
	}

	public boolean bodyHasKeyword(String keyword) {
		List<WebElement> paragraphs = driver.findElements(By.cssSelector("#tinymce p"));
		for (int i = 0; i < paragraphs.size(); i++) {
			String p = paragraphs.get(i).getText().toLowerCase();
			if (!(p.contains(keyword.toLowerCase()))) {
				return false;
			}
		}
		return true;
	}
}
