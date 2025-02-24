package org.appiumtesting.pageObjects.ios;

import org.appiumtesting.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HomePage extends IOSActions{

	//Global Variable - here this Driver doesnot have any life
	IOSDriver driver;

	
	public HomePage(IOSDriver driver)
	{
		//real life of Driver is getting from the Constructor arguement - Driver
		//When constructor are created the argument must
		//to inherit the driver from the parent constructor - we use "super" keyword
		super(driver);
		//assigning the local variable IOSDriver driver with "this" keyword to the inside constructor variable driver
		this.driver =driver;
		//to access the class and construct we use pagefactory in the constructor -
		//page factory is used to create the page object
		PageFactory.initElements(new AppiumFieldDecorator(driver), this); //
		
	}
	
	//driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
	@iOSXCUITFindBy(accessibility="Alert Views")
	private WebElement alertViews;
	
	public AlertViews selectAlertViews()
	{
		alertViews.click();
		return new AlertViews(driver);
	}
	
	
	
}
