package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class RegBase {
	public WebDriver driver;

	@BeforeClass
	@Parameters({ "browser" })
	public void setup(String br) {
		switch (br.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		default:
			System.out.println("code doesn't support given type");
			return;
		}

		driver.manage().window().maximize();
	}

	public String randomStrings() {
		String alpha = RandomStringUtils.randomAlphabetic(4);
		return alpha;
	}

	public String randommails() {
		String alnum = RandomStringUtils.randomAlphanumeric(4);
		String suffixes = RandomStringUtils.randomAlphanumeric(2);
		return (alnum + "@" + suffixes + ".com");
	}

	public String randnum() {
		String num = RandomStringUtils.randomNumeric(10);
		return num;
	}

	public String randpass() {
		String passers = RandomStringUtils.randomAlphanumeric(8);
		return passers;
	}

	@AfterClass
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
		
		
	}

}
