package mego.ebayTest.tests;

import mego.ebayTest.pages.companyPage;
import mego.ebayTest.pages.welcomePage;
import mego.sellenium.seleniumBase;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyCompanyUrlTest {
    public static void main(String[] args) {
        seleniumBase base = new seleniumBase();
        ChromeDriver driver = base.seleniumInit("https://www.ebay.com/");

        companyPage companyPage = new companyPage(driver);
        companyPage.companyUrl();//

        base.seleniumClose(driver);
    }
}
