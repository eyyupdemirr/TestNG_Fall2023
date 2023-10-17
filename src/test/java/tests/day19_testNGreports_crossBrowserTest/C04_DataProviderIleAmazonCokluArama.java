package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

// String[] aranacakUrunler = {"Nutella", "Java", "elma", "Aykut", "Erik", "Malatya"};

public class C04_DataProviderIleAmazonCokluArama{


    @DataProvider
    public static Object[][] urunListesi() {

        String[][] aranacakUrunler = {{"Nutella"}, {"Java"}, {"elma"}, {"Aykut"}, {"Erik"}, {"Malatya"}};

        return aranacakUrunler;
    }

    @Test(dataProvider = "urunListesi")
    public void amazonCokluArama(String urun) {


        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        // verilen listedeki her bir urun icin arama yaptirin
        // her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin


        String sonucYazisi;
        int sonucSayisi;
        String[] sonucYazisininPArcalari;
        String sonucSayisiStr;

        AmazonPage amazonPage=new AmazonPage();


            amazonPage.aramaKutusu.sendKeys(urun + Keys.ENTER);

            sonucYazisi= amazonPage.sonucYaziElementi.getText();
            sonucYazisininPArcalari=sonucYazisi.split(" ");

            if (sonucYazisininPArcalari[2].equals("over")){
                sonucSayisiStr=sonucYazisininPArcalari[3];

            }else {
                sonucSayisiStr=sonucYazisininPArcalari[2];
            }
            sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");

            sonucSayisi=Integer.parseInt(sonucSayisiStr);

            Assert.assertTrue(sonucSayisi>1000);

            Driver.closeDriver();





    }



}
