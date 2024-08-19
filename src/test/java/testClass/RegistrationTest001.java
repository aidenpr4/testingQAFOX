package testClass;

import javax.management.RuntimeErrorException;

import org.testng.annotations.Test;
import PageObjs.AccRegPage;
import PageObjs.HomePage;
import testBase.RegBase;
import utilities.UserCreds;

public class RegistrationTest001 extends RegBase {
	@Test
	public void registration() throws InterruptedException {
		try {
			HomePage page = new HomePage(driver);
			page.getPage();
			Thread.sleep(1000);

			page.clickelement();

			page.clickreg();
			String Password = randpass();
			String email = randommails();
			AccRegPage regpage = new AccRegPage(driver);
			regpage.setfirstname(randomStrings().toUpperCase());
			regpage.setlastname(randomStrings().toUpperCase());
			regpage.setEmail(email);
			regpage.setTelephone(randnum());
			regpage.setPassword(Password);
			regpage.SetConfPassword(Password);
			regpage.setNewsletter();
			regpage.setAgree();
			regpage.clickContinueBtn();
			regpage.checkConfMsg();
			UserCreds.setEmail(email);
			UserCreds.setPassword(Password);
		} catch (Exception e) {
			System.out.println("test failed" + e.getMessage());
			}

	}

	@Test(dependsOnMethods = "registration")
	public void savecreds() {
		String email = UserCreds.getEmail();
		String passwd = UserCreds.getPassword();
		if (email == null || passwd == null) {

			throw new RuntimeErrorException(null, "creds are not stored sorry");
		}
		System.out.println(email + " : " + passwd);
	}
}
