package com.assignment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.ImdbPage;
import com.utils.UtilsFile;
import com.utils.webDriverUtil;

public class AppTesting {

	WebDriver driver;
	Properties prop;
	ImdbPage imdb;

	@BeforeClass
	public void loadPropertyFile() {

		String filePath = "src\\main\\resources\\data.properties";
		prop = UtilsFile.readPropertyFile(filePath);
		driver = webDriverUtil.getChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test() {

		imdb = new ImdbPage(driver);

		String movieName = prop.getProperty("movieName");
		
		driver.get(prop.getProperty("wikipedia"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		imdb.searchMovieName(movieName);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		imdb.searchIcon(movieName);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		imdb.getReleaseDate();
		imdb.getCountry();

		Assert.assertEquals(imdb.getCountry(), "India");
		System.out.println(imdb.getReleaseDate() + " --- " + imdb.getCountry());

	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}

}
