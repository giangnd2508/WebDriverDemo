package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.Links;

public class LoginPage {
	
	private static final Logger log = LogManager.getLogger(LoginPage.class.getName());

	@FindBy(id = "user_login")
	WebElement user_login;

	@FindBy(id = "user_pass")
	WebElement user_pass;

	@FindBy(id = "wp-submit")
	WebElement submitBtn;

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void login(String userName, String password) {
		user_login.sendKeys(userName);
		user_pass.sendKeys(password);
		submitBtn.click();
		log.info("Login with username: '"+ userName + "' and password: '" + password + "'");
		
	}
	
	public DashboardPage loginSuccess() {
		user_login.sendKeys("giang");
		user_pass.sendKeys("123456789");
		submitBtn.click();
		log.info("Get into the dashboard page");
		return new DashboardPage(driver);
	}

	public boolean isDisplayed() {
		if (Links.URL_LOGIN.equals(driver.getCurrentUrl())) {
			return true;
		} else {
			return false;
		}
	}

}
