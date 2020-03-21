package conteiner.file_system;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Predicate;

public class Search {
    public List<File> files(String parent, Predicate<File> condition) {
        List<File> rsl = new ArrayList<>();
        File root = new File(parent);
        Queue<File> data = new LinkedList<>();
        data.offer(root);
        while (!data.isEmpty()) {
            File file = data.poll();
            if (file.isDirectory()) {
                File[] arr = file.listFiles();
                if (arr != null) {
                    data.addAll(List.of(file.listFiles()));
                }
            } else if (file.isFile()) {
                if (condition.test(file)) {
                    rsl.add(file);
                }
            }
        }
        return rsl;
    }
    public boolean isTxtFile(File file) {
        boolean rsl = false;
        String[] arrFile = file.getName().split("\\.");
        if (arrFile.length == 2) {
            if (arrFile[1].equals("txt")) {
                rsl = true;
            }
        }
        return rsl;
    }
}
