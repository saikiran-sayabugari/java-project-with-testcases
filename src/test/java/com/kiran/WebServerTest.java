package com.kiran;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import spark.Spark;
import spark.utils.IOUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import static org.junit.Assert.assertEquals;

public class WebServerTest {

    @BeforeClass
    public static void setUp() {
        WebServer.main(null);  // Start the Spark server
    }

    @AfterClass
    public static void tearDown() {
        Spark.stop();  // Stop the Spark server
    }

    @Test
    public void testReverseEndpoint() throws IOException {
        URL url = new URL("http://localhost:8080/reverse/Java");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        // Read the response
        String response = IOUtils.toString(connection.getInputStream());

        // Verify the response
        assertEquals("Reversed: avaJ", response);
    }
}

