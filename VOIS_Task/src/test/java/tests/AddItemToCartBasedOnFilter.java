package tests;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.ReadProperties;
import pages.AmazonHomePage;
import pages.ItemDetailsPage;

public class AddItemToCartBasedOnFilter extends TestBase{
	
	AmazonHomePage amazonHomePageObject;
	ItemDetailsPage itemDetailsObject;
	
	String department1 = ReadProperties.data.getProperty("department1");
	String department2 = ReadProperties.data.getProperty("department2");
	String discountPercentage = ReadProperties.data.getProperty("discountPercentage");
	
	@Test(priority = 1)
	public void addItemToCartBasedOnFilter()
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		amazonHomePageObject = new AmazonHomePage(driver);
		wait.until(ExpectedConditions.visibilityOf(amazonHomePageObject.donotChangeBtn));
		amazonHomePageObject.clickOnDonotChangeBtn();
		amazonHomePageObject.clickOnTodayDealsBtn();
		amazonHomePageObject.filterByDepartment(department1);
		amazonHomePageObject.filterByDepartment(department2);
		amazonHomePageObject.filterByDiscount(discountPercentage);
		wait.until(ExpectedConditions.visibilityOf(amazonHomePageObject.thirdPageBtn));
		amazonHomePageObject.clickOnThirdPageBtn();
		wait.until(ExpectedConditions.visibilityOf(amazonHomePageObject.fourthPageBtn));
		amazonHomePageObject.clickOnFourthPageBtn();
		wait.until(ExpectedConditions.visibilityOf(amazonHomePageObject.itemAfterFilter));
		amazonHomePageObject.clickOnItemAfterFilter();
		
		itemDetailsObject = new ItemDetailsPage(driver);
		wait.until(ExpectedConditions.visibilityOf(itemDetailsObject.addToCartBtn));
		itemDetailsObject.clickOnAddToCartBtn();
		wait.until(ExpectedConditions.visibilityOf(itemDetailsObject.addedToCartMsg));
		Assert.assertTrue(itemDetailsObject.addedToCartMsg.getText().equalsIgnoreCase("Added to Cart"));
	}

}
