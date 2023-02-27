package day09_excel_screenshot_jsExecutor;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class C02_ReadExcel {
    //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
    // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
    // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
    // - Satir sayisini bulalim
    // - Fiziki olarak kullanilan satir sayisini bulun
    // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

    @Test
    public void test01() throws IOException {

        String dosyaYolu="src/test/java/day09_excel_screenshot_jsExecutor/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(1));

        // - 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenData= workbook
                .getSheet("Sayfa1")
                .getRow(0)
                .getCell(1)
                .toString();
        System.out.println("İstenen data : " + istenenData);

        // - 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedData="Kabil";
        String actualData=workbook
                .getSheet("Sayfa1")
                .getRow(1).getCell(3)
                .toString();
        Assert.assertEquals(expectedData,actualData);

        // - Satir sayisini bulalim

        System.out.println("satır sayısı : " + (workbook.getSheet("Sayfa1").getLastRowNum()+1));

        // - Sayfa2'deki satır sayısı ve Fiziki olarak kullanilan satir sayisini bulun
        System.out.println("Sayfa2 satır sayısı : " + (workbook.getSheet("Sayfa2").getLastRowNum()+1));
        System.out.println("sayfa2 fiziki kullanılan satır sayısı : " +
                workbook.getSheet("Sayfa2").getPhysicalNumberOfRows());

        // - Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        Map<String,String> ulkelerMap= new TreeMap<>();
        int sonSatirIndexi=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 1; i <=sonSatirIndexi; i++) {// başlıgı almamak için 1'den başladı

            String key= workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            String baskent=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString();

            ulkelerMap.put(key,baskent);

        }
        System.out.println(ulkelerMap);

        Set<Map.Entry<String ,String>> ulkelerEntrySet=ulkelerMap.entrySet();
        for (Map.Entry<String,String> eachEntry:ulkelerEntrySet
             ) {
            System.out.println(eachEntry);
        }

    }
}
