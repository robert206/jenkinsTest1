package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.SelenideWait;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ForensixxLoginPage {

    public SelenideElement usernameField = $(byXpath("//*[@id='loginUsername']"));
    public SelenideElement passwordField = $(byId("loginPassword"));
    public SelenideElement loginBtn = $(byId("login-btn"));
    public SelenideElement assetMgmtlink = $(byId("AssetManagement"));

    public SelenideElement userBtn = $(byId("user-menu"));
    // all elements when clicking username
    public ElementsCollection userMenuList = $$(byXpath("*//a[@class='dropdown-item']"));


}
