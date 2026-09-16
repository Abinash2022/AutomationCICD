package abinashDash.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.commons.io.*;
import abinashDash.TestComponent.BaseTest;
import abinashDash.pageObjects.CartPage;
import abinashDash.pageObjects.CheckOut;
import abinashDash.pageObjects.ConfirmationPage;
import abinashDash.pageObjects.LandingPage;
import abinashDash.pageObjects.OrderPage;
import abinashDash.pageObjects.ProductCatalogue;


public class SubmitOrdertest extends BaseTest{
	String productName = "ZARA COAT 3";	
	
		@Test(dataProvider= ("getData"), groups= {"Purchase"})
		public void SubmitOrder(HashMap<String, String> input) throws InterruptedException, IOException 
		{
			
		ProductCatalogue productCatalogue = landingPage.LogintoPage(input.get("Email"), input.get("Password"));
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("product"));
		CartPage CartPage = productCatalogue.goTocartPage();	
		Boolean match = CartPage.verifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		CheckOut CheckOut = CartPage.CheckOut();
		CheckOut.selectCountry("india");
		ConfirmationPage ConfirmationPage = CheckOut.SubmitOrder();
		String confirmMSG = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMSG.equalsIgnoreCase("Thankyou for the order."));
		
	}
		
		@Test(dependsOnMethods = {"SubmitOrder"})
		public void OrderHistoryTest() {
			ProductCatalogue productCatalogue = landingPage.LogintoPage("d.abinash@gmail.com", "Snap@23@");
			OrderPage ordersPage = productCatalogue.goToOrdersPage();
			Assert.assertTrue(ordersPage.verifyProductDisplay(productName));
			
		}
		
		@DataProvider
		public Object[][] getData() throws IOException {
			List<HashMap<String, String>> data = jsonData("src/test/java/abinashDash/data/PurchaseOrder.json");
			return new Object[][] {{data.get(0)}, {data.get(1)}};
		}
		
		
//		public Object[][] getData() {
//			return new Object [] [] {{"d.abinash@gmail.com", "Snap@23@", "ZARA COAT 3"}, {"nanii@gmail.com", "Snap@23@", "ADIDAS ORIGINAL"}};
//		}
		
//		HashMap<String, String> map = new HashMap <String, String>();
//		map.put("Email", "d.abinash@gmail.com");
//		map.put("Password", "Snap@23@");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap<String, String> map2 = new HashMap <String, String>();
//		map2.put("Email", "nanii@gmail.com");
//		map2.put("Password", "Snap@23@");
//		map2.put("product", "ADIDAS ORIGINAL");
		
}
