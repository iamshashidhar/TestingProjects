package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestContextSetup;

public class LandingPage {
	
	WebDriver driver;
	
	//Single responsiblity Principle
		//loosly coupled
		public LandingPage(WebDriver driver)
		{
			this.driver=driver;
		}
		
	
	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By increment=   By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public void getSearchTest()
	{
		driver.findElement(search);
	}


	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

	
	public void selectTopDeals()
	{
		driver.findElement(topDeals).click();
	}

	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	
}
