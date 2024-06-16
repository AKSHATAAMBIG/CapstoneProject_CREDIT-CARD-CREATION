package commom.method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReadDataFromExcel {

    public static String createJsonBody(String name, int year, String creditCardNumber, double limit, String expDate, String cardType) {
        String body = "{\n" +
                "    \"name\": \"" + name + "\",\n" +
                "    \"data\": {\n" +
                "        \"year\": " + year + ",\n" +
                "        \"Credit Card Number\": \"" + creditCardNumber + "\",\n" +
                "        \"Limit\": \"" + limit + "\",\n" +
                "        \"EXP Date\": \"" +expDate+ "\",\n" +
                "        \"Card Type\": \"" + cardType + "\"\n" +
                "    }\n" +
                "}";

        return body;
    }

    public static List<String> readingXlFileData() {
        List<String> creditCardNumbers = new ArrayList<>();
        try {

            String xlFile = "C:/Users/akshatan/Desktop/Cards_TestData.xlsx";
            FileInputStream f = new FileInputStream(xlFile);
            Workbook workbook = new XSSFWorkbook(f);
            Sheet sheet = workbook.getSheet("Sheet1");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);
                Cell cell = row.getCell(0);
                String creditCardNumber = cell.getStringCellValue().trim();
                creditCardNumbers.add(creditCardNumber);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return creditCardNumbers;
    }
}
