package testClass;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import PageObjs.AccRegPage;
import PageObjs.HomePage;
import testBase.RegBase;

public class RegTestDP002 extends RegBase {
	String phone = randnum();

	@DataProvider(name = "registration")
	public Object[][] register() {
		return new Object[][] { { "abcd", "tim", "konga@gmail.com", randnum(), "ab343csds", "ab343csds" }, { "kurkure",
				"kongistan", "skfjsl@gmail.com", randnum(), "abcdefg", "abcdefg" } };
	}

	@Test(dataProvider = "registration")
	public void regtest(String firstname, String lastname, String email, String telephone, String passwd,
			String confPasswd) {
		try {
			HomePage page = new HomePage(driver);
			page.getPage();
			Thread.sleep(1000);

			page.clickelement();

			page.clickreg();
			AccRegPage regpage = new AccRegPage(driver);
			regpage.setfirstname(firstname);
			regpage.setlastname(lastname);
			regpage.setEmail(email);
			regpage.setTelephone(telephone);
			regpage.setPassword(passwd);
			regpage.SetConfPassword(confPasswd);
			regpage.setNewsletterYes();
			regpage.setAgree();
			regpage.clickContinueBtn();
			regpage.checkConfMsg();
		} catch (Exception e) {
			Assert.fail("test failed" + e.getMessage());
		}
	}
}