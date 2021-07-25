package com.wolfkill.charmeleon.application.system.upload;

import java.io.*;
import java.util.*;

import com.wolfkill.charmeleon.application.system.processing.FileProcessingFactory;
import com.wolfkill.charmeleon.application.system.processing.excel.ExcelProcessingFactory;

public class Menu {
    private static final FileProcessingFactory FACTORY = ExcelProcessingFactory.getInstance();
    private static Map<Integer, Map<Integer, List<String>>> menuInfo;
    private static Menu menu;

    private Menu() {}

    public static void loadMenu(String filePath) throws IOException {
        menuInfo = FACTORY.parse(filePath);
    }

    public static Menu getMenu() {
        if (menu == null) {
            menu = new Menu();
        }
        return menu;
    }

    public static Map<Integer, Map<Integer, List<String>>> getMenuInfo() {
        return menuInfo;
    }
}
