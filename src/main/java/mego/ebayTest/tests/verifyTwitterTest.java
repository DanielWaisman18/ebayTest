package mego.ebayTest.tests;

import mego.ebayTest.pages.companyPage;
import mego.sellenium.seleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class verifyTwitterTest {
    public static void main(String[] args) throws InterruptedException {


        seleniumBase base = new seleniumBase();
        WebDriver driver = base.seleniumInit("https://www.ebay.com");

        companyPage companyPage = new companyPage(driver);
        companyPage.verifyTwitterContact();

        base.seleniumClose((ChromeDriver) driver);

    }



    }
