package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewPostPage;
import pages.AllPostsPage;
import pages.DashboardPage;
import pages.LoginPage;

public class AllPostsTest extends BaseTest {
	LoginPage loginPg;
	DashboardPage dashBoardPg;
	AddNewPostPage addNewPg;
	AllPostsPage allPostsPg;

	@Test
	public void deleteFirstPost() {
		loginPg = new LoginPage(driver);

		dashBoardPg = loginPg.loginSuccess();
		addNewPg = dashBoardPg.moveToAddNewPostPage();
		addNewPg.addANewPost(title, body);

		allPostsPg = addNewPg.moveToAllPostsPage();
		allPostsPg.deleteFirstRowPost();
		Assert.assertNotEquals(allPostsPg.getTitleFirstPost(), title);
	}
}
