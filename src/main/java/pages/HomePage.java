package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    @FindBy(xpath = "//a[contains(@href,'https://avic.ua/girobordy') and contains(@class,'sidebar')]")
    private WebElement girobordyButton;

    @FindBy(xpath = "//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")
    private WebElement amountOfProductsInCart;

    @FindBy(xpath = "//span[@class='sidebar-item']")
    private WebElement productCatalogButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void waitEmptyBasket() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until((ExpectedCondition<Boolean>) driver -> {
            String actualProductsCountInCart = getOrderAmount();
            if (actualProductsCountInCart.equals("0"))
                return true;
            else
                return false;

        });

    }

    public void clickGirobordyButton() {

        girobordyButton.click();
    }

    public String getOrderAmount() {
        return amountOfProductsInCart.getText();
    }

}
