package tests.heroku;

import base.BaseTest;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AddRemoveTest extends BaseTest {
    @Test
    public void addRemoveElementsTest(){
        open("https://the-internet.herokuapp.com/add_remove_elements/");
        $("button[onclick='addElement()']").shouldBe(visible).click();
        SelenideElement deleteButton = $("button[onclick='deleteElement()']");
        deleteButton.shouldBe(visible).click();
        deleteButton.shouldNot(exist);
    }
}
