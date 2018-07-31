package pages;

import org.openqa.selenium.WebDriver;

import utilities.Links;

public class DashboardPage extends BasePage {

	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isDisplayed() {
		if (Links.URL_DASHBOARD.equals(driver.getCurrentUrl())) {
			return true;
		} else {
			return false;
		}
	}
}
