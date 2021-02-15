import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Copy_Bytes {
    public static void main(String[] args) throws IOException {

        String path = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";

        FileInputStream text = new FileInputStream(path);
        FileOutputStream output = new FileOutputStream(outputPath);

        Scanner term = new Scanner(text);

        int digit = text.read();
        while (digit > -1){
            if (digit == ' ' || digit == '\n'){
                output.write(digit);
            } else {
                output.write(String.valueOf(digit).getBytes());
            }

            digit = text.read();
        }
        text.close();
        output.flush();
    }
}
