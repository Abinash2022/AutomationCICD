package abinashDash.test;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import abinashDash.TestComponent.BaseTest;
import abinashDash.TestComponent.Retry;
import abinashDash.pageObjects.CartPage;
import abinashDash.pageObjects.CheckOut;
import abinashDash.pageObjects.ConfirmationPage;
import abinashDash.pageObjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest {

	@Test(groups= {"ErrorValidation"}, retryAnalyzer = Retry.class)
	public void loginErrorValidation() throws InterruptedException, IOException {
		landingPage.LogintoPage("d.abina@gmail.com", "Snap3@");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMSG());

	}

	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {
		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.LogintoPage("da.absh@gmail.com", "Sna23@");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage CartPage = productCatalogue.goTocartPage();
		Boolean match = CartPage.verifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		CheckOut CheckOut = CartPage.CheckOut();
	
	}

}
