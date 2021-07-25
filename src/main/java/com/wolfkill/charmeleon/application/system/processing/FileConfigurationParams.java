package com.wolfkill.charmeleon.application.system.processing;

public interface FileConfigurationParams {

    default String getDelimiter() {
        return "";
    }

    default String getExtraction() {
        return "";
    }
}
