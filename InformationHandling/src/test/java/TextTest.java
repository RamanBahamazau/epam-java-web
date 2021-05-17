import com.bahamazau.composite.text.Text;
import org.junit.jupiter.api.Test;

public class TextTest {

    @Test
    public void should_whenParse_given() {
        // given
        String str = "    It has survived - not only (five) centuries, but also the leap into electronic " +
                "typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) " +
                "with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and " +
                "more recently with desktop publishing software like Aldus PageMaker Faclon9 including " +
                "versions of Lorem Ipsum!\n" +
                "\tIt is a long a!=b established fact that a reader will be distracted by the readable " +
                "content of a page when looking at its layout. The point of using Ipsum is that it has a " +
                "more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), " +
                "content here's, making it look like readable English?\n" +
                "    It is a established fact that a reader will be of a page when looking at its layout...\n" +
                "\tBye бандерлоги.\n";
        Text text = new Text(1L);
        // when
        text.parse(str);
        // then
    }
}
