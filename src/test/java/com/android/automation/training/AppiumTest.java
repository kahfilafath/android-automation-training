package com.android.automation.training;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumTest {

  @Test
  public void loginWithValidData(){
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
    caps.setCapability(MobileCapabilityType.UDID,"emulator-5554");
    caps.setCapability(MobileCapabilityType.APP,"D://app/app.apk");
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UIAutomator2");
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,120);
    caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);

    //url appium
    String url = "http://127.0.0.1:4723";
    //initialize appium
    AndroidDriver<AndroidElement> driver = null;
    try{
      driver = new AndroidDriver<>(new URL(url),caps);

    }catch (MalformedURLException e){
      e.printStackTrace();
    }
    //implicitly wait
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);



  }


}
