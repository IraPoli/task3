package Task3tests;

import org.testng.annotations.Test;


import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class NavigateTest extends BaseTest {
    private final String GIROBORD_TAB = "girobordyi-i-giroskuteryi";
    private final String TITEL_WORD = "Купить гироборд, моноколесо в Киеве и Харькове";
    private final String LOW_RANGE_VALUE = "20000";

    @Test(priority = 1)
    public void checkThatPageNavigateToGirobordyTab() {
        getHomePage().clickGirobordyButton();
        assertEquals(getDriver().getTitle(), TITEL_WORD);
        assertTrue(getDriver().getCurrentUrl().contains(GIROBORD_TAB));
    }

    @Test(priority = 2)
    public void checkElementsAmountFormedByFilter() {
        getHomePage().clickGirobordyButton();
        getGidrobordyPage().inputLowRange(LOW_RANGE_VALUE);
        getGidrobordyPage().implicitWait(30);
        getGidrobordyPage().clickSetLowRange();
        assertEquals(getGidrobordyRangePage().getRangeResultsCount(), 4);
    }
}
