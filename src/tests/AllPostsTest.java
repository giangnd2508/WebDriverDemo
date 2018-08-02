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

	@Test(enabled=false)
	public void deleteFirstPost() {
		loginPg = new LoginPage(driver);

		dashBoardPg = loginPg.loginSuccess();
		addNewPg = dashBoardPg.moveToAddNewPostPage();
		addNewPg.addANewPost(title, body);

		allPostsPg = addNewPg.moveToAllPostsPage();
		allPostsPg.deleteFirstRowPost();
		Assert.assertNotEquals(allPostsPg.getTitleFirstPost(), title);
	}
	
	@Test
	public void filterByCategory() {
		loginPg = new LoginPage(driver);
		dashBoardPg = loginPg.loginSuccess();
		addNewPg = dashBoardPg.moveToAddNewPostPage();
		addNewPg.addANewPostWithCategory(title, body, "auto");
		allPostsPg = addNewPg.moveToAllPostsPage();
		allPostsPg.filterByCategory("auto");
		allPostsPg.deleteFirstRowPost();
		allPostsPg = allPostsPg.moveToAllPostsPage();
		
		Assert.assertNotEquals(allPostsPg.getTitleFirstPost(), title);
	}
}
