package com.android.automation.training.steps;

import com.android.automation.training.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class SearchSteps extends PageBaseObject {

    @Given("user on the HomePage")
    public void userOnTheHomePage() {
        By HOMESCREEN = MobileBy.id("edt_search");
        Assertions.assertEquals("Mau belanja apa?",getText(HOMESCREEN),"Failed load Homepage");
    }


    @When("user click field search")
    public void userClickFieldSearch() {
        By CLICK_SEARCH = MobileBy.id("edt_search");
        click(CLICK_SEARCH);
    }


//    @And("user search the product “ultra milk susu uht coklat” on the search bar")
//    public void userSearchTheProductUltraMilkSusuUhtCoklatOnTheSearchBar() {
//        By INPUT_KEYWORD = MobileBy.id("edt_search");
//        input(INPUT_KEYWORD,"ultra milk susu uht coklat");
//    }

//    @And("user see the product suggestion “ultra milk susu uht coklat” below the search bar")
//    public void userSeeTheProductSuggestionUltraMilkSusuUhtCoklatBelowTheSearchBar(String title_sugest) {
//        By SUGGESTION = MobileBy.id("tv_keyword");
//        Assertions.assertEquals(title_sugest,getText(SUGGESTION),"Failed load suggestion");
//
//    }

    @And("user click the product suggestion below the search bar")
    public void userClickTheProductSuggestionBelowTheSearchBar() {
        By CLICK_SUGGESTION = MobileBy.id("tv_keyword");
        click(CLICK_SUGGESTION);

    }

//    @Then("user should discover the product “ULTRA MILK Susu UHT Coklat 1 L” on the search result page")
//    public void userShouldDiscoverTheProductUltraMilkSusuUhtCoklatOnTheSearchResultPage(String title_discover) {
//        By RESULT = MobileBy.id("txt_product_name");
//        Assertions.assertEquals(title_discover,getText(RESULT),"Failed load product");
//
//    }

    @And("user search the product {string} on the search bar")
    public void userSearchTheProductOnTheSearchBar(String input_search) {
        By INPUT_KEYWORD = MobileBy.id("edt_search");
        input(INPUT_KEYWORD,input_search);
    }

    @And("user see the product suggestion {string} below the search bar")
    public void userSeeTheProductSuggestionBelowTheSearchBar(String see_product) {
        By SUGGESTION = MobileBy.id("tv_keyword");
        Assertions.assertEquals(see_product,getText(SUGGESTION),"Failed load suggestion");
    }

    @Then("user should discover the product {string} on the search result page")
    public void userShouldDiscoverTheProductOnTheSearchResultPage(String title_product) {
        By RESULT = MobileBy.id("txt_product_name");
        Assertions.assertEquals(title_product,getText(RESULT),"Failed load product");
    }
}
