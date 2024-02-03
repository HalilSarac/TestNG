package tests.day19_testNGReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class C02_RaporluAramaSepetiTesti extends TestBaseRapor {

    @Test
    public void aramaSepetiTesti(){
        extentTest = extentReports.createTest("Arama sepeti testi","Sepete attığımız ürün ismi ile sepetteki ürün ismi aynı olmalı");

        //1- https://www.testotomasyonu.com/ anasayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));
        extentTest.info("Kullanici test otomasyonu anasayaya gider");

        //2- phone icin arama yapin
        TestOtomasyonPage testOtomasyonPage = new TestOtomasyonPage();
        testOtomasyonPage.aramaKutusu.sendKeys("phone" + Keys.ENTER);
        extentTest.info("phone için arama yapar");

        // 3- Listelenen sonuclardan ilkini tiklayin
        testOtomasyonPage.bulunanUrunElementleriList.get(0).click();
        extentTest.info("listelenen sonuçlardan ilkine tıklar");

        //4- urun ismini kaydedin ve sepete ekleyin
        String sayfadakiUrunIsmi = testOtomasyonPage.urunSayfasindaUrunIsimElementi.getText();
        testOtomasyonPage.addToCartButonu.click();
        extentTest.info("urun ismini kaydeder ve sepete ekler");

        //5- your cart linkine tiklayin
        testOtomasyonPage.yourCart.click();
        extentTest.info("your cart linkine tıklar");

        //6- kaydettiginiz urun ismi ile sepetteki urun isminin ayni oldugunu test edin
        String sepettekiUrunIsmi = testOtomasyonPage.sepettekiUrunIsimElementi.getText();
        ReusableMethods.waitFor(1);
        extentTest.info("kaydettiği ürün ile sepetteki ürün isminin aynı olduğunu test eder");

        Assert.assertEquals(sepettekiUrunIsmi,sayfadakiUrunIsmi);

        //7- sayfayi kapatin
        Driver.quitDriver();
        extentTest.info("sayfayi kapatır");
    }
}
