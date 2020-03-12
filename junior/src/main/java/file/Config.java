package file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(String path) {
        this.path = path;
    }
    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(this::writeToValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String value(String key) {
        return this.values.get(key);
    }
    private void writeToValues(String arg) {
        if (!arg.equals("") && arg.charAt(0) != '#') {
            String[] arr = arg.split("=");
            this.values.put(arr[0], arr[1]);
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("./properties/app.properties");
        config.load();
    }
}
