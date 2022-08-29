package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends PageBase{

	public AmazonHomePage(WebDriver driver) {
		super(driver);
		
	}
	

	@FindBy(id = "twotabsearchtextbox")
	WebElement searchTxtBox;
	
	@FindBy(id = "nav-search-submit-button")
	WebElement searchBtn;
	
	@FindBy(css = "div.a-section.a-spacing-small.a-spacing-top-small")
	public WebElement filterResultsLabel;
	
	@FindBy(xpath = "//*[@id=\"search\"]/div[1]/div[1]/div/span[3]/div[2]/div[3]/div/div/div/div/div/div/div[1]/span/a/div/img")
	public WebElement firstItem;
	
	@FindBy(id = "nav-cart-count-container")
	WebElement cartBtn;
	
	@FindBy(linkText = "Today's Deals")
	WebElement todayDealsBtn;
	
	@FindBy(xpath = "//*[@id=\"grid-main-container\"]/div[2]/span[3]/span/ul")
	WebElement departmentList;
	
	@FindBy(xpath = "//*[@id=\"grid-main-container\"]/div[2]/span[6]/span/ul")
	WebElement discountList;
	
	@FindBy(xpath = "//*[@id=\"nav-main\"]/div[1]/div/div/div[3]/span[1]/span/input")
	public WebElement  donotChangeBtn;
	
	@FindBy(xpath = "//*[@id=\"slot-15\"]/div/div/div[3]/div/ul/li[4]/a")
	public WebElement thirdPageBtn;
	
	@FindBy(xpath = "//*[@id=\"slot-15\"]/div/div/div[3]/div/ul/li[5]/a")
	public WebElement fourthPageBtn;
	
	@FindBy(xpath = "//img[@alt='FullChea - Longjing Tea - Dragonwell Tea - Chinese Green Tea Loose Leaf - Toasty Bean Aromatic - Lung Ching Dragon Well (8...']")
	public WebElement itemAfterFilter;
	
	public void searchForItem(String itemName)
	{
		sendText(searchTxtBox, itemName);
		searchBtn.click();
	}
	
    public void chooseFirstItem() {
		
		firstItem.click();
		
	}
	
	public void clickOnCartBtn()
	{
		cartBtn.click();
	}
	public void clickOnTodayDealsBtn()
	{
		todayDealsBtn.click();
	}
	public void clickOnDonotChangeBtn()
	{
		donotChangeBtn.click();
	}
	public void filterByDepartment(String departmentName)
	{
		selectFromList(departmentList, departmentName, "li");
	}
	public void filterByDiscount(String discount)
	{
		selectFromList(discountList, discount, "li");
	}
	public void clickOnThirdPageBtn()
	{
		thirdPageBtn.click();
	}
	public void clickOnFourthPageBtn()
	{
		fourthPageBtn.click();
	}
	public void clickOnItemAfterFilter()
	{
		itemAfterFilter.click();
	}
}
