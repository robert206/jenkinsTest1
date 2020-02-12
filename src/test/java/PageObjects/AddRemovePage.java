package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddRemovePage {

    public SelenideElement addRemoveLink = $(byLinkText("Add/Remove Elements")) ;
    public SelenideElement addRemoveBtn = $(byXpath("//button[@onclick='addElement()']"));
    public ElementsCollection deleteBtns = $$(byXpath("//div[@id='elements']/button"));

    public void clickDeleteBtns () {
        for (SelenideElement btn : deleteBtns) {
            btn.click();
        }
    }

}
