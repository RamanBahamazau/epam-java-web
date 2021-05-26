package com.bahamazau.service;

import com.bahamazau.composite.TextElement;
import com.bahamazau.composite.common.TextElementMother;
import com.bahamazau.dao.TextReader;

import java.io.IOException;
import java.util.List;

public class TextService {

    private TextReader textReader = new TextReader();

    public void sort(List<TextElement> textElementMotherList) throws IOException {
        int minSize = 0;
        for (TextElement textElementMother : textElementMotherList) {
            if (minSize < textElementMother.getTextElements().size()) {
                System.out.println(minSize);
            }
        }
    }

}
