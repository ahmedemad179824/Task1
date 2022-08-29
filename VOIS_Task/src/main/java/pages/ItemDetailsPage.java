package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ItemDetailsPage extends PageBase{

	public ItemDetailsPage(WebDriver driver) {
		super(driver);
	}

	@FindBy( id ="add-to-cart-button")
	public WebElement addToCartBtn;
	
	@FindBy( id ="title")
	 WebElement itemTitle;
	
	@FindBy(css = "div.a-section.a-spacing-none.a-padding-none")
	public WebElement addedToCartMsg;
	
	public void clickOnAddToCartBtn()
	{
		addToCartBtn.click();
	}
	
	public String getItemTitle() 
	{
		return itemTitle.getText();
	}

}
