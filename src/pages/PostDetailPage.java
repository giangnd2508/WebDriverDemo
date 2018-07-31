package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PostDetailPage {
	WebDriver driver;

	public PostDetailPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getPostTitle() {
		String titlePost = driver.findElement(By.tagName("h1")).getText();
		return titlePost;
	}
	
	public String getUrlDetailPage() {
		return driver.getCurrentUrl();
	}
}
