package cop2805;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.io.*;
import java.util.*;

public class CCulpHomework4Example {
    public static void main(String[] args) {
        Path file = Paths.get("MyFile.txt");
        try {
            Path newFile = Files.createFile(file);
        } catch (FileAlreadyExistsException x) {
            System.err.format("file named %s" + " already exists%n", file);
        } catch (IOException x) {
            System.err.format("createFile error: %s%n", x);
        }


    }
}
