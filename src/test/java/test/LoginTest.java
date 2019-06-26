package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.Database;

public class LoginTest {

	@Test
	public void loginTest() throws ClassNotFoundException, SQLException, InterruptedException {

		// Starts the browser and saves the driver in the test class
		WebDriver driver = BrowserFactory.startBrowser();
		// Take you to the site
		driver.get("http://techfios.com/test/billing/?ng=admin/");
		// Calling LoginPage Class or Activate
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		// calling the method inside LoginPage
		
		Thread.sleep(2000);
		loginPage.login(Database.getUsername(), Database.getPassword());
		Thread.sleep(2000);
		
		// Activate the DashboardPage
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		// call methods inside Dashboard Page
		dashboardPage.waitForPage();

		driver.close();
		driver.quit();
	}
}