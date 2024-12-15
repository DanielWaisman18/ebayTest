package mego.ebayTest.tests;

import mego.ebayTest.pages.welcomePage;
import mego.googleSearch.tests.seleniumbase;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;


public class getFirstPriceTest {
    @Test
    public void testGetFirstPrice() {
        String itemToFind = "laptop";
        String expectedPrice = "ILS 226.93";
        seleniumbase base = new seleniumbase();
        ChromeDriver driver = base.seleniumInit("https://www.ebay.com");

        welcomePage welcomePage = new welcomePage((ChromeDriver) driver);
        welcomePage.getFirstPrice(itemToFind, expectedPrice);

        base.seleniumClose(driver);

    }

//    public void main(String[] args) throws InterruptedException {
//        seleniumbase base = new seleniumbase();
//        ChromeDriver driver = base.seleniumInit("https://www.ebay.com");
//
//        welcomePage welcomePageObject = new welcomePage((ChromeDriver) driver);
//        welcomePageObject.getFirstPrice("jeans","ILS 220");

}