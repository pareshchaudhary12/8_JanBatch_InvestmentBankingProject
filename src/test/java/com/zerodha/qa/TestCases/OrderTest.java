package com.zerodha.qa.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zerodha.qa.Base.TestBase;
import com.zerodha.qa.Pages.HomePage;
import com.zerodha.qa.Pages.LoginPage;
import com.zerodha.qa.Pages.OrderPage;
import com.zerodha.qa.utility.Utils;


public class OrderTest extends TestBase {
	@BeforeClass
	public void Setup() {
		intializeBrowser("chrome");
	}
	
	
	
	@Test
	public void EquityOrderTest() throws EncryptedDocumentException, IOException, InterruptedException {
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setZerodhaLoginPageUsername(Utils.getStringTestData(0, 0));
		lp.setZerodhaLoginPagePassword(Utils.getStringTestData(0, 1));
		lp.clickZerodhaLoginPageLoginBtn();
		lp.setZerodhaLoginPagePin(Utils.getStringTestData(0, 2));
		lp.clickZerodhaLoginPagePinContinueBtn();
		
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		hp.ClickZerodhaHomePageTataShareBuy();
		
		
		OrderPage op = new OrderPage(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(10000);
		//op.verifyZerodhaOrderPageBSEPrice();
		//op.verifyZerodhaOrderPageNSEPrice();
		//op.verifyZerodhaOrderPageReularOrderOptn();
		//op.verifyZerodhaOrderPageCoverOrderOptn();
		//op.verifyZerodhaOrderPageAmoOrderOptn();
		//op.verifyZerodhaOrderPageIcebergOrderOptn();
		//op.verifyZerodhaOrderPageIntradayOrderOptn();
		//op.verifyZerodhaOrderPageLongTermOrderOptn();
		op.setZerodhaOrderPageShareQuantityOptn("25");
		op.setZerodhaOrderPageSharePriceOptn("417.79");
		//op.verifyZerodhaOrderPageTriggerPriceOptn();
		//op.verifyZerodhaOrderPageMarketOptn();
		//op.verifyZerodhaOrderPageLimitOptn();
		op.verifyZerodhaOrderPageStopLossOptn();
		op.verifyZerodhaOrderPageStopLossMarketOptn();
		op.verifyZerodhaOrderPageMarginRequired();
		op.clickZerodhaOrderPageOrderBtn();
		
		
		
	}
	
}
