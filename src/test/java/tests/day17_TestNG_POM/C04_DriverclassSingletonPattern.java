package tests.day17_TestNG_POM;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DriverclassSingletonPattern {

    @Test
    public void test01(){

        /*
            Testlerimizde kullanacağımız WebDriver objesini
            utilities/ Driver class'indaki
            getDriver() ile olusturuyoruz

            Driver class'ındaki WebDriver objesi olarak oluşturulan
            driver'a Driver Class'indan obje oluşturarak da erişebiliriz
            ancak Mahşerin 4 atlısı çalışmadığından
            driver objesi bir işe yaramaz

            POM dizayninda Driver class'indaki driver objesine
            obje üzerinden erişimi iptal etmek için singleton pattern tercih edilmiş
         */

        // Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

        //Driver obj = new Driver();//'Driver()' has private access in 'utilities.Driver'
        //obj.driver.get(ConfigReader.getProperty("toUrl"));


    }
}
