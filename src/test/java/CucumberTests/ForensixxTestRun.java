package CucumberTests;

import PageObjects.ForensixxLoginPage;
import Utils.ConfigurationTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class ForensixxTestRun {

    ConfigurationTest cfg;
    String env = "Forensixx";
    ForensixxLoginPage fpage = new ForensixxLoginPage();

    @Given("the forensixx login page")
    public void go_to_login_page () throws ParserConfigurationException, SAXException, IOException {
        cfg = new ConfigurationTest();
        cfg = cfg.readConfigFile(env);
        Configuration.timeout = 30000;//super slow this one
        open(Configuration.baseUrl);
        fpage.loginBtn.waitUntil(visible,50000);
    }

    @When("I enter login credentials and press Login")
    public void enter_credentials() {
        fpage.usernameField.click();
        fpage.usernameField.val(cfg.username);
        fpage.passwordField.val(cfg.password);
        fpage.loginBtn.click();
    }

    @Then("I should be logged in")
    public void check_if_logged_in () {
        fpage.assetMgmtlink.waitUntil(visible,50000);
        fpage.assetMgmtlink.shouldBe(visible);
    }

    @When("I click logout")
    public void i_click_logout () {
        fpage.userBtn.click();
        SelenideElement logoutBtn = fpage.userMenuList.get(1);
        logoutBtn.click();
    }
}
