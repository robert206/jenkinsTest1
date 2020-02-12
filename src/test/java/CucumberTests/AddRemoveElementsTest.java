package CucumberTests;

import PageObjects.AddRemovePage;
import Utils.ConfigurationTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.source;
import static org.junit.Assert.*;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selectors.*;

public class AddRemoveElementsTest {


    //String environment = "Test02";
    String environment = "Forensixx";

    String url = "http://the-internet.herokuapp.com/";
    AddRemovePage addRemovePage = new AddRemovePage();
    //ConfigurationTest cfg = new ConfigurationTest();



    /** For Cucumber After and Before hooks ,if defined in any Step definition class ,they are automatically executed in ALL Step defs classes **/
   @Before
    public void setup (Scenario scenario) throws ParserConfigurationException, SAXException, IOException {
       ConfigurationTest cfg = new ConfigurationTest();
       cfg = cfg.readConfigFile(environment);
       Configuration.browser = cfg.getBrowser();
       Configuration.browserSize = cfg.getBrowserRes();
       Configuration.startMaximized = cfg.getMaximized();
       Configuration.baseUrl = cfg.getUrl();
       System.out.println("------------------------------");
       System.out.println("Starting - " + scenario.getName());
       System.out.println("------------------------------");
    }


    @Given("Add Remove elements page")
    public void navigate_to_add_remove_elements_page () {
        open(url);
        addRemovePage.addRemoveLink.click();
        assertTrue("Not on correct page",source().contains("Add Element"));
    }

    @When("I click on Add element btn")
    public void click_add_n_times () {
        for (int i=1;i <= 10;i++) {
            addRemovePage.addRemoveBtn.click();
        }
    }

    @Then("Element should be added and Delete btn should be seen")
    public void element_should_be_added_delete_visible () {
        addRemovePage.deleteBtns.shouldHaveSize(10);
        for (SelenideElement delBtn : addRemovePage.deleteBtns) {
            delBtn.shouldBe(visible);
        }
    }

    @When("I click Delete btn 10 times")
    public void click_all_delete_btns () {
        addRemovePage.clickDeleteBtns();
    }

    @Then("Btns should be removed")
    public void check_all_Delbtns_removed () {
        $(byText("Delete")).shouldNotBe(visible);
    }
}

