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
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.parser.Element;

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
    
    By BUTTON_LATER = MobileBy.id("btn_later");
    AndroidElement findButtonLater = driver.findElement(BUTTON_LATER);
    boolean ButtonLaterDisplayed = findButtonLater.isDisplayed();
    Assertions.assertTrue(ButtonLaterDisplayed);
    click(BUTTON_LATER);

    
  }
  
  // Test Add To Cart on PDP page
  @Test
  public void AddToCartPDP() {
    
    //call method loginValid
    loginWithValidData();
   
    //Click Button Shopping
    By ICON_SHOPPING = MobileBy.id("iv_shopping") ;
    waitUntilPresent(ICON_SHOPPING);
    click(ICON_SHOPPING);

    // Choose Product
    By PRODUCT = MobileBy.id("card_product");
    AndroidElement findProduct = driver.findElement(PRODUCT) ;
    boolean ProductDisplayed = findProduct.isDisplayed();
    Assertions.assertTrue(ProductDisplayed);
    click(PRODUCT);

  
    //Addtion Quantity on PDP page
    By INCREASE = MobileBy.id("imgIncreaseQty");
    waitUntilPresent(INCREASE);
    click(INCREASE);

    //Click Button Add To Cart on PDP page
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    AndroidElement findIconAdd = driver.findElement(ICON_ADD);
    boolean IconAddDisplayed = findIconAdd.isDisplayed();
    Assertions.assertTrue(IconAddDisplayed);
    click(ICON_ADD);

     //Click Button Backet After redirect to Shopping Page
    By ICON_BACKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BACKET);
    click(ICON_BACKET);

    //Verify Object on Page Bucket
    By STOCK_TOKO = MobileBy.id("tv_seller");
    AndroidElement findStockToko = driver.findElement(STOCK_TOKO);
    boolean StockTokoDisplayed = findStockToko.isDisplayed();
    Assertions.assertTrue(StockTokoDisplayed);
  
  }
  //Test Add To Cart on Shopping Page
    @Test
  public void AddToCartShoopingPage() {
    
    //call method loginValid
    loginWithValidData();
   
    //click Icon shopping on shopping page
    By ICON_SHOPPING = MobileBy.id("iv_shopping") ;
    waitUntilPresent(ICON_SHOPPING);
    click(ICON_SHOPPING);

    // Choose Product on shopping page
    By PRODUCT = MobileBy.id("txt_product_name");
    AndroidElement findAllProduct = driver.findElement(PRODUCT);
    boolean ProductDisplayed = findAllProduct.isDisplayed();
    Assertions.assertTrue(ProductDisplayed);
  
    
    //Click Button Add To Cart on Shopping Page
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    AndroidElement findIconAdd = driver.findElement(ICON_ADD);
    boolean IconAddDisplayed = findIconAdd.isDisplayed();
    Assertions.assertTrue(IconAddDisplayed);
    click(ICON_ADD) ;


    //Click ICON BACKET IN SHOPPING PAGE
    By ICON_BACKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BACKET);
    click(ICON_BACKET);


    //Verify Object In page bucket
    By STOCK_TOKO = MobileBy.id("tv_seller");
    AndroidElement findStockToko = driver.findElement(STOCK_TOKO);
    boolean StockTokoDisplayed = findStockToko.isDisplayed();
    Assertions.assertTrue(StockTokoDisplayed);
  }


  //Search Product Add to Cart
  @Test
  public void AddToCartSearchProduct() {
    
    //call method loginValid
    loginWithValidData();

    //search product
    By SEARCH_PRODUCT = MobileBy.id("edt_search");
    click(SEARCH_PRODUCT);
    driver.findElement(SEARCH_PRODUCT).sendKeys("Bimoli");
    driver.executeScript("mobile:performEditorAction",ImmutableMap.of("action", "search"));
  

    //choose product
    By PRODUCT = MobileBy.id("container_product");
    waitUntilPresent(PRODUCT);
    AndroidElement findAllProduct = driver.findElement(PRODUCT);
    boolean ProductDisplayed = findAllProduct.isDisplayed();
    Assertions.assertTrue(ProductDisplayed);


    //Click button ADD TO CART IN RESULT SEARCH PAGE
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    AndroidElement findIconAdd = driver.findElement(ICON_ADD);
    boolean IconAddDisplayed = findIconAdd.isDisplayed();
    Assertions.assertTrue(IconAddDisplayed);
    click(ICON_ADD);


    //Click ICON BACKET IN RESULT SEARCH PAGE
    By ICON_BACKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BACKET);
    click(ICON_BACKET);

    
    //Verify Object In page bucket
    By STOCK_TOKO = MobileBy.id("tv_seller");
    AndroidElement findStockToko = driver.findElement(STOCK_TOKO);
    boolean StockTokoDisplayed = findStockToko.isDisplayed();
    Assertions.assertTrue(StockTokoDisplayed);
  }
 //test
  @Test
  public void ChangePasswordValid() {
    //call method login
    loginWithValidData();
    
    //click button profil
    By PROFIL_BUTTON = MobileBy.id("iv_account");
    click(PROFIL_BUTTON);
  
    //Click Account setting
    By BUTTON_ACCOUNT_SET= MobileBy.id("tv_menu_name");
    AndroidElement findButtonAccountSet = driver.findElement(BUTTON_ACCOUNT_SET);
    boolean ButtonAccountSetDisplayed = findButtonAccountSet.isDisplayed();
    Assertions.assertTrue(ButtonAccountSetDisplayed);
    click(BUTTON_ACCOUNT_SET);

    //Button change pw
    By BUTTON_CHANGE_PW = MobileBy.id("container_menu_name");
    AndroidElement findButtonChangePw = driver.findElement(BUTTON_CHANGE_PW);
    boolean ButtonChangePwDisplayed = findButtonChangePw.isDisplayed();
    Assertions.assertTrue(ButtonChangePwDisplayed);
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