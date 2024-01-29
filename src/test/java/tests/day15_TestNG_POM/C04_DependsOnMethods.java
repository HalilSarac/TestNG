package tests.day15_TestNG_POM;

import org.testng.annotations.Test;

public class C04_DependsOnMethods {

    @Test(priority = -10)
    public void testOtomasyonTesti(){

        System.out.println("test otomasyonu testi calisti");
    }

    @Test
    public void wiseQuarterTesti(){

        System.out.println("Wise Quarter testi calisti");
    }

    @Test
    public void youtubeTesti(){

        System.out.println("Youtube testi calisti");
    }
}
