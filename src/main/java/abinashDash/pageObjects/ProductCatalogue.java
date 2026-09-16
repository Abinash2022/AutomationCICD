package abinashDash.pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponentsPackage.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".col-lg-4")
	List<WebElement> products;
	By productsBy = By.cssSelector(".col-lg-4");
	By addTocart = By.cssSelector(".card-body button:last-of-type");
	By toastMSG = By.id("toast-container");
	By invisible = By.id(".ng-animating");
	
	
	
	public List<WebElement> getProductList() throws InterruptedException {
		Thread.sleep(3000L);
		waitForElementToAppear(productsBy);
		return products;
	}
	
//	WebElement prod  = ls.stream().filter(product -> 
//	product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
	public WebElement getProductByName(String productName) throws InterruptedException {
		WebElement prod  = getProductList().stream().filter(product -> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	


	public void addProductToCart(String productName) throws InterruptedException {
		WebElement prod = getProductByName(productName);
		prod.findElement(addTocart).click();
		Thread.sleep(2000L);
		waitForElementToAppear(toastMSG);
		waitForElementToDissappear(invisible);
	}
	
	
	
	
	
	
	
}
