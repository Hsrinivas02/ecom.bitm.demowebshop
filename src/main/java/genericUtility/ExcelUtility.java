package genericUtility;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import java.io.FileInputStream;
import java.io.IOException;
public class ExcelUtility {
    public static String getData(String sheetName, int row, int cell) throws IOException {
        FileInputStream excel = new FileInputStream("src/test/resources/DemoWebShop_TestData.xlsx");
        Workbook wb = WorkbookFactory.create(excel);
        DataFormatter df = new DataFormatter();//converts Excel cell values into Strings that look like the values displayed in Excel.

        String data = df.formatCellValue(wb.getSheet(sheetName).getRow(row).getCell(cell));
        //formatCellValue: This method takes a particular Excel cell and returns its formatted value as a String.
        wb.close();
        excel.close();
        return data;
    }
}
