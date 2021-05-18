import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Counter object = null;
        Scanner read = new Scanner(System.in);
        String fileNameRead;
        File file;
        while (object == null){
            System.out.println("Enter the file name like 'data/*filename");

            fileNameRead = read.next();
            file = new File(fileNameRead);
            if (file.exists() && file.canRead() && !file.isDirectory()){
                object = new Counter(file);
            }

        }
        object.count();
        String fileNameWrite;
        File wfile = new File("data/output.txt");
        while (wfile.exists() || wfile.exists()) {
            System.out.println("Enter filename to write");
            fileNameWrite = read.next();
            wfile = new File(fileNameWrite);
        }
        object.print(wfile);
    }
}
