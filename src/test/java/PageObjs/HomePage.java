package PageObjs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@title='My Account' and .//span[@class='hidden-xs hidden-sm hidden-md' and text()='My Account']]\r\n"
			+ "")
	WebElement lnkMyAcc;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkReg;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement Loginreg;

	public void getPage() {
		driver.get("https://tutorialsninja.com/demo/");
	}

	public void clickelement() {
		lnkMyAcc.click();

	}

	public void clickreg() {
		lnkReg.click();
	}

	public void clicklogin() {
		
		wait.until(ExpectedConditions.elementToBeClickable(Loginreg));
		Loginreg.click();
	}

}
