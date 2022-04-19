package com.zerodha.qa.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zerodha.qa.Base.TestBase;
import com.zerodha.qa.Pages.HomePage;
import com.zerodha.qa.Pages.LoginPage;
import com.zerodha.qa.utility.Utils;


public class HomeTest extends TestBase {
	@BeforeClass
	public void Setup() {
		intializeBrowser("chrome");
	}
	
	
	@Test
	public void HomePageTest() throws EncryptedDocumentException, IOException {
		
	// Login to the application ==> Go to the home page and check several aspects.
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setZerodhaLoginPageUsername(Utils.getStringTestData(0, 0));
		lp.setZerodhaLoginPagePassword(Utils.getStringTestData(0, 1));
		lp.clickZerodhaLoginPageLoginBtn();
		lp.setZerodhaLoginPagePin(Utils.getStringTestData(0, 2));
		lp.clickZerodhaLoginPagePinContinueBtn();
		
		
		HomePage hp = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		hp.verifyZerodhaHomePageLogo();
		hp.verifyZerodhaHomePageNickName();
		hp.verifyZerodhaHomePageSearchBar();
		hp.verifyZerodhaHomePageDashboardOpt();
		hp.verifyZerodhaHomePageOrdersOpt();
		hp.verifyZerodhaHomePageHoldingsOpt();
		hp.verifyZerodhaHomePagePositionsOpt();
		hp.verifyZerodhaHomePageFundsOpt();
		hp.verifyZerodhaHomePageAppsOpt();
		hp.verifyZerodhaHomePageViewStatementOpt();
		hp.verifyZerodhaHomePageMarginAvailableOpt();
		hp.verifyZerodhaHomePageMarginUsedOpt();
		hp.verifyZerodhaHomePageOpeningBalanceOpt();
		hp.verifyZerodhaHomePageUserAccountProfileOpt();
		hp.clickZerodhaHomePageUserAccountProfileOpt();
		hp.verifyZerodhaHomePageUserFullName();
		hp.verifyZerodhaHomePageUserEmailId();
		hp.clickZerodhaHomePageLogoutBtn();
	}
	
	@AfterMethod()
	public void Capturess(ITestResult result) throws IOException {
		if(result.FAILURE==result.getStatus()) {
			Utils.getscreenshot(driver, result.getName());
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}
