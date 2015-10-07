package org.testng.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractClass {

	public AbstractClass(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
}
