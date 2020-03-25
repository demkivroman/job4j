package chat;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Chat {
    private Map<Integer, Answer> answerMap = new HashMap<>();
    private String answFile;
    private String log;

    public Chat() {
        String dir = System.getProperty("user.dir");
        this.answFile = dir.concat("/junior/src/main/java/chat/answers");
        this.log = dir.concat("/junior/src/main/java/chat/log");
        try (BufferedReader read = new BufferedReader(new FileReader(answFile))) {
            int index = 0;
            String line = read.readLine();
            while (line != null) {
                Answer obj = new Answer(index++, line);
                answerMap.put(obj.id, obj);
                line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getAnswer() {
        Random random = new Random();
        int num = random.nextInt(answerMap.size());
        return answerMap.get(num).phrase;
    }
    public String getTimeForLog(String value) {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy HH:mm:ss");
        return String.format("%s - %s", dateFormat.format(date), value);
    }

    public void run () {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(log, true)))) {
            System.out.println("Ask chat?");
            Scanner in = new Scanner(System.in);
            String cycle = in.nextLine();
            out.println(getTimeForLog(cycle));
            while (!cycle.equals("закончить")) {
                if (cycle.equals("стоп")) {
                    while (!cycle.equals("продолжить")) {
                        cycle = in.nextLine();
                        out.println(getTimeForLog(cycle));
                    }
                    String ans = getAnswer();
                    System.out.println(ans);
                    out.println(getTimeForLog(ans));
                } else {
                    String ans = getAnswer();
                    System.out.println(ans);
                    out.println(getTimeForLog(ans));
                }
                cycle = in.nextLine();
                out.println(getTimeForLog(cycle));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static class Answer {
        int id;
        String phrase;

        public Answer(int id, String phrase) {
            this.id = id;
            this.phrase = phrase;
        }
    }
    public static void main(String[] args) {
        new Chat().run();
    }
}
