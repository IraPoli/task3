package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GirobordyInRangePage extends BasePage {

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> rangeResultsProductsList;

    public GirobordyInRangePage(WebDriver driver) {
        super(driver);
    }

    public int getRangeResultsCount() {
        return getResultsList().size();
    }

    public List<WebElement> getResultsList() {
        return rangeResultsProductsList;
    }
}
