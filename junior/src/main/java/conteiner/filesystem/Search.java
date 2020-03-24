package conteiner.filesystem;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.util.ArrayList;
import java.util.List;

public class Search {
    public static List<String> search(Path root, String ext) throws IOException {
        List<String> rsl = new ArrayList<>();
        Files.walkFileTree(root, new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (file.toString().endsWith(ext)) {
                    rsl.add(file.toAbsolutePath().toString());
                }
                return CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                return CONTINUE;
            }
        });
        return rsl;
    }
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/roman/IdeaProjects/job4j");
        search(path, "js").forEach(System.out::println);
    }
}
