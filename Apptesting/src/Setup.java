import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.gson.stream.MalformedJsonException;

import io.appium.java_client.android.AndroidDriver;

public class Setup {
 AndroidDriver driver;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	
	public void desiredcapa() {
		//private static
	capabilities.setCapability("BROWSER_NAME", "");
	capabilities.setCapability("VERSION", "8.0.1"); 
	capabilities.setCapability("deviceName","Redmi Note 6 Pro");
	capabilities.setCapability("platformName","Android");
 
   
   capabilities.setCapability("appPackage", "com.miui.calculator");
// This package name of your app (you can get it from apk info app)
	capabilities.setCapability("appActivity","com.miui.calculator.cal.CalculatorActivity"); // This is Launcher activity of your app (you can get it from apk info app)
	
	}
	public void openapp() throws MalformedJsonException, MalformedURLException{
		URL url = new URL("http://0.0.0.0:4723/wd/hub");
		WebDriver driver =new AndroidDriver(url,capabilities);
	}


}
