package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс в котором происходит взаимодействие со страницей Basket
 */
public class BasketPage {
    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Конструктор создания BasketPage
     *
     * @param driver драйвер для управления браузером
     */
    public BasketPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Элемент кнопки "CHECKOUT" в корзине
     */
    @FindBy(css = "#checkout")
    private WebElement checkout;

    /**
     * Метод нажатия на кнопку CHECKOUT
     */
    public void checkout() {
        checkout.click();
    }
}
