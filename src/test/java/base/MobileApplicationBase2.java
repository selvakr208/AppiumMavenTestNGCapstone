package base;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MobileApplicationBase2 {

	// public static AppiumDriver driver;
	public String testPlatformName = "Android";
	public static String browser;
	
	
	public ThreadLocal<AppiumDriver> driver = new ThreadLocal<AppiumDriver>();
	
	public void setDriver(AppiumDriver driver) {
		this.driver.set(driver);
		
	}
	
	public AppiumDriver getDriver() {
		return this.driver.get();
		
	}
	@BeforeMethod
	@Parameters({"deviceName","portNumber"})
	public void launchApp(String deviceName,  String portNumber) {
		
		startAppiumService(portNumber);

		if (testPlatformName.equalsIgnoreCase("Android")) {

			UiAutomator2Options options = new UiAutomator2Options();

			options.setCapability("platformName", "Android");

			options.setCapability("appium:app", System.getProperty("user.dir") + "/apps/ApiDemos-debug.apk");
			options.setCapability("appium:deviceName", deviceName);
		//	options.setCapability("appium:platformVersion", platformVersion);
			options.setCapability("appium:automationName", "UiAutomator2");
			
			try {
				setDriver(new AndroidDriver(new URL("http://127.0.0.1:"+portNumber), options));
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void startAppiumService(String portNumber) {
		
		AppiumDriverLocalService service;
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(Integer.parseInt(portNumber));
		builder.withAppiumJS(new File("/Users/elaiyaperumal/node_modules/appium/build/lib/main.js"));
		
	//	builder.usingPort((4723));
		service = AppiumDriverLocalService.buildService(builder);
		
		service.start();
		System.out.println("The Appium service has been started with port number: "+portNumber);
	}

	/*
	 * @BeforeMethod public void launchApp() {
	 * 
	 * if (testPlatformName.equalsIgnoreCase("Android")) {
	 * 
	 * UiAutomator2Options options = new UiAutomator2Options();
	 * 
	 * options.setCapability("platformName", "Android");
	 * 
	 * options.setCapability("appium:app", System.getProperty("user.dir") +
	 * "/apps/ApiDemos-debug.apk"); options.setCapability("appium:deviceName",
	 * "emulator-5554"); options.setCapability("appium:automationName",
	 * "UiAutomator2");
	 * 
	 * try { driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
	 * } catch (MalformedURLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } }
	 */
	@AfterMethod
	public void tearDown() {

//		driver.close();
		getDriver().quit();
	}

	public static void takeScreenShot(AppiumDriver appiumDriver, String screenShotName) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss");
			String timestamp = dateFormat.format(new Date());
			String fileName = screenShotName + "_" + timestamp + ".png";

			TakesScreenshot scrShot = ((TakesScreenshot) appiumDriver);
			File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File DestFile = new File(System.getProperty("user.dir") + "/screenshot/" + fileName);
			FileUtils.copyFile(SrcFile, DestFile);
		} catch (Exception e) {
			System.out.println("Error while taking screenshot. Make sure the screenshot folder is clean..!" + e);
		}
	}

}
