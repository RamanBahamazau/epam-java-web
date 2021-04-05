package com.bahamazau.api.service;

import com.bahamazau.api.exception.ArrayException;

public interface FileReaderService {

    public String readOnlyDigitsLine(String path) throws ArrayException;

}
