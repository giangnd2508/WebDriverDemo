package utilities;

import java.io.File;

public class Links {
	public static final String DOMAIN = "http://localhost/wp";
	public static final String URL_LOGIN = DOMAIN + "/wp-login.php";
	public static final String URL_DASHBOARD = DOMAIN + "/wp-admin/";
	public static final String URL_ADD_NEW = DOMAIN + "/wp-admin/post-new.php";
	public static final String URL_ALL_POSTS = DOMAIN + "/wp-admin/edit.php";
	public static final String URL_TRASH = DOMAIN + "/wp-admin/edit.php?post_status=trash&post_type=post";
	
	public static final String PATH_TO_EXCEL = System.getProperty("user.dir") + File.separator + "data"	+ File.separator + "data.xlsx";
}