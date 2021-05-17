package com.bahamazau.dao;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.Optional;

public class TextReader {

    public Optional<String> readText(String filePath) throws IOException {
        URL url = getClass().getClassLoader().getResource(filePath);
        if (url != null) {
            File file = new File(url.getFile());
            return Optional.ofNullable(new String(Files.readAllBytes(file.toPath())));
        }

        return Optional.empty();
    }

}
