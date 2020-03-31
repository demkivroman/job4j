package file.find;

import java.io.*;
import java.nio.file.*;

public class FindFile {
    public static void findFile(Args args) throws IOException {
        Path dir = Paths.get(args.getDirectory());
        SearchFile searchF = new SearchFile(args);
        Files.walkFileTree(dir, searchF);
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(args.getLog())))) {
            out.write(searchF.getOut().toString());
        }
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
