package com.wolfkill.charmeleon.application.system.processing;

import java.io.*;
import java.util.*;

public interface FileProcessingFactory {

    default Map<Integer, Map<Integer, List<String>>> parse(String filePath) throws IOException {
        return null;
    }

    default String[] getHeader(){
        return new String[] {};
    }
}
