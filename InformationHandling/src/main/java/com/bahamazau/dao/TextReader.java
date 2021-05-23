package com.bahamazau.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;

public class TextReader {

    public Optional<String> readText(String filePath) throws IOException {
        URL url = getClass().getClassLoader().getResource(filePath);

        String content = null;
        if (url != null) {
            File file = new File(url.getFile());
            content = new String(Files.readAllBytes(file.toPath()));
        }

        return Optional.ofNullable(content);
    }

}
