package day07_actionsClass_fileTestleri;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FilePath {

    @Test
    public void test01(){

        // bilgisayarımızın temel dosya yolu user.home'dur.
        // C:\Users\metaverseelektronik\Desktop

        // İçinde bulunduğumuz projenin temel yolu user.dir'dir
        // C:\Users\metaverseelektronik\Desktop\GitHubTeam108\seleniumTeam108\src\test\java\day07_actionsClass_fileTestleri\text.txt

        String dosyaYolu= "C:\\Users\\metaverseelektronik\\Desktop";

        boolean sonuc= Files.exists(Paths.get(dosyaYolu));
        System.out.println(sonuc);

        /*
           Bilgisayarımızda bir dosyanın var olduğunu test etmek için
           dosya yoluna ihtiyacımız var

           Ancak herkesin bilgisayarındaki dosya yolları
           farklılıklar gösterir.

           Herkesin bilgisayarına göre farklı olan kısmı
           Javadan bir komut ile elde edebiliriz

         */

        System.out.println(System.getProperty("user.home"));

        // String dosyaYolu= "C:\\Users\\metaverseelektronik\\Desktop";
        dosyaYolu=System.getProperty("user.home") + "\\Desktop";

        System.out.println(System.getProperty("user.dir"));

    }
}
