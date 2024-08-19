package PageObjs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import testBase.RegBase;

public class CartBase extends RegBase {
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Searchbox;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnSearch;

}
