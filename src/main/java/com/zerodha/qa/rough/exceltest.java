package com.zerodha.qa.rough;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import com.zerodha.qa.utility.Utils;

public class exceltest {

	@Test
	public void readData() throws EncryptedDocumentException, IOException {
		
		  String username = Utils.getStringTestData(0, 0); String password =
		  Utils.getStringTestData(0,1); System.out.println(username +" "+ password);
		 
		
	}
		
	
}
