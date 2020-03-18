package file;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenCheckServerLog() throws IOException {
        File source = folder.newFile("server_log.csv");
        File target = folder.newFile("analyze_server_log.csv");
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream(source))) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("400 11:02:02");
            out.println("200 11:03:01");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(builder::append);
        }

        String expected = "10:58:01;10:59:01;11:01:02;11:03:01;";

        assertThat(
                expected,
                is(builder.toString())
        );
    }
    @Test
    public void whenCheckEmptyServerLogError() throws IOException {
        File source = folder.newFile("server_log.csv");
        File target = folder.newFile("analyze_server_log.csv");
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream(source))) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("200 10:58:01");
            out.println("200 10:59:01");
            out.println("200 11:01:02");
            out.println("200 11:02:02");
            out.println("200 11:03:01");
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(builder::append);
        }

        String expected = "";

        assertThat(
                expected,
                is(builder.toString())
        );
    }
}
