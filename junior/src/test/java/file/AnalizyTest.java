package file;

import org.junit.Test;

import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AnalizyTest {
    private String source = "/home/roman/IdeaProjects/job4j/junior/src/main/java/file/server_log.csv";
    private String target = "/home/roman/IdeaProjects/job4j/junior/src/main/java/file/analyze_server_log.csv";

    @Test
    public void whenCheckServerLog() {
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream(source))) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("400 11:02:02");
            out.println("200 11:03:01");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(
                    line -> builder.append(line).append(System.lineSeparator())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        String expected = "10:58:01;10:59:01;" + System.lineSeparator()
                + "11:01:02;11:03:01;" + System.lineSeparator();

        assertThat(
                expected,
                is(builder.toString())
        );
    }
    @Test
    public void whenCheckEmptyServerLogError() {
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream(source))) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("200 10:58:01");
            out.println("200 10:59:01");
            out.println("200 11:01:02");
            out.println("200 11:02:02");
            out.println("200 11:03:01");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Analizy analizy = new Analizy();
        analizy.unavailable(source, target);

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            reader.lines().forEach(
                    line -> builder.append(line).append(System.lineSeparator())
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        String expected = "";

        assertThat(
                expected,
                is(builder.toString())
        );
    }
}
