package com.kiran;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import static org.junit.Assert.assertEquals;

public class FileManagerTest {

    @Test
    public void testReadFile() throws IOException {
        String content = "Test File Content";
        Path filePath = Files.createTempFile("test", ".txt");
        Files.writeString(filePath, content);

        assertEquals(content, FileManager.readFile(filePath.toString()));
    }

    @Test
    public void testWriteFile() throws IOException {
        String content = "Test File Content";
        Path filePath = Files.createTempFile("test", ".txt");
        FileManager.writeFile(filePath.toString(), content);

        assertEquals(content, Files.readString(filePath));
    }
}

