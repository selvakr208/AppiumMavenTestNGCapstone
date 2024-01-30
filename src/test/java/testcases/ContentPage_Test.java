package testcases;

import java.lang.reflect.Method;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.MobileApplicationBase;
import pages.Home_Page;

public class ContentPage_Test extends MobileApplicationBase {
	
	WebElement element;
	
	@Test
	public void verify_ContentMenu_Screen(Method method) throws Exception {

		Home_Page homepage = new Home_Page(driver);
		homepage.getTtext_appMenu();
		System.out.println("The text of the menu is ---> " + homepage.getTtext_appMenu());

		takeScreenShot(driver, method.getName());
		Assert.assertTrue(homepage.click_ContentMenu().verify_numberOf_ContentMenus(),
				"FAILED.----> The total number of menus in Content screen is mismatched.!");

	}

}
