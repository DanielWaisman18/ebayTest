package mego.ebayTest.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class resultsHeadingPage {

//    @FindBy(xpath = "//a[@href='https://www.ebay.com/b/Auto-Parts-Accessories/6028/bn_569479' and text()='Motors']")
//    private WebElement motorsButton;

    @FindBy(linkText = "Motors")
    private WebElement motorsButton2;

    @FindBy(xpath = "//a[@class='seo-breadcrumb-text' and contains(., 'eBay Motors')]")
    private WebElement motorsLinkInHeading;

    @FindBy(partialLinkText = "Motors")
    private WebElement motorsInBreadcrumb;


    private WebDriver driver;

    public resultsHeadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    public void checkIfIsHeading(){
        motorsButton2.click();

//        String headingText = motorsLinkInHeading.getText().toLowerCase();
        String headingText = motorsInBreadcrumb.getText().toLowerCase();

        boolean isPass = headingText.contains("motors");
        Assert.assertTrue( "'Motors' is not found in the search results", isPass);

        // Verificar si contiene la palabra "motors"
//        if (headingText.contains("motors")) {
//            System.out.println("Verification Passed: 'motors' is found in the heading text.");
//        } else {
//            System.out.println("Verification Failed: 'motors' is NOT found in the heading text.");
//            throw new AssertionError("'motors' is not found in the heading text: " + headingText);
//        }

    }

}
