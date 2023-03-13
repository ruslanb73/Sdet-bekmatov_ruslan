
import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import pages.*;

import static org.assertj.core.api.SoftAssertions.assertSoftly;

/**
 * Основной класс с тестами SauceDemo
 */
public class SauceDemoTest extends BaseTest {

    @Test
    public void VerificationOfASuccessfulPurchaseTest() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);
        BasketPage basketPage = new BasketPage(driver);
        CheckoutInformationPage checkoutPage = new CheckoutInformationPage(driver);
        CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage(driver);

        Allure.step("Предусловие: 3. Заполнить поле Username значением standard_user", () -> {
            loginPage.loginUserName("standard_user");
        });

        Allure.step("Предусловие: 4. Заполнить поле Password значением secret_sauce", () -> {
            loginPage.loginPassword("secret_sauce");
        });

        Allure.step("Предусловие: 5. Нажать на кнопку LOGIN", loginPage::loginButton);

        Allure.step("Шаг 1: Положить первый продукт в списке на странице PRODUCTS в корзину кнопкой ADD TO CART", productsPage::addToCart);

        Allure.step("Шаг 2: Нажать на иконку корзины", productsPage::basket);

        Allure.step("Шаг 3: На открывшейся странице корзины нажать кнопку CHECKOUT", basketPage::checkout);

        Allure.step("Шаг 4:  На открывшейся странице CHECKOUT: YOUR INFORMATION заполнить поля First Name, Last\n" +
                "Name, Zip Code значением test", () -> {
            checkoutPage.checkout("test", "test", "test");
        });

        Allure.step("Шаг 5: Нажать на кнопку CONTINUE", checkoutPage::setContinueButton);

        Allure.step("Шаг 6: На открывшейся странице CHECKOUT: OVERVIEW нажать кнопку FINISH", checkoutOverviewPage::finishButton);

        //Сообщение на странице Checkout Complete
        String message = driver.findElement(By.xpath("//*[@id=\"checkout_complete_container\"]/h2")).getText();

        //Url страницы завершения покупки
        String url = driver.getCurrentUrl();
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(message)
                            .withFailMessage("На странице не отображается сообщение: THANK YOU FOR YOUR ORDER ")
                            .isEqualTo("Thank you for your order!");
                    softAssertions
                            .assertThat(url)
                            .withFailMessage("Не произошел редирект на страницу завершения покупки ")
                            .isEqualTo("https://www.saucedemo.com/checkout-complete.html");
                }
        );
    }

    @Test
    public void CheckingTheErrorMessageWhenTryingToEnterALoginForANonExistentUserTest() {
        LoginPage loginPage = new LoginPage(driver);

        Allure.step("Шаг 1: Заполнить поле Username значением test", () -> {
            loginPage.loginUserName("test");
        });

        Allure.step("Шаг 2: Заполнить поле Password значением test", () -> {
            loginPage.loginPassword("test");
        });

        Allure.step("Шаг 3: Нажать на кнопку LOGIN", loginPage::loginButton);

        String message = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText();
        assertSoftly(
                softAssertions -> {
                    softAssertions
                            .assertThat(message)
                            .withFailMessage("Ошибка при вводе данных ")
                            .isEqualTo("Epic sadface: Username and password do not match any user in this service");
                }
        );
    }
}