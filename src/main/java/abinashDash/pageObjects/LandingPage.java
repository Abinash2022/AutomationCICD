package abinashDash.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponentsPackage.AbstractComponents;

public class LandingPage extends AbstractComponents{
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
//	WebElement userLogin = driver.findElement(By.id("userEmail"));
	
	@FindBy(id = "userEmail")
	WebElement UserEmail;
	
	@FindBy(id = "userPassword")
	WebElement passwordEle;
	
	@FindBy(css = "input[type='submit']")
	WebElement Login;
	
	@FindBy(css = "[class*='flyInOut']")
	WebElement ErrorMSG;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMSG() {
		waitForWebElementToAppear(ErrorMSG);
		return ErrorMSG.getText();
	}
	
	public ProductCatalogue LogintoPage(String Email, String password) {
		UserEmail.sendKeys(Email);
		passwordEle.sendKeys(password);
		Login.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	
}
