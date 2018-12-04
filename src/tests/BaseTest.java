package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Generator;
import utilities.Links;
import utilities.TakeScreenshotAfterTest;

public class BaseTest {

	WebDriver driver;
	Generator gen;
	String title, body;
	TakeScreenshotAfterTest screenshot;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		gen = new Generator();
		screenshot = new TakeScreenshotAfterTest(gen, driver);
		title = gen.title();
		body = gen.body();
		driver.get(Links.URL_LOGIN);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() throws IOException {
		screenshot.TakeScreenshot();
		driver.quit();
	}
}
