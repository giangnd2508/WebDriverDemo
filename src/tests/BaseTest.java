package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.Generator;
import utilities.Links;

public class BaseTest {

	WebDriver driver;
	Generator gen;
	String title, body;

	@BeforeMethod
	public void setUp() {
		driver = new FirefoxDriver();
		gen = new Generator();
		title = gen.title();
		body = gen.body();
		driver.get(Links.URL_LOGIN);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
