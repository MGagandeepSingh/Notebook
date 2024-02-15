package com.notebook.core.util;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException("Static utility class doesn't need to be instantiated");
    }

    public static Map<String, String> getFileData(String folder) {

        Map<String, String> filesData = new HashMap<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(folder))) {
            for(Path filePath : directoryStream)
                if(Files.isRegularFile(filePath)) {
                    String fileName = filePath.getFileName().toString();
                    List<String> lines = Files.readAllLines(filePath);
                    filesData.put(fileName, lines.toString());
                }
        } catch (IOException ioe) {
            log.error("Unable to find the folder: {}", folder, ioe);
        }
        return filesData;
    }
}
