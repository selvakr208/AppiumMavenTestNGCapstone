package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class Content_Page {
	public AppiumDriver driver;

	public Content_Page(AppiumDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(className = "android.widget.TextView") 
	private List<WebElement> menus_in_content;
	
	public List<WebElement> get_Listof_ContentMenus() {
		return this.menus_in_content;
	}
	
	public int get_Sizeof_ContentMenus_List() {
		return this.menus_in_content.size();
	}
	
	public boolean verify_numberOf_ContentMenus() {
		boolean status= false;
		List<WebElement> content_menu_elem = this.menus_in_content;
		content_menu_elem.size();
		System.out.println("The total number of element in CONTENT screen is =====> " + content_menu_elem.size());
		if(content_menu_elem.size()==7) {
			status = true;
		}
		return status;
	}
	
	public void navigate_backTo_HomePage() {
		driver.navigate().back();
	}
}
