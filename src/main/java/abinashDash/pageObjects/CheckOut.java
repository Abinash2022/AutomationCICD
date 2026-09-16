package abinashDash.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import AbstractComponentsPackage.AbstractComponents;

public class CheckOut extends AbstractComponents {
	WebDriver driver;
	
	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[placeholder*='Select Country']")
	WebElement Country;
	
	@FindBy(css=".actions a")
	WebElement submit;
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(Country, CountryName).perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public ConfirmationPage SubmitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
	}

}
