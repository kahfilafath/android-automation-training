package com.android.automation.training.steps;

import com.android.automation.training.base.PageBaseObject;
import com.android.automation.training.drivers.AndroidDriverInit;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginSteps extends PageBaseObject {


 @Given("user open the Alfagift App")
  public void userOpenTheAlfagiftApp(){
   initialize();
  }

  @And("user click Enter on Welcome screen")
  public void userClickEnterOnWelcomeScreen() {
    By BUTTON_ENTER = MobileBy.id("btn_login");
    click(BUTTON_ENTER);
  }

  @And("user click next button on Login screen")
  public void userClickNextButtonOnLoginScreen() {
    By BUTTON_CONTINUE = MobileBy.id("btnNext");
    click(BUTTON_CONTINUE);
  }

  @Then("user should see “Selamat Datang di Alfagift” on Home screen")
  public void userShouldSeeSelamatDatangDiAlfagiftOnHomeScreen() {
  }

  @When("user input phone number {string} on Login screen")
  public void userInputPhoneNumberOnLoginScreen(String phone) {
    By INPUT_USERNAME = MobileBy.id("etPhonePontaNumber");
    input(INPUT_USERNAME, phone);
  }

  @And("user input password {string} on Login screen")
  public void userInputPasswordOnLoginScreen(String password) {
    By INPUT_PASSWORD = MobileBy.id("etPassword");
    input(INPUT_PASSWORD, password);
  }

  @Then("user should see {string} on Home screen")
  public void userShouldSeeOnHomeScreen(String title) {
    By LABEL_WELCOME_SCREEN = MobileBy.id("tv_title");
    waitUntilPresent(LABEL_WELCOME_SCREEN);
    Assertions.assertEquals(title,getText(LABEL_WELCOME_SCREEN),
        "Failed to go to Home Page!");
  }
}
