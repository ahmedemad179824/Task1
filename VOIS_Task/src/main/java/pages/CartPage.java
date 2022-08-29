package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends PageBase{

	public CartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "activeCartViewForm")
	public WebElement itemForm;
	
	@FindBy(xpath = "//*[@id=\"activeCartViewForm\"]/div[2]")
	public WebElement itemTitleInCart;

}
