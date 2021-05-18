import java.io.*;
import java.sql.SQLOutput;

public class Counter {
    private final File fileNameRead;
    private final int[] smallLetters;
    private final int[] capitalLetters;

    Counter (File fileName) {
        this.fileNameRead = fileName;
        smallLetters = new int[26];
        capitalLetters = new int[26];
    }
    
    void count(){
        FileReader fr = null;
        char letter = (char) 0;
        try{
            fr = new FileReader(this.fileNameRead);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        if (fr != null){
            while (letter != (char)-1){
                try{
                    letter = (char)fr.read();
                }catch (IOException ex){
                    System.out.println("letter not found");
                }
                if (letter >= 'a' && letter <= 'z'){
                    smallLetters[letter - 'a']++;
                } else if (letter >= 'A' && letter <= 'Z'){
                    capitalLetters[letter - 'A']++;
                }
            }
        }
    }

    void print(File fileName) throws IOException {
        FileWriter fw = null;
        fw = new FileWriter(fileName);
        if (fw != null) {
            fw.write(
                    "The count of letters:\n");
            for (int i = 0; i < this.smallLetters.length; i++) {

                if (this.smallLetters[i] > 0) {
                    fw.write(String.format("%c %d\n",
                            i + 97, this.smallLetters[i]));
                }
                if (this.capitalLetters[i] > 0) {
                    fw.write(String.format("%c %d\n",
                            i + 65, this.capitalLetters[i]));
                }
            }
            fw.close();
        }
    }
}

