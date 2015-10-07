package org.testng.Tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class VerifySearch extends BaseClass{
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setUp(String browser,String url){
		startBrowserSession(browser,url);
	}
	
	@Test
	@Parameters("inputString")
	public void enterSearch(String inputString){
		searchPage.enterUsername(inputString);					
	}
	
	@Test(dependsOnMethods="enterSearch")
	@Parameters("testString")
	public void verifySearch(String testString){
		System.out.println(searchPage.getSearch(testString));
	}
	
	@AfterClass
	public void tearDown(){
		stopBrowserSession();
	}

}
