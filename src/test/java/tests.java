import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class tests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Ivan");
        $("#lastName").setValue("Ivanov");
        $("#userEmail").setValue("ivanov@mail.com");
        $(".custom-radio").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $("[aria-label='Choose Saturday, March 9th, 2024']").click();
        $("#subjectsInput").setValue("a");
        $("#react-select-2-option-0").click();
        $(".custom-checkbox").click();
        $("#uploadPicture").uploadFromClasspath("example.jpg");
        $("#currentAddress").setValue("qwerty qwerty");
        $("#state").click();
        $("#react-select-3-option-0").click();
        $("#city").click();
        $("#react-select-4-option-0").click();
        $("#submit").scrollIntoView(false).click();


        $(".modal-body tr:nth-child(1) td:nth-child(2)").shouldHave(text("Ivan Ivanov"));
        $(".modal-body tr:nth-child(2) td:nth-child(2)").shouldHave(text("ivanov@mail.com"));
        $(".modal-body tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $(".modal-body tr:nth-child(4) td:nth-child(2)").shouldHave(text("1234567890"));
        $(".modal-body tr:nth-child(5) td:nth-child(2)").shouldHave(text("09 March,2024"));
        $(".modal-body tr:nth-child(6) td:nth-child(2)").shouldHave(text("Maths"));
        $(".modal-body tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports"));
        $(".modal-body tr:nth-child(8) td:nth-child(2)").shouldHave(text("example.jpg"));
        $(".modal-body tr:nth-child(9) td:nth-child(2)").shouldHave(text("qwerty qwerty"));
        $(".modal-body tr:nth-child(10) td:nth-child(2)").shouldHave(text("NCR Delhi"));
    }
}