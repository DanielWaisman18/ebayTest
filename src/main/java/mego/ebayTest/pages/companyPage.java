package mego.ebayTest.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static java.lang.Thread.sleep;
import java.time.Duration;
import java.util.Set;

public class companyPage {

    @FindBy(linkText = "Company info")
    private WebElement companyInfoLink;

    @FindBy(linkText = "Contact Us")
    private WebElement contactUsLink;

    @FindBy(css = "a[href='https://twitter.com/askebay']")
    private WebElement twitterLink;


    private WebDriver driver;

    public companyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public void companyUrl() {

        companyInfoLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://www.ebayinc.com/company/"));

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        boolean isPass = currentUrl.equals("https://www.ebayinc.com/company/");
        Assert.assertTrue("Expected URL not found", isPass);

        driver.quit();
    }


    public void verifyTwitterContact() throws InterruptedException {
        companyInfoLink.click();
        sleep (3000);

        contactUsLink.click();
        sleep(3000);

        String mainWindowHandle = driver.getWindowHandle();

        twitterLink.click();
        sleep(3000);

        // Wait for the new window to open and switch to it
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        // Assert that the current URL matches the expected Twitter URL
        String currentUrl = driver.getCurrentUrl();
        String expectedUrl = "https://x.com/askebay";
        Assert.assertEquals("Twitter contact URL does not match", expectedUrl, currentUrl);

        System.out.println("Twitter contact link verified successfully: " + currentUrl);

        // Close the Twitter window and switch back to the main window
      driver.close();
      driver.switchTo().window(mainWindowHandle);

        // Close the main window as well
        driver.close();
    }

}
