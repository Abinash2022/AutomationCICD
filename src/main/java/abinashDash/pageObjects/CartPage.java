package abinashDash.pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import AbstractComponentsPackage.AbstractComponents;


public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutFile;
	
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean verifyProductDisplay(String ProductName) {
		Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(ProductName));
		return match;
	}
	
	public abinashDash.pageObjects.CheckOut CheckOut() {
		checkoutFile.click();
		return new CheckOut(driver);
	}

}
