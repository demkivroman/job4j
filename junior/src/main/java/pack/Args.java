package pack;

public class Args {
    private String directory;
    private String exclude;
    private String output;
    public Args(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-d")) {
                this.directory = args[++i];
            } else if (args[i].equals("-e")) {
                this.exclude = args[++i].split("\\.")[1];
            } else if (args[i].equals("-o")) {
                this.output = args[++i];
            }
        }
    }
    public String directory() {
        return this.directory;
    }
    public String exclude() {
        return this.exclude;
    }
    public String output() {
        return this.output;
    }
}
