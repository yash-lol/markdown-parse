import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testNewFile() throws IOException {
        Path fileName = Path.of("test-file.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from test-file.md", List.of("https://something.com", "some-page.html"), links);
    }

    @Test
    public void testImg() throws IOException {
        Path fileName = Path.of("img.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from img.md", List.of(), links);
    }

    // @Test
    // public void testfirstLine() throws IOException {
    // Path fileName = Path.of("firstline.md");
    // String contents = Files.readString(fileName);
    // ArrayList<String> links = MarkdownParse.getLinks(contents);
    // assertEquals("Test the links from firstline.md", List.of(""), links);
    // }
}