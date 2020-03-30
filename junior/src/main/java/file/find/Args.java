package file.find;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Args {
    String directory;
    String name;
    SearchType type;
    String log;

    public Args(String[] args) throws IllegalArgumentException, IllegalMaskException {
        validateParam(args);
        this.directory = args[1];
        this.name = args[3];
        String type = args[4].substring(1);
        if (type.equals(SearchType.f.name())) {
            this.type = SearchType.f;
        } else if (type.equals(SearchType.m.name())) {
            this.type = SearchType.m;
        } else if (type.equals(SearchType.r.name())) {
            this.type = SearchType.r;
        }
        this.log = args[6];
    }

    public void validateParam(String[] args) throws IllegalArgumentException, IllegalMaskException {
        StringBuilder builderArgs = new StringBuilder();
        Stream.of(args).forEach(
                line -> builderArgs.append(line).append(" ")
        );
        Pattern pattern = Pattern.compile("^-[a-z]\\s.+\\s-n\\s((.+|\\*)\\.\\w+)|.+\\s-[mfr]\\s-o\\s.+\\.txt$");
        Matcher matcher = pattern.matcher(builderArgs.toString().trim());
        if (!matcher.matches()) {
            String msg = "Incorrect arguments types!" + System.lineSeparator() + "=====================" + System.lineSeparator()
                    + "Use this format:" + System.lineSeparator()
                    + "-d [directory for search] -n [file name or mask or regular expression] -m or -f or -r..."
                    + System.lineSeparator() + "[mask or file coincidence or regular] -o [file for output <log.txt>]";
            throw new IllegalArgumentException(msg);
        }
        String[] arr = args[3].split("\\.");
        String fName = (arr.length > 1) ? arr[0] : args[3];
        String fKey = args[4];
        if (
                fName.equals("*") && !fKey.equals("-m")
                        || !fName.equals("*") && fKey.equals("-m")
        ) {
            String msg = "Incorrect arguments!" + System.lineSeparator() + "=====================" + System.lineSeparator()
                    + "If you looking for by mask <*> put key [-m]," + System.lineSeparator()
                    + "by <file name> put key [-f]";
            throw new IllegalMaskException(msg);
        }
    }
    enum SearchType {
        m, f, r
    }
}
