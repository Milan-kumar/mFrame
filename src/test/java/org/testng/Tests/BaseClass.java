package org.testng.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Page.SearchPage;
import org.testng.Page.Xls_Util;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;




public class BaseClass {
	
	protected static WebDriver driver;
	protected static SearchPage searchPage;
	Xls_Util xls = new Xls_Util(".\\Data\\TestData.xlsx");
	
	
	public static void initPageObjects(WebDriver driver){
		searchPage = new SearchPage(driver);		
	}	
	
	
	public static boolean startBrowserSession(String browser, String URL){
		
//		String browser = BROWSER;
		String url = URL;
		boolean flag= false;
		if(browser.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url);
			flag = true;
		}else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			flag = true;
		}
		else if (browser.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
			driver.get(url);
			flag = true;
		}else
			System.out.println("Input correct browser details");
		if (flag) {
			initPageObjects(driver);
		}
		return flag;
	}	

	public static boolean stopBrowserSession(){
		driver.quit();
		return true;
	}

}
