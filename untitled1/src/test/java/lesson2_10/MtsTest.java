package lesson2_10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MtsTest {

    private WebDriver driver;
    private MtsPage mtsPage;

// ============================================================
// SET UP
// ============================================================

    @BeforeEach
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.get("https://www.mts.by/");

        mtsPage = new MtsPage(driver);
    }

// ============================================================
// TEAR DOWN
// ============================================================

    @AfterEach
    public void tearDown() {

        if (mtsPage != null) {
            mtsPage.close();
        }
    }

// ============================================================
// PAYMENT BLOCK TITLE
// ============================================================

    @Test
    public void checkPaymentBlockTitle() {

        assertEquals(
                "ОНЛАЙН ПОПОЛНЕНИЕ БЕЗ КОМИССИИ",
                mtsPage.getPaymentBlockTitle()
        );
    }

// ============================================================
// CONNECTION PHONE PLACEHOLDER
// ============================================================

    @Test
    public void checkConnectionPhonePlaceholder() {

        assertEquals(
                "Номер телефона",
                mtsPage.getConnectionPhonePlaceholder()
        );
    }

// ============================================================
// INTERNET PLACEHOLDERS
// ============================================================

    @Test
    public void checkInternetPlaceholders() {

        assertEquals(
                "Номер абонента",
                mtsPage.getInternetSubscriberPlaceholder()
        );

        assertEquals(
                "Сумма",
                mtsPage.getInternetAmountPlaceholder()
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getInternetEmailPlaceholder()
        );
    }

// ============================================================
// INSTALLMENT PLACEHOLDERS
// ============================================================

    @Test
    public void checkInstalmentPlaceholders() {

        assertEquals(
                "Номер счета на 44",
                mtsPage.getInstallmentAccountPlaceholder()
        );

        assertEquals(
                "Сумма",
                mtsPage.getInstallmentAmountPlaceholder()
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getInstallmentEmailPlaceholder()
        );
    }

// ============================================================
// DEBT PLACEHOLDERS
// ============================================================

    @Test
    public void checkArrearsPlaceholders() {

        assertEquals(
                "Номер счета на 2073",
                mtsPage.getDebtAccountPlaceholder()
        );

        assertEquals(
                "Сумма",
                mtsPage.getDebtAmountPlaceholder()
        );

        assertEquals(
                "E-mail для отправки чека",
                mtsPage.getDebtEmailPlaceholder()
        );
    }

// ============================================================
// CONNECTION PAYMENT FORM + BEPAID
// ============================================================

    @Test
    public void checkConnectionPaymentForm() {

        // --------------------------------------------------------
        // Выбираем "Услуги связи"
        // --------------------------------------------------------

        mtsPage.selectPaymentType("Услуги связи");

        // --------------------------------------------------------
        // Вводим номер телефона
        // --------------------------------------------------------

        /*
         * На форме MTS вводится номер без +375.
         * В BePaid ожидаем полный номер:
         * 375297777777
         */

        mtsPage.enterPhone("297777777");

        // --------------------------------------------------------
        // Вводим сумму
        // --------------------------------------------------------

        mtsPage.enterAmount("10");

        // --------------------------------------------------------
        // Нажимаем "Продолжить"
        // --------------------------------------------------------

        mtsPage.clickContinue();

        // --------------------------------------------------------
        // Ждём появления BePaid
        // --------------------------------------------------------

        mtsPage.waitForBePaidFrame();

        // --------------------------------------------------------
        // Переходим в iframe BePaid
        // --------------------------------------------------------

        mtsPage.switchToBePaidFrame();

        // ========================================================
        // СУММА
        // ========================================================

        assertEquals(
                "10.00 BYN",
                mtsPage.getBePaidAmountText()
        );

        // ========================================================
        // НОМЕР ТЕЛЕФОНА
        // ========================================================

        assertTrue(
                mtsPage.getBePaidPhoneText()
                        .contains("375297777777"),
                "Номер телефона в BePaid отображается некорректно"
        );

        // ========================================================
        // НОМЕР КАРТЫ
        // ========================================================

        assertTrue(
                mtsPage.isCardNumberFieldDisplayed(),
                "Поле номера карты не отображается"
        );

        assertEquals(
                "Номер карты",
                mtsPage.getCardNumberLabel()
        );

        // ========================================================
        // СРОК ДЕЙСТВИЯ
        // ========================================================

        assertTrue(
                mtsPage.isCardExpiryFieldDisplayed(),
                "Поле срока действия карты не отображается"
        );

        assertEquals(
                "ММ / ГГ",
                mtsPage.getCardExpiryPlaceholder()
        );

        assertEquals(
                "Срок действия",
                mtsPage.getCardExpiryLabel()
        );

        // ========================================================
        // CVC
        // ========================================================

        assertTrue(
                mtsPage.isCardCvcFieldDisplayed(),
                "Поле CVC не отображается"
        );

        assertEquals(
                "CVC",
                mtsPage.getCardCvcLabel()
        );

        // ========================================================
        // ИМЯ И ФАМИЛИЯ ДЕРЖАТЕЛЯ КАРТЫ
        // ========================================================

        assertTrue(
                mtsPage.isCardHolderFieldDisplayed(),
                "Поле имени держателя карты не отображается"
        );

        assertEquals(
                "Имя и фамилия на карте",
                mtsPage.getCardHolderLabel()
        );

        // ========================================================
        // APPLE PAY
        // ========================================================

        assertTrue(
                mtsPage.isApplePayDisplayed(),
                "Apple Pay не отображается"
        );

        // ========================================================
        // GOOGLE PAY
        // ========================================================

        assertTrue(
                mtsPage.isGooglePayDisplayed(),
                "Google Pay не отображается"
        );

        // ========================================================
        // VISA
        // ========================================================

        assertTrue(
                mtsPage.isVisaDisplayed(),
                "Иконка Visa не отображается"
        );

        // ========================================================
        // MASTERCARD
        // ========================================================

        assertTrue(
                mtsPage.isMastercardDisplayed(),
                "Иконка MasterCard не отображается"
        );

        // ========================================================
        // КНОПКА ОПЛАТЫ
        // ========================================================

        assertEquals(
                "Оплатить 10.00 BYN",
                mtsPage.getBePaidPayButtonText()
        );
    }

}
