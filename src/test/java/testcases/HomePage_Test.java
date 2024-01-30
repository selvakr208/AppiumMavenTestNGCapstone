package testcases;

import java.lang.reflect.Method;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import base.MobileApplicationBase;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import pages.Home_Page;

public class HomePage_Test extends MobileApplicationBase {
	WebElement element;

	@Test
	@Ignore
	public void verify_appLaunch() throws Exception {

		/*
		 * UiAutomator2Options options = new UiAutomator2Options();
		 * 
		 * options.setCapability("platformName", "Android");
		 * 
		 * options.setCapability("appium:app", System.getProperty("user.dir") +
		 * "/apps/ApiDemos-debug.apk"); options.setCapability("appium:deviceName",
		 * "emulator-5554"); options.setCapability("appium:automationName",
		 * "UiAutomator2"); // options.se // options.setCapability("appium:avd",
		 * "5554");
		 * 
		 * AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),
		 * options);
		 */

		Home_Page homepage = new Home_Page(driver);
		homepage.getTtext_appMenu();
		System.out.println("The text of the menu is ---> " + homepage.getTtext_appMenu());

//		System.out.println(
//				"The text of the menu is ---> " + driver.findElement(AppiumBy.xpath("//*[@content-desc='App']")).getText());

		/*
		 * driver.findElement(By.xpath("//*[@content-desc='App']")).click();
		 * List<WebElement> app_menu_elem =
		 * driver.findElements(By.className("android.widget.TextView"));
		 * app_menu_elem.size();
		 * System.out.println("The total number of element in APP screen is =====> " +
		 * app_menu_elem.size());
		 */

		// System.out.println("The total number of element in APP screen is =====> " +
		// homepage.click_appMenu().get_Sizeof_AppMenus_List());

		homepage.click_appMenu().click_DeviceAdmin_menu();

		/*
		 * Thread.sleep(500); Iterator<WebElement> iterator = app_menu_elem.iterator();
		 * while(iterator.hasNext()){
		 * 
		 * WebElement elem = iterator.next(); String app_text = elem .getText();
		 * System.out.println("The text in the app menu is ===> "+app_text);
		 * if(app_text.equalsIgnoreCase("Device Admin")) { elem.click(); break; }
		 * 
		 * }
		 */
		Thread.sleep(500);

		homepage.navigate_backTo_HomePage_from_DeviceAdminMenu();
		/*
		 * driver.navigate().back(); driver.navigate().back();
		 */
		Thread.sleep(500);

		System.out.println("The total number of element in CONTENT screen is =====> "
				+ homepage.click_ContentMenu().get_Sizeof_ContentMenus_List());

		Thread.sleep(500);
		homepage.navigate_backTo_HomePage_from_ContentMenu();

		/*
		 * driver.findElement(By.xpath("//*[@content-desc='Content']")).click();
		 * 
		 * List<WebElement> content_menu_elem =
		 * driver.findElements(By.className("android.widget.TextView"));
		 * content_menu_elem.size();
		 * System.out.println("The total number of element in CONTENT screen is =====> "
		 * + content_menu_elem.size()); Thread.sleep(500); driver.navigate().back();
		 */

		System.out.println("The total number of element in Text screen is =====> "
				+ homepage.click_TextMenu().get_Sizeof_TextMenus_List());
		Thread.sleep(500);
		homepage.navigate_backTo_HomePage_from_TextMenu();

		/*
		 * driver.findElement(By.xpath("//*[@content-desc='Text']")).click();
		 * List<WebElement> text_menu_elem =
		 * driver.findElements(By.xpath("//*[@class='android.widget.TextView']"));
		 * text_menu_elem.size();
		 * System.out.println("The total number of element in Text screen is =====> " +
		 * text_menu_elem.size());
		 * 
		 * driver.navigate().back();
		 */
		Thread.sleep(500);
	}

	@Test
	public void verify_DeviceAdminMenu(Method method) throws Exception {

		Home_Page homepage = new Home_Page(driver);
		homepage.getTtext_appMenu();
		System.out.println("The text of the menu is ---> " + homepage.getTtext_appMenu());

		takeScreenShot(driver, method.getName());
		Assert.assertTrue(homepage.click_appMenu().verify_DeviceAdminMenu_isDisplayed(),"FAILED.----> The Device Admin menu is NOT displayed.!");

		Thread.sleep(500);
	}

}
