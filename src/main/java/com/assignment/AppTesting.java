package com.assignment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.utils.UtilsFile;
import com.utils.webDriverUtil;

public class AppTesting {

	WebDriver driver;
	Properties prop;

	@BeforeClass
	public void loadPropertyFile() {

		String filePath = "src\\main\\resources\\data.properties";
		prop = UtilsFile.readPropertyFile(filePath);
		driver = webDriverUtil.getChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test() {

		String movieName = prop.getProperty("movieName");
		driver.get(prop.getProperty("imdb"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

		String searchIcon = prop.getProperty("searchIcon").replace("movieName", movieName);
		driver.findElement(By.xpath(prop.getProperty("inputBox"))).sendKeys(movieName);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(searchIcon)).click();

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		String ReleaseDate = driver.findElement(By.xpath(prop.getProperty("ReleaseDate"))).getText();
		String Country = driver.findElement(By.xpath(prop.getProperty("Country"))).getText();

		Assert.assertEquals(Country, "India");
		System.out.println(ReleaseDate + " --- " + Country);

	}

	@AfterClass
	public void quitDriver() {
		driver.quit();
	}

}
