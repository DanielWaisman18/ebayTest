package mego.ebayTest.tests;
import mego.ebayTest.pages.advancedSearchPage;
import mego.sellenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;
import static java.lang.Thread.sleep;

//search item in the advanced page with dropdown and filling checkbox - then check if it appears in the results page

public class advancedSearchTest {

        public static void main(String[] args) throws InterruptedException {
            String itemToFind = "laptop";
            seleniumBase base = new seleniumBase();
            ChromeDriver driver = base.seleniumInit("https://www.ebay.com/");

            advancedSearchPage advancedPage = new advancedSearchPage(driver);
            advancedPage.advancedSearch(itemToFind);


            sleep (3000);


            base.seleniumClose(driver);
        }
    }



