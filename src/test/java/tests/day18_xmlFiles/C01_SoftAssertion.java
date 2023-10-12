package tests.day18_xmlFiles;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_SoftAssertion {

    @Test
    public void test01(){
        //. “http://zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroAppUrl"));




        // 2. Sign in butonuna basin
        // 3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password” yazin
        // 5. Sign in tusuna basin
        // 6. Online banking menusu icinde Pay Bills sayfasina gidin
        // 7. “Purchase Foreign Currency” tusuna basin
        // 8. “Currency” drop down menusunden Eurozone’u secin
        // 9. soft assert kullanarak "Eurozone (euro)" secildigini test edin
        // 10. soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin "Select One", "Australia (dollar)",
        // "Canada (dollar)","Switzerland (franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"





    }


}
