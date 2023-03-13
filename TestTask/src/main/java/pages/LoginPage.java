package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.ashot.Screenshot;

/**
 * Класс в котором происходит взаимодействие со страницей авторизации SauceDemo
 */
public class LoginPage {

    /**
    * Экземпляр драйвера для управления браузером
    */
    private final WebDriver driver;

    /**
     * Конструктор создания LoginPage
     *
     * @param driver драйвер для управления браузером
     */
    public LoginPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Элемент поля "Password" на главной странице
     */
    @FindBy(id = "password")
    private WebElement pass;

    /**
     * Элемент поля "Username" на главной странице
     */
    @FindBy(id = "user-name")
    private WebElement name;

    /**
     * Элемент кнопки "LOGIN" на главной странице
     */
    @FindBy(id = "login-button")
    private WebElement button;

    /**
     * Метод ввода в поле UserName
     */
    public void loginUserName(String userName) {
        name.sendKeys(userName);
    }
    /**
     * * Метод ввода в поле Password
     */
    public void loginPassword(String password) {
        pass.sendKeys(password);
    }
    /**
     * * Метод нажатия кнопки
     */
    public void loginButton() {
        button.click();


    }
}

