package org.appiumtesting.pageObjects.ios;

import org.appiumtesting.utils.IOSActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class AlertViews extends IOSActions{

	//Global Variable - here this Driver doesnot have any life
	IOSDriver driver;

	//GrandParent(AppiumUtils) -> IOSActions -> AlertViews
	public AlertViews(IOSDriver driver)
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
	//driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();
	@iOSXCUITFindBy(iOSClassChain="**/XCUIElementTypeStaticText[`label =='Text Entry'`]")
	private WebElement textEntryMenu;
	
	//driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();
	@iOSXCUITFindBy(iOSNsPredicate="type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")
	private WebElement confirmMenuItem;
	
	 @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeCell")
	    private WebElement textBox;

	   @iOSXCUITFindBy(accessibility = "OK")
	   private WebElement acceptPopUp;
	
	   @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[c] 'A message'")
	    private WebElement confirmMessage;

	    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
	    private WebElement submit;
	    
	    
	    public void fillTextLabel(String name)
	    {
	    	
	    	textEntryMenu.click();
	    	textBox.sendKeys(name);
	    	acceptPopUp.click();
	    		
	    }
	    
	    public String getConfirmMessage()
	    {
	    	confirmMenuItem.click();
	    	return confirmMessage.getText();
	    }
	    
	    

	
	
	
	
}
