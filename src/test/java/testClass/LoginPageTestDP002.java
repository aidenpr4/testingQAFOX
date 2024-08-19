package testClass;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjs.HomePage;
import PageObjs.LoginBase;
import testBase.RegBase;

public class LoginPageTestDP002 extends RegBase {
	@DataProvider(name = "params")
	public Object[][] creds() {
		return new Object[][] { { "kurkure@gmail.com", "ab343csds" }, { "abcdefg.com", "abcdefg" } };
	}

	@Test(dataProvider = "params")
	public void DPlogin(String email, String passwd) {

		HomePage hme = new HomePage(driver);
		LoginBase bse = new LoginBase(driver);
		hme.getPage();
		hme.clickelement();
		hme.clicklogin();
		bse.passmail(email);
		bse.passpass(passwd);
		bse.clicksubmit();
		bse.verifylogin("Qafox.com");
		bse.logout();
		bse.logoutSuccessfull();
	}
}
