package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.MobileApplicationBase;
import pages.Home_Page;

public class TextPage_Test extends MobileApplicationBase {
	
	WebElement element;
	
	@Test
	public void verify_TextMenu_Screen(Method method) throws Exception {

		Home_Page homepage = new Home_Page(driver);
		homepage.getTtext_appMenu();
		System.out.println("The text of the menu is ---> " + homepage.getTtext_appMenu());

		takeScreenShot(driver, method.getName());
		Assert.assertTrue(homepage.click_TextMenu().verify_numberOf_TextMenus(),
				"FAILED.----> The total number of menus in Text screen is mismatched.!");

	}

}
