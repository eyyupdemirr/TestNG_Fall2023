package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {


@Test
    public void nutellaTesti(){
    extentTest=extentReports.createTest("Raporda gorunecek isim Nutella","Burayada aciklama yaziyoruz kullanici amazonda nutella aratiyor");


    // amazon anasayfaya gidelim
    Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
    extentTest.info("Kullanici amazon anasayfaya gider");

    // url'in amazon icerdigini test edelim
    String expectedIcerik="amazon";
    String actualUrlIcerik=Driver.getDriver().getCurrentUrl();

    Assert.assertTrue(actualUrlIcerik.contains(expectedIcerik));
extentTest.pass("url inamazon icerdigini test eder");

    // aranacak kelimeyi aratalim
    AmazonPage amazonPage=new AmazonPage();
    amazonPage.aramaKutusu.sendKeys(ConfigReader.getProperty("amazonAranacakKelime")+ Keys.ENTER);
    extentTest.info("Test  datasi olarak belirlenen kelimeyi arartir.");

    // sonuclarin aranacak kelimeyi icerdigini test edelim
    // Assert.assertTrue(amazonPage.sonucYaziElementi.getText().contains(ConfigReader.getProperty("amazonAranacakKelime")));

    String expectedSonucIcerik = ConfigReader.getProperty("amazonAranacakKelime");
    String actualSonucYazisi = amazonPage.sonucYaziElementi.getText();

    Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    extentTest.pass("amazon arama sonuclarinin aranan kelimeyi icerdigini test eder");

    // ilk urune tiklayalim
    amazonPage.ilkUrunElementi.click();
extentTest.info("ilk urune tiklar");


    // ilk urun isminde aranacak kelime bulundugunu test edelim
    String expextedUrunIcerik=ConfigReader.getProperty("amazonAranacakKelime");
    String actualIlkUrunIcerik=amazonPage.ilkUrunIsimElementi.getText();

    Assert.assertTrue(actualIlkUrunIcerik.contains(expextedUrunIcerik));
    extentTest.pass("ilkurun isminde aranan kelimenin bulundugunu test eder");

    // sayfayi kapatalim
    Driver.closeDriver();
    extentTest.info("sayfayi kapatir");
}



}
