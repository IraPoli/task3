package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GidrobordyPage extends BasePage{
    //div[contains(@class,'item')]//i[contains(@class,' js-btn-close')]
    //div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]
    @FindBy(xpath = "//a[contains(@data-ecomm-cart,'243123')]")
    private WebElement buyButton;


    @FindBy(xpath = "//div[@class='btns-cart-holder']//a[contains(@class,'btn--orange')]")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//input[contains(@class, 'form-control-min') ]")
    private WebElement lowRangeInput;


    //div[contains(@class,'open')]//span[contains(@class,'filter')]
    @FindBy(xpath = "//div[contains(@class,'open')]//span[contains(@class,'filter')]")
    private WebElement showFilterButton;

    @FindBy(id = "js_cart")
    private WebElement addToCartPopup;

    @FindBy(xpath =  "//span[contains(@class,'name')]")
    private WebElement orderedProduct;

    @FindBy(xpath =  "//div[contains(@class,'item')]//i[contains(@class,' js-btn-close')]")
    private WebElement deleteFromBasketButton;



    public GidrobordyPage(WebDriver driver) {
        super(driver);
    }

    public void clickBuyButton(){
     //   driver.findElement(By.xpath(BUY_BUTTON)).click();
        buyButton.click();
    }

    public void clickOnContinueShoppingButton() {
        continueShoppingButton.click();
    }

    public void inputLowRange(String lowRange){
        lowRangeInput.sendKeys(lowRange);
    }

    public void clickShowFilterButton(){
        showFilterButton.click();
    }

    public void clickSetLowRange(){
      //  inputLowRange(lowRange);
      //  getHomePage().implicitWait(30);
        clickShowFilterButton();

    }

    public WebElement getAddToCartPopup() {
        return addToCartPopup;
    }

    public String getOrderedProductName(){
        return orderedProduct.getText();
    }

    public void clickDeleteFromBasketButton(){
        deleteFromBasketButton.click();
    }


    public void waitVisibilityOfElement(long timeToWait){
     this.waitVisibilityOfElement(timeToWait,addToCartPopup);
    }
    //public void wait()




}
