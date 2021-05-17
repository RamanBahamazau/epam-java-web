package com.bahamazau.composite.text;

import com.bahamazau.composite.text.paragraph.Paragraph;
import com.bahamazau.parser.TextParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Text implements TextParser {

    private static final String TEXT_REGEX = "(?m)(?=^\\s{4})";

    private Long id;
    private List<Paragraph> paragraphList;

    public Text(Long id) {
        this.id = id;
        this.paragraphList = new ArrayList<>();
    }

    @Override
    public void parse(String text) {
        Arrays.stream(text.split(TEXT_REGEX)).forEach(paragraphText -> {
            Paragraph paragraph = new Paragraph(1L);

            String replacedText = paragraphText.replace("\r\n", "").replace("    ", "").replace("\t", "");
            paragraph.parse(replacedText);

            paragraphList.add(paragraph);
        });
    }

    public Long getId() {
        return id;
    }

    public List<Paragraph> getParagraphList() {
        return paragraphList;
    }
}
