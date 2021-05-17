package com.bahamazau.api;

import com.bahamazau.api.exception.ShapeException;

import java.util.List;

public interface ShapeFileReaderService {

    public List<String> readDataFromFile(String path) throws ShapeException;

}
