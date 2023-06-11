package com.android.automation.training.base;

import com.android.automation.training.drivers.AndroidDriverInit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBaseObject extends AndroidDriverInit {


  public void init(){
    initialize();
  }
  public AndroidDriver<AndroidElement> getDriver(){
    return driver;
  }
  public AndroidElement find(By locator){
    return getDriver().findElement(locator);
  }
  public void click(By locator){
    find(locator).click();
  }
  public void input(By locator, String text){
    AndroidElement element = find(locator);
    element.clear();
    element.sendKeys(text);
  }
  public String getText(By locator){
    return find(locator).getText();
  }

  public AndroidElement findAll(By locator){
    return getDriver().findElement(locator);
  }
//wrap the elements into collection of arraylist with stream method and map it to get the text
  // public void stream(By locator, String text){
  //   List<AndroidElement> elements = getDriver().findElements(locator);
  //   elements.stream().collect(Collectors.toList());
    
  // }

  // public void stream(By locator, String text) {
  //   List<AndroidElement> elements = getDriver().findElements(locator);
  //   elements.stream().map(element -> element.getText()).collect(Collectors.toList());
  // }

  public void streamElement(By locator, String text) {
    List<AndroidElement> elements = getDriver().findElements(locator);
    elements.stream().map(element -> element.getText()).collect(Collectors.toList());
  }

  public void waitUntilPresent(By locator) {
    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }
  public void waitUntilTextPresent(By locator, String text) {
    WebDriverWait wait = new WebDriverWait(driver, 15);
    wait.until(ExpectedConditions.textToBePresentInElement(find(locator), text));
  }

}
