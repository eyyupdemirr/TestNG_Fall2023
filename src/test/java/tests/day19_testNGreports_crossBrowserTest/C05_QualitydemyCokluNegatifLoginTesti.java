package tests.day19_testNGreports_crossBrowserTest;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.Arrays;

public class C05_QualitydemyCokluNegatifLoginTesti {


    @DataProvider
    public static Object[][] Gecersizkullanicidenemeleri() {


        String[][] gecersizKullaniciBilgileri1={{"ahmet","1234"},{"ali","58658"}};  // bu yolda var




        String[][] gecersizKullaniciBilgileri=new String[5][2];
        Faker faker=new Faker();

        for (int i = 0; i <gecersizKullaniciBilgileri.length ; i++) {

            gecersizKullaniciBilgileri[i][0]=faker.internet().emailAddress();
            gecersizKullaniciBilgileri[i][1]=faker.internet().password();


        }



        return gecersizKullaniciBilgileri1;
    }

    @Test(dataProvider = "Gecersizkullanicidenemeleri")
    public void cokluNegatifTest(String username, String password) {


        // qualitydemy anasayfaya gidin
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));


        // ilk login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookiesKbulElementi.click();
        qualitydemyPage.ilkLoginLinki.click();

        // verilen gecersiz kullanici adi ve sifreleri listesindeki
        // 5 isim ve sifre icin giris yapilamadigini test edin
        qualitydemyPage.emailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        Assert.assertTrue(qualitydemyPage.emailKutusu.isDisplayed());

        // sayfayi kapatin
        Driver.closeDriver();


    }










}
