import com.bahamazau.composite.common.TextElementMother;
import com.bahamazau.dao.TextReader;
import com.bahamazau.parser.TextParserBuilder;
import com.bahamazau.service.TextService;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class TextServiceTest {

    private TextReader textReader = new TextReader();
    private TextService service = new TextService();

    @Test
    public void should_when_given() throws IOException {
        // given
        Optional<String> actual = textReader.readText("textExample.txt");

        TextElementMother list = new TextParserBuilder().build().parse(actual.get());
        // when
//        service.sort(list);
        // then
    }
}
