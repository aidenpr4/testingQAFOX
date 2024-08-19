package testClass;

import org.testng.annotations.Test;

import PageObjs.HomePage;
import PageObjs.LoginBase;
import testBase.RegBase;
import utilities.UserCreds;

public class LoginPageTest001 extends RegBase {
	@Test(dependsOnMethods = "registration")
	public void loginPage() {
		HomePage hme = new HomePage(driver);
		LoginBase bse = new LoginBase(driver);
		hme.getPage();
		hme.clickelement();
		hme.clicklogin();
		String email = UserCreds.getEmail();
		String pass = UserCreds.getPassword();
		bse.passmail(email);
		bse.passpass(pass);
		bse.clicksubmit();
		bse.verifylogin("Qafox.com");
		bse.logout();

	bse.logoutSuccessfull();
	}

}
