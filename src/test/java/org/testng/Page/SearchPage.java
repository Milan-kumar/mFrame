package org.testng.Page;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BaseUi{

	public SearchPage(WebDriver driver) {
		super(driver);	
		this.driver = driver;		
	}
	
	public WebDriver driver;
	
	@FindBy(id="lst-ib")
	public static WebElement username;	
	
	public void enterUsername(String inputString){	
//		System.out.println();
//		String uName = xls.getCellData("TestData", 1, "Input");
		System.out.println("Title:"+driver.getTitle());
		System.out.println("Title:"+inputString);
		username.sendKeys(inputString);
		username.submit();
//		searchInput.sendKeys(inputString);
//		searchInput.submit();
//		return true;
	}
	
	

	public boolean getSearch(String testString) {
//		String uName = xls.getCellData("TestData", 1, "Input");
		boolean flag= false;
//		List<WebElement> element = driver.findElements(By.cssSelector("div.g>div>h3>a"));
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(".//*[@class='srg']/div/div/h3/a")));				
		List<WebElement> element = driver.findElements(By.xpath(".//*[@class='srg']/div/div/h3/a"));		
		for (WebElement webElement : element) {
			System.out.println(webElement.getText());
			if(webElement.getText().trim().contains(testString)){
				System.out.println(webElement.getText());
				flag=true;
				return flag;
			}
		}
		return flag;
		
	}



	public String openGmail() {
		driver.findElement(By.linkText("Gmail")).click();;
		System.out.println("In first test ");
		return driver.getTitle();		
	}	

}
