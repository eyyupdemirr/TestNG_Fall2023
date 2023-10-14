package tests.day19_testNGreports_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_AmazonCokluArama {
    @Test
    public void amazonCokluArama() {


        // amazon anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));


        // verilen listedeki her bir urun icin arama yaptirin
        // her urun icin bulunan sonuc sayisinin 1000'den fazla oldugunu test edin
        String[] aranacakUrunler = {"Nutella", "Java", "elma", "Aykut", "Erik", "Malatya"};

        String sonucYazisi;
        int sonucSayisi;
        String[] sonucYazisininPArcalari;
        String sonucSayisiStr;

        AmazonPage amazonPage=new AmazonPage();
        for (int i = 0; i <aranacakUrunler.length ; i++) {
            amazonPage.aramaKutusu.clear();
            amazonPage.aramaKutusu.sendKeys(aranacakUrunler[i]+ Keys.ENTER);
           sonucYazisi= amazonPage.sonucYaziElementi.getText();
           sonucYazisininPArcalari=sonucYazisi.split(" ");

           if (sonucYazisininPArcalari[2].equals("over")){
               sonucSayisiStr=sonucYazisininPArcalari[3];

           }else {
               sonucSayisiStr=sonucYazisininPArcalari[2];
           }
           sonucSayisiStr=sonucSayisiStr.replaceAll("\\D","");

           sonucSayisi=Integer.parseInt(sonucSayisiStr);

            Assert.assertTrue(sonucSayisi>100);

        }



    }

}
