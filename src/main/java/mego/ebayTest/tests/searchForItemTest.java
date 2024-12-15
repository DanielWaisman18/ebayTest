package mego.ebayTest.tests;
import mego.ebayTest.pages.welcomePage;
import mego.googleSearch.tests.seleniumbase;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class searchForItemTest {


    public void main(String[] args) throws InterruptedException {
        seleniumbase base = new seleniumbase();
        ChromeDriver driver = base.seleniumInit("https://www.ebay.com");

        welcomePage welcomePageObject = new welcomePage((ChromeDriver) driver);
        welcomePageObject.searchForItem("puppy");
        //search for item and then check if it appears in h1  of results page


        sleep(3000);

        base.seleniumClose(driver);
    }
}
