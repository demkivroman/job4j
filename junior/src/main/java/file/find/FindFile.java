package file.find;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFile {
    public static boolean findFile(Args args) throws IOException {
        boolean rsl = false;
        String directory = args.directory;
        String fName = args.name;
        String key = String.valueOf(args.type);
        String outFile = args.log;
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File(outFile))));
        Files.walkFileTree(Paths.get(directory), new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (key.equals("m")) {
                        String ext = fName.split("\\.")[1];
                        if (file.toString().endsWith(ext)) {
                            out.println(file.toAbsolutePath());
                        }
                    } else if (key.equals("f")) {
                        if (fName.equals(file.getFileName().toString())) {
                            out.println(file.toAbsolutePath());
                        }
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
        if (out != null) {
            out.close();
        }
        return rsl;
    }
    public static void main(String[] args) {
        try {
            Args argm = new Args(args);
            findFile(argm);
            System.out.println("Succeed! Check results in output file.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IllegalMaskException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
