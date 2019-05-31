import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.google.gson.stream.MalformedJsonException;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;



public class Install_apk {
	AppiumDriver<MobileElement> driver;

@BeforeMethod
public void setUp() throws MalformedJsonException, MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "");
	capabilities.setCapability("VERSION", "7.1.2"); 
	capabilities.setCapability("deviceName","Redmi");
	capabilities.setCapability("platformName","Android");
 
   
   capabilities.setCapability("appPackage", "com.shaadi.android");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.shaadi.android.ui.splash.SplashScreenActivity"); // This is Launcher activity of your app (you can get it from apk info app)


 driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

@Test
public void testGooglePlayApp() throws InterruptedException {
	
	try {
		MobileElement menu = (MobileElement) driver.findElementById("com.android.vending:id/navigation_button");
		menu.click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		MobileElement scrollToText = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"Play Protect\"));"));
		 scrollToText.click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 //MobileElement playprotect= (MobileElement)driver.findElement(By.xpath("// android.widget.Switch[@text='ON']"));
		 MobileElement playprotecttoggle= (MobileElement)driver.findElementByXPath("//android.widget.Switch[@resource-id='com.google.android.gms:id/toggle'  and @text='ON']");
		
		 playprotecttoggle.click();
		 MobileElement popupok= (MobileElement)driver.findElementByXPath("//android.widget.Button[@resource-id='android:id/button1' and @text='OK']");
		 
		 popupok.click();
		 driver.navigate().back();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	} catch (NoSuchElementException e1) {
		// TODO Auto-generated catch block
		System.out.println(" already toggle off ");
		driver.navigate().back();
	}
	 
	
	
	
	String appnames[]={"Instagram" , "Skype", "LINE: Free Calls & Messages", "TimesOfIndia", "Ganna" ,"Uber","Flipart","WhatsApp Messenger","Facebook", "Amazon Shopping","Clean master","My Talking Tom","Wego Flights & Hotels","MiFit" , "hangout"};
 for(int i=0;i<=14;i++)   {
	 //How to scroll to specific text
   // 

		MobileElement appTitlsearchbox = (MobileElement) driver.findElementById("com.android.vending:id/search_box_idle_text");
		
		appTitlsearchbox.click();
	
		// ((StartsActivity) driver).startActivity(new Activity("com.android.vending", "com.android.vending.AssetBrowserActivity"));
		// MobileElement appTitlsearchbox1 = (MobileElement) driver.findElementById("com.android.vending:id/search_box_idle_text");
			
			//appTitlsearchbox1.click();

	
		try {
			// driver.findElementById("com.android.vending:id/action_button and @content-desc='Clear'");
			 MobileElement cross = (MobileElement)driver.findElementByXPath("//android.widget.ImageView[@resource-id='com.android.vending:id/action_button' and @content-desc='Clear']");
			cross.click();
		} catch (NoSuchElementException e1) {
			System.out.println("no cross");
		}
	
	
	
	//editText.clear();
	//appTitlsearchbox.clear();
    // Verifying the app detail page
   // MobileElement appTitle = (MobileElement) driver.findElementById("com.android.vending:id/title_title");

  //  Assert.assertTrue(appName.equals(appTitle.getText().trim()));

   // driver.navigate().back();

    //Clicking the search bar icon

  //  MobileElement scrollToElement = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description());"));
  //  scrollToElement.click();


    MobileElement editText = (MobileElement) driver.findElementById("com.android.vending:id/search_box_text_input");
  
    
    
    //Thread.sleep(1000);
    editText.sendKeys(appnames[i]);
    
//editText.click();
   // Thread.sleep(1000);

 /*List<MobileElement> listOfSuggestedResults = driver.findElementsById("com.android.vending:id/suggest_text");
// WebElement listOfSuggestedResults =  driver.findElementById("com.android.vending:id/title");
 System.out.println("sUGGEST" +listOfSuggestedResults.size());
  for (MobileElement element : listOfSuggestedResults) {
 if (appnames[i].equals(element.getText())) {
  element.click();
   break;
  }
 }*/
//
  //editText = (MobileElement) driver.findElementById("com.android.vending:id/title_title");

//  Assert.assertTrue(editText.equals(editText.getText().trim()));
MobileElement suggestedapp = (MobileElement) driver.findElementById("com.android.vending:id/title");
suggestedapp.click();
Thread.sleep(1000);
//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
   //  appname = (MobileElement) driver.findElementByClassName("android.widget.Button");
  try {
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	MobileElement appfetched= (MobileElement)driver.findElement(By.xpath("//android.widget.Button[@text='INSTALL']"));
	    if(appfetched.isDisplayed()){appfetched.click();
	    System.out.println(appnames[i]+" App is going to be  installed");}
	    
	   
	    
} catch (NoSuchElementException e) {
	System.out.println(appnames[i]+" App is already installed");
}
  driver.navigate().back();
 }
}

@AfterClass
public void tearDown() {
	System.out.println("Please wait...");
   /* if (driver != null) {
        driver.quit();
    }*/
}

}