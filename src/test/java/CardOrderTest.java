import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class CardOrderTest {

    @BeforeAll
    static void setUp() {
        Configuration.headless = true; // включение headless-режима
        Configuration.baseUrl = "http://localhost:9999";
    }

    @Test
    void shouldSubmitFormSuccessfully() {
        open("/");
        $("[data-test-id='name'] input").setValue("Иван Иванов");
        $("[data-test-id='phone'] input").setValue("+71234567890");
        $("[data-test-id='agreement']").click();
        $("[type='button']").click();
        $("[data-test-id='order-success']").shouldHave(text("Ваша заявка успешно отправлена!"));
    }
}
