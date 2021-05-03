package com.bahamazau.api;

import com.bahamazau.impl.exception.CustomException;

import java.util.List;

public interface ShapeFileReaderService {

    List<String> readDataFromFile(String path) throws CustomException;

}
