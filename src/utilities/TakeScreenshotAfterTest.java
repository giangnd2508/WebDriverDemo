package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TakeScreenshotAfterTest {

	Generator gen;
	WebDriver driver;

	public TakeScreenshotAfterTest(Generator gen, WebDriver driver) {
		this.gen = gen;
		this.driver = driver;
	}

	public void TakeScreenshot() throws IOException {
		gen = new Generator();
		String fileName = gen.getTimeInFormat() + ".png";
		String directory = "C:\\Users\\nguye\\eclipse-workspace\\demo\\img\\";

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
	}
}
