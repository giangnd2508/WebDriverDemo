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

	public void searchPost(String word) {
		searchInput.sendKeys(word);
		searchBtn.click();
	}

	public boolean hasWord(String word) {
		for (int i = 0; i < postList.size(); i++) {
			String postTitle = postList.get(i).getText().toLowerCase();
			if (!(postTitle.contains(word.toLowerCase()))) {
				postList.get(i).click();
				driver.switchTo().frame("content_ifr");
				String body = driver.findElement(By.cssSelector("#tinymce p")).getText();
				if (!(body.contains(word))) {
					return false;
				}
				driver.switchTo().defaultContent();
				driver.navigate().back();
			} 
		}
		return true;
	}
}
