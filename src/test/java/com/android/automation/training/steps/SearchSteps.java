package com.android.automation.training.steps;

import com.android.automation.training.base.PageBaseObject;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import io.cucumber.plugin.event.Result;

import static org.mockito.ArgumentMatchers.matches;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.lang.model.element.Element;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindAll;

public class SearchSteps extends PageBaseObject {

    public ArrayList<String> collect;

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

    @And("user click the product suggestion below the search bar")
    public void userClickTheProductSuggestionBelowTheSearchBar() {
        By CLICK_SUGGESTION = MobileBy.id("tv_keyword");
        click(CLICK_SUGGESTION);
    }

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
        findAll(RESULT).stream()
        //mapping element to get text
        .map(element -> element.getText())
        //collect all text to arraylist
        .collect(Collectors.toCollection(ArrayList::new));
        //looping arraylist
        for (String test : ArrayList) {
            MatcherAssert.assertThat("Produk tidak ditemukan",test,Matchers.containsString(title_product));
        }


//        for (String test : disProduct) {
//            MatcherAssert.assertThat("Produk tidak ditemukan",test,Matchers.containsString(title_product));
//        }
        // List<Product> products = Arrays.asList();
        //         List<String> discover = products.stream()
        //         .map(Product::getName)
        //                 .collect(Collectors.toList());

            // for (String test : discover) {
            //         MatcherAssert.assertThat("Produk tidak ditemukan",test,Matchers.containsString(title_product));
            //     }
    







//         List<String> Result = Arrays.asList("txt_product_name");
//
//         List<String> textList = findAll(RESULT).stream()
//         .map(test -> test)
//                 .collect(Collectors.toList());



        

        // .map(test ->).collect(Collectors.toCollection(ArrayList::new));
                
                // .collect(Collectors.toCollection(ArrayList::new)); // Assuming findAll() returns a List<Result>

                // .collect(Collectors.toCollection(ArrayList::new));
        
//              .collect(Collectors.toCollection(ArrayList::new));

       
    //collect to arraylist

    // ArrayList<String> list = new ArrayList<>();

        
//    ArrayList<String> list = new ArrayList<>();
    //looping arraylist

        // for (String test : list) {
        //     MatcherAssert.assertThat("Fail Gan",test,Matchers.containsString(title_product));
        // }
 
    }

               

//map element to get text
//                 .map(RemoteWebElement::getText)
// //collect all text to arraylist
//                 .collect(Collectors.toCollection(ArrayList::new))) {
//             MatcherAssert.assertThat("Error Gan",test, Matchers.containsString(title_product));
//         }


        // for (String element : ArrayList) {
        //     MatcherAssert.assertThat("messge",element,Matchers.containsString(title_product));
        // }
//         findAll.stream(RESULT)
//         .map(element -> element.getText())
//         for(String test : element){
//          MatcherAssert.assertThat("messge",test,Matchers.containsString(""));
 
//     }
 }

//collect = findAll(RESULT).stream()
//    //mapping element to get text
//                .map(element -> element.getText())
//
//    //collect all text to arraylist
//                .collect(Collectors.toCollection(ArrayList::new));
//
//    //looping arraylist
//    for (String element : arrayList) {
//        MatcherAssert.assertThat("messge",element,Matchers.containsString(title_product));
//    }
//    }
//
//    }

               

//map element to get text
//                 .map(RemoteWebElement::getText)
// //collect all text to arraylist
//                 .collect(Collectors.toCollection(ArrayList::new))) {
//             MatcherAssert.assertThat("Error Gan",test, Matchers.containsString(title_product));
//         }


        // for (String element : ArrayList) {
        //     MatcherAssert.assertThat("messge",element,Matchers.containsString(title_product));
        // }
//         findAll.stream(RESULT)
//         .map(element -> element.getText())
//         for(String test : element){
//          MatcherAssert.assertThat("messge",test,Matchers.containsString(""));
 
//     }


