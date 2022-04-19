package com.zerodha.qa.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zerodha.qa.Base.TestBase;

public class Utils extends TestBase {
	// You can add all one time activites over here and call it according to your need.
	
	
	// ============================ Screen Shot Utillity ==================================================
	
		public static void getscreenshot(WebDriver driver,String testname) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		Date d= new Date();
		System.out.println(d);
		String filename = testname+"_"+d.toString().replace(" ", "_").replace(":", "_")+".png";
		File dest = new File("C:\\Users\\DELL\\Desktop\\Velocity_Katraj\\facebookts_"+filename);
		FileUtils.copyFile(src, dest);
	}
	
	
	// ============================  Apache Poi  Excel Sheet Utility ==================================================
	
	public static String getStringTestData(int row, int col) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\DELL\\Desktop\\Automation_Test.xlsx");
		String value = WorkbookFactory.create(file).getSheet("Login_Credentials").getRow(row).getCell(col).getStringCellValue();
		return value;
	}
	
	
	
	// ============================ Java Script Executor==================================================
	
		public static void borderbyJS(WebDriver driver,WebElement element) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].style.border='3px solid red'", element);
		}
		
		
		// capturing the title. ==> Method which accepts the parameter but will return title
		
		public static String titlebyJS(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String Title=js.executeScript("return document.title;").toString();
		return Title;
		}
		
		// click on element
		public static void clickbyJS(WebDriver driver,WebElement element) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].click();", element);
		}
		
		// generate userdefined alert.
		
		public static void alertbyJS(WebDriver driver, String message) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("alert('" + message + "')");
		}
		
		// refresh the page
		public static void refreshbyJS(WebDriver driver) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("history.go(0)");
		}
		
		// Scrolling the page.
		
		public static void scrolldownbyJS(WebDriver driver,int x, int y) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("scroll("+x+","+y+")");    // scroll down	
		}
		
		public static void scrollupbyJS(WebDriver driver,int x, int y) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
				js.executeScript("scroll("+x+","+y+")");    // scroll up
		}
		
		// scroll into view.

		public static void scrollIntoViewbyJS(WebDriver driver,WebElement element) {
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		
		}
}
