package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
	WebDriver driver; //Global
	//Every Page must have a constructor to invite the driver 
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Element Library
	@FindBy(how = How.XPATH, using = "//h2[contains(text(),'Dashboard')]") WebElement PageTitle;
	@FindBy(how = How.LINK_TEXT, using = "Add Deposit") WebElement AddDepositButton;
	//Methods to interact with the elements
	public void waitForPage() {
		waitForElement(PageTitle, driver);
	}
	
	public void clickOnAddDepositButton() {
		AddDepositButton.click();
	}
}