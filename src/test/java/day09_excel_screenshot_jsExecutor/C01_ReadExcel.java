package day09_excel_screenshot_jsExecutor;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {
        /*
          Biz kodlarımızla bilgisayardaki bir dosyaya direkt erişim sağlayıp
          anlık o dosyadan bilgi almayız.

          Bunun yerine class'ın başında, bilgisayarımızdaki excel dosyanın
          1- bir kopyasını oluşturur
          2- excel'deki tüm bilgileri kopya workbook'a yükler
          3- workbook üzerinde yapacağımız tüm işlemleri yaparız
          4- eğer oluşturduğumuz workbook'da update yaparsak
             son halini excel'e işlemek için
             class'in sonunda kopya workbook'taki bilgileri excel'e kaydederiz.
         */

        // 1- Bilgisayardaki excel'e ulaşabilmek için dosya yolu gerekir

        String dosyaYolu="src/test/java/day09_excel_screenshot_jsExecutor/ulkeler.xlsx";

        // 2- Dosya yolunu oluşturduğumuz excel'den bilgileri almak için
        //    FileInputStream objesi oluşturmalıyız.

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // 3- Bilgilerini aldığımız excel'de çalışma yapabilmek için
        //    kod ortamımızda kopya bir workbook oluşturmalıyız.

        Workbook workbook = WorkbookFactory.create(fis);

        // Bilgisayarımızdaki excel'in içinde bulunan tüm bilgiler
        // artık workbook objesinde kayıtlı
        // excel'in yapısı gereği sırayla
        // - istenen sayfa
        // - istenen satır
        // - istenen hücre
        // oluşturulmalıdır / okunmalıdır

        // 12. satırın 3. hücresinin "Azerbaycan" olduğunu test edin
        Sheet sayfa1= workbook.getSheet("Sayfa1");
        // excel index kullanır yani 0'dan başlar
        // bu durumda 12/3 yerine 11/2 girmeliyiz
        Row row= sayfa1.getRow(11);
        Cell cell= row.getCell(2);

        String expectedData="Azerbaycan";
        String actualData=cell.toString();

        Assert.assertEquals(expectedData,actualData);



    }
}
