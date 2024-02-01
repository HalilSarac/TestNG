package tests.day16_TestNG_POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TestOtomasyonPage;
import pages.TestotomasyonFormPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class C04_TestOtomasyonuFormTesti {

    @Test
    public void formTesti(){

        //1 - https://testotomasyonu.com/form adresine gidin
        Driver.getDriver().get("https://testotomasyonu.com/form");

        //2- Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        TestotomasyonFormPage testotomasyonFormPage = new TestotomasyonFormPage();

        Select selectGun = new Select(testotomasyonFormPage.gunDropdownMenu);
        selectGun.selectByIndex(5);

        //3- Dogum tarihi ay seçeneğinden value kullanarak Nisan’i secin
        Select selectAy = new Select(testotomasyonFormPage.ayDropdownMenu);
        selectAy.selectByValue("nisan");

        //4- Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        Select selectYil = new Select(testotomasyonFormPage.yilDropdownMenu);
        selectYil.selectByVisibleText("1990");

        //5- Secilen değerleri konsolda yazdirin
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());

        //6- Ay dropdown menüdeki tum değerleri(value) yazdırın
        List<WebElement> ayDropdownTumOpsiyonElementleri = selectAy.getOptions();
        System.out.println(ReusableMethods.stringToList(ayDropdownTumOpsiyonElementleri));

        //7- Ay Dropdown menusunun boyutunun 13 olduğunu test edin
        Assert.assertEquals(ayDropdownTumOpsiyonElementleri.size(),13);

        ReusableMethods.waitFor(5);
        Driver.quitDriver();
    }
}
