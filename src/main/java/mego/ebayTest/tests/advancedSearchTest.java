package mego.ebayTest.tests;

import mego.ebayTest.pages.advancedSearchPage;
import mego.sellenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class advancedSearchTest {

        public static void main(String[] args) throws InterruptedException {
            seleniumBase base = new seleniumBase();
            ChromeDriver driver = base.seleniumInit("https://www.ebay.com/");

            advancedSearchPage advancedPage = new advancedSearchPage(driver);
            advancedPage.advancedSearch("laptop");// here enter your word to advanced search
            // with dropdown and filling checkbox - then check if appears in results page


            sleep (3000);


            base.seleniumClose(driver);
        }
    }



