package mego.ebayTest.tests;

import mego.ebayTest.pages.welcomePage;
import mego.googleSearch.tests.seleniumbase;
import org.openqa.selenium.chrome.ChromeDriver;


public class getFirstPriceTest {
    public void testGetFirstPrice() {
        String itemToFind = "laptop";
        String expectedPrice = "ILS 337.34";
        seleniumbase base = new seleniumbase();
        ChromeDriver driver = base.seleniumInit("https://www.ebay.com");

        welcomePage welcomePage = new welcomePage((ChromeDriver) driver);
        welcomePage.getFirstPrice(itemToFind, expectedPrice);

        base.seleniumClose(driver);

    }
}