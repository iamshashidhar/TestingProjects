package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class OfferPage {
	
	WebDriver driver;
	
	//Single responsiblity Principle
		//loosly coupled
		public OfferPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
	
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchTest()
	{
		driver.findElement(search);
	}


	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}
