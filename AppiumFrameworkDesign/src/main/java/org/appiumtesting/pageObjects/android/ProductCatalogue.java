package org.appiumtesting.pageObjects.android;

import java.util.List;

import org.appiumtesting.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions {

	//Global Variable - here this Driver doesnot have any life
	AndroidDriver driver;
	
	
	public ProductCatalogue(AndroidDriver driver)
	{
		//real life of Driver is getting from the Constructor arguement - Driver
		//When constructor are created the argument must
		//to inherit the driver from the parent constructor - we use "super" keyword
		super(driver);
		
		
		//assigning the local variable AndroidDriver driver with "this" keyword to the inside constructor variable driver
		this.driver =driver;
		//to access the class and construct we use pagefactory in the constructor -
		//page factory is used to create the page object
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
		
	}
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	//driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']"))
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement cart;
	
	
	public void addItemToCartByIndex(int index)
	{
		addToCart.get(index).click();
	
	}
	public CartPage goToCartPage() throws InterruptedException
	{
		cart.click();
		Thread.sleep(2000);
		return new CartPage(driver);
		
		
		
	}
	
}
