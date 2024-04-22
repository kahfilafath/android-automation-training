package com.android.automation.training.hooks;

import static com.android.automation.training.drivers.AndroidDriverInit.driver;

import com.android.automation.training.drivers.AndroidDriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.File;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class AndroidDriverHook {

  AndroidDriverInit init = new AndroidDriverInit();
  @Before
  public void init(){
    init.initialize();
  }
  @After()
  public void afterScenario(Scenario scenario){
    if(scenario.isFailed()){
      TakesScreenshot ts = driver;
      byte[] src = ts.getScreenshotAs(OutputType.BYTES);
      File srcFile = ts.getScreenshotAs(OutputType.FILE);
      scenario.attach(src, "image/png", "screenshot");
      File file = new File(srcFile.toURI());
    }
  }

}
