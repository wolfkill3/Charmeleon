package com.wolfkill.charmeleon.application.system;

public enum ExtractFileType {
    CSV(";", ".csv"),
    TXT(",", ".txt"),
    XML("", ".xml"),
    HTML("", ".html");

    private final String delimiter;
    private final String extraction;

    ExtractFileType(final String delimiter, final String extraction) {
        this.delimiter = delimiter;
        this.extraction = extraction;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public String getExtraction() {
        return extraction;
    }

    @Override
    public String toString() {
        return "ExtractFileType{" +
               "delimiter='" + delimiter + '\'' +
               '}';
    }
}
