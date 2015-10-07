package org.testng.Page;

import java.io.FileInputStream;





import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class BaseUi {
	
	public WebDriver driver;
	Xls_Util xls = new Xls_Util(".\\Data\\TestData.xlsx");
//	protected static SearchPage searchPage;
//	String path = System.getProperties("user.dir");
	
	public BaseUi(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	
	
	
//	public void getCellData()
	
	public void enterText(){	
//		System.out.println();
		System.out.println("Title:"+driver.getTitle());
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("Testing");
//		searchInput.sendKeys(inputString);
		
//		return true;
	}
	
	

}
