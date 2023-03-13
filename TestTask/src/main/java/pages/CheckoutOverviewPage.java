package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс в котором происходит взаимодействие со страницей CHECKOUT: OVERVIEW
 */
public class CheckoutOverviewPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Конструктор создания CheckoutPage
     *
     * @param driver драйвер для управления браузером
     */
    public CheckoutOverviewPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Элемент кнопки "FINISH" на странице CHECKOUT: OVERVIEW
     */
    @FindBy(id = "finish")
    private WebElement finishButton;

    /**
     * Метод нажатия на кнопку FINISH  на странице CHECKOUT: OVERVIEW
     */
    public void finishButton() {
        finishButton.click();
    }

}
