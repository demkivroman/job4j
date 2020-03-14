package file;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line;
            boolean flag = true;
            PrintWriter out = new PrintWriter(new FileOutputStream(target));
            while ((line = read.readLine()) != null) {
                String[] arr = line.split(" ");
                if (arr[0].equals("400") || arr[0].equals("500")) {
                    if (flag) {
                        try {
                            out.print(String.format("%s;", arr[1]));
                            flag = false;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    if (!flag) {
                        try {
                            out.println(String.format("%s;", arr[1]));
                            flag = true;
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(
                new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
