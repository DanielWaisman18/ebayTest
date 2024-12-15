package mego.ebayTest.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class resultsHeadingPage {


    @FindBy(linkText = "Motors")
    private WebElement motorsButton;

    @FindBy(partialLinkText = "Motors")
    private WebElement motorsInBreadcrumb;


    private WebDriver driver;

    public resultsHeadingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize @FindBy elements
    }

    public void checkIfIsHeading(){
        motorsButton.click();

        String headingText = motorsInBreadcrumb.getText().toLowerCase();

        boolean isPass = headingText.contains("motors");
        Assert.assertTrue( "'Motors' is not found in the search results", isPass);

    }

}
