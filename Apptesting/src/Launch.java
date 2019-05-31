

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import com.google.gson.stream.MalformedJsonException;

import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.StartsActivity;


@Test
public class Launch {
	private static AndroidDriver driver;

@BeforeClass
public void setUp() throws MalformedJsonException, MalformedURLException{
	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setCapability("BROWSER_NAME", "");
	capabilities.setCapability("VERSION", "8.0.1"); 
	capabilities.setCapability("deviceName","Poco");
	capabilities.setCapability("platformName","Android");
 
   
   capabilities.setCapability("appPackage", "com.miui.calculator");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity"); // This is Launcher activity of your app (you can get it from apk info app)


  // driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
	
	URL url = new URL("http://0.0.0.0:4723/wd/hub");
	WebDriver driver =new AndroidDriver(url,capabilities);
	driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();
	// driver.findElement(arg0)
	 driver.findElement(By.id("com.miui.calculator:id/btn_plus_s")).click();;

	 driver.findElement(By.id("com.miui.calculator:id/btn_4_s")).click();;
	  
	  driver.findElement(By.id("com.miui.calculator:id/btn_equal_s")).click();;
	  
	   //locate the edit box of the calculator by using By.tagName()
	  // WebElement results=driver.findElement(By.tagName("EditText"));
		//Check the calculated value on the edit box
	//assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";
	  ((StartsActivity) driver).startActivity(new Activity("com.android.vending", "com.android.vending.AssetBrowserActivity"));
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  //driver.findElement(By.xpath("//android.widget.TextView[@text='TOP CHARTS']")).click();
	  driver.findElement(By.xpath("//android.widget.TextView[@text='Top charts']")).click();
		// driver.findElement(arg0)
		driver.findElement(By.xpath("//android.widget.Switch[@resource-id='com.android.vending:id/toggle_switch_button']")).click();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//android.widget.TextView[@text='TikTok - including musical.ly']")).click();
	
		//driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.vending:id/toggle_switch_button']")).click();
		//driver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.android.vending:id/search_box_text_input']")).sendKeys("Hoststar");
		//com.android.vending:id/suggest_text
		
		//android.widget.TextView
		//
				   //locate the edit box of the calculator by using By.tagName()
		//driver.findElement(By.xpath("//android.widget.Button[@text='OPEN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  ((StartsActivity) driver).startActivity(new Activity("com.miui.calculator", "com.miui.calculator.cal.CalculatorActivity"));
}

public void testCal() throws Exception {
	
	System.out.print("PASS1");

}

@AfterClass
public void teardown(){
	//close the app
System.out.print("PASS");}
}