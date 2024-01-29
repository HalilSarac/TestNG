package tests.day14_testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.security.Key;

public class C01_testNGIlktest extends TestBase {

    @Test
    public void aramaTesti (){

        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // phone için arama yapın
        WebElement aramakutusu = driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys("phone" + Keys.ENTER);

        // arama sonucunda ürün bulunbildiğini test edin
        WebElement aramaSonucElementi = driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedSonucYazisi = "0 Products Found";
        String actualSonucYazisi = aramaSonucElementi.getText();

        Assert.assertNotEquals(actualSonucYazisi,unExpectedSonucYazisi);
    }
}
