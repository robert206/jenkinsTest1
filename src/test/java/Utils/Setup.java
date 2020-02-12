package Utils;

import com.codeborne.selenide.Configuration;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Setup {

    @Before
    public void setup (Scenario scenario) {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.startMaximized = true;
        System.out.println("------------------------------");
        System.out.println("Starting - " + scenario.getName());
        System.out.println("------------------------------");
    }


}
