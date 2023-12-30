package com.kiran;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileManager {

    public static String readFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    public static void writeFile(String filePath, String content) throws IOException {
        Files.writeString(Path.of(filePath), content);
    }
}

