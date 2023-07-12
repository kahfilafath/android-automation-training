package com.android.automation.training;

import com.android.automation.training.base.PageBaseObject;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppiumTest extends PageBaseObject {

  public AndroidDriver<AndroidElement> androidDriverInit() {
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
    caps.setCapability(MobileCapabilityType.DEVICE_NAME, "device");
    // caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
    caps.setCapability(MobileCapabilityType.UDID, "90fa84ca");
    caps.setCapability(MobileCapabilityType.APP, "E://app/app_revamp2.apk");
    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
    caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
    caps.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);
    caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.alfamart.alfagift.debug");
    // capabilities.setCapability("unicodeKeyboard", "true");                                     
    // capscapabilities.setCapability("resetKeyboard", "true");

    //url appium
    String url = "http://127.0.0.1:4723";
    //initialize appium
    AndroidDriver<AndroidElement> driver = null;
    try {
      driver = new AndroidDriver<>(new URL(url), caps);

    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
    //implicitly wait
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    return driver;
  }

  @Test
  public void verifyWelcomeScreenIsWellDisplayedAfterLaunchedApp() {
    //call driver method to create session (mandatory step to run automation)
    AndroidDriver<AndroidElement> driver = androidDriverInit();
    //Initialize locators & find the element on the welcome screen
    By IMG_ALFAMART = MobileBy.id("iv_logo");
    AndroidElement findAlfaImage = driver.findElement(IMG_ALFAMART);
    By BUTTON_PROMO = MobileBy.id("btn_promo");
    AndroidElement findButtonPromo = driver.findElement(BUTTON_PROMO);
    By BUTTON_STORE = MobileBy.id("btn_store");
    AndroidElement findStoreBtn = driver.findElement(BUTTON_STORE);
    By LABEL_WELCOME_SCREEN = MobileBy.id("txt_title");
    AndroidElement findWelcomeScreen = driver.findElement(LABEL_WELCOME_SCREEN);
    
    

    //call the methods to perform action & verify the acceptance criteria on the welcome screen
    boolean imgAlfaDisplayed = findAlfaImage.isDisplayed();
    Assertions.assertTrue(imgAlfaDisplayed, "Alfamart icon is not exist!");

    boolean btnPromoDisplayed = findButtonPromo.isDisplayed();
    Assertions.assertTrue(btnPromoDisplayed, "Button Promo is not exist!");

    Assertions.assertTrue(findStoreBtn.isDisplayed(), "Button Store is not exist!");
    Assertions.assertEquals("Selamat Datang di Alfagift!", findWelcomeScreen.getText(),
        "Format Greeting Salah!");

  }

  //Sample test using Page Object Model
  @Test
  public void loginWithValidData() {
    //call driver method to create session (mandatory step to run automation)
    initialize();


    //click enter to go to login screen
    By BUTTON_ENTER = MobileBy.id("btn_login");
    click(BUTTON_ENTER);

    //input username
    By INPUT_USERNAME = MobileBy.id("etPhonePontaNumber");
    input(INPUT_USERNAME, "081324787131");

    //input password
    By INPUT_PASSWORD = MobileBy.id("etPassword");
    input(INPUT_PASSWORD, "Yasmin22");

    //click continue
    By BUTTON_CONTINUE = MobileBy.id("btnNext");
    click(BUTTON_CONTINUE);

    //verify user successfully enter to home page
    By LABEL_WELCOME_SCREEN = MobileBy.id("tv_title");
    Assertions.assertEquals("Selamat Datang di Alfagift",getText(LABEL_WELCOME_SCREEN),"Failed to go to Home Page!");
    
    By Buttonnanti = MobileBy.id("btn_later");
    AndroidElement findButtonnanti = driver.findElement(Buttonnanti);
    boolean ButtonnantiDisplayed = findButtonnanti.isDisplayed();
    Assertions.assertTrue(ButtonnantiDisplayed);
    click(Buttonnanti);

    
  }
  
  // test add to cart in PDP page
  @Test
  public void add_to_cart() {
    
    //call method loginValid
    loginWithValidData();
   
    //click button shopping
    By ICON_SHOPPING = MobileBy.id("iv_shopping") ;
    waitUntilPresent(ICON_SHOPPING);
    click(ICON_SHOPPING);

    // choose product
    By PRODUCT = MobileBy.id("card_product");
    AndroidElement findPRODUCT = driver.findElement(PRODUCT) ;
    boolean PRODUCTDisplayed = findPRODUCT.isDisplayed();
    Assertions.assertTrue(PRODUCTDisplayed);
    click(PRODUCT);

  
    //Addtion Quantity
    By Increase = MobileBy.id("imgIncreaseQty");
    waitUntilPresent(Increase);
    click(Increase);

    //Click button ADD TO CART IN PDP Page
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    waitUntilPresent(ICON_ADD);
    click(ICON_ADD);

     //Click button Backet
    By ICON_BACKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BACKET);
    click(ICON_BACKET);

    //Verify Object In page bucket
    By STOCKTOKO = MobileBy.id("tv_seller");
    AndroidElement findSTOCKTOKO = driver.findElement(STOCKTOKO);
    boolean STOCKTOKODisplayed = findSTOCKTOKO.isDisplayed();
    Assertions.assertTrue(STOCKTOKODisplayed);
  
  }
  //Test add to cart in shopping page
    @Test
  public void add_to_cart_shoopingpage() {
    
    //call method loginValid
    loginWithValidData();
   
    //click button shopping
    By ICON_SHOPPING = MobileBy.id("iv_shopping") ;
    waitUntilPresent(ICON_SHOPPING);
    click(ICON_SHOPPING);

    // choose product
    By PRODUCT = MobileBy.id("txt_product_name");
    AndroidElement findAllPRODUCT = driver.findElement(PRODUCT);
    boolean PRODUCTDisplayed = findAllPRODUCT.isDisplayed();
    Assertions.assertTrue(PRODUCTDisplayed);
  
    
    //Click button ADD TO CART IN SHOPPING PAGE
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    click(ICON_ADD) ;


    //Click ICON BACKET IN SHOPPING PAGE
    By ICON_BACKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BACKET);
    click(ICON_BACKET);


    //Verify Object In page bucket
    By STOCKTOKO = MobileBy.id("tv_seller");
    AndroidElement findSTOCKTOKO = driver.findElement(STOCKTOKO);
    boolean STOCKTOKODisplayed = findSTOCKTOKO.isDisplayed();
    Assertions.assertTrue(STOCKTOKODisplayed);
  }


  //search product add to cart
  @Test
  public void add_to_cart_searchproduct() {
    
    //call method loginValid
    loginWithValidData();

    //search product
    By searchproduct = MobileBy.id("edt_search") ;
    click(searchproduct);
    driver.findElement(By.id("edt_search")).sendKeys("Bimoli");
    driver.executeScript("mobile:performEditorAction",ImmutableMap.of("action", "search"));
  

    //choose product
    By PRODUCT = MobileBy.id("container_product");
    waitUntilPresent(PRODUCT);
    AndroidElement findAllPRODUCT = driver.findElement(PRODUCT);
    boolean PRODUCTDisplayed = findAllPRODUCT.isDisplayed();
    Assertions.assertTrue(PRODUCTDisplayed);


    //Click button ADD TO CART IN RESULT SEARCH PAGE
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    waitUntilPresent(ICON_ADD);
    click(ICON_ADD);


    //Click ICON BACKET IN RESULT SEARCH PAGE
    By ICON_BACKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BACKET);
    click(ICON_BACKET);

    
    //Verify Object In page bucket
    By STOCKTOKO = MobileBy.id("tv_seller");
    AndroidElement findSTOCKTOKO = driver.findElement(STOCKTOKO);
    boolean STOCKTOKODisplayed = findSTOCKTOKO.isDisplayed();
    Assertions.assertTrue(STOCKTOKODisplayed);
  }
 //test
  @Test
  public void changepasswordVALID() {
    //call method login
    loginWithValidData();
    
    //click button profil
    By PROFIL_BUTTON = MobileBy.id("iv_account");
    click(PROFIL_BUTTON);
  
    //Click Account setting
    By BUTTON_ACCOUNT_SET= MobileBy.id("tv_menu_name");
    click(BUTTON_ACCOUNT_SET);

    //Button change pw
    By BUTTON_CHANGE_PW = MobileBy.id("container_menu_name");
    click(BUTTON_CHANGE_PW);
    // Input PW Old
    By INPUT_PASSWORD_OLD = MobileBy.id("etCurrentPassword");
    input(INPUT_PASSWORD_OLD, "Yasmin22");

    // Input PW NEW
    By INPUT_PASSWORD_NEW = MobileBy.id("etPassword");
    input(INPUT_PASSWORD_NEW, "Yasmin234");

    // Input PW NEW CONFIRM
    By INPUT_PASSWORD_CONFRM = MobileBy.id("etConfirmPassword");
    input(INPUT_PASSWORD_CONFRM, "Yasmin234");

    //Click SAVE
    By BUTTON_SAVE = MobileBy.id("btnSave");
    click(BUTTON_SAVE);

    //VERIFY SUCCES
    By LABEL_SUCCES = MobileBy.id("txtMessage");
    Assertions.assertEquals("Password diubah!",getText(LABEL_SUCCES),"Kata Sandi lama Anda salah");

}
}