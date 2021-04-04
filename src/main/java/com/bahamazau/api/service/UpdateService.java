package com.bahamazau.api.service;

import com.bahamazau.api.entity.ArrayEntity;

public interface UpdateService {

    public void replaceArrayElement(ArrayEntity arrayEntity, int newElement, int oldElement);

}
