package CucumberTests;

import PageObjects.VariousFeaturesPage;
import Utils.ConfigurationTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.Assert.assertTrue;

public class VariousFeaturesTest {

    ConfigurationTest cfg = new ConfigurationTest();
    String url = "http://the-internet.herokuapp.com/";
    VariousFeaturesPage vrPage = new VariousFeaturesPage();



    @Given("subpage for broken images and list of all images on page")
    public void navigate_to_image_page () {
        open(Configuration.baseUrl);
        vrPage.brokenImageLink.click();
        assertTrue("Not on correct page",url().contains("broken_images"));
    }

    @Then("we check all images for Http response code")
    public void check_for_dead_images () {
        for (SelenideElement img : vrPage.imageList) {
            if (vrPage.checkImageResponse(img)) {
                System.out.println("Image valid: " + img);
            }
        }
    }

    /** context box **/
    @Given("the subpage for context click")
    public void navigate_to_subpage_for_context_click () {
        open(url);
        vrPage.contextPageLink.click();
        assertTrue("Not on context menu page",url().contains("context_menu"));
    }

    @When("clicking inside context box")
    public void clicking_inside_box () {
        vrPage.contextBox.contextClick();
    }

    @Then("alert window is displayed")
    public void check_for_alert_wnd () {
        String alertText = switchTo().alert().getText();
        assertTrue("Alert window not displayed or incorrect text",alertText.matches("You selected a context menu"));
        switchTo().alert().accept();
    }


    /** Dropdowns evaluation **/
    @Given("the subpage with dropdown menu")
    public void go_to_dropdown_page () {
        open(url);
        vrPage.dropdDownLink.click();
        assertTrue("Not on correct page.",source().contains("Dropdown List"));
    }

    @When("we select Option1")
    public void select_option1 () {
        SelenideElement option1 = vrPage.dropdownList.get(0).getSelectedOption();
    }

}
