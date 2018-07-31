package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddNewPostPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.PostDetailPage;

public class AddNewPostTest extends BaseTest {
	LoginPage loginPg;
	DashboardPage dashboardPg;
	AddNewPostPage addNewPg;
	PostDetailPage postDetailPg;

	@Test
	public void addNewPost(){
		loginPg = new LoginPage(driver);

		dashboardPg = loginPg.loginSuccess();
		addNewPg = dashboardPg.moveToAddNewPostPage();
		addNewPg.addANewPost(title, body);
		postDetailPg = addNewPg.goToDetailPage();
		
		Assert.assertEquals(postDetailPg.getPostTitle(), title);
	}
}
