package Task3tests;


import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class BasketTest extends BaseTest {
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
