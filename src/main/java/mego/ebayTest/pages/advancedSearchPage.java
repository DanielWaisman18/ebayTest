package mego.ebayTest.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class advancedSearchPage {

    @FindBy(id = "gh-as-a")
    private WebElement advancedButton;

    @FindBy(className = "textbox__control")
    private WebElement searchBoxAdvanced;

    @FindBy(id = "s0-1-17-4[0]-7[1]-_in_kw")
    private WebElement dropDownCategory;

    @FindBy(id = "s0-1-17-5[1]-[1]-LH_Complete")
    private WebElement completedBox;

    @FindBy(xpath = "//button[contains(text(),'Search')]")
    private WebElement buttonAdvancedSearch;

    @FindBy(className = "srp-controls__count-heading")
    private WebElement resultSearchText;



    private ChromeDriver driver;

    public advancedSearchPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void advancedSearch(String itemToFind){
        advancedButton.click();
        searchBoxAdvanced.click();
        searchBoxAdvanced.sendKeys(itemToFind);
        dropDownCategory.click();
        Select categories = new Select(dropDownCategory);
        categories.selectByIndex(2);
        completedBox.click();
        buttonAdvancedSearch.click();

        String resultsText = resultSearchText.getText().toLowerCase();
        boolean isPass = resultsText.contains(itemToFind.toLowerCase());
        Assert.assertTrue(itemToFind + " is not found in the advanced search results", isPass);

    }

}











