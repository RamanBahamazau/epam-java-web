import com.bahamazau.composite.TextElement;
import com.bahamazau.composite.common.TextElementMother;
import com.bahamazau.dao.TextReader;
import com.bahamazau.parser.TextParserBuilder;
import com.bahamazau.service.TextService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Optional;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

public class TextServiceTest {

    private final TextReader textReader = new TextReader();
    private final TextParserBuilder textParserBuilder = new TextParserBuilder();
    private final TextService service = new TextService();

    @Test
    public void shouldReturnSortedTextElementOfTextType_whenReadTextAndSortByParagraphsSize_givenTextPathToFileWithNonSortedParagraphs() throws IOException {
        // given
        String textPath = "textExampleForTestingSort.txt";
        // when
        Optional<String> actualTextOptional = textReader.readText(textPath);
        // then
        assertNotEquals(actualTextOptional, Optional.empty());

        // given
        TextElementMother textElementMother = textParserBuilder.build().parse(actualTextOptional.get());
        // when
        TextElementMother actual = service.sortParagraphsBySize((TextElement) textElementMother);
        // then
        int startIndex = 1;
        for (TextElementMother actualTextElement : ((TextElement) actual).getTextElements()) {
            assertEquals(((TextElement) actualTextElement).getTextElements().size(), startIndex);
            startIndex++;
        }
    }

}
