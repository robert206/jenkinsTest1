package CucumberTests;

import PageObjects.CheckBoxesPage;
import com.codeborne.selenide.Condition;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static com.codeborne.selenide.Condition.selected;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CheckboxesTest {

    CheckBoxesPage chkPage = new CheckBoxesPage();
    String url = "http://the-internet.herokuapp.com/";

    @Given("The checkboxes page")
    public void navigate_to_checkboxes_page () {
        open(url);
        chkPage.checkBoxesLink.click();
        Assert.assertTrue("Not on checkboxes page",url().matches("http://the-internet.herokuapp.com/checkboxes"));
    }

    @When("I click checkbox1")
    public void click_checkbox1 () {
        chkPage.checkBoxesList.get(0).click();
    }

    @Then("it should be selected")
    public void it_should_be_selected () {
        chkPage.checkBoxesList.get(0).shouldBe(selected);
    }

    @When("I click checkbox2")
    public void checkbox2_select () {
        chkPage.checkBoxesList.get(1).click();
    }

    @Then("Checkbox2 should be de-selected")
    public void checkbox2_is_selected () {
        chkPage.checkBoxesList.get(1).shouldNotBe(selected);
    }

}
