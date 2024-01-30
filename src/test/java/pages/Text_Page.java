package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class Text_Page {
	
	public AppiumDriver driver;
	public Text_Page(AppiumDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this); 
		
	}
	
	@FindBy(xpath = "//*[@class='android.widget.TextView']") 
	private List<WebElement> menus_in_text;
	
	
	
	public List<WebElement> get_Listof_TextMenus() {
		return this.menus_in_text;
	}
	
	public int get_Sizeof_TextMenus_List() {
		return this.menus_in_text.size();
	}
	
	public boolean verify_numberOf_TextMenus() {
		boolean status= false;
		List<WebElement> text_menu_elem = this.menus_in_text;
		text_menu_elem.size();
		System.out.println("The total number of element in CONTENT screen is =====> " + text_menu_elem.size());
		if(text_menu_elem.size()==6) {
			status = true;
		}
		return status;
	}
	
	public void navigate_backTo_HomePage() {
		driver.navigate().back();
	}

}
