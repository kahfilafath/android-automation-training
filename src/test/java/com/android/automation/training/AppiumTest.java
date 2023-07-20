package com.android.automation.training;

import com.android.automation.training.base.PageBaseObject;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    
    By BUTTON_LATER = MobileBy.id("btn_later");
    AndroidElement findButtonLater = driver.findElement(BUTTON_LATER);
    boolean buttonLaterDisplayed = findButtonLater.isDisplayed();
    Assertions.assertTrue(buttonLaterDisplayed);
    click(BUTTON_LATER);

    
  }
  
  // Test Add To Cart on PDP page
  @Test
  public void addToCartPDP() {
    
    //call method loginValid
    loginWithValidData();
   
    //Click Button Shopping
    By ICON_SHOPPING = MobileBy.id("iv_shopping") ;
    waitUntilPresent(ICON_SHOPPING);
    click(ICON_SHOPPING);

    // Choose Product
    By PRODUCT = MobileBy.id("card_product");
    findAll(PRODUCT).get(0).click();

  
    //Addtion Quantity on PDP page
    By INCREASE = MobileBy.id("imgIncreaseQty");
    waitUntilPresent(INCREASE);
    click(INCREASE);


    //Click Button Add To Cart on PDP page
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    findAll(ICON_ADD).get(0).click();
   


     //Click Button Basket After redirect to Shopping Page
    By ICON_BASKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BASKET);
    click(ICON_BASKET);



    //Verify Object on Page Bucket
    By STOCK_TOKO = MobileBy.id("tv_seller");
    AndroidElement findStockToko = driver.findElement(STOCK_TOKO);
    boolean stockTokoDisplayed = findStockToko.isDisplayed();
    Assertions.assertTrue(stockTokoDisplayed);
  
  }
  //Test Add To Cart on Shopping Page
  @Test
  public void addToCartShoopingPage() {
    
    //call method loginValid
    loginWithValidData();
   
    //click Icon shopping on shopping page
    By ICON_SHOPPING = MobileBy.id("iv_shopping") ;
    waitUntilPresent(ICON_SHOPPING);
    click(ICON_SHOPPING);

    // Choose Product on shopping page
    By PRODUCT = MobileBy.id("txt_product_name");
    AndroidElement findAllProduct = findAll(PRODUCT).get(0);
    boolean ProductDisplayed = findAllProduct.isDisplayed();
    Assertions.assertTrue(ProductDisplayed);
  
    
    //Click Button Add To Cart on Shopping Page
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    findAll(ICON_ADD).get(0).click();


    //Click ICON BASKET IN SHOPPING PAGE
    By ICON_BASKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BASKET);
    click(ICON_BASKET);


    //Verify Object In page bucket
    By STOCK_TOKO = MobileBy.id("tv_seller");
    AndroidElement findStockToko = driver.findElement(STOCK_TOKO);
    boolean stockTokoDisplayed = findStockToko.isDisplayed();
    Assertions.assertTrue(stockTokoDisplayed);
  }


  //Search Product Add to Cart
  @Test
  public void addToCartSearchProduct() {
    
    //call method loginValid
    loginWithValidData();

    //search product
    By SEARCH_PRODUCT = MobileBy.id("edt_search");
    click(SEARCH_PRODUCT);
    driver.findElement(SEARCH_PRODUCT).sendKeys("Bimoli");
    driver.executeScript("mobile:performEditorAction",ImmutableMap.of("action", "search"));
  

    //choose product
    By PRODUCT = MobileBy.id("container_product");
    findAll(PRODUCT).get(0);
    

    //Click button ADD TO CART IN RESULT SEARCH PAGE
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    findAll(ICON_ADD).get(0).click();


    //Click ICON BASKET IN RESULT SEARCH PAGE
    By ICON_BASKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BASKET);
    click(ICON_BASKET);

    
    //Verify Object In page bucket
    By STOCK_TOKO = MobileBy.id("tv_seller");
    AndroidElement findStockToko = driver.findElement(STOCK_TOKO);
    boolean stockTokoDisplayed = findStockToko.isDisplayed();
    Assertions.assertTrue(stockTokoDisplayed);
  }

//  test Change Password Valid
  @Test
  public void changePasswordValid() {
    //call method login
    loginWithValidData();
    
    //click button profil
    By PROFIL_BUTTON = MobileBy.id("iv_account");
    click(PROFIL_BUTTON);
  
    //Click Account setting
    By BUTTON_ACCOUNT_SET= MobileBy.id("tv_menu_name");
    findAll(BUTTON_ACCOUNT_SET).get(0).click();

    //Button change pw
    By BUTTON_CHANGE_PW = MobileBy.id("container_menu_name");
    findAll(BUTTON_CHANGE_PW).get(0).click();

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
  //test Choose Product To Cart
  @Test
  public void addProductToCart() {
    //Call Method Login
    loginWithValidData();

    //Click Icon Shopping on Home page
     By ICON_SHOPPING = MobileBy.id("iv_shopping") ;
    waitUntilPresent(ICON_SHOPPING);
    click(ICON_SHOPPING);

   

    // Choose Product on shopping page "ULTRA MILK Susu UHT Coklat 250 ml"
    By PRODUCT = MobileBy.id("txt_product_name");
    findAll(PRODUCT).stream().filter(e -> e.getText().equalsIgnoreCase("ULTRA MILK Susu UHT Coklat 250 ml"))
    .findFirst().get().click();

    //Click Button Add To Cart
    By ICON_ADD = MobileBy.id("btn_add_to_cart");
    findAll(ICON_ADD).get(0).click(); 
    
   
    //Scroll helper  
    find(MobileBy.AndroidUIAutomator(String.format("new UiScrollable(new UiSelector().resourceIdMatches(\".*%s.*\")"
    + ".scrollable(true)).scrollIntoView(new UiSelector().text(\"%s\"))", "rv_content", "Tehbotol SOSRO Minuman Teh Original 350 ml")));
    
    
    // Choose Product on shopping page "Tehbotol SOSRO Minuman Teh Original 350 ml"
    findAll(PRODUCT).stream().
    filter(e -> e.getText()
    .equalsIgnoreCase("Tehbotol SOSRO Minuman Teh Original 350 ml"))
    .findFirst().get().click();
    findAll(ICON_ADD).get(0).click(); 



    //Click Icon Basket in Shopping Page
    By ICON_BASKET = MobileBy.id("iv_basket");
    waitUntilPresent(ICON_BASKET);
    click(ICON_BASKET);

    
    //Verify Object In page busket
    By PRODUCT_LIST = MobileBy.id("tv_product_name");
        List<AndroidElement> elements1 = driver.findElements(PRODUCT_LIST);
        List<AndroidElement> elements2 = driver.findElements(PRODUCT_LIST);
        
        // Define expected values for both elements
        String expectedText1 = "ULTRA MILK Susu UHT Coklat 250 ml";
        String expectedText2 = "Tehbotol SOSRO Minuman Teh Original 350 ml";

        // Create a list to hold the elements for iteration
        List<MobileElement> elementsList = new ArrayList<>();
        elementsList.addAll(elements1);
        elementsList.addAll(elements2);

        for (MobileElement element : elementsList) {
            String actualText = element.getText();

            if (actualText.equals(expectedText1)) {
              System.out.println("Element text matches the expected value: " + actualText);
              // Perform additional verification logic or actions as needed
          } else if (actualText.equals(expectedText2)) {
              System.out.println("Element text matches the expected value: " + actualText);
              // Perform additional verification logic or actions as needed
          } else {
              System.out.println("Element text does not match any expected value: " + actualText);
              // Perform additional verification logic or raise an error as needed
          }
      }
    }
  }
     
            
        
    
        