package com.bahamazau.composite.text.paragraph;

import com.bahamazau.composite.text.paragraph.sentence.Sentence;
import com.bahamazau.parser.TextParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Paragraph implements TextParser {

    private static final String TEXT_REGEX = "\\.\\s(?!\\d)|(?<!\\d)\\.\\s";

    private Long id;
    private List<Sentence> sentenceList;

    public Paragraph(Long id) {
        this.id = id;
        this.sentenceList = new ArrayList<>();
    }

    @Override
    public void parse(String text) {
        Arrays.stream(text.split(TEXT_REGEX)).forEach(sentenceText -> {
            Sentence sentence = new Sentence(1L);
            sentence.parse(sentenceText);

            sentenceList.add(sentence);
        });
    }

}
