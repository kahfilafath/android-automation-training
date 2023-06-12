package com.android.automation.training.steps;

import com.android.automation.training.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        List<String> collect = findAll(RESULT).stream().map(RemoteWebElement::getText).collect(Collectors.toList());
            for (String test : collect) {
            MatcherAssert.assertThat("Produk tidak ada", test, Matchers.containsString(title_product));
            }
//        findAll(RESULT).stream().map().collect(Collectors.toCollection());
//        for (String element: ArrayList) {
//            MatcherAssert.assertThat("Produk tidak ada", element, Matchers.containsString(title_product));
//        }

//        Assertions.assertEquals(title_product,getText(RESULT),"Failed load product");
    }
}
