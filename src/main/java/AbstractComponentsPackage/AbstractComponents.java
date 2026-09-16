package AbstractComponentsPackage;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import abinashDash.pageObjects.CartPage;
import abinashDash.pageObjects.OrderPage;

public class AbstractComponents {
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[routerlink*=cart]")
	WebElement cartheader;
	
	@FindBy(css = "[routerlink*=myorders]")
	WebElement orderheader;
	
	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		
	}
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
		
	}
	
	public void waitForElementToDissappear(By notFindBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(notFindBy));
	}
	
	public CartPage goTocartPage() {
		waitForElementToAppear(By.cssSelector("[routerlink*=cart]"));
		cartheader.click();
		CartPage CartPage = new CartPage(driver);
		return CartPage;
	}
	
	public OrderPage goToOrdersPage() {
		orderheader.click();
		OrderPage OrderPage = new OrderPage(driver);
		return OrderPage;
	}

}
