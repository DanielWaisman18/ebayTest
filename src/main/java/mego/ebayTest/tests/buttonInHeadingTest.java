package mego.ebayTest.tests;

import mego.ebayTest.pages.resultsHeadingPage;
import mego.googleSearch.tests.seleniumbase;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class buttonInHeadingTest {
    public static void main(String[] args) throws InterruptedException {
        seleniumbase base = new seleniumbase();
        ChromeDriver driver = base.seleniumInit("https://www.ebay.com");

        resultsHeadingPage motorsInHeadingPage = new resultsHeadingPage(driver);
        motorsInHeadingPage.checkIfIsHeading();// I check if the button with the link of motors takes you to the motors page

        sleep(3000);

        base.seleniumClose(driver);


    }
}
