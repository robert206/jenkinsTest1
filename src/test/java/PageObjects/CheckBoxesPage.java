package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CheckBoxesPage {
    public SelenideElement checkBoxesLink = $(byLinkText("Checkboxes"));
    public ElementsCollection checkBoxesList = $$(byXpath("//*[@id='checkboxes']/input"));

}
