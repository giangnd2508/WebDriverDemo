package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewPostPage extends BasePage {

	@FindBy(id = "content_ifr")
	WebElement iframe;

	@FindBy(id = "title")
	WebElement titleID;

	@FindBy(id = "tinymce")
	WebElement bodyID;

	@FindBy(id = "publish")
	WebElement publishBtn;

	@FindBy(css = "#message a")
	WebElement linkNewPost;

	@FindBy(css = "#edit-slug-box > strong")
	WebElement permalink;

	@FindBy(id = "sample-permalink")
	WebElement linkPost;

	@FindBy(id = "category-add-toggle")
	WebElement addNewCatLink;

	@FindBy(id = "newcategory")
	WebElement newCatInput;
	
	@FindBy(id = "category-add-submit")
	WebElement newCatBtn;

	WebDriver driver;
	WebDriverWait wait;

	public AddNewPostPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		wait = new WebDriverWait(driver, 20);
		PageFactory.initElements(driver, this);
	}

	public void addANewPost(String title, String body) {
		titleID.sendKeys(title);
		driver.switchTo().frame(iframe);
		bodyID.sendKeys(body);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(permalink));
		publishBtn.click();
	}

	public PostDetailPage goToDetailPage() {
		linkNewPost.click();
		return new PostDetailPage(driver);
	}

	public void addNewCat(String cat) {
		addNewCatLink.click();
		wait.until(ExpectedConditions.elementToBeClickable(newCatInput));
		newCatInput.sendKeys(cat);
		newCatBtn.click();
	}

	public void selectCategory(String category) {
		String xpath = "//*[@id='categorychecklist']//label[contains(text(), '" + category + "')]";
		driver.findElement(By.xpath(xpath)).click();
	}

	public void addANewPostWithCategory(String title, String body, String cat) {
		titleID.sendKeys(title);
		driver.switchTo().frame(iframe);
		bodyID.sendKeys(body);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(permalink));
		selectCategory(cat);
		publishBtn.click();
	}

}
