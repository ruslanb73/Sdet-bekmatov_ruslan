package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Класс в котором происходит взаимодействие со страницей PRODUCTS
 */
public class ProductsPage {

    /**
     * Экземпляр драйвера для управления браузером
     */
    private final WebDriver driver;

    /**
     * Конструктор создания ProductPage
     *
     * @param driver драйвер для управления браузером
     */
    public ProductsPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Элемент кнопки "ADD TO CART" на странице PRODUCTS
     */
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCart;

    /**
     * Элемент кнопки "Корзина" на странице PRODUCTS
     */
    @FindBy(xpath = "//*[@id=\"shopping_cart_container\"]/a")
    private WebElement basket;

    /**
     * Метод добавления первого товара в корзину
     */
    public void addToCart() {
        addToCart.click();
    }

    /**
     * Метод перехода в корзину
     */
    public void basket() {
        basket.click();
    }

}
