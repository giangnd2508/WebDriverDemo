package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
import utilities.Links;
import utilities.ReadFile;

public class LoginTest extends BaseTest {
	LoginPage loginPg;
	DashboardPage dashboardPg;
	
	private static final Logger log = LogManager.getLogger(LoginTest.class.getName());

//	@Test
	public void loginWithBlankField() {
		loginPg = new LoginPage(driver);
		loginPg.login("", "");
		Assert.assertTrue(loginPg.isDisplayed());
	}

//	@Test
	public void loginByAdmin() {
		loginPg = new LoginPage(driver);
		dashboardPg = loginPg.loginSuccess();
		Assert.assertTrue(dashboardPg.isDisplayed());
	}
	
	@Test(dataProvider="loginData")
	public void loginFail(String userName, String password) {
		log.info("**********Test_login_fail_with_data_from_excel***********");
		loginPg = new LoginPage(driver);
		loginPg.login(userName, password);
		Assert.assertFalse(loginPg.isDisplayed());
	}
	
	
	@DataProvider(name = "loginData")
	public Object[][] dataProvider() throws Exception {
		ReadFile.setExcelFile(Links.PATH_TO_EXCEL, "LoginTest");
		Object[][] testData = ReadFile.getTestData("invalid");
		return testData;
	}

}
