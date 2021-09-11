package Task3tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.GidrobordyPage;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertEquals;

public class BasketTest extends BaseTest{
    private final String SCOOTER_NAME = "Электросамокат Ninebot by Segway MAX G30LE (AA.00.0003.81)";
    private final String ZERO_ELEMENTS = "0";



    @Test(priority = 3)
    public void checkElementsAddToBasket() {
        getHomePage().clickGirobordyButton();
        getGidrobordyPage().clickBuyButton();
        getGidrobordyPage().waitVisibilityOfElement(30);
        String text = getGidrobordyPage().getOrderedProductName();
        assertEquals(text, SCOOTER_NAME);
    }

    @Test(priority = 4)
    public void checkDeleteFromBasket() {
        getHomePage().clickGirobordyButton();
        getGidrobordyPage().clickBuyButton();
        getGidrobordyPage().waitVisibilityOfElement(30);
       getGidrobordyPage().clickDeleteFromBasketButton();
       getGidrobordyPage().clickOnContinueShoppingButton();


        getHomePage().waitEmptyBasket();


        String actualProductsCountInCart = getHomePage().getOrderAmount();
        assertEquals(ZERO_ELEMENTS, actualProductsCountInCart);
    }


}
