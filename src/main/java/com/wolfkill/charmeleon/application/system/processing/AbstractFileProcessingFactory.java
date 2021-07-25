package com.wolfkill.charmeleon.application.system.processing;

import java.io.*;
import java.util.*;

public abstract class AbstractFileProcessingFactory implements FileProcessingFactory {
    protected FileConfigurationParams configurationParams;

    protected AbstractFileProcessingFactory(FileConfigurationParams configurationParams) {
        this.configurationParams = configurationParams;
    }

    protected AbstractFileProcessingFactory() {
    }

    @Override
    public abstract Map<Integer, Map<Integer, List<String>>> parse(final String filePath) throws IOException;

    @Override
    public abstract String[] getHeader();
}
