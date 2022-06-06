package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.*;

public class CartPage extends BasePage {

    public CartPage(ChromeDriver driver) {
        super(driver);
    }


    //Page elements

    @FindBy(xpath = "//h2[@class = 'pageheader']")
    WebElement pageHeader;

    @FindBy(xpath = "//a[@class = 'remove_link']")
    WebElement removeButton;

    @FindBy(xpath = "//span[normalize-space() = 'Continue Shopping']")
    WebElement continueShoppingButton;

    @FindBy(xpath = "//a[normalize-space() = 'CS:GO Prime Status Upgrade']")
    WebElement specificGameUpgrade;

    @FindBy(xpath = "//div[@class = 'cart_status_message']")
    WebElement cartStatusMessage;

    @FindBy(xpath = "//a[normalize-space() = 'Valve Complete Pack']")
    WebElement valveCompletePack;

    @FindBy(xpath = "//a[normalize-space() = 'CS:GO Prime Status Upgrade']")
    WebElement cSGoPrimeStatusUpgrade;

    @FindBy(xpath = "//a[normalize-space() = 'Remove all items']")
    WebElement removeAllItemsButton;

    @FindBy(xpath = "//span[normalize-space() = 'Yes']")
    WebElement confirmationButton;

    //Methods

    public String pageHeaderText() {
        return pageHeader.getText();
    }

    public String cartStatusMessageRemovedItem() {
        return cartStatusMessage.getText();
    }

    public boolean specificGameUpgradeIsPresent() {
        print("Specific game upgrade is present");
        waitForElementVisibility(specificGameUpgrade);
        return elementPresent(specificGameUpgrade);
    }

    public void removeGameFromCart() {
        print("Removing from cart");
        waitForElementToBeClickable(removeButton);
        removeButton.click();
    }

    public void clickOnRemoveAllItemsButton() {
        print("Removing all items from cart");
        removeAllItemsButton.click();
    }


    public ArrayList<WebElement> getNumberOfGamesInTheCart() {
        ArrayList<WebElement> numberOfGames = new ArrayList<>();
        numberOfGames.add(cSGoPrimeStatusUpgrade);
        numberOfGames.add(valveCompletePack);
        return numberOfGames;
    }

    public void clickOnConfirmationButton() {
        print("Confirming by clicking on 'Yes' button");
        waitForElementToBeClickable(confirmationButton);
        if (confirmationButton.isDisplayed()) {
            confirmationButton.click();
        }
    }

}