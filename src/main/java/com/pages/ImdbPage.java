package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImdbPage {

	WebDriver driver;

	By inputBox = By.xpath("//input[@id='searchInput' and @name='search'] | //input[@id='suggestion-search']");

	By searchIcon = By.xpath(
			"//i[@class='sprite svg-search-icon'] | //div[@class='sc-d2740ffb-2 STkQo searchResult__constTitle' and contains(.,'Pushpa: The Rise')]");

	By ReleaseDate = By.xpath(
			"//th[contains(.,'Release date')]/following-sibling::td | //li/a[contains(.,'Release')]/following-sibling::div/ul/li");

	By Country = By.xpath(
			"//th[contains(.,'Country')]/following-sibling::td | //li/span[contains(.,'Country of origin')]/following-sibling::div/ul/li");

	public ImdbPage(WebDriver driver) {

		this.driver = driver;
	}

	public void searchMovieName(String movieName) {

		driver.findElement(inputBox).sendKeys(movieName);
	}

	public void searchIcon(String movieName) {

		driver.findElement(searchIcon).click();
	}

	public String getReleaseDate() {

		return driver.findElement(ReleaseDate).getText();
	}

	public String getCountry() {

		return driver.findElement(Country).getText();
	}
	
}
