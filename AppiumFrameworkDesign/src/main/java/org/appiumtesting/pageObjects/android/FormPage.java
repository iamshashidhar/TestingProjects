package org.appiumtesting.pageObjects.android;

import org.appiumtesting.utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage extends AndroidActions{
	
	//Global Variable - here this Driver doesnot have any life
	AndroidDriver driver;

	
	public FormPage(AndroidDriver driver)
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
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Rahul Shetty");
	
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	//	driver.findElement(By.id("com.androidsample.generalstore:id/nameField"))
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;
	//driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']"))
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;
	
	@AndroidFindBy(id = "android:id/text1")
	private WebElement countrySelection;
	
	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement shopButton;
	
	
	public void setNameField(String name)
	{
		nameField.sendKeys(name);
		driver.hideKeyboard();
		
	}
	
	public void setActivity()
	{
		//Activity activity = new Activity("com.androidsample.generalstore","com.androidsample.generalstore.MainActivity");
		//driver.startActivity(activity);
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","com.androidsample.generalstore/com.androidsample.generalstore.MainActivity"));
	
	}
	
	public void setGender(String gender)
	{
		if (gender.contains("female"))
			femaleOption.click();
		else
			maleOption.click();
		
	}
	
	public void setCountrySelection(String countryName)
	
	{
		countrySelection.click();
		scrollToText(countryName);
		driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
		
	}
	
	public ProductCatalogue submitForm()
	{
		shopButton.click();
		return	new ProductCatalogue(driver);
		
	}
	
	
	
	
	
}
