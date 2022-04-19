package com.zerodha.qa.TestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.zerodha.qa.Base.TestBase;
import com.zerodha.qa.Pages.LoginPage;
import com.zerodha.qa.utility.Utils;



public class LoginTest extends TestBase {
	@BeforeClass
	public void Setup() {
		intializeBrowser("chrome");
	}
	
	
	
	@Test(testName = "ZerodhaLoginPageTest")
	public void ZerodhaLoginPageTest() throws EncryptedDocumentException, IOException {
		
		LoginPage lp = new LoginPage(driver);
		lp.verifyZerodhaLoginPageLogo();
		lp.verifyZerodhaLoginPageAndroidLogo();
		lp.verifyZerodhaLoginPageIosLogo();
		lp.verifyZerodhaLoginPageApplicationVersion();
		lp.setZerodhaLoginPageUsername(Utils.getStringTestData(0, 0));
		lp.setZerodhaLoginPagePassword(Utils.getStringTestData(0, 1));
		lp.clickZerodhaLoginPageLoginBtn();
		lp.setZerodhaLoginPagePin(Utils.getStringTestData(0, 2));
		lp.clickZerodhaLoginPagePinContinueBtn();
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
