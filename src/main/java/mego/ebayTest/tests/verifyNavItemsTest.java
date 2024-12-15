package mego.ebayTest.tests;

import mego.aSpare.homePage;
import mego.ebayTest.pages.welcomePage;
import mego.sellenium.seleniumBase;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class verifyNavItemsTest {

    @Test
    public void testFlyoutNavItems() throws InterruptedException {
        seleniumBase base = new seleniumBase();
        WebDriver driver = base.seleniumInit("https://www.ebay.com");

        welcomePage welcomePage = new welcomePage(driver);
        welcomePage.verifyFlyoutNavItems();

        sleep (3000);


        base.seleniumClose((ChromeDriver) driver);
    }
}
