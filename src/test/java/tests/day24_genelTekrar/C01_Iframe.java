package tests.day24_genelTekrar;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_Iframe {

    @Test
    public void iFrametesti() {
        /*
        1.“http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        2.“Our Products” butonuna basin
        3.“Cameras product”i tiklayin
        4.Popup mesajini yazdirin
        5.“close” butonuna basin
        6.“WebdriverUniversity.com (IFrame)” linkini tiklayin
        7.“http://webdriveruniversity.com/index.html” adresine gittigini test edin

         */


        Driver.getDriver().get(ConfigReader.getProperty("webUniUrl"));

        WebUniPage webUniPage = new WebUniPage();


        Driver.getDriver().switchTo().frame(webUniPage.IframeElementi);
        ReusableMethods.bekle(3);

        webUniPage.ourProductslinki.click();
        ReusableMethods.bekle(3);

        webUniPage.camerasElementi.click();

        System.out.println(webUniPage.alertYaziElementi.getText());


        webUniPage.closeButtonu.click();


        Driver.getDriver().switchTo().defaultContent();

        webUniPage.webDriverLinki.click();


        String expectedUrl = "http://webdriveruniversity.com/index.html";
        String actualUrl = Driver.getDriver().getCurrentUrl();


        Assert.assertEquals(actualUrl, expectedUrl);

        ReusableMethods.bekle(2);
        Driver.closeDriver();


    }


}
