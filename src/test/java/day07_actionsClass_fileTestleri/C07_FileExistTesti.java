package day07_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C07_FileExistTesti {

    @Test
    public void test01(){

        // çalıştığımız package içerisinde
        // text.txt isimli bir file olduğunu test edin

        String dinamikDosyaYolu = System.getProperty("use.dir")
                                  +"/src/test/java/day07_actionsClass_fileTestleri/text.txt";

        System.out.println(dinamikDosyaYolu);
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

    }
}
