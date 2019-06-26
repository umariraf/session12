package test;

import java.io.File;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.AddDepositPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddDepositTest {

	WebDriver driver;

	@Before
	public void setup() throws Exception {

		driver = BrowserFactory.startBrowser();
		// Take you to the site
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		// Calling LoginPage Class or Activate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// calling the method inside LoginPage
		loginPage.login("techfiosdemo@gmail.com", "abc123");
		// Activate the DashboardPage
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// call methods inside Dashboard Page
		dashboardPage.waitForPage();
		screenShot(driver, "C:\\new\\something.jpg");
	}

	public static void screenShot(WebDriver driver, String fileWithPath) throws Exception {
		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);
		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
		// Move image file to new destination
		File DestFile = new File(fileWithPath);
		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}

	@Test
	public void AddDepositToVerifyDepositPosted() throws InterruptedException {
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		dashboardPage.clickOnAddDepositButton();
		// Activate Add Deposit Page
		AddDepositPage addDepositPage = PageFactory.initElements(driver, AddDepositPage.class);
		// validate Add deposit Page opened (waitForPage)
		addDepositPage.waitForPage();
		// A method to select a specific infor from dropDown
		addDepositPage.selectFromDropDownForAccount("AutoAccount");
		addDepositPage.clearTheDateAndInput("2019-06-12");
		addDepositPage.clickAway();
		Thread.sleep(500);
		// Initiate Random Class
		Random random = new Random();
		// Storage for description and Amount
		String eDescription = "TestDescription" + String.valueOf(random.nextInt(999));
		String eAmount = String.valueOf(random.nextInt(99999));
		// Method to input description and amount
		addDepositPage.inputDescriptionAndAmount(eDescription, eAmount);
		// click on submit button
		addDepositPage.clickOnSubmitButton();
		// Explicit wait validation
		addDepositPage.waitForSuccessMsg();
		// Assertion class to validate
		Assert.assertTrue("Success Message did not show!", addDepositPage.isSuccessMsgDisplayed());
		// Call the fill in the form method
	}

	@After
	public void closeBrowser() {
		driver.close();
		driver.quit();
	}
}