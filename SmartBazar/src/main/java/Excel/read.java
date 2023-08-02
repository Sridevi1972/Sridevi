package Excel;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class read {
    public static String excel(int row, int column) throws Exception{
        //String testData = null;
        String filepath = System.getProperty("user.dir") + "//src//main//resources/test.xlsx";
        FileInputStream file = new FileInputStream(filepath);
        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet ws = wb.getSheetAt(0);  //sheet1
        String testData= String.valueOf(ws.getRow(row).getCell(column));
        return testData;
    }
}
