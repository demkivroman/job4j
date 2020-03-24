package pack;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public List<File> seekby(String root, String ext) {
        List<File> rsl = new ArrayList<>();
        try {
            Files.walkFileTree(Paths.get(root), new FileVisitor<Path>() {
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (!file.toString().endsWith(ext)) {
                        rsl.add(file.toFile());
                    }
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }

                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }
    void pack(List<File> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File entry : source) {
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(entry))) {
                    zip.putNextEntry(new ZipEntry(entry.getPath()));
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        if (args.length > 0) {
            Args arguments = new Args(args);
            Zip zip = new Zip();
            zip.pack(zip.seekby(arguments.directory(), arguments.exclude()),
                    new File(arguments.output()));
        } else {
            System.out.println("Enter parametres for zip, please");
        }
    }
}
