import config.BaseConfig;
import io.qameta.allure.Allure;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.time.Duration;

/**
 * Общий класс с настройками для всех тестов
 */
abstract public class BaseTest {

    /**
     * Переменная с экземпляром драйвера
     */
    protected WebDriver driver;

    /**
     * Экземпляр конфигурации с общими параметрами
     */
    private final BaseConfig config = ConfigFactory.create(BaseConfig.class, System.getenv());

    protected BaseTest() {
    }

    /**
     * Общие настройки для всех тестов, перед выполнением каждого
     */
    @BeforeEach
    public void setUp() {

        Allure.step("Предусловие: 1. Открыть браузер", () ->{
        // создание экземпляра драйвера
            driver = new FirefoxDriver();
        });

        Allure.step("Предусловие: 2. Перейти на страницу входа: https://www.saucedemo.com/", () ->{
            driver.get(config.url());
        // Разворот страницы на полное окно
            driver.manage().window().maximize();
        //Ожидание по умолчанию 10 секунд
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        });
    }

    /**
     * Общие настройки для всех тестов, после выполнения каждого
     */
    @AfterEach
    public void tearDown() {
        // Остановка работы драйвера
        driver.close();
    }
}
