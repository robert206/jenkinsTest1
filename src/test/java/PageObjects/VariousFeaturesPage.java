package PageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

public class VariousFeaturesPage {

    /** Broken images elements **/
    public SelenideElement brokenImageLink = $(byLinkText("Broken Images"));
    public ElementsCollection imageList = $$(byXpath("//*/div/img"));

    /** Context box **/
    public SelenideElement contextBox = $(byId("hot-spot"));
    public SelenideElement contextPageLink = $(byLinkText("Context Menu"));

    /** Dropdowns **/
    public SelenideElement dropdDownLink = $(byLinkText("Dropdown"));
    public ElementsCollection dropdownList = $$(byXpath("//*[@id='dropdown']/option"));



    public boolean checkImageResponse (SelenideElement image) {
        HttpResponse response = null;
        try {
            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet(image.getAttribute("src"));
            response = client.execute(request);
        } catch(Exception e) {
            e.printStackTrace();
        }
        assertTrue("Http response for images is null",response!=null);
        return response.getStatusLine().getStatusCode() == 200;
    }



}
