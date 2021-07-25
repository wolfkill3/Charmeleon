package com.wolfkill.charmeleon.application.system.processing.excel;

import com.wolfkill.charmeleon.application.system.ExtractFileType;
import com.wolfkill.charmeleon.application.system.processing.FileConfigurationParams;

public class ExcelConfigurationParams implements FileConfigurationParams {
    public ExtractFileType fileType;

    public ExcelConfigurationParams(final ExtractFileType fileType) {
        this.fileType = fileType;
    }

    @Override
    public String getDelimiter() {
        return fileType.getDelimiter();
    }

    @Override
    public String getExtraction() {
        return fileType.getExtraction();
    }
}
