package com.bahamazau.service;

import com.bahamazau.composite.TextElement;
import com.bahamazau.composite.common.TextElementMother;

import javax.swing.text.html.Option;

import static java.util.Arrays.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bahamazau.composite.TextType.PARAGRAPH;
import static com.bahamazau.composite.TextType.TEXT;

public class TextService {

    /**
     * Sort paragraphs of text by elements size.
     *
     * @param textElement must be TEXT type.
     * @return new TextElement with sorted values or current if input textElement not is TEXT.
     */
    public TextElementMother sortParagraphsBySize(TextElement textElement) {
        if (textElement.getTextType() == TEXT) {
            List<TextElementMother> textElementList = textElement
                    .getTextElements()
                    .stream()
                    .sorted()
                    .collect(Collectors.toList());
            return new TextElement(TEXT, textElementList);
        }

        return textElement;
    }

    /**
     * Search sentence with the longest word.
     *
     * @param textElement must be TEXT or PARAGRAPH type.
     * @return sentence with the longest word if textElement valid, else Optional.empty() if textElement not TEXT or PARAGRAPH type.
     */
    public Optional<TextElementMother> selectSentenceWithLongestWord(TextElement textElement) {
        if (asList(TEXT, PARAGRAPH).contains(textElement.getTextType())) {
            switch (textElement.getTextType()) {
                case TEXT:
                    List<TextElementMother> paragraphs = textElement.getTextElements();
                    TextElementMother sentenceFromParagraphWithLongestWord = null;
                    for (TextElementMother paragraph : paragraphs) {
                        TextElementMother currentSentence = selectSentenceFromParagraphWithLongestWord((TextElement) paragraph);
                        if (currentSentence != null) {
                            sentenceFromParagraphWithLongestWord = currentSentence;
                        }
                    }
                    return Optional.ofNullable(sentenceFromParagraphWithLongestWord);

                case PARAGRAPH:
                    TextElementMother sentenceWithLongestWord = selectSentenceFromParagraphWithLongestWord(textElement);
                    return Optional.ofNullable(sentenceWithLongestWord);
            }
        }

        return Optional.empty();
    }

    private TextElementMother selectSentenceFromParagraphWithLongestWord(TextElement textElement) {
        int maxWordSize = 0;
        TextElementMother sentenceWithLongestWord = null;

        List<TextElementMother> sentences = textElement.getTextElements();
        for (TextElementMother sentence : sentences) {
            List<TextElementMother> words = ((TextElement) sentence).getTextElements();
            for (TextElementMother word : words) {
                int currentSize = ((TextElement) word).getTextElements().size();
                if (currentSize > maxWordSize) {
                    maxWordSize = currentSize;
                    sentenceWithLongestWord = sentences.get(sentences.indexOf(sentence));
                }
            }
        }

        return sentenceWithLongestWord;
    }

}
