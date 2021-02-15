import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Write_To_File {
    public static void main(String[] args) throws IOException {

        String path = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        String outputPath = "D:\\04. Java-Advanced-Streams-Files-and-Directories-Resources\\" +
                "04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        String chars = ",.!?";
        FileInputStream text = new FileInputStream(path);
        FileOutputStream output = new FileOutputStream(outputPath);

        int current = text.read();
        while (current > -1){
            char symbol = (char) current;
            if (!chars.contains(String.valueOf(symbol))){
                output.write(symbol);
            }
            current = text.read();
            if (current == -1){
                break;
            }
        }
        text.close();
        output.close();
    }
}
