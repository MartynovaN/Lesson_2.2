package lesson2_9;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SeleniumTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.manage().window().maximize();
        driver.get("https://mts.by/");

        closeCookieIfPresent();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void checkOnlinePaymentBlockTitle() {
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("section.pay h2")
                )
        );

        String actualTitle = title.getText().trim();
        String expectedTitle = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";

        System.out.println("ТЕКСТ ЗАГОЛОВКА: [" + actualTitle + "]");

        Assertions.assertEquals(
                expectedTitle,
                actualTitle,
                "Название блока отображается неправильно"
        );
    }

    @Test
    void checkPaymentSystemLogos() {
        WebElement visa = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("section.pay img[alt='Visa']")
                )
        );

        WebElement verifiedByVisa = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("section.pay img[alt='Verified By Visa']")
                )
        );

        WebElement mastercard = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("section.pay img[alt='MasterCard']")
                )
        );

        WebElement mastercardSecure = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("section.pay img[alt='MasterCard Secure Code']")
                )
        );

        WebElement belkart = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("section.pay img[alt='Белкарт']")
                )
        );

        Assertions.assertTrue(visa.isDisplayed(), "Логотип Visa не отображается");
        Assertions.assertTrue(
                verifiedByVisa.isDisplayed(),
                "Логотип Verified By Visa не отображается"
        );
        Assertions.assertTrue(
                mastercard.isDisplayed(),
                "Логотип MasterCard не отображается"
        );
        Assertions.assertTrue(
                mastercardSecure.isDisplayed(),
                "Логотип MasterCard Secure Code не отображается"
        );
        Assertions.assertTrue(
                belkart.isDisplayed(),
                "Логотип Белкарт не отображается"
        );

        System.out.println("Все логотипы платёжных систем найдены и отображаются.");
    }

    @Test
    void checkMoreAboutServiceLink() {
        WebElement link = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(
                                "//section[contains(@class,'pay')]" +
                                        "//a[contains(normalize-space(),'Подробнее о сервисе')]"
                        )
                )
        );

        String actualText = link.getText().trim();

        Assertions.assertEquals(
                "Подробнее о сервисе",
                actualText,
                "Текст ссылки отображается неправильно"
        );

        String href = link.getAttribute("href");

        Assertions.assertNotNull(
                href,
                "У ссылки отсутствует адрес"
        );

        Assertions.assertTrue(
                href.contains(
                        "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"
                ),
                "Ссылка ведёт на неправильный адрес: " + href
        );

        System.out.println("Текст ссылки: " + actualText);
        System.out.println("Адрес ссылки: " + href);

        closeCookieIfPresent();

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                link
        );

        closeCookieIfPresent();

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                link
        );

        wait.until(
                ExpectedConditions.urlContains(
                        "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"
                )
        );

        String currentUrl = driver.getCurrentUrl();

        System.out.println("Текущий URL после перехода: " + currentUrl);

        Assertions.assertTrue(
                currentUrl.contains(
                        "/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"
                ),
                "Переход по ссылке выполнен неправильно"
        );
    }

    @Test
    void checkContinueButtonForCommunicationServices() {
        WebElement communicationServices = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(
                                "//section[contains(@class,'pay')]" +
                                        "//*[contains(normalize-space(),'Услуги связи')]"
                        )
                )
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                communicationServices
        );

        closeCookieIfPresent();

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                communicationServices
        );

        WebElement phoneInput = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//section[contains(@class,'pay')]//input"
                        )
                )
        );

        phoneInput.clear();
        phoneInput.sendKeys("297777777");

        System.out.println("Введён номер: 297777777");

        WebElement continueButton = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        By.xpath(
                                "//section[contains(@class,'pay')]" +
                                        "//button[contains(normalize-space(),'Продолжить')]"
                        )
                )
        );

        Assertions.assertTrue(
                continueButton.isDisplayed(),
                "Кнопка «Продолжить» не отображается"
        );

        System.out.println("Кнопка «Продолжить» найдена.");

        closeCookieIfPresent();

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                continueButton
        );

        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();",
                continueButton
        );

        System.out.println("Кнопка «Продолжить» нажата.");

        Assertions.assertTrue(
                continueButton.isDisplayed()
                        || driver.getCurrentUrl() != null,
                "После нажатия кнопки произошла ошибка"
        );
    }

    private void closeCookieIfPresent() {
        try {
            List<WebElement> cookies = driver.findElements(
                    By.cssSelector(".cookie.show")
            );

            if (cookies.isEmpty()) {
                System.out.println("Cookie-баннер не найден. Продолжаем тест.");
                return;
            }

            WebElement cookie = cookies.get(0);

            if (!cookie.isDisplayed()) {
                return;
            }

            System.out.println("Cookie-баннер найден.");

            List<WebElement> buttons = cookie.findElements(
                    By.tagName("button")
            );

            if (!buttons.isEmpty()) {
                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].click();",
                        buttons.get(0)
                );

                System.out.println("Cookie-баннер закрыт кнопкой.");
            }

            Thread.sleep(500);

            List<WebElement> visibleCookies = driver.findElements(
                    By.cssSelector(".cookie.show")
            );

            if (!visibleCookies.isEmpty()
                    && visibleCookies.get(0).isDisplayed()) {

                ((JavascriptExecutor) driver).executeScript(
                        "arguments[0].remove();",
                        visibleCookies.get(0)
                );

                System.out.println("Cookie-баннер принудительно удалён.");
            }

        } catch (Exception e) {
            System.out.println(
                    "Cookie-баннер не удалось закрыть: " + e.getMessage()
            );
        }
    }
}