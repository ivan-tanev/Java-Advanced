import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Read_File {
    public static void main(String[] args) throws IOException {

        String path = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream input = new FileInputStream(path);

        int oneByte = input.read();
        while (oneByte > -1){
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = input.read();
        }
        input.close();
    }
}
