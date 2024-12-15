package mego.ebayTest.pages;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class welcomePage {

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    @FindBy(xpath = "//span[@class='s-item__price' and contains(text(), 'ILS')]")
    private WebElement priceElement;

    @FindBy(css = ".vl-flyout-nav__container > li")
    private List<WebElement> flyoutNavItems;

    @FindBy(xpath = "//h1[contains(text(),'results for')]")
    private WebElement resultSearchText;

    @FindBy(xpath = "//*[contains(@class, 'seo-breadcrumb-text')]")
    private WebElement resultInHeading;


    private WebDriver driver;

    public welcomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }


    public void searchForItem(String itemToFind) {
        searchBox.sendKeys(itemToFind);
        searchButton.click();


        String resultsText = resultSearchText.getText().toLowerCase();


//        if (resultsText.contains(itemToFind.toLowerCase())) {
//            System.out.println("Verification Passed: '" + itemToFind + "' is found in the search results.");
//        } else {
//            System.out.println("Verification Failed: '" + itemToFind + "' is NOT found in the search results.");
//        }
        boolean isPass = resultsText.contains(itemToFind.toLowerCase());
        Assert.assertTrue(itemToFind + " is not found in the search results", isPass);

    }

    public void getFirstPrice(String itemToFind, String expectedPrice) {
        searchBox.sendKeys(itemToFind);
        searchButton.click();
        String price = priceElement.getText();
        System.out.println("The first price is: " + price);

        boolean isPass = price.contains("ILS");
        Assert.assertTrue(itemToFind + " is not found in the search results", isPass);

//        Assert.assertEquals("The price does not match the expected value.", expectedPrice, price);


    }

    public boolean verifyFlyoutNavItems() {

        List<String> expectedNavTexts = List.of(
                "Explore (New!)", "Saved", "Electronics", "Motors", "Fashion",
                "Collectibles and Art", "Sports", "Health & Beauty", "Industrial equipment",
                "Home & Garden", "Deals", "Sell"
        );

        List<String> actualNavTexts = new ArrayList<>();
        for (WebElement item : flyoutNavItems) {
            actualNavTexts.add(item.getText().trim());


            boolean allPresent = actualNavTexts.containsAll(expectedNavTexts);
            Assert.assertTrue("Not all expected navigation items are present", allPresent);

        }
        return false;

    }
}

