package tests.day16_testNG_framework;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.Driver;

public class C02_PageClassKullanimi {

    @Test
    public void nutellaTesti() {

        // amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");

        // Nutella icin arama yapalim

        AmazonPage amazonePage=new AmazonPage();
        amazonePage.aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // arama sonuclarinin Nutella icerdigini test edelim
        String expectedIcerik="Nutella";
        String actualIcerik=amazonePage.sonucYaziElementi.getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));

        Driver.closeDriver();



    }
}