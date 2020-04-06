package file.find;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

import static java.nio.file.FileVisitResult.CONTINUE;

public class SearchFile implements FileVisitor<Path> {
    private Args args;
    private StringBuilder out;
    public SearchFile(Args args) {
        this.args = args;
        out = new StringBuilder();
    }

    public StringBuilder getOut() {
        return out;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fName = args.getName();
        String key = String.valueOf(args.getType());
        if (key.equals("m")) {
            String ext = fName.split("\\.")[1];
            if (file.toString().endsWith(ext)) {
                out.append(file.toAbsolutePath()).append(System.lineSeparator());
            }
        } else if (key.equals("f")) {
            if (fName.equals(file.getFileName().toString())) {
                out.append(file.toAbsolutePath()).append(System.lineSeparator());
            }
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
}
