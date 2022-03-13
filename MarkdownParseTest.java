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

    @Test
    public void testfirstLine() throws IOException {
        Path fileName = Path.of("firstline.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from firstline.md", List.of(), links);
    }

    @Test
    public void testSeparated() throws IOException {
        Path fileName = Path.of("separated.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from separated.md", List.of("isValid"), links);
    }

    @Test
    public void testreeeeee() throws IOException {
        Path fileName = Path.of("ree.md");
        String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals("Test the links from ree.md", List.of("ao"), links);
    }

    @Test
    public void testsnip1() throws IOException {
        Path fileName = Path.of("snip1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> ourLinks = MarkdownParse.getLinks(contents);

        assertEquals("Test the links from snip1.md for our method", List.of("`google.com", "google.com", "ucsd.edu"),
                ourLinks);

    }

    public void testsnip1other() throws IOException {
        Path fileName = Path.of("snip1.md");
        String contents = Files.readString(fileName);
        ArrayList<String> otherLinks = MarkdownParse.getLinksOther(contents);

        assertEquals("Test the links from snip1.md for others method", List.of("`google.com", "google.com", "ucsd.edu"),
                otherLinks);
    }

    @Test
    public void testsnip2() throws IOException {
        Path fileName = Path.of("snip2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> ourLinks = MarkdownParse.getLinks(contents);

        assertEquals("Test the links from snip2.md for our method", List.of("a.com", "a.com(())", "example.com"),
                ourLinks);
    }

    @Test
    public void testsnip2other() throws IOException {
        Path fileName = Path.of("snip2.md");
        String contents = Files.readString(fileName);
        ArrayList<String> otherLinks = MarkdownParse.getLinksOther(contents);

        assertEquals("Test the links from snip2.md for others method", List.of("a.com", "a.com(())", "example.com"),
                otherLinks);
    }

    @Test
    public void testsnip3() throws IOException {
        Path fileName = Path.of("snip3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> ourLinks = MarkdownParse.getLinks(contents);

        assertEquals("Test the links from snip3.md for our method",
                List.of(" https://www.twitter.com ", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/"),
                ourLinks);

    }

    @Test
    public void testsnip3other() throws IOException {
        Path fileName = Path.of("snip3.md");
        String contents = Files.readString(fileName);
        ArrayList<String> otherLinks = MarkdownParse.getLinksOther(contents);

        assertEquals("Test the links from snip3.md for others method",
                List.of(" https://www.twitter.com ", "https://ucsd-cse15l-w22.github.io/", "https://cse.ucsd.edu/"),
                otherLinks);
    }
}
