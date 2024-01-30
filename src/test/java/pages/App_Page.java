package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class App_Page {
	
	public AppiumDriver driver;
	
	public App_Page(AppiumDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this); 
		
	}
	@FindBy(className = "android.widget.TextView")
	private List<WebElement> menus_in_page;
	
	public List<WebElement> get_Listof_AppMenus() {
		return this.menus_in_page;
	}
	
	public int get_Sizeof_AppMenus_List() {
		return this.menus_in_page.size();
	}
	
	public Content_Page click_DeviceAdmin_menu() {
		List<WebElement> app_menu_elem = this.menus_in_page;
		app_menu_elem.size();
		System.out.println("The total number of element in APP screen is =====> " + app_menu_elem.size());

		Iterator<WebElement> iterator = app_menu_elem.iterator();
		while(iterator.hasNext()){
			
			WebElement elem = iterator.next();
					 String app_text = elem	.getText();
			System.out.println("The text in the app menu is ===> "+app_text);
			if(app_text.equalsIgnoreCase("Device Admin")) {
				elem.click();
				break;
			}
			
		}
		return new Content_Page(driver);
	}
	
	public boolean verify_DeviceAdminMenu_isDisplayed() {
		
		boolean status= false;
		List<WebElement> app_menu_elem = this.menus_in_page;
		app_menu_elem.size();
		System.out.println("The total number of element in APP screen is =====> " + app_menu_elem.size());

		Iterator<WebElement> iterator = app_menu_elem.iterator();
		while(iterator.hasNext()){
			
			WebElement elem = iterator.next();
					 String app_text = elem	.getText();
			System.out.println("The text in the app menu is ===> "+app_text);
			if(app_text.equalsIgnoreCase("Device Admin")) {
				status = true;
				break;
			}
			
		}
		return status;
	}
	


}
