package org.testng.Tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.sun.jna.platform.win32.SetupApi;

public class HomePage extends BaseClass {	
	
	@BeforeClass
	@Parameters({"browser","url"})
	public void setUp(String browser,String url){
		startBrowserSession(browser,url);
	}
	
	@Test
//	@Parameters("homePageInput")
	public void enterSearch(){
//		int loop = searchPage.readXls(); 
//		System.out.println("userName: "+this.userName);
		/*driver.findElement(By.linkText("Gmail")).click();;
		Assert.assertEquals(driver.getTitle(), "Gmail");
		System.out.println("In first test ");*/
		searchPage.openGmail();
		Assert.assertEquals(driver.getTitle(), "Gmail");					
	}
	
	@AfterClass
	public void tearDown(){
		stopBrowserSession();
	}
	

}
