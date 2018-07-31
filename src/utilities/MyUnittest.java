package utilities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import pages.AllPostsPage;

public class MyUnittest {
	WebDriver driver;

	@Test
	public void compare() {
		driver = new FirefoxDriver();
		AllPostsPage allPost = new AllPostsPage(driver);
		assertEquals(allPost.getTitleFirstPost(), "cat mountain Agree cat -1292266659, title");
	}

}
