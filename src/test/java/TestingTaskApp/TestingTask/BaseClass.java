package TestingTaskApp.TestingTask;

import org.testng.annotations.BeforeClass;


import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {


public AndroidDriver driver;

@BeforeClass
public void appiumtest() throws MalformedURLException, InterruptedException {
	
	
	
	    DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
		
		cap.setCapability(MobileCapabilityType.DEVICE_NAME,"vivo1818");

	    cap.setCapability(MobileCapabilityType.APP, "C://eclipse-java-2022-06-R-win32-x86_64//eclipse//TestingTask//src//test//java//Resources//app.apk");

		
		cap.setCapability("appWaitActivity","com.example.testingtask.MainActivity");
		cap.setCapability("appWaitActivity", "com.example.testingtask");
		cap.setCapability("appWaitActivity", "com.example.testingtask.LoginActivity");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),cap);
	
}



@AfterClass
public void tearDown() throws Exception {
	driver.quit();
	Thread.sleep(4000);
} 

}
