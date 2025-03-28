package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	public WebDriver driver ;
	public String landingPageProductName;
	public String offerPageProductName;
	
	TestContextSetup testContextSetup;
	public CheckoutPage checkoutPage;
	
	//Single responsiblity Principle
	//loosly coupled
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
		//not to create duplicate object on every methods
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}
	

	@Then("verify user has ability to enter promo code and place the order")
	public void  verify_user_has_ability_enter_promo()
	{
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
		
	}

	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		
		checkoutPage.CheckoutItems();
		//Assertion to extract name from screen and compare with name
	}
	

}
