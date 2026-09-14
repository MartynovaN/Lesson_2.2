package lesson2_10;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MtsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js;

// ============================================================
// PAYMENT BLOCK
// ============================================================

    private final By paymentBlockTitle =
            By.cssSelector("section.pay h2");

    private final By paymentSelect =
            By.id("pay");

// ============================================================
// PAYMENT FORMS
// ============================================================

    private final By connectionForm =
            By.id("pay-connection");

    private final By internetForm =
            By.id("pay-internet");

    private final By installmentForm =
            By.id("pay-instalment");

    private final By debtForm =
            By.id("pay-arrears");

// ============================================================
// CONNECTION
// ============================================================

    private final By connectionPhoneInput =
            By.id("connection-phone");

    private final By connectionAmountInput =
            By.id("connection-sum");

    private final By connectionContinueButton =
            By.cssSelector(
                    "#pay-connection button[type='submit']"
            );

// ============================================================
// INTERNET
// ============================================================

    private final By internetSubscriberInput =
            By.cssSelector(
                    "#pay-internet input[placeholder='Номер абонента']"
            );

    private final By internetAmountInput =
            By.cssSelector(
                    "#pay-internet input[placeholder='Сумма']"
            );

    private final By internetEmailInput =
            By.cssSelector(
                    "#pay-internet input[placeholder='E-mail для отправки чека']"
            );

// ============================================================
// INSTALLMENT
// ============================================================

    private final By installmentAccountInput =
            By.cssSelector(
                    "#pay-instalment input[placeholder='Номер счета на 44']"
            );

    private final By installmentAmountInput =
            By.cssSelector(
                    "#pay-instalment input[placeholder='Сумма']"
            );

    private final By installmentEmailInput =
            By.cssSelector(
                    "#pay-instalment input[placeholder='E-mail для отправки чека']"
            );

// ============================================================
// DEBT
// ============================================================

    private final By debtAccountInput =
            By.cssSelector(
                    "#pay-arrears input[placeholder='Номер счета на 2073']"
            );

    private final By debtAmountInput =
            By.cssSelector(
                    "#pay-arrears input[placeholder='Сумма']"
            );

    private final By debtEmailInput =
            By.cssSelector(
                    "#pay-arrears input[placeholder='E-mail для отправки чека']"
            );

// ============================================================
// BEPAID IFRAME
// ============================================================

    private final By bepaidFrame =
            By.xpath(
                    "//iframe[contains(@src, 'widget_v2')]"
            );

// ============================================================
// BEPAID AMOUNT
// ============================================================

    private final By bepaidAmount =
            By.xpath(
                    "//*[normalize-space()='10.00 BYN']"
            );

// ============================================================
// BEPAID PHONE
// ============================================================

    private final By bepaidPhone =
            By.xpath(
                    "//*[contains(normalize-space(), '375297777777')]"
            );

// ============================================================
// BEPAID CARD NUMBER
// ============================================================

    private final By cardNumberInput =
            By.id("cc-number");

    private final By cardNumberLabel =
            By.cssSelector(
                    "#cc-number + label"
            );

// ============================================================
// BEPAID CARD EXPIRY
// ============================================================

    private final By cardExpiryInput =
            By.cssSelector(
                    "input[autocomplete='cc-exp']"
            );

    private final By cardExpiryLabel =
            By.cssSelector(
                    "input[autocomplete='cc-exp'] + label"
            );

// ============================================================
// BEPAID CVC
// ============================================================

    private final By cardCvcInput =
            By.cssSelector(
                    "input[autocomplete='cc-csc']"
            );

    private final By cardCvcLabel =
            By.cssSelector(
                    "input[autocomplete='cc-csc'] + label"
            );

// ============================================================
// BEPAID CARD HOLDER
// ============================================================

    /*
     * Актуальная разметка BePaid:
     *
     * <input formcontrolname="holder"
     *        autocomplete="cc-name">
     * <label>Имя и фамилия на карте</label>
     *
     * Поэтому используем непосредственного соседа:
     * input + label
     */

    private final By cardHolderInput =
            By.cssSelector(
                    "input[formcontrolname='holder']"
            );

    private final By cardHolderLabel =
            By.cssSelector(
                    "input[formcontrolname='holder'] + label"
            );

// ============================================================
// BEPAID PAYMENT BUTTON
// ============================================================

    private final By bepaidPayButton =
            By.xpath(
                    "//button[contains(normalize-space(), 'Оплатить 10.00 BYN')]"
            );

// ============================================================
// APPLE PAY
// ============================================================

    private final By applePayButton =
            By.id("apple-pay-button");

// ============================================================
// GOOGLE PAY
// ============================================================

    private final By googlePayButton =
            By.id("gpay-button-online-api-id");

// ============================================================
// VISA
// ============================================================

    private final By visaIcon =
            By.cssSelector(
                    "img[src*='visa-system.svg']"
            );

// ============================================================
// MASTERCARD
// ============================================================

    private final By mastercardIcon =
            By.cssSelector(
                    "img[src*='mastercard-system.svg']"
            );

// ============================================================
// CONSTRUCTOR
// ============================================================

    public MtsPage(WebDriver driver) {

        this.driver = driver;

        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20)
        );

        this.js = (JavascriptExecutor) driver;
    }

// ============================================================
// PAYMENT BLOCK TITLE
// ============================================================

    public String getPaymentBlockTitle() {

        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        paymentBlockTitle
                )
        );

        return title.getText()
                .replace("\n", " ")
                .replaceAll("\\s+", " ")
                .trim()
                .toUpperCase();
    }

// ============================================================
// SELECT PAYMENT TYPE
// ============================================================

    public void selectPaymentType(String paymentType) {

        WebElement select = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        paymentSelect
                )
        );

        js.executeScript(
                """
                const select = arguments[0];
                const value = arguments[1];
    
                const option = Array.from(select.options)
                    .find(option => option.text.trim() === value);
    
                if (!option) {
                    throw new Error(
                        'Payment type not found: ' + value
                    );
                }
    
                select.value = option.value;
    
                select.dispatchEvent(
                    new Event('change', { bubbles: true })
                );
                """,
                select,
                paymentType
        );

        wait.until(
                driver -> {

                    WebElement currentSelect =
                            driver.findElement(paymentSelect);

                    return currentSelect
                            .findElement(
                                    By.cssSelector("option:checked")
                            )
                            .getText()
                            .trim()
                            .equals(paymentType);
                }
        );
    }

// ============================================================
// PAYMENT FORMS
// ============================================================

    public boolean isMobilePaymentDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        connectionForm
                )
        ).isDisplayed();
    }

    public boolean isInternetPaymentDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        internetForm
                )
        ).isDisplayed();
    }

    public boolean isInstallmentPaymentDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        installmentForm
                )
        ).isDisplayed();
    }

    public boolean isDebtPaymentDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        debtForm
                )
        ).isDisplayed();
    }

// ============================================================
// CONNECTION PHONE
// ============================================================

    public String getConnectionPhonePlaceholder() {

        selectPaymentType("Услуги связи");

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        connectionPhoneInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "Номер телефона"
        );
    }

// ============================================================
// INTERNET
// ============================================================

    public String getInternetSubscriberPlaceholder() {

        selectPaymentType("Домашний интернет");

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        internetSubscriberInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "Номер абонента"
        );
    }

    public String getInternetAmountPlaceholder() {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        internetAmountInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "Сумма"
        );
    }

    public String getInternetEmailPlaceholder() {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        internetEmailInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "E-mail для отправки чека"
        );
    }

// ============================================================
// INSTALLMENT
// ============================================================

    public String getInstallmentAccountPlaceholder() {

        selectPaymentType("Рассрочка");

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        installmentAccountInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "Номер счета на 44"
        );
    }

    public String getInstallmentAmountPlaceholder() {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        installmentAmountInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "Сумма"
        );
    }

    public String getInstallmentEmailPlaceholder() {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        installmentEmailInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "E-mail для отправки чека"
        );
    }

// ============================================================
// DEBT
// ============================================================

    public String getDebtAccountPlaceholder() {

        selectPaymentType("Задолженность");

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        debtAccountInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "Номер счета на 2073"
        );
    }

    public String getDebtAmountPlaceholder() {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        debtAmountInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "Сумма"
        );
    }

    public String getDebtEmailPlaceholder() {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        debtEmailInput
                )
        );

        return getRequiredPlaceholder(
                input,
                "E-mail для отправки чека"
        );
    }

// ============================================================
// PLACEHOLDER HELPER
// ============================================================

    private String getRequiredPlaceholder(
            WebElement input,
            String expected
    ) {

        String placeholder =
                input.getAttribute("placeholder");

        Assertions.assertNotNull(
                placeholder,
                "Placeholder отсутствует. Ожидался: "
                        + expected
        );

        Assertions.assertFalse(
                placeholder.isBlank(),
                "Placeholder пустой. Ожидался: "
                        + expected
        );

        Assertions.assertEquals(
                expected,
                placeholder.trim(),
                "Некорректный placeholder."
        );

        return placeholder.trim();
    }

// ============================================================
// ENTER PHONE
// ============================================================

    public void enterPhone(String phone) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        connectionPhoneInput
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                input
        );

        input.clear();
        input.sendKeys(phone);
    }

// ============================================================
// ENTER AMOUNT
// ============================================================

    public void enterAmount(String amount) {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        connectionAmountInput
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                input
        );

        input.clear();
        input.sendKeys(amount);
    }

// ============================================================
// CLICK CONTINUE
// ============================================================

    public void clickContinue() {

        WebElement button = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        connectionContinueButton
                )
        );

        js.executeScript(
                "arguments[0].scrollIntoView({block:'center'});",
                button
        );

        try {

            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            connectionContinueButton
                    )
            );

            button.click();

        } catch (Exception e) {

            js.executeScript(
                    "arguments[0].click();",
                    button
            );
        }
    }

// ============================================================
// WAIT FOR BEPAID
// ============================================================

    public void waitForBePaidFrame() {

        try {

            wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            bepaidFrame
                    )
            );

        } catch (Exception e) {

            System.out.println();
            System.out.println("========== DIAGNOSTICS ==========");

            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page title: " + driver.getTitle());

            System.out.println("========== IFRAMES ==========");

            for (WebElement iframe : driver.findElements(By.tagName("iframe"))) {

                System.out.println(
                        "iframe src = "
                                + iframe.getAttribute("src")
                );

                System.out.println(
                        "iframe id = "
                                + iframe.getAttribute("id")
                );

                System.out.println(
                        "iframe class = "
                                + iframe.getAttribute("class")
                );
            }

            System.out.println("========== PAGE SOURCE PART ==========");

            String source = driver.getPageSource();

            if (source.contains("bepaid")) {
                System.out.println("BePaid найден в Page Source");
            } else {
                System.out.println("BePaid НЕ найден в Page Source");
            }

            if (source.contains("widget_v2")) {
                System.out.println("widget_v2 найден в Page Source");
            } else {
                System.out.println("widget_v2 НЕ найден в Page Source");
            }

            System.out.println("====================================");

            throw e;
        }
    }

// ============================================================
// SWITCH TO BEPAID
// ============================================================

    public void switchToBePaidFrame() {

        wait.until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                        bepaidFrame
                )
        );
    }

// ============================================================
// BEPAID AMOUNT
// ============================================================

    public String getBePaidAmountText() {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bepaidAmount
                )
        );

        return element.getText().trim();
    }

    public boolean isBePaidAmountDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bepaidAmount
                )
        ).isDisplayed();
    }

// ============================================================
// BEPAID PHONE
// ============================================================

    public String getBePaidPhoneText() {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bepaidPhone
                )
        );

        return element.getText().trim();
    }

    public boolean isBePaidPhoneDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bepaidPhone
                )
        ).isDisplayed();
    }

// ============================================================
// CARD NUMBER FIELD
// ============================================================

    public boolean isCardNumberFieldDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardNumberInput
                )
        ).isDisplayed();
    }

// ============================================================
// CARD NUMBER LABEL
// ============================================================

    public String getCardNumberLabel() {

        WebElement label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardNumberLabel
                )
        );

        return label.getText().trim();
    }

    public String getCardNumberPlaceholder() {

        return getCardNumberLabel();
    }

// ============================================================
// CARD EXPIRY FIELD
// ============================================================

    public boolean isCardExpiryFieldDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardExpiryInput
                )
        ).isDisplayed();
    }

// ============================================================
// CARD EXPIRY LABEL
// ============================================================

    public String getCardExpiryLabel() {

        WebElement label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardExpiryLabel
                )
        );

        return label.getText().trim();
    }

// ============================================================
// CARD EXPIRY PLACEHOLDER
// ============================================================

    public String getCardExpiryPlaceholder() {

        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardExpiryInput
                )
        );

        String placeholder =
                input.getAttribute("placeholder");

        Assertions.assertEquals(
                "ММ / ГГ",
                placeholder,
                "Некорректный placeholder срока действия."
        );

        return placeholder;
    }

// ============================================================
// CARD CVC FIELD
// ============================================================

    public boolean isCardCvcFieldDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardCvcInput
                )
        ).isDisplayed();
    }

// ============================================================
// CARD CVC LABEL
// ============================================================

    public String getCardCvcLabel() {

        WebElement label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardCvcLabel
                )
        );

        return label.getText().trim();
    }

    public String getCardCvcPlaceholder() {

        return getCardCvcLabel();
    }

// ============================================================
// CARD HOLDER FIELD
// ============================================================

    public boolean isCardHolderFieldDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardHolderInput
                )
        ).isDisplayed();
    }

// ============================================================
// CARD HOLDER LABEL
// ============================================================

    public String getCardHolderLabel() {

        WebElement label = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        cardHolderLabel
                )
        );

        return label.getText().trim();
    }

    public String getCardHolderPlaceholder() {

        return getCardHolderLabel();
    }

// ============================================================
// BEPAID PAYMENT BUTTON
// ============================================================

    public String getBePaidPayButtonText() {

        WebElement button = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bepaidPayButton
                )
        );

        return button.getText().trim();
    }

    public boolean isBePaidPayButtonDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        bepaidPayButton
                )
        ).isDisplayed();
    }

// ============================================================
// APPLE PAY
// ============================================================

    public boolean isApplePayDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        applePayButton
                )
        ).isDisplayed();
    }

// ============================================================
// GOOGLE PAY
// ============================================================

    public boolean isGooglePayDisplayed() {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        googlePayButton
                )
        ).isDisplayed();
    }

// ============================================================
// VISA
// ============================================================

    public boolean isVisaDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            visaIcon
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

// ============================================================
// MASTERCARD
// ============================================================

    public boolean isMastercardDisplayed() {

        try {

            return wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            mastercardIcon
                    )
            ).isDisplayed();

        } catch (Exception e) {

            return false;
        }
    }

// ============================================================
// RETURN TO MAIN DOCUMENT
// ============================================================

    public void switchToMainDocument() {

        driver.switchTo().defaultContent();
    }

// ============================================================
// CLOSE
// ============================================================

    public void close() {

        if (driver != null) {
            driver.quit();
        }
    }

}
