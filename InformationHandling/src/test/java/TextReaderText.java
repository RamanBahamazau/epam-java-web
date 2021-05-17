import com.bahamazau.composite.text.Text;
import com.bahamazau.dao.TextReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TextReaderText {

    private TextReader textReader = new TextReader();

    @Test
    public void should_whenReadText_given() throws IOException {
        // given
        String content = textReader.readText("textExample.txt").get();

        Text text = new Text(1L);
        // when
        text.parse(content);
    }

}
