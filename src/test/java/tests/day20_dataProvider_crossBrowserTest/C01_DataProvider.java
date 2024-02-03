package tests.day20_dataProvider_crossBrowserTest;

import org.openqa.selenium.Keys;
import org.openqa.selenium.devtools.v118.input.model.DragData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C01_DataProvider extends TestBaseRapor {
    @DataProvider
    public static Object[][] aranacakUrunlerProvider() {
        /*
            @DataProvider notasyonunu kullanan method'lar
            bize 2 katli bir array döndürmek üzere hazırlanmıştır

            bu method'un içerisinde non-primitive data türüne sahip
            2 katlı bir array (matrix) oluşturup
            bu array'i return olarak gönderirsek
            arraydeki her bir inner array'i sırasıyla
            test methodumuza parametre olarak göderir
         */
        String [][] aranacakUrunlerArrayi = {{"phone"},{"java"},{"dress"},{"apple"},{"nutella"},{"cokokrem"},{"baby"}};
        return aranacakUrunlerArrayi;
    }

    // test otomasyonu ana sayfaya gidin
    // verilen urun listesindeki her bir urun icin
    // arama yapip, arama sonucunda urun bulunabildigini test edin
    // aranacak urun listesi : phone, java, dress, apple, nutella, cokokrem, baby

    @Test(dataProvider = "aranacakUrunlerProvider")
    public void topluAramaTesti(String aranacakUrun){

        extentTest = extentReports.createTest("Toplu arama testi","Verilen listedeki tüm ürünlerin stokta bulunduğunu test eder");
        extentTest.info("kullanici testotomasyonu ana sayfaya gider");

        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys(aranacakUrun);

        extentTest.info("arama kutusuna "+aranacakUrun+" elementi yazar");

        ReusableMethods.waitFor(2);
        testOtomasyonPage.aramaKutusu.submit();
        extentTest.info("arama kutusuna "+aranacakUrun+" için arama yapar");
        ReusableMethods.waitFor(2);

        String unexpectedSonucYazisi = "0 Products Found";

        Assert.assertFalse(testOtomasyonPage.bulunanUrunSayisiElementi.getText().equals(unexpectedSonucYazisi));
        extentTest.pass(aranacakUrun+" aramasinda ürün bulunabildiğini test eder");

        Driver.quitDriver();
        extentTest.info("sayfayı kapatır");
    }
}
