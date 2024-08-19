package PageObjs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccRegPage extends BasePage {

	public AccRegPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmpassword;
	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	WebElement newsletter;
	@FindBy(xpath = "//input[@value='0']")
	WebElement newsletterno;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement agree;
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continuebut;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmMsg;


public void setfirstname(String fname) {
	firstname.sendKeys(fname);
}
public void setlastname(String lname) {
	lastname.sendKeys(lname);
	}
public void setEmail(String emails) {
	email.sendKeys(emails);
}

public void setTelephone(String tel) {
	telephone.sendKeys(tel);
}
public void setPassword(String pwd) {
	password.sendKeys(pwd);
}
public void SetConfPassword(String pwd) {
	confirmpassword.sendKeys(pwd);
}
public void setNewsletterYes() {
	newsletter.click();
}
public void setNewsletter() {
	newsletterno.click();
}
public void setAgree() {
	agree.click();
}
public void clickContinueBtn() {
	continuebut.click();
}
public String checkConfMsg() {
	try {
	return (confirmMsg.getText());
}
	catch(Exception e) {
	 return e.getMessage();
	}	
	}
}
