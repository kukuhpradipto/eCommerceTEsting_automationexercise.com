package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {

//    public static Object[][] readExcel(String filePath, String sheetName) {
//        try (FileInputStream fis = new FileInputStream(filePath);
//             Workbook workbook = new XSSFWorkbook(fis)) {
//
//            Sheet sheet = workbook.getSheet(sheetName);
//            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
//
//            List<Object[]> dataList = new ArrayList<>();
//
//            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
//                Row row = sheet.getRow(i);
//                if (row == null) continue;
//
//                Object[] rowData = new Object[colCount];
//                boolean hasAtLeastOneCellFilled = false;
//
//                for (int j = 0; j < colCount; j++) {
//                    Cell cell = row.getCell(j);
//                    if (cell != null && cell.getCellType() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
//                        hasAtLeastOneCellFilled = true;
//
//                        if (cell.getCellType() == CellType.NUMERIC) {
//                            double val = cell.getNumericCellValue();
//                            rowData[j] = (val % 1 == 0) ? String.valueOf((int) val) : String.valueOf(val);
//                        } else {
//                            rowData[j] = cell.toString().trim();
//                        }
//                    } else {
//                        rowData[j] = "";
//                    }
//                }
//
//                if (hasAtLeastOneCellFilled) {
//                    dataList.add(rowData);
//                }
//            }
//
//            return dataList.toArray(new Object[0][0]);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            return new Object[0][0];
//        }
//    }
public static Object[][] readExcel(String filePath, String sheetName) {
    try (FileInputStream fis = new FileInputStream(filePath);
         Workbook workbook = new XSSFWorkbook(fis)) {

        Sheet sheet = workbook.getSheet(sheetName);
        int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

        List<Object[]> dataList = new ArrayList<>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);

            // Jika row null dan tidak ada data di bawahnya, break
            if ((row == null || isRowEmpty(row)) && i == sheet.getLastRowNum()) {
                continue; // Skip baris terakhir jika kosong
            }

            if (row == null) {
                row = sheet.createRow(i);
            }

            Object[] rowData = new Object[colCount];
            for (int j = 0; j < colCount; j++) {
                Cell cell = row.getCell(j);
                if (cell != null && cell.getCellType() != CellType.BLANK) {
                    if (cell.getCellType() == CellType.NUMERIC) {
                        double val = cell.getNumericCellValue();
                        rowData[j] = (val % 1 == 0) ? String.valueOf((int) val) : String.valueOf(val);
                    } else {
                        rowData[j] = cell.toString();
                    }
                } else {
                    rowData[j] = "";
                }
            }

            dataList.add(rowData);
        }

        return dataList.toArray(new Object[0][0]);
    } catch (IOException e) {
        e.printStackTrace();
        return new Object[0][0];
    }
}

    private static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
