package filesystem;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class SearchTest {
   private String path = System.getProperty("java.io.tmpdir").concat("/");

    @Before
    public void beforeTest() throws IOException {
        String dir = path.concat("dir/");
        new File(dir).mkdirs();
        new File(dir.concat("dir1/")).mkdirs();
        new File(dir.concat("1.txt")).createNewFile();
        new File(dir.concat("2.pdf")).createNewFile();
        new File(dir.concat("3.csv")).createNewFile();
        new File(dir.concat("11.txt")).createNewFile();
        new File(dir.concat("dir2")).mkdirs();
        String dir1 = dir.concat("dir1/");
        new File(dir1).mkdirs();
        new File(dir1.concat("dir1.txt")).createNewFile();
        new File(dir1.concat("dir2.pdf")).createNewFile();
        new File(dir1.concat("dir3.txt")).createNewFile();
        new File(dir.concat("dir2/").concat("dir2.txt")).createNewFile();
        new File(dir.concat("dir2/").concat("dir3.txt")).createNewFile();
    }
    @Test
    public void whenCheckSearchOfFileSystem() throws IOException {

    }
}
