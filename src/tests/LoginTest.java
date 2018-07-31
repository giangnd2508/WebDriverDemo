package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;

public class LoginTest extends BaseTest {
	LoginPage loginPg;
	DashboardPage dashboardPg;

	@Test
	public void loginWithBlankField() {
		loginPg = new LoginPage(driver);
		loginPg.login("", "");
		Assert.assertTrue(loginPg.isDisplayed());
	}

	@Test
	public void loginByAdmin() {
		loginPg = new LoginPage(driver);	
		dashboardPg = loginPg.loginSuccess();
		Assert.assertTrue(dashboardPg.isDisplayed());
	}

}
