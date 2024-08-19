package PageObjs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginBase extends BasePage {
	public LoginBase(WebDriver driver) {
		super(driver);
	}

	WebDriverWait wait;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement loginMail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement loginPass;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement submitButton;
	@FindBy(xpath = "//a[normalize-space()='Qafox.com']")
	WebElement verifyLogin;
	@FindBy(xpath = "//a[@class='list-group-item' and text()='Logout']")
	WebElement logout;
	@FindBy(xpath = "//h1[normalize-space()='Account Logout']")
	WebElement logoutSuccess;

	public void passmail(String mailid) {
		loginMail.sendKeys(mailid);

	}

	public void passpass(String password) {
		loginPass.sendKeys(password);
	}

	public void clicksubmit() {
		submitButton.click();
	}

	public void verifylogin(String expectedtext) {
		Assert.assertNotNull(verifyLogin, expectedtext);
		Assert.assertEquals(verifyLogin.getText(), expectedtext);
	}

	public void logout() {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    WebElement logoutElement = wait.until(ExpectedConditions.visibilityOf(logout));
	    wait.until(ExpectedConditions.elementToBeClickable(logoutElement));
	    logoutElement.click();
	}

	public void logoutSuccessfull() {

		String exp = logoutSuccess.getText();
		String succ = "Account Logout";
	Assert.assertEquals(exp,succ);

	}
}
