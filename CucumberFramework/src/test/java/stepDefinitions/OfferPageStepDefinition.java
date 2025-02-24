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
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
	public WebDriver driver ;
	public String landingPageProductName;
	public String offerPageProductName;
	
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;

	//Single responsiblity Principle
	//loosly coupled
	public OfferPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup = testContextSetup;
	}
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
	    // offer page-->enter text--- >grab text---
		
	
		switchToOfferPage();
		
		
		
		OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		
		offerPage.searchItem(shortName);
		Thread.sleep(3000);
		offerPageProductName = offerPage.getProductName();
		System.out.println(offerPageProductName);
		
	}
	
	public void switchToOfferPage()
	{
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		testContextSetup.genericUtils.SwitchWindowToChild();
		
	}
	
	
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_Landing_Page() 
	{
	Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);

	}
	

	
	

}
