package file;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "/home/roman/IdeaProjects/job4j/properties/app.properties";
        Config config = new Config(path);
        config.load();

        assertThat(
                config.value("name"),
                is("demkiv")
        );
    }
}
