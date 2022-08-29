package tests;

import java.time.Duration;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.ReadProperties;
import pages.AmazonHomePage;
import pages.CartPage;
import pages.ItemDetailsPage;

public class AddSpecificItemToCart extends TestBase{
	
	AmazonHomePage amazonHomePageObject;
	ItemDetailsPage itemDetailsObject;
	CartPage cartObject;
	
	String searchValue= ReadProperties.data.getProperty("searchValue");
	String itemTitle;
	
	@Test (priority = 1)
	private void searchForItem() 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		amazonHomePageObject = new AmazonHomePage(driver);
		amazonHomePageObject.searchForItem(searchValue);
		wait.until(ExpectedConditions.visibilityOf(amazonHomePageObject.filterResultsLabel));
		Assert.assertTrue(amazonHomePageObject.filterResultsLabel.getText().contains(searchValue));
	}
	
	
	@Test(priority = 2, dependsOnMethods = "searchForItem")
	private void addItemToCart() 
	{
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		amazonHomePageObject = new AmazonHomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(amazonHomePageObject.firstItem));
		amazonHomePageObject.chooseFirstItem();
		
		itemDetailsObject = new ItemDetailsPage(driver);
		itemTitle = itemDetailsObject.getItemTitle();
		System.out.println(itemTitle);
		
		wait.until(ExpectedConditions.visibilityOf(itemDetailsObject.addToCartBtn));
		itemDetailsObject.clickOnAddToCartBtn();
		
		wait.until(ExpectedConditions.visibilityOf(itemDetailsObject.addedToCartMsg));
		Assert.assertTrue(itemDetailsObject.addedToCartMsg.getText().equalsIgnoreCase("Added to Cart"));
		
	}
	
	
	@Test(priority = 3, dependsOnMethods = "addItemToCart")
	public void CheckItemAddedToTheCart()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		amazonHomePageObject = new AmazonHomePage(driver);
		amazonHomePageObject.clickOnCartBtn();
		
		cartObject = new CartPage(driver);
		if(itemTitle.length() >= 66)
		{
			String itemTitleAfterReduction = StringUtils.left(itemTitle, 66);
			System.out.println(itemTitleAfterReduction);
			wait.until(ExpectedConditions.visibilityOf(cartObject.itemTitleInCart));
			Assert.assertTrue(cartObject.itemTitleInCart.getText().contains(itemTitleAfterReduction));
		}
		else 
		{
			Assert.assertTrue(cartObject.itemTitleInCart.getText().contains(itemTitle));
		}
	}

}
