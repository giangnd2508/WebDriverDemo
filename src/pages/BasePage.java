package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	@FindBy(xpath = "//*[@id='menu-dashboard']/a")
	WebElement navDashborad;
	
	@FindBy(xpath = "//*[@id='menu-posts']/a")
	WebElement navPosts;

	@FindBy(xpath = "//*[@id=\"menu-posts\"]//a[text()='All Posts']")
	WebElement navAllPosts;
	
	@FindBy(xpath = "//*[@id=\"menu-posts\"]//a[text()='Add New']")
	WebElement navAddNew;
	
	WebDriver driver;
	Actions action;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		action = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	
	public DashboardPage moveToDashboradPage() {
		navDashborad.click();
		return new DashboardPage(driver);
	}
	
	public AllPostsPage moveToAllPostsPage() {
		navPosts.click();
		return new AllPostsPage(driver);
	}
	
	public AddNewPostPage moveToAddNewPostPage() {
		action.moveToElement(navPosts).click().perform();
		navAddNew.click();
		return new AddNewPostPage(driver);
	}

}
