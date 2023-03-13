package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс в котором происходит взаимодействие со страницей CHECKOUT: YOUR INFORMATION
 */
public class CheckoutInformationPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Конструктор создания CheckoutPage
     *
     * @param driver драйвер для управления браузером
     */
    public CheckoutInformationPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Элемент поля "First Name" на странице CHECKOUT: YOUR INFORMATION
     */
    @FindBy(id = "first-name")
    private WebElement firstName;

    /**
     * Элемент поля "Last Name" на странице CHECKOUT: YOUR INFORMATION
     */
    @FindBy(id = "last-name")
    private WebElement lastName;

    /**
     * Элемент поля "Zip Code" на странице CHECKOUT: YOUR INFORMATION
     */
    @FindBy(id = "postal-code")
    private WebElement postalСode;

    /**
     * Элемент кнопки "CONTINUE" на странице PRODUCTS
     */
    @FindBy(xpath = "//*[@id=\"continue\"]")
    private WebElement continueButton;

    /**
     * Метод ввода данных информации о пользователе
     */
    public void checkout(String firstName, String lastName, String postalСode ) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalСode.sendKeys(postalСode);
    }
    /**
     * Метод нажатия на кнопку CONTINUE
     */
    public void setContinueButton() {
        continueButton.click();
    }

}
