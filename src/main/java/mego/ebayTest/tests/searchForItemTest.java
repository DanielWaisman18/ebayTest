package mego.ebayTest.tests;
import mego.ebayTest.pages.welcomePage;
import mego.googleSearch.tests.seleniumbase;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;
public class searchForItemTest {

    //search for item and then check if it appears in the results page

    public void main(String[] args) throws InterruptedException {
        String itemToFind = "laptop";
        seleniumbase base = new seleniumbase();
        ChromeDriver driver = base.seleniumInit("https://www.ebay.com");

        welcomePage welcomePageObject = new welcomePage((ChromeDriver) driver);
        welcomePageObject.searchForItem(itemToFind);


        sleep(3000);

        base.seleniumClose(driver);
    }
}
