import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by blake on 6/28/17.
 */
public class ImportFromFile {
    public void doit(String inputFile) {
        Scanner in = new Scanner(FileReader(inputFile));
        try {

        } finally {
            in.close();
        }
    }
}
