package com.bahamazau.composite.text.paragraph.sentence.token;

import java.util.List;

public abstract class Token {

    private Long id;
    private List<Character> symbolList;

    public Token(Long id, List<Character> symbolList) {
        this.id = id;
        this.symbolList = symbolList;
    }
}
