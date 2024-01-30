package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class Home_Page {
	public AppiumDriver driver;

	public Home_Page(AppiumDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(how = How.XPATH, using = "//*[@content-desc='App']")
	private WebElement appMenu;

	@FindBy(how = How.XPATH, using = "//*[@content-desc='Content']")
	private WebElement contentMenu;

	@FindBy(xpath = "//*[@content-desc='Text']")
	private WebElement textMenu;

	public boolean verifyHomePage_isLaucnhed() {

		boolean status = false;
		if (this.appMenu.isDisplayed()) {
			status = true;
		}

		return status;
	}
	
	public String getTtext_appMenu() {
		String extractedText = null;
		extractedText = this.appMenu.getText();
		return extractedText;
		
	}
	
	public App_Page click_appMenu() {
		this.appMenu.click();
		return new App_Page(driver);
	}
	
	public Content_Page click_ContentMenu() {
		
		this.contentMenu.click();
		return new Content_Page(driver);
	}
	
	public Text_Page click_TextMenu() {
		this.textMenu.click();
		return new Text_Page(driver);
	}
	

	public void navigate_backTo_HomePage_from_DeviceAdminMenu() {
		driver.navigate().back();
		driver.navigate().back();
		
	}

	public void navigate_backTo_HomePage_from_ContentMenu() {
		driver.navigate().back();
		
		
	}
	
	public void navigate_backTo_HomePage_from_TextMenu() {
		driver.navigate().back();
		
		
	}
	
}
