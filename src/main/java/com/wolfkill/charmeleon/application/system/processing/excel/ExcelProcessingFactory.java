package com.wolfkill.charmeleon.application.system.processing.excel;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

import com.wolfkill.charmeleon.application.system.ExtractFileType;
import com.wolfkill.charmeleon.application.system.processing.AbstractFileProcessingFactory;
import com.wolfkill.charmeleon.application.system.processing.FileConfigurationParams;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProcessingFactory extends AbstractFileProcessingFactory {

    public ExcelProcessingFactory(FileConfigurationParams params) {
        super(params);
    }

    @Override
    public Map<Integer, Map<Integer, List<String>>> parse(final String filePath) throws IOException {
        if (Files.notExists(Path.of(filePath))) {
            return Collections.emptyMap();
        }

        Workbook workbook = getExcelWorkbook(filePath);
        return parseWorkbook(workbook);
    }

    public static ExcelProcessingFactory getInstance() {
        FileConfigurationParams params = new ExcelConfigurationParams(ExtractFileType.CSV);

        return new ExcelProcessingFactory(params);
    }

    private Map<Integer, Map<Integer, List<String>>> parseWorkbook(final Workbook workbook) {
        Map<Integer, Map<Integer, List<String>>> excelPageByNumber = new HashMap<>();

        for (int pageNumber = 0; pageNumber < workbook.getNumberOfSheets(); pageNumber++) {
            Sheet sheet = workbook.getSheetAt(pageNumber);
            excelPageByNumber.put(pageNumber, parsePage(sheet));
        }
        return excelPageByNumber;
    }

    private Map<Integer, List<String>> parsePage(final Sheet sheet) {
        Map<Integer, List<String>> page = new HashMap<>();

        int columnIndex = 0;
        for (var column : sheet) {
            page.put(columnIndex, parseColumn(column));
            columnIndex++;
        }
        return page;
    }

    private List<String> parseColumn(final Row column) {
        List<String> cells = new ArrayList<>();

        for (var cell : column) {
            switch (cell.getCellTypeEnum()) {
                case STRING: cells.add(cell.getStringCellValue());
                case NUMERIC: cells.add(String.valueOf(cell.getNumericCellValue()));
                default: cells.add(" ");
            }
        }
        return cells;
    }

    private Workbook getExcelWorkbook(String filePath) throws IOException {
        File file = new File(filePath);
        FileInputStream fileInputStream = new FileInputStream(file);
        return new XSSFWorkbook(fileInputStream);
    }

    private File buildTemporaryFile(String filePath) throws IOException {
        Path path = Path.of(filePath).toAbsolutePath();
        File file = File.createTempFile(path + "excel", configurationParams.getExtraction());
        file.deleteOnExit();
        return file;
    }

    @Override
    public String[] getHeader() {
        return new String[] { "Наименование позиции", "Цена" };
    }
}
